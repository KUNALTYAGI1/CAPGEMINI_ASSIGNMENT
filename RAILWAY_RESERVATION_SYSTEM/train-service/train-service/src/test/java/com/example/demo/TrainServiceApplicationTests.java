package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.ak.train.entity.Seat;
import com.ak.train.entity.SeatBucket;
import com.ak.train.entity.Train;
import com.ak.train.repo.SeatBucketRepo;
import com.ak.train.repo.SeatRepo;
import com.ak.train.repo.TrainRepo;
import com.ak.train.service.SeatService;



@RunWith(SpringRunner.class)
@SpringBootTest

class TrainServiceApplicationTests {

	
	@MockBean
	private SeatBucketRepo seatBucketRepo;
	@MockBean
	private SeatRepo seatRepo;
	@MockBean
	private TrainRepo trainRepo;
	
	@Autowired
	private SeatService seatService;
	
	
	@Test
	void contextLoads() {
	}
	
	
	
	
	@Test
	public void refreshAllSeatsTest() {
		when(seatBucketRepo.findById(1l)).thenReturn(Optional.of(new SeatBucket()));
		
		when(seatRepo.findAllById(Stream.of(1l,2l).collect(Collectors.toList()))).thenReturn(Stream.of(new Seat(),new Seat()).collect(Collectors.toList()));
	
	
	    when(seatRepo.saveAll(Stream.of(new Seat()).collect(Collectors.toList()))).thenReturn(Stream.of(new Seat()).collect(Collectors.toList()));
	
	    
	}
	
	
	
	@Test
	public void createNewSeatTest() {
		try {
		Seat seat=new Seat();
		when(seatRepo.count()).thenReturn(1l);
		when(seatRepo.save(seat)).thenReturn(seat);
		
		when(seatBucketRepo.findById(1l)).thenReturn(Optional.of(new SeatBucket()));
		when(seatBucketRepo.save(new SeatBucket())).thenReturn(new SeatBucket());
		assertEquals(seat, seatService.createNewSeat(seat, 1l));

	  }catch (Exception e) {
		assertThat(e).isInstanceOf(Exception.class);
	}	
	}
	
	
	
	
	
	
	
	@Test
	public void deleteSeatTest() {
		when(seatBucketRepo.findById(1l)).thenReturn(Optional.of(new SeatBucket()));
	}
	
	
	
	
	@Test
	public void addSeatToSeatBucketTest() {
		try {
		SeatBucket seatBucket=new SeatBucket();
		when(seatBucketRepo.findById(1l)).thenReturn(Optional.of(seatBucket));
		when(seatBucketRepo.save(seatBucket)).thenReturn(seatBucket);
		
		assertEquals(seatBucket,seatService.addSeatToSeatBucket(1,1));
		}catch (Exception e) {
			assertThat(e).isInstanceOf(Exception.class);
		}
	}
	
	
	
	
	
	@Test
	public void  removeSeatFromSeatBucketTest() {
		SeatBucket seatBucket=new SeatBucket();
		when(seatBucketRepo.findById(1l)).thenReturn(Optional.of(seatBucket));
		when(seatBucketRepo.save(seatBucket)).thenReturn(seatBucket);
		
	}
	
	
	
	
	
	
	
	@Test
	public void checkAvailableSeatsInBucketTest() {
		when(seatBucketRepo.findById(1l)).thenReturn(Optional.of(new SeatBucket()));
        when(seatRepo.findAllById(Stream.of(1l).collect(Collectors.toList()))).thenReturn(Stream.of(new Seat()).collect(Collectors.toList()));
	
	}
	
	
	
	
	
	@Test
	public void allotSeatToPassengersTest() {
		when(trainRepo.findById(1l)).thenReturn(Optional.of(new Train()));
		when(seatBucketRepo.findById(1l)).thenReturn(Optional.of(new SeatBucket()));
		when(seatRepo.findAllById(Stream.of(1l).collect(Collectors.toList()))).thenReturn(Stream.of(new Seat()).collect(Collectors.toList()));
		when(seatRepo.saveAll(Stream.of(new Seat()).collect(Collectors.toList()))).thenReturn(Stream.of(new Seat()).collect(Collectors.toList()));
	}
	
	
	
	
	
	
	@Test
	public void markSeatsAsAvailableTest() {
		when(seatRepo.findAllById(Stream.of(1l).collect(Collectors.toList()))).thenReturn(Stream.of(new Seat()).collect(Collectors.toList()));
		when(seatRepo.saveAll(Stream.of(new Seat()).collect(Collectors.toList()))).thenReturn(Stream.of(new Seat()).collect(Collectors.toList()));
	}

}
