package com.ak.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.RouteMatcher.Route;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ak.dto.Train;
import com.ak.dto.Train.Day;
import com.ak.service.DateService;
import com.ak.service.MyCustomException;



@CrossOrigin
@RestController
@RequestMapping("/psn/train")
public class TrainDetailsController {

	
	@Autowired
	private RestTemplate rt;
	
	@Autowired
	private DateService dateService;
	
	
	/**
	 * get train by id
	 */
	@GetMapping(path="/get/byId/{trainId}")
	public Train getTrainById(@PathVariable("trainId")long trainId)throws Exception{
		return rt.getForObject("http://TRAIN-SERVICE/train/get/byId/"+trainId, Train.class);
		
	}

	
	
	
	
	
	
	
	/**
	 * get all by trainName
	 * may be two or more trains have same name
	 */
	@GetMapping(path="/get/byName/{name}")
	public ResponseEntity<Object> getAllByName(@PathVariable("name")String name)throws Exception{
		Object obj= rt.getForObject("http://TRAIN-SERVICE/train/get/byName/"+name, Object.class);
		return ResponseEntity.ok().body(obj);
	};
	
	
	
	
	
	
	
	
	/**
	 * get all between stations
	 */
	@GetMapping(path="/get/BtwStations/{startingPoint}/{destinationPoint}")
	public List<Train> getAllBewteenStations(@PathVariable("startingPoint")String startingPoint,@PathVariable("destinationPoint")String destinationPoint)throws Exception{
		return rt.getForObject("http://TRAIN-SERVICE/train/get/BtwStations/"+startingPoint+"/"+destinationPoint,new ArrayList().getClass());	
	};
	
	
	
	
	
	
	
	
	
	

	/**
	 * get all between stations on given date
	 * DD/MM/YYYY
	 */
	@GetMapping(path="/get/BtwStations/{startingPoint}/{destinationPoint}/{date}")
	public ResponseEntity<Object> getAllBewteenStations(@PathVariable("startingPoint")String startingPoint,@PathVariable("destinationPoint")String destinationPoint,@PathVariable("date")String date)throws Exception{
	List<Train> trains=null;
	List<Train> trainsResponce=null;
	String dayString=dateService.getDayFromDate(date);
	System.out.println("day------------"+dayString);
	ParameterizedTypeReference<List<Train>> typeRef = new ParameterizedTypeReference<List<Train>>() {};
	ResponseEntity<List<Train>> responseEntity= rt.exchange("http://TRAIN-SERVICE/train/get/BtwStations/"+startingPoint+"/"+destinationPoint,HttpMethod.GET,null,typeRef);
				//("http://TRAIN-SERVICE/train/get/BtwStations/"+startingPoint+"/"+destinationPoint,new ArrayList<>().getClass());
	   
		trains=responseEntity.getBody();
		
		//filter on particular day
		trains.removeIf(train->{
			return ! train.getAvailableDays().contains(Day.valueOf(dayString));
		});
		
		System.out.println("----"+trains.size());
		
		//calculate total distance
		trainsResponce=trains.stream().map(train->{
			Train trainTemp=train;
			long availableseats=0;
			double distance=0;
			distance=rt.getForObject("http://TRAIN-SERVICE/train/get/TotalDistance/"+train.getRouteId()+"/"+startingPoint+"/"+destinationPoint, Double.class);	
		    trainTemp.setTotalPrice(distance*train.getFarePerKm());
	
		    return trainTemp;
		}).collect(Collectors.toList());
		
		System.out.println(trainsResponce.size());
		
		return ResponseEntity.ok().body(trainsResponce);
	};
	
	
	
	
	
	
    @GetMapping("/get/trainroute/{trainId}")
	public Route getTrainRoute(@PathVariable("trainId")long trainId) throws Exception {
    	return rt.getForObject("http://TRAIN-SERVICE/train/get/trainroute/"+trainId, Route.class);
	}	
	
	
    
    
    
    
    
    
    
    @GetMapping("/get/farePerKm/{trainId}")
    public double getFarePerKm(@PathVariable("trainId")long trainId) throws Exception {
    	return rt.getForObject("http://TRAIN-SERVICE/train/get/farePerKm/"+trainId,Double.class);
    }
    
    
    
    
    @GetMapping("/get/TotalDistance/{routeId}/{startPoint}/{endPoint}")
    public double calculateTotalDistance(@PathVariable("routeId")long routeId,@PathVariable("startPoint") String startPostion,@PathVariable("endPoint")String endPosition) throws Exception {
    return  rt.getForObject("http://TRAIN-SERVICE/train/get/TotalDistance/"+routeId+"/"+startPostion+"/"+endPosition, Double.class);	
    }
    
    
    
    
    
    
    
    
    

	@GetMapping(path="/checkAvailableSeats/{seatBucketId}")
	public long checkAvailableSeatsInBucket(@PathVariable("seatBucketId")long seatBucketId) throws Exception {
		try {
	  return rt.getForObject("http://TRAIN-SERVICE/seat/checkAvailableSeats/"+seatBucketId, Long.class);
		}catch (Exception e) {
	    throw new MyCustomException("no value present");
		}
		
	}
	
    
    
    
    
  
    

	public boolean isPassenger(String token)throws Exception{
		
		String role=rt.postForObject("http://JWT-SERVICE/jwt/getRole",token, String.class);
		return role.equalsIgnoreCase("USER")?true:false;
	}
}
