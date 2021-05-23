package com.ak.train.entity;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="seqDetails")
public class AutoIncrementDetails {
	
	@Id
	private Long id;
	private HashMap<String,Long> sequesnceNumber=new HashMap<String, Long>();
	
	
	public AutoIncrementDetails() {
		sequesnceNumber.put("seat",1l);
	}

}
