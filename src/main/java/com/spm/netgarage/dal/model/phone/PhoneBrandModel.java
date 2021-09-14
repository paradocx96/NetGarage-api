package com.spm.netgarage.dal.model.phone;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PhoneBrandModel {
	
	@Id
	private String id;
	private String name;
	
	public PhoneBrandModel(){
		
	}
	
	public PhoneBrandModel(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
