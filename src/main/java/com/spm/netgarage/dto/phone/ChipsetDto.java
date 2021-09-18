package com.spm.netgarage.dto.phone;

public class ChipsetDto {
	
	private String id;
	private String brandmodel;
	private String cpu;
	private String gpu;
	private String lithography;
	
	public ChipsetDto() {
		
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
	
	
	

}
