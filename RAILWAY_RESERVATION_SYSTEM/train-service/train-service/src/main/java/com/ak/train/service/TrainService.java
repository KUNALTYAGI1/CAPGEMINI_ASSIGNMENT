package com.ak.train.service;

import java.util.List;

import com.ak.train.entity.Route;
import com.ak.train.entity.Train;

public interface TrainService {


	
	/**
	 * get train by train id
	 */
	public Train getById(long trainId)throws Exception;
	
	
	/**
	 * get all by trainName
	 * may be two or more trains have same name
	 */
	public List<Train> getAllByName(String name)throws Exception;
	
	
	
	
	
	/**
	 * 
	 * @param trainId
	 * @return
	 * @throws Exception
	 */
	public Route getTrainRoute(long trainId)throws Exception;
	
	
	
	
	
	/**
	 * get all between stations
	 */
	public List<Train> getAllBewteenStations(String startingPoint,String destinationPoint)throws Exception;
	
	
	
	
	
	/**
	 * 
	 * @param trainId
	 * @return
	 * @throws Exception
	 */
	public double getFarePerKm(long trainId)throws Exception;
	
	
	
	public double calculateTotalDistance(long routeId,int startPostion, int endPosition)throws Exception;
}
