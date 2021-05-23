package com.ak.controller;

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

import com.ak.dto.TicketBookingRequest;
import com.ak.entity.Ticket;
import com.ak.service.MyCustomException;
import com.ak.service.TicketBookingService;




@CrossOrigin
@RestController
@RequestMapping("/psn/ticket")
public class TicketBookingController {

	
	@Autowired
	private TicketBookingService ticketBookingService;
	@Autowired
	private RestTemplate rt;
	
	@PostMapping("/bookTicket")
	public Ticket BookTicket(@RequestBody TicketBookingRequest ticketBookingRequest,@RequestHeader("Authorization")String token) throws Exception {		
		if(!isUser(token)) {
			throw new MyCustomException("YOU ARE NOT loggedin ");
		}
		
		
		//match user id with token and ticket
		ticketBookingRequest.getTicket().setBookedByUserId(getUserId(token));
		return ticketBookingService.BookTicket(ticketBookingRequest.getTicket(),ticketBookingRequest.getPassengers());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping(path="/findTicketByUserId/{userId}")
    public TicketBookingRequest getTicketByUserId(@PathVariable("userId")long userId,@RequestHeader("Authorization")String token)throws Exception{
		if(!(getUserId(token)==userId))
			throw new MyCustomException("you are not authorized");
		
		
		return ticketBookingService.getTicketByUserId(userId);
    }
	
	
	
	
	
	@GetMapping(path="/findTicketByTicketId/{ticketId}")
	public TicketBookingRequest getTicketByTicketId(@PathVariable("ticketId")long ticketId,@RequestHeader("Authorization")String token)throws Exception{
		return ticketBookingService.getTicketByTicketId(ticketId);
	}
	
	
	
	
	@DeleteMapping(path="/deleteTicket/{ticketId}")
	public boolean deleteTicket(@PathVariable("ticketId")long ticketId,@RequestHeader("Authorization")String token)throws Exception{
		
		if(! isUser(token))
			throw new MyCustomException("you are not authorized");
		
		return ticketBookingService.deleteTicket(ticketId);
	}
	
	
	
	
	
	
	
	
public boolean isUser(String token)throws Exception{
		
		String role=rt.postForObject("http://JWT-SERVICE/jwt/getRole",token, String.class);
		return role.equalsIgnoreCase("USER")?true:false;
	}






public long getUserId(String token)throws Exception{
		return rt.postForObject("http://JWT-SERVICE/jwt/getUserId",token, Long.class);
		
	}
}
