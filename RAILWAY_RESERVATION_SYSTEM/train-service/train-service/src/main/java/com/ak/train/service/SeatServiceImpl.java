package com.ak.train.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.customexe.CustomException;
import com.ak.train.entity.AutoIncrementDetails;
import com.ak.train.entity.Seat;
import com.ak.train.entity.SeatBucket;
import com.ak.train.repo.AutoIncrementRepo;
import com.ak.train.repo.SeatBucketRepo;
import com.ak.train.repo.SeatRepo;
import com.ak.train.repo.TrainRepo;

import lombok.Synchronized;

@Service
public class SeatServiceImpl implements SeatService{

	
	@Autowired
	private SeatBucketRepo seatBucketRepo;
	@Autowired
	private SeatRepo seatRepo;
	@Autowired
	private TrainRepo trainRepo;
	
	@Autowired
	private AutoIncrementRepo autoIncrementDetailsRepo;
	
	
	@Override
	public boolean refreshAllSeats(long seatBucketId) throws Exception {
		SeatBucket seatBucket=null;
		Optional<SeatBucket> optional=null;
		optional=seatBucketRepo.findById(seatBucketId);
		List<Seat> seats=null;
		if(!optional.isPresent())
			throw new CustomException("this seat bucket no available");
		
		if(optional.isPresent()){
			seatBucket=optional.get();
			};
			
		seats=StreamSupport.stream(seatRepo.findAllById(seatBucket.getSeatIds()).spliterator(),false).collect(Collectors.toList());
		
	    seats=seats.stream().map(seat->{
	    	seat.setAvailable(true);
	    	seat.setOccupiedByPassengerId(0);
	    	return seat;
	    }).collect(Collectors.toList());
	        
	  seatRepo.saveAll(seats);
	
		return true;
	}

	
	
	
	
	
	@Override
	public Seat createNewSeat(Seat seat,long seatbucketId) throws Exception {
		
		SeatBucket seatBucket=null;
		long lastIndex=0;
		
		lastIndex=seatRepo.count()+1;
		
		seat.setSeatId(lastIndex);
		seatRepo.save(seat);
		seatBucket=seatBucketRepo.findById(seatbucketId).get();
		seatBucket.getSeatIds().add(seat.getSeatId());
        seatBucketRepo.save(seatBucket);
		return seat;
	}

	
	
	
	
	
	
	
	@Override
	public boolean deleteSeat(long seatId,long seatBucketId) throws Exception {
		SeatBucket seatBucket=null;
		seatRepo.deleteById(seatId);
		
		seatBucket=seatBucketRepo.findById(seatBucketId).get();
		seatBucket.getSeatIds().removeIf(id->{
			return id==seatId;
		});
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public SeatBucket addSeatToSeatBucket(long seatId, long seatBucketId) throws Exception {
	SeatBucket seatBucket=null;
	
	seatBucket=seatBucketRepo.findById(seatBucketId).get();
	seatBucket.getSeatIds().add(seatId);
	seatBucketRepo.save(seatBucket);
	return seatBucket;
	}

	
	
	
	
	
	@Override
	public SeatBucket removeSeatFromSeatBucket(long seatId, long seatBucketId) throws Exception {
		SeatBucket seatBucket=null;
		seatBucket=seatBucketRepo.findById(seatBucketId).get();
		seatBucket.getSeatIds().removeIf(id->{
			return id==seatId;
		});
		
		seatBucket=seatBucketRepo.save(seatBucket);
		return seatBucket;
	}

	
	
	
	
	
	
	
	@Override
	public long checkAvailableSeatsInBucket(long seatBucketId) throws Exception {
		List<Long> seatIds=null;
		long noOfSeatsOccupied=0;
		seatIds=seatBucketRepo.findById(seatBucketId).get().getSeatIds();
		
		
		noOfSeatsOccupied=StreamSupport.stream(seatRepo.findAllById(seatIds).spliterator(),false).filter(seat->!seat.isAvailable()).count();
		
		return seatIds.size()-noOfSeatsOccupied;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	@Synchronized
	public List<Seat> allotSeatToPassengers(long trainId, List<Long> passengerIds) throws Exception {
		SeatBucket seatBucket=null;
		long SeatBucketId=0;
		List<Seat> seats=null;
		List<Seat> availableSeats=null;
		List<Seat> allotedSeats=null;
		
		SeatBucketId=trainRepo.findById(trainId).get().getRouteId();
		seatBucket=seatBucketRepo.findById(SeatBucketId).get();
		seats=StreamSupport.stream(seatRepo.findAllById(seatBucket.getSeatIds()).spliterator(),false).collect(Collectors.toList());
		
		
		
		//check if seat is available
		availableSeats=seats.stream().filter(seat->{
			return seat.isAvailable();
		}).collect(Collectors.toList());
		
		
	
		
		
		allotedSeats=new ArrayList<Seat>();
		for (Long passId : passengerIds) {
			Seat seat2=availableSeats.get(0);
			seat2.setOccupiedByPassengerId(passId);
			availableSeats.remove(0);
			seat2.setAvailable(false);
			allotedSeats.add(seat2);
		}
		
		
		return seatRepo.saveAll(allotedSeats);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Seat> markSeatsAsAvailable(List<Long> seatIds) throws Exception {
		List<Seat> seats=StreamSupport.stream(seatRepo.findAllById(seatIds).spliterator(),false).map(seat->{
			seat.setAvailable(true);
			seat.setOccupiedByPassengerId(0);
			return seat;
		}).collect(Collectors.toList());
		
		return seatRepo.saveAll(seats);
		
	}
	
}
