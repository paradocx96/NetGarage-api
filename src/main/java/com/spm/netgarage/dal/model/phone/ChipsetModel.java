package com.spm.netgarage.dal.model.phone;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ChipsetModel {
	
	@Id
	private String id;
	//had to be changed from brandAndModel because of issue in mongo repository interface not recognizing the 
	//attribute
	//getter and setter names remain unchanged
	private String brandmodel;  
	private String cpu;
	private String gpu;
	private String lithography;
	
	public ChipsetModel() {
		
	}
	

	public ChipsetModel(String id, String brandAndModel, String cpu, String gpu, String lithography) {
		super();
		this.id = id;
		this.brandmodel = brandAndModel;
		this.cpu = cpu;
		this.gpu = gpu;
		this.lithography = lithography;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrandmodel() {
		return brandmodel;
	}

	public void setBrandmodel(String brandAndModel) {
		this.brandmodel = brandAndModel;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}
	

	public String getLithography() {
		return lithography;
	}


	public void setLithography(String lithography) {
		this.lithography = lithography;
	}


	@Override
	public String toString() {
		return "ChipsetModel [id=" + id + ", brandAndModel=" + brandmodel + ", cpu=" + cpu + ", gpu=" + gpu
				+ ", lithography=" + lithography + "]";
	}
	
	
	
	

}
