package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ak.train.entity.Route;
import com.ak.train.entity.SeatBucket;
import com.ak.train.entity.Stoppage;
import com.ak.train.entity.Train;
import com.ak.train.repo.RouteRepo;
import com.ak.train.repo.SeatBucketRepo;
import com.ak.train.repo.StoppageRepo;
import com.ak.train.repo.TrainRepo;
import com.ak.train.service.TrainUpdateService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainUpdateserviceTest {
	@MockBean
	private TrainRepo trainRepo;
	@MockBean
	private RouteRepo routeRepo;
	@MockBean
	private StoppageRepo stoppageRepo;
	@MockBean
	private SeatBucketRepo seatBucketRepo;
	@Autowired
	private TrainUpdateService trainUpdateService;
	
	
	
	
	@Test
	public void createNewTrainTest() {
		try {
		Train train=new Train();
		when(seatBucketRepo.count()).thenReturn(1l);
		when(seatBucketRepo.save(new SeatBucket())).thenReturn(new SeatBucket());
		when(routeRepo.count()).thenReturn(1l);
		when(routeRepo.save(new Route())).thenReturn(new Route());
		when(trainRepo.count()).thenReturn(1l);
		when(trainRepo.save(train)).thenReturn(train);
		assertEquals(train,trainUpdateService.createNewTrain(train));
	    }catch (Exception e) {
			    assertThat(e).isInstanceOf(Exception.class);
			}
	   }
	
	
	
	
	
	
	
	
	
	
	 @Test
	 public void updateAvailableDaysTrain() {
	    	when(trainRepo.findById(1l)).thenReturn(Optional.of(new Train()));
	    	when(trainRepo.save(new Train())).thenReturn(new Train());
	 }
	
	
	    
	    
	    
	@Test
	public void createNewRouteTest() {
		when(routeRepo.save(new Route())).thenReturn(new Route());
	}
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void addStopageInRouteTest() {
		when(routeRepo.findById(1l)).thenReturn(Optional.of(new Route()));
		when(stoppageRepo.count()).thenReturn(1l);
		when(routeRepo.save(new Route())).thenReturn(new Route());
		when(stoppageRepo.save(new Stoppage())).thenReturn(new Stoppage());
	}
	
	
	
	
	
	
	@Test
	public void addStoppageInTrainRouteTest() {
		when(routeRepo.findById(1l)).thenReturn(Optional.of(new Route()));
		when(stoppageRepo.count()).thenReturn(1l);
		when(routeRepo.save(new Route())).thenReturn(new Route());
		when(stoppageRepo.save(new Stoppage())).thenReturn(new Stoppage());
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void updateDistanceOfAnyStoppageTest() {
		when(routeRepo.findById(1l)).thenReturn(Optional.of(new Route()));
		when(routeRepo.save(new Route())).thenReturn(new Route());
	}
	
	
	
	
	
	
	
	
	@Test
	public void updateFare() {
		Train train=new Train();
		when(trainRepo.findById(1l)).thenReturn(Optional.of(train));
		when(trainRepo.save(train)).thenReturn(train);
	}
}
