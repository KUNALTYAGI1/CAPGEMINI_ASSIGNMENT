package com.ak.train.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ak.train.entity.Route;

@Repository
public interface RouteRepo extends MongoRepository<Route, Long> {

	
	//find route by stationname
	@Query("{'stoppages.stationName':?0}")
	public List<Route> findAllByRouteStationName(String startingPoint,String destination);
	
}
