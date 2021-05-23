package com.ak.train.controller;

import java.util.List;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ak.train.entity.Route;
import com.ak.train.entity.Train;
import com.ak.train.service.TrainUpdateService;

import io.swagger.annotations.Info;

@CrossOrigin(origins= {"http://localhost:9104"}) //only for admin
@RestController
@RequestMapping("/api/train/update")
public class TrainUpdateController {

	
	@Autowired
	private TrainUpdateService trainUpdateService;
	
	
	
	
	
	
	
	/**
	 * create new train
	 */
	
	@PostMapping(path="/addTrain")
	public Train createNewTrain(@RequestBody Train train)throws Exception{
		return trainUpdateService.createNewTrain(train);
	};
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/createRoute")
	public Route createNewRoute(@RequestBody Route route)throws Exception{
		return trainUpdateService.createNewRoute(route);
	}
	
	
	
	
	
	
	
	@PostMapping("/updateRoute/{routeId}/{station}/{index}")
	public Route addStopageInRoute(@PathVariable("routeId")long routeId,@PathVariable("station")String station,@PathVariable("index")int index)throws Exception{
	   return trainUpdateService.addStopageInRoute(routeId, station, index);	
	}
	
	
	
	/**
	 * update train availability days
	 * 
	 */
	@PostMapping(path="/availableDays/{trainId}")
	public List<String> updateAvailableDays(@RequestBody List<String> days,@PathVariable("trainId")long trainId)throws Exception{
		return trainUpdateService.updateAvailableDays(days,trainId);
	};
	
	
	
	
	/**
	 * update fare
	 */
	
	@PostMapping(path="/fare/{trainId}")
	public Double updateFare(@RequestBody double fare,@PathVariable("trainId")long trainId)throws Exception{
		return trainUpdateService.updateFare(fare, trainId);
	};
	
	
	
	
	
	
	@PostMapping(path="/update/nextStopDistance")
	public Route updateDistanceOfAnyStoppage(@RequestParam("routeId")long routeId, @RequestParam("stoppageId")long stoppageId, @RequestParam("nextStoppageDistance")double nextStoppageDistance)throws Exception {
		return trainUpdateService.updateDistanceOfAnyStoppage(routeId, stoppageId, nextStoppageDistance);
		
	}
	
	
	
	
	
	@PostMapping(path="/route/updateStoppage/{station}/{index}/{routeId}")
	public Route addStoppageInTrainRoute(@PathVariable("station")String station,@PathVariable("index")int index,@PathVariable("routeId") long routeId) throws Exception{
      return trainUpdateService.addStoppageInTrainRoute(station, index, routeId);		
	}
}
