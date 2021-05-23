package com.ak.train.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="route")
public class Route {
	
	
	@Id
	private long id;
	private List<Stoppage> stoppages=new ArrayList<Stoppage>();

}
