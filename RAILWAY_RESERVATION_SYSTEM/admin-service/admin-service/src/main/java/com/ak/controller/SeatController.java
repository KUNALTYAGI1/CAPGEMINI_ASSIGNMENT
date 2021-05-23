package com.ak.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ak.dto.Seat;
import com.ak.dto.SeatBucket;
import com.ak.entity.MyCustomException;


@CrossOrigin//cross origin allows a controller to be called from another website 
@RestController
@RequestMapping("/admin/seat")
public class SeatController {

	
	@Autowired
	private RestTemplate rt;
	
	
	
	@GetMapping(path="/refreshSeatAsAvailable/{seatBucketId}")
	public boolean refreshAllSeats(@PathVariable("seatBucketId")long seatBucketId,@RequestHeader("Authorization")String token)throws Exception{
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		return rt.getForObject("http://TRAIN-SERVICE/seat/refreshSeatAsAvailable/"+seatBucketId, Boolean.class);
	};
	
	
	
	
	
	@PostMapping(path="/createNewSeat/{seatBucketId}")
	public Seat createNewSeat(@RequestBody Seat seat,@PathVariable("seatBucketId")long seatBucketId,@RequestHeader("Authorization")String token)throws Exception{
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		return rt.postForObject("http://TRAIN-SERVICE/seat/createNewSeat/"+seatBucketId,seat,Seat.class);
		
	};

	
	
	
	
	@DeleteMapping(path="/deleteseat/{seatId}/{seatBucketId}")
	public boolean deleteSeat(@PathVariable("seatId")long seatId,@PathVariable("seatBucketId")long seatBucketId,@RequestHeader("Authorization")String token)throws Exception{
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		rt.delete("http://TRAIN-SERVICE/seat/deleteseat/"+seatId+"/"+seatBucketId);
		return true;	
	}
	
	
	
	
	
	
	@PostMapping(path="/addSeatToseatBucket/{seatId}/{seatBucketId}")
	public SeatBucket addSeatToSeatBucket(@PathVariable("seatId")long seatId,@PathVariable("seatBucketId")long seatBucketId,@RequestHeader("Authorization")String token)throws Exception{
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		return rt.postForObject("http://TRAIN-SERVICE/seat/addSeatToseatBucket/"+seatId+"/"+seatBucketId,null,SeatBucket.class);
		
	}
	
	
	@DeleteMapping(path="/removeSeatFromSeatBucket/{seatId}/{seatBucketId}")
	public String removeSeatFromSeatBucket(@PathVariable("seatId")long seatId,@PathVariable("seatBucketId")long seatBucketId,@RequestHeader("Authorization")String token)throws Exception{
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		rt.delete("http://TRAIN-SERVICE/seat/removeSeatFromSeatBucket/"+seatId+"/"+seatBucketId);
		return "completed"; 	
	}
	
	
	
	
	
	@GetMapping(path="/checkAvailableSeats/{seatBucketId}")
	public long checkAvailableSeatsInBucket(@PathVariable("seatBucketId")long seatBucketId,@RequestHeader("Authorization")String token) throws Exception {
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		return rt.getForObject("http://TRAIN-SERVICE/seat/checkAvailableSeats/"+seatBucketId, Long.class);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping(path="/markSeatAsAvailable")
    public List<Seat> markSeatsAsAvailable(@RequestBody List<Long> seatIds,@RequestHeader("Authorization")String token) throws Exception {
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		return rt.postForObject("http://TRAIN-SERVICE/seat/markSeatAsAvailable",seatIds,new ArrayList().getClass());
	}
	
	
	
	

	
	
	
	
	
public boolean isAdmin(String token)throws Exception{
		
		String role=rt.postForObject("http://JWT-SERVICE/jwt/getRole",token, String.class);
		return role.equalsIgnoreCase("ADMIN")?true:false;
	}
	
	
}
