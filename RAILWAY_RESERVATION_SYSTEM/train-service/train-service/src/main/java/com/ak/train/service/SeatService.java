package com.ak.train.service;

import java.util.List;

import com.ak.train.entity.Seat;
import com.ak.train.entity.SeatBucket;


public interface SeatService {
	
	/**
	 * sets all seats as available
	 * @param seatBucketId
	 * @return
	 * @throws Exception
	 */
	public boolean refreshAllSeats(long seatBucketId)throws Exception;
	
	
	
	
	
	/**
	 * usually used when someone cancels his ticket 
	 * @param seatIds
	 * @return
	 * @throws Exception
	 */
	public List<Seat> markSeatsAsAvailable(List<Long> seatIds)throws Exception;
	
	
	
	/**
	 * it adds autoincrement to seat's id and create new seat
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public Seat createNewSeat(Seat seat,long seatBucketId)throws Exception;

	
	
	
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean deleteSeat(long seatId,long seatBucketId)throws Exception;
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param seatId
	 * @param seatBucketId
	 * @return
	 * @throws Exception
	 */
	public SeatBucket addSeatToSeatBucket(long seatId,long seatBucketId)throws Exception;
	
	
	
	public SeatBucket removeSeatFromSeatBucket(long seatId,long seatBucketId)throws Exception;
	
	
	
	
	
	
	
	public long checkAvailableSeatsInBucket(long seatBucketId)throws Exception;
	
	
	
	
	
	
	
	public List<Seat> allotSeatToPassengers(long trainId,List<Long> passengerIds)throws Exception;
 }
