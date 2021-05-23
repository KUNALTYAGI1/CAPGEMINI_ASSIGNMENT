package com.ak.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ak.dto.Seat;
import com.ak.dto.TicketBookingRequest;
import com.ak.entity.Passenger;
import com.ak.entity.Ticket;
import com.ak.repo.PassengerRepo;
import com.ak.repo.TicketRepo;

@Service
public class TicketBookingServiceImpl implements TicketBookingService{
	
	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private PassengerRepo passengerRepo;
	@Autowired
	private RestTemplate rt;
	
	
	
	
	
	
	
	
	@Override
	public Ticket BookTicket(Ticket ticket, List<Passenger> passengers) throws Exception {
	long id=ticketRepo.count()+1;
	ticket.setTicketId(id);
	//List<Seat> seats=null;
	List<Long> passengerIds=null;
	long count=passengerRepo.count();
	for(int i=0;i<passengers.size();i++) {
		passengers.get(i).setPassengerId(i+1+count+1);
	}
	/*passengers=passengers.stream().map(passenger->{
		
		long passengerId=passengerRepo.count()+1+count;
		passenger.setPassengerId(passengerId);
		
		return passenger;
		
	}).collect(Collectors.toList());*/
	
	ticket.setPassengerIds(passengers.stream().map(pass->pass.getPassengerId()).collect(Collectors.toList()));
	ticket.setStatus("CNF");
	ticketRepo.save(ticket);
	passengers=passengerRepo.saveAll(passengers);
	
	
	
	passengerIds=passengers.stream().map(pass->{
		return pass.getPassengerId();
	}).collect(Collectors.toList());
	
	//allot seats to passengers
	ParameterizedTypeReference<List<Seat>> myBean =new ParameterizedTypeReference<List<Seat>>() {};
	HttpEntity<List<Long>> entity = new HttpEntity<>(passengerIds);
	     
	
	List<Seat> seats=rt.exchange("http://TRAIN-SERVICE/seat/allotSeats/"+ticket.getTrainId(),HttpMethod.POST, entity, myBean).getBody();

	
	passengers=passengers.stream().map(pas->{
	long seatId=seats.stream().filter(seat->{
		return	seat.getOccupiedByPassengerId()==pas.getPassengerId();
		}).findAny().get().getSeatId();
	
	pas.setAllotedSeatId(seatId);
	return pas;
	}).collect(Collectors.toList());
	
	
	passengerRepo.saveAll(passengers);
	       return ticket;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public TicketBookingRequest getTicketByUserId(long userId) throws Exception {
		Ticket ticket=null;
		List<Passenger> passengers=null;
		TicketBookingRequest responce=new TicketBookingRequest();
		ticket=ticketRepo.findByBookedByUserId(userId);
		responce.setTicket(ticket);
		
	   passengers=StreamSupport.stream(passengerRepo.findAllById(ticket.getPassengerIds()).spliterator(),false).collect(Collectors.toList());
		
		responce.setPassengers(passengers);
		
		
		return responce;
	}
	
	
	@Override
	public TicketBookingRequest getTicketByTicketId(long ticketId) throws Exception {
		
		Ticket ticket=null;
		List<Passenger> passengers=null;
		TicketBookingRequest responce=new TicketBookingRequest();
		ticket=ticketRepo.findById(ticketId).get();
		responce.setTicket(ticket);
		
	    passengers=StreamSupport.stream(passengerRepo.findAllById(ticket.getPassengerIds()).spliterator(),false).collect(Collectors.toList());
		
		responce.setPassengers(passengers);
		
		
		return responce;
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	//@Transactional
	public boolean deleteTicket(long ticketId) throws Exception {
		Ticket ticket=null;
		List<Long> bookedSeatIds=null;

		ticket=ticketRepo.findById(ticketId).get();
		bookedSeatIds=StreamSupport.stream(passengerRepo.findAllById(ticket.getPassengerIds()).spliterator(),false).map(pass->pass.getAllotedSeatId()).collect(Collectors.toList());
		
		passengerRepo.deleteAllById(ticket.getPassengerIds());
		ticketRepo.deleteById(ticketId);
		
		
		//mark seat as available
		rt.postForObject("http://TRAIN-SERVICE/seat/markSeatAsAvailable", bookedSeatIds,Object.class);
		return true;
	}
}
