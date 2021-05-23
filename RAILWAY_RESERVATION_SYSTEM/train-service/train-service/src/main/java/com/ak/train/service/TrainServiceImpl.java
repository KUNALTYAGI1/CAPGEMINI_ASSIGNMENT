package com.ak.train.service;

import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.train.entity.Route;
import com.ak.train.entity.Stoppage;
import com.ak.train.entity.Train;
import com.ak.train.repo.RouteRepo;
import com.ak.train.repo.TrainRepo;

@Service
public class TrainServiceImpl implements TrainService{

	@Autowired
	private TrainRepo trainRepo;
	@Autowired
	private RouteRepo routeRepo;


	@Override
	public Train getById(long trainId) throws Exception {
		return trainRepo.findById(trainId).get();
	}
	
	
	

	@Override
	public List<Train> getAllByName(String name) throws Exception {
		return trainRepo.findAllByName(name);
		
	}

	

	@Override
	public List<Train> getAllBewteenStations(String startingPoint, String destinationPoint) throws Exception {
		List<Route> routes=null;
		List<Long> routesIds=null;
		Iterable<Train> iterable=null;
		routes=routeRepo.findAllByRouteStationName(startingPoint, destinationPoint);
		routesIds=routes.stream().filter(rout->{
			int startingPointosition=0;
			int destinationPosition=0;		
			startingPointosition=rout.getStoppages().stream().filter(stoppage->{
				return stoppage.getStationName().equals(startingPoint);
			}).findFirst().get().getPosition();
			destinationPosition=rout.getStoppages().stream().filter(stoppage->{
				return stoppage.getStationName().equals(destinationPoint);
			}).findFirst().get().getPosition();
			
			return startingPointosition<destinationPosition;
		}).map(rt->rt.getId()).collect(Collectors.toList());
		iterable= trainRepo.findAllById(routesIds);
		return StreamSupport.stream(iterable.spliterator(), true).collect(Collectors.toList());
	}
	
	
	
	
	
	
	

	
	@Override
	public Route getTrainRoute(long trainId) throws Exception {
		long routeId=trainRepo.findById(trainId).get().getRouteId();
		return routeRepo.findById(routeId).get();
		
	}
	
	
	
	

	
	
	
	
	
	
	
	@Override
	public double getFarePerKm(long trainId) throws Exception {
		return trainRepo.findById(trainId).get().getFarePerKm();
	}
	
	
	
	
	
	
	
	@Override
	public double calculateTotalDistance(long routeId, int startPostion, int endPosition) throws Exception {
		Route route=null;
		double distance=0;
		
		route=routeRepo.findById(routeId).get();		
		distance=route.getStoppages().stream().filter(stopage->{
			return stopage.getPosition()>=startPostion && stopage.getPosition()<endPosition;
		}).mapToDouble(new ToDoubleFunction<Stoppage>() {
        	@Override
			public double applyAsDouble(Stoppage value) {
				return value.getNextStoppageDistance();
			}
		}).sum();
		
		System.out.println("distance---------"+distance);
		return distance;
	}
}
