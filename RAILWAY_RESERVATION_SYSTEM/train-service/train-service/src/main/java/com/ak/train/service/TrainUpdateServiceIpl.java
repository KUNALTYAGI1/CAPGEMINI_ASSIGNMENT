package com.ak.train.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.train.entity.Route;
import com.ak.train.entity.SeatBucket;
import com.ak.train.entity.Stoppage;
import com.ak.train.entity.Train;
import com.ak.train.entity.Train.Day;
import com.ak.train.repo.RouteRepo;
import com.ak.train.repo.SeatBucketRepo;
import com.ak.train.repo.StoppageRepo;
import com.ak.train.repo.TrainRepo;

@Service
public class TrainUpdateServiceIpl implements TrainUpdateService{

	@Autowired
	private TrainRepo trainRepo;
	@Autowired
	private RouteRepo routeRepo;
	@Autowired
	private StoppageRepo stoppageRepo;
	@Autowired
	private SeatBucketRepo seatBucketRepo;
	
	
	@Override
	public Train createNewTrain(Train train) throws Exception {
		SeatBucket seatBucket=new SeatBucket();
		
		seatBucket.setSeatBucketId(seatBucketRepo.count()+1);
		seatBucketRepo.save(seatBucket);
		train.setSeatBucketId(seatBucket.getSeatBucketId());
		
		//create new route
		Route route=new Route();
		route.setId(routeRepo.count()+1);
		routeRepo.save(route);
		
		train.setRouteId(route.getId());
		
		train.setTrainId(trainRepo.count()+1);
		return trainRepo.save(train);
	}
	
	
	
	
	
	@Override
	public List<String> updateAvailableDays(List<String> days, long trainId) throws Exception {
		Train train=null;
		List<Day> daysList=null;
        train= trainRepo.findById(trainId).get();
        
        daysList=days.stream().filter(day->{
        	return day.isEmpty()||day==null?false:true;
        }).map(day->{
        	return Day.valueOf(day);
        }).collect(Collectors.toList());
        
        daysList.addAll(train.getAvailableDays());
        
        daysList=daysList.stream().distinct().collect(Collectors.toList());
        train.getAvailableDays().clear();
        train.getAvailableDays().addAll(daysList);
        train=trainRepo.save(train);
        return train.getAvailableDays().stream().map(day->day.name()).distinct().collect(Collectors.toList());
	}
	
	
	
	
	
	
	
	@Override
	public Route createNewRoute(Route route) throws Exception {
		return routeRepo.save(route);	
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Route addStopageInRoute(long routeId, String station, int index) throws Exception {	
		Route route=null;
		Optional<Stoppage> optional=null;
		Stoppage stoppage=null;
		route=routeRepo.findById(routeId).get();
		optional=route.getStoppages().stream().filter(stp->{
			return stp.getPosition()==index;
					}).findFirst();
		if(! optional.isPresent()) {
			stoppage=new Stoppage();
			stoppage.setDuration(5);//yha mene hardcoded value de rkha h
			stoppage.setPosition(index);
			stoppage.setStationName(station);
			stoppage.setStoppageId(stoppageRepo.count()+1);
			route.getStoppages().add(stoppage);
		}
		else {
			stoppage=optional.get();
			}
		stoppage.setStationName(station);
		stoppage.setPosition(index);
		routeRepo.save(route);
		stoppageRepo.save(stoppage);
		return route;
	}
	
	
	
	
	
	
	
	@Override
	public Route addStoppageInTrainRoute(String station,int index, long routeId) throws Exception {
		Route route=null;
		Optional<Stoppage> optional=null;
		Stoppage stoppage=null;
		route=routeRepo.findById(routeId).get();
		System.out.println("size-------------------"+route.getStoppages().size());
		optional=route.getStoppages().stream().filter(stp->{
			System.out.println("stp======"+stp);
			System.out.println("index----------"+index);
			return stp.getPosition()==index;
					}).findFirst();
		
		
		
		System.out.println(optional.isPresent()+"-----------------");
		if(!( optional.isPresent())) {
			stoppage=new Stoppage();
			stoppage.setDuration(5);
			stoppage.setPosition(index);
			stoppage.setStationName(station);
			
			stoppage.setStoppageId(stoppageRepo.count()+1);
			route.getStoppages().add(stoppage);
		}
		else {
		stoppage=optional.get();
		}
		stoppage.setStationName(station);
		stoppage.setPosition(index);
		
		routeRepo.save(route);
		stoppageRepo.save(stoppage);
		return route;
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public Route updateDistanceOfAnyStoppage(long routeId, long stoppageId, double nextStoppageDistance)
			throws Exception {
		Route route=null;
		Stoppage stoppage=null;
		route=routeRepo.findById(routeId).get();
		
		stoppage=route.getStoppages().stream().filter(stop->{
			return stop.getStoppageId()==stoppageId;
		}).findFirst().get();
		
		stoppage.setNextStoppageDistance(nextStoppageDistance);
		route.getStoppages().removeIf(stop->stop.getStoppageId()==stoppageId);
		route.getStoppages().add(stoppage);
		routeRepo.save(route);
		return route;
	}
	
	
	
	
	
	@Override
	public Double updateFare(double fare, long trainId) throws Exception {
		Train train=null;
		train=trainRepo.findById(trainId).get();
		train.setFarePerKm(fare);
	    train=	trainRepo.save(train);
	    return train.getFarePerKm();
	
	}
}
