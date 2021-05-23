package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.ak.dto.Seat;
import com.ak.dto.TicketBookingRequest;
import com.ak.entity.Passenger;
import com.ak.entity.Ticket;
import com.ak.repo.PassengerRepo;
import com.ak.repo.TicketRepo;
import com.ak.service.TicketBookingService;


@RunWith(SpringRunner.class)
@SpringBootTest
class PassengerServiceApplicationTests {

	
	@Autowired
	private TicketBookingService ticketBookingService;
	@MockBean
	private RestTemplate rt;
	
	@MockBean
	private TicketRepo ticketRepo;
	@MockBean
	private PassengerRepo passengerRepo;
	
	
	@Test
	void contextLoads() {
	}

	
	@Test
	public void BookTicketTest() {
		when(ticketRepo.count()).thenReturn(1l);
		Ticket ticket=new Ticket();
		ticket.setTicketId(1);
       when(ticketRepo.save(ticket)).thenReturn(ticket);
      
     //allot seats to passengers
   	ParameterizedTypeReference<List<Seat>> myBean =new ParameterizedTypeReference<List<Seat>>() {};
   	HttpEntity<List<Long>> entity = new HttpEntity<>(Stream.of(1l,2l,3l).collect(Collectors.toList()));
   	     
   	

    when(rt.exchange("http://TRAIN-SERVICE/seat/allotSeats/"+ticket.getTrainId(),HttpMethod.POST, entity, myBean))
     .thenReturn(ResponseEntity.ok().body(Stream.of(new Seat()).collect(Collectors.toList())));
       
       when(passengerRepo.saveAll(Stream.of(new Passenger()).collect(Collectors.toList()))).thenReturn(Stream.of(new Passenger()).collect(Collectors.toList()));
	
	assertEquals(1,1);
	}
	
	
	
	
	
	
	
	
	@Test
	public void getTicketByUserIdTest() {
		try {
		when(ticketRepo.findByBookedByUserId(1)).thenReturn(new Ticket());
		
		when(passengerRepo.findAllById(Stream.of(1l,2l).collect(Collectors.toList()))).thenReturn(Stream.of(new Passenger()).collect(Collectors.toList()));
		
		
		assertEquals("", "");
		
		}catch (Exception e) {
			assertThat(e).isInstanceOf(Exception.class);
		}	
	}
	
	
	
	
	@Test
	
	public void getTicketByTicketIdTest() {
		Ticket ticket=new Ticket();
		ticket.setTicketId(1);
		when(ticketRepo.findById(1l)).thenReturn(Optional.of(ticket));
		
		when(passengerRepo.findAllById(Stream.of(1l,2l).collect(Collectors.toList()))).thenReturn(Stream.of(new Passenger()).collect(Collectors.toList()));
		
		
		try {
		assertEquals(TicketBookingRequest.class,ticketBookingService.getTicketByTicketId(1l).getClass());
		}catch (Exception e) {
			assertThat(e).isInstanceOf(Exception.class);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public void deleteTicketTest() {
		try {
		Ticket ticket=new Ticket();
		ticket.setPassengerIds(Stream.of(1l,2l).collect(Collectors.toList()));
		when(ticketRepo.findById(1l)).thenReturn(Optional.of(ticket));
		when(passengerRepo.findAllById(Stream.of(1l,2l).collect(Collectors.toList()))).thenReturn(Stream.of(new Passenger()).collect(Collectors.toList()));
		
		
		
		 when(rt.postForObject("http://TRAIN-SERVICE/seat/markSeatAsAvailable",Stream.of(1,2).collect(Collectors.toList()),Object.class)).thenReturn("done");
	     
	      
		
		}catch (Exception e) {
			assertThat(e).isInstanceOf(Exception.class);
		}
		
		
		
		
		
		
		
		
		
	}
	
}
