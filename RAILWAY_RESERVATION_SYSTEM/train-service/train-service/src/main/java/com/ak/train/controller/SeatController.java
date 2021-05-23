package com.ak.train.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.train.entity.Seat;
import com.ak.train.entity.SeatBucket;
import com.ak.train.service.SeatService;


@CrossOrigin
@RestController
@RequestMapping("/seat")
public class SeatController {

	
	
	@Autowired
	private SeatService seatservice;
	
	
	
	
	@GetMapping(path="/refreshSeatAsAvailable/{seatBucketId}")
	public boolean refreshAllSeats(@PathVariable("seatBucketId")long seatBucketId)throws Exception{
		return seatservice.refreshAllSeats(seatBucketId);
	};
	
	
	
	
	
	@PostMapping(path="/createNewSeat/{seatBucketId}")
	public Seat createNewSeat(@RequestBody Seat seat,@PathVariable("seatBucketId")long seatBucketId)throws Exception{
		return seatservice.createNewSeat(seat, seatBucketId);
	};

	
	
	
	
	@DeleteMapping(path="/deleteseat/{seatId}/{seatBucketId}")
	public boolean deleteSeat(@PathVariable("seatId")long seatId,@PathVariable("seatBucketId")long seatBucketId)throws Exception{
	return seatservice.deleteSeat(seatId, seatBucketId);	
	}
	
	
	
	
	
	
	@PostMapping(path="/addSeatToseatBucket/{seatId}/{seatBucketId}")
	public SeatBucket addSeatToSeatBucket(@PathVariable("seatId")long seatId,@PathVariable("seatBucketId")long seatBucketId)throws Exception{
	return seatservice.addSeatToSeatBucket(seatId, seatBucketId);
	}
	
	
	@DeleteMapping(path="/removeSeatFromSeatBucket/{seatId}/{seatBucketId}")
	public SeatBucket removeSeatFromSeatBucket(@PathVariable("seatId")long seatId,@PathVariable("seatBucketId")long seatBucketId)throws Exception{
	return seatservice.removeSeatFromSeatBucket(seatId, seatBucketId);	
	}
	
	
	
	
	
	@GetMapping(path="/checkAvailableSeats/{seatBucketId}")
	public long checkAvailableSeatsInBucket(@PathVariable("seatBucketId")long seatBucketId) throws Exception {
	   return seatservice.checkAvailableSeatsInBucket(seatBucketId);
	}
	
	
	
	
	
	
	
	
	@PostMapping(path="/allotSeats/{trainId}")
	public List<Seat> allotSeatToPassengers(@PathVariable("trainId")long trainId,@RequestBody List<Long> passengerIds) throws Exception {
		return seatservice.allotSeatToPassengers(trainId, passengerIds);
	}
	
	
	
	
	
	@PostMapping(path="/markSeatAsAvailable")
	public List<Seat> markSeatsAsAvailable(@RequestBody List<Long> seatIds) throws Exception {
		return seatservice.markSeatsAsAvailable(seatIds);
	}
}
