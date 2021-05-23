package com.ak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ak.dto.Route;
import com.ak.dto.Train;
import com.ak.entity.MyCustomException;


@CrossOrigin
@RestController
@RequestMapping("/admin")
public class UpdateTrainController {

	
	
	@Autowired
	private RestTemplate rt;
	
	
	
	
	
	
	/**
	 * create new train
	 */
	@PostMapping(path="/addTrain")
	public Train createNewTrain(@RequestBody Train train, @RequestHeader("Authorization")String token)throws Exception{  
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		
	
		return rt.postForObject("http://TRAIN-SERVICE/api/train/update/addTrain", train, Train.class);	
	};
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/createRoute")
	public Route createNewRoute(@RequestBody Route route,@RequestHeader("Authorization")String token)throws Exception{
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		return rt.postForObject("http://TRAIN-SERVICE/api/train/update/createRoute", route, Route.class);
		
	}
	
	
	
	
	
	
	
	@PostMapping("/updateRoute/{routeId}/{station}/{index}")
	public Route addStopageInRoute(@PathVariable("routeId")long routeId,@PathVariable("station")String station,@PathVariable("index")int index,
			@RequestHeader("Authorization")String token)throws Exception{
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		return rt.postForObject("http://TRAIN-SERVICE/api/train/update/updateRoute/"+routeId+"/"+station+"/"+index, null,Route.class);
			
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * update train availability days
	 * 
	 */
	@PostMapping(path="/availableDays/{trainId}")
	public Object updateAvailableDays(@RequestBody List<String> days,@PathVariable("trainId")long trainId,@RequestHeader("Authorization")String token)throws Exception{
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		return rt.postForObject("http://TRAIN-SERVICE/api/train/update/availableDays/"+trainId,days,Object.class);
	};
	
	
	
	
	/**
	 * update fare
	 */
	@PostMapping(path="/fare/{trainId}")
	public Double updateFare(@RequestBody double fare,@PathVariable("trainId")long trainId,@RequestHeader("Authorization")String token)throws Exception{
		if(!isAdmin(token)) {
			throw new MyCustomException("YOU ARE NOT ADMIN ");
		}
		return rt.postForObject("http://TRAIN-SERVICE/api/train/update/fare/"+trainId,fare, Double.class);
	};
	
	
	
	
	@PostMapping(path="/route/updateStoppage/{station}/{index}/{routeId}")
	public Route addStoppageInTrainRoute(@PathVariable("station")String station,@PathVariable("index")int index,@PathVariable("routeId") long routeId,@RequestHeader("Authorization")String token) throws Exception{
    return rt.postForObject("http://TRAIN-SERVICE/api/train/update/route/updateStoppage/"+station+"/"+index+"/"+routeId,null,Route.class);
			
	}
	
	
	
	public boolean isAdmin(String token)throws Exception{
		
		String role=rt.postForObject("http://JWT-SERVICE/jwt/getRole",token, String.class);
		return role.equalsIgnoreCase("ADMIN")?true:false;
	}
	
	
	

	
	
}
