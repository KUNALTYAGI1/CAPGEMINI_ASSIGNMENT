package com.ak.train.service;

import java.util.List;

import com.ak.train.entity.Route;
import com.ak.train.entity.Train;

public interface TrainUpdateService {

	
	
	/**
	 * create new train
	 */
	public Train createNewTrain(Train train)throws Exception;
	
	
	
	/**
	 * update train availability days
	 * 
	 */
	
	public List<String> updateAvailableDays(List<String> days,long trainId)throws Exception;
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param route
	 * @return
	 * @throws Exception
	 */
	public Route createNewRoute(Route route)throws Exception;
	
	
	
	
	/**
	 * 
	 * @param routeId
	 * @param station
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public Route addStopageInRoute(long routeId,String station,int index)throws Exception;
	
	
	
	
	
	
	
	
	
	public Route updateDistanceOfAnyStoppage(long routeId,long stoppageId,double nextStoppageDistance)throws Exception;
	
	
	/**
	 * 
	 * @param station
	 * @param index
	 * @param routeId
	 * @return
	 * @throws Exception
	 */
	
	public Route addStoppageInTrainRoute(String station,int index, long routeId) throws Exception;
	
	
	
	/**
	 * update fare
	 */
	public Double updateFare(double fare,long trainId)throws Exception;
}
