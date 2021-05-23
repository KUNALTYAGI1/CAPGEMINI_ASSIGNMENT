package com.ak.train.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="seatBucket")
public class SeatBucket {
	
	@Id
	private long seatBucketId;
	
	private List<Long> seatIds=new ArrayList<>();

}
