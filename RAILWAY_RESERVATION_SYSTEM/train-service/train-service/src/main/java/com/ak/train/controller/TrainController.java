package com.ak.train.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.train.entity.Route;
import com.ak.train.entity.Train;
import com.ak.train.repo.RouteRepo;
import com.ak.train.service.TrainService;



@CrossOrigin
@RestController
@RequestMapping("/train")
public class TrainController {
	
	@Autowired
	private TrainService trainService;
	
	@Autowired
	private RouteRepo routeRepo;
	
	
	
	
	
	
	/**
	 * get train by id
	 */
	@GetMapping(path="/get/byId/{trainId}")
	public Train getTrainById(@PathVariable("trainId")long trainId)throws Exception{
		return trainService.getById(trainId);
	}

	
	
	
	
	
	
	
	/**
	 * get all by trainName
	 * may be two or more trains have same name
	 */
	@GetMapping(path="/get/byName/{name}")
	public List<Train> getAllByName(@PathVariable("name")String name)throws Exception{
		return trainService.getAllByName(name);
	};
	
	
	
	
	
	
	
	
	/**
	 * get all between stations
	 */
	@GetMapping(path="/get/BtwStations/{startingPoint}/{destinationPoint}")
	public List<Train> getAllBewteenStations(@PathVariable("startingPoint")String startingPoint,@PathVariable("destinationPoint")String destinationPoint)throws Exception{
		List<Train> trains=null;
		trains= trainService.getAllBewteenStations(startingPoint, destinationPoint);
		return trains.stream().filter(train->true).collect(Collectors.toList());
	};
	
	
	
	
	
	
	
    @GetMapping("/get/trainroute/{trainId}")
	public Route getTrainRoute(@PathVariable("trainId")long trainId) throws Exception {
	return trainService.getTrainRoute(trainId);
	}	
	
	
    
    
    
    
    
    
    
    @GetMapping("/get/farePerKm/{trainId}")
    public double getFarePerKm(@PathVariable("trainId")long trainId) throws Exception {
    	return trainService.getFarePerKm(trainId);
    }
    
    
    
    
    @GetMapping("/get/TotalDistance/{routeId}/{startPoint}/{endPoint}")
    public double calculateTotalDistance(@PathVariable("routeId")long routeId,@PathVariable("startPoint") String startPoint,@PathVariable("endPoint")String endPoint) throws Exception {
        Route route=null;
        int startPosition=0;
        int endPosition=0;
        
    	//get start and end position from route
        route=routeRepo.findById(routeId).get();
        startPosition=route.getStoppages().stream().filter(stop->{
        	return stop.getStationName().equalsIgnoreCase(startPoint); 
        }).findAny().get().getPosition();
        
        endPosition=route.getStoppages().stream().filter(stop->{
        	return stop.getStationName().equalsIgnoreCase(endPoint); 
        }).findAny().get().getPosition();
    	return trainService.calculateTotalDistance(routeId, startPosition, endPosition);	
    }
	
    
    
    
    
    
    
    
    
}