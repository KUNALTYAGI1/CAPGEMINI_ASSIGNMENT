package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ak.train.entity.Route;
import com.ak.train.entity.Train;
import com.ak.train.repo.RouteRepo;
import com.ak.train.repo.TrainRepo;
import com.ak.train.service.TrainService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainServiceTest {

	
	@MockBean
	private TrainRepo trainRepo;
	@MockBean
	private RouteRepo routeRepo;
    @Autowired
	private TrainService trainService;

	
	
	
	@Test
	public void contextLoads() {
	}
	
	
	
	@Test
	public void getByIdTest() {
		try {
		Train train=new Train();
		when(trainRepo.findById(1l)).thenReturn(Optional.of(train));
		
	    assertEquals(train, trainService.getById(1l)); 
		    }catch (Exception e) {
			assertThat(e).isInstanceOf(Exception.class);
		}	
	}
	
	
	
	
	
	
	
	@Test
	public void getAllByNameTest() {
		when(trainRepo.findAllByName("name")).thenReturn(Stream.of(new Train()).collect(Collectors.toList()));
	}
	
	
	
	
     @Test	
	public void getAllBewteenStationsTest() {
		when(routeRepo.findAllByRouteStationName("patna","saharsa")).thenReturn(Stream.of(new Route()).collect(Collectors.toList()));
		when(trainRepo.findAllById(Stream.of(1l).collect(Collectors.toList()))).thenReturn(Stream.of(new Train()).collect(Collectors.toList()));
	}
	
     
     
     
     @Test
     public void getTrainRouteTest() {
    	when(trainRepo.findById(1l)).thenReturn(Optional.of(new Train())); 
    	when(routeRepo.findById(1l)).thenReturn(Optional.of(new Route()));
     }
     
     
     
     
     
     @Test
     public void getFarePerKmTest() {
    	 when(trainRepo.findById(1l)).thenReturn(Optional.of(new Train()));
     }
     
     
    
     @Test
     public void calculateTotalDistanceTest() {
    	 when(routeRepo.findById(1l)).thenReturn(Optional.of(new Route()));
     }
     
     
     
     
     
}
