package com.spm.netgarage.dal.model.phone;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PhoneModel {
	@Id
	private String id;
	private String brandmodel;
	private String brand;
	private String image;
	//public List<String> otherimages;
	
	private String network;
	//body attributes
	
	private String dimensions;
	private String weight;
	private String sim;
	
	//display attributes
	private String displaytype;
	private String displaysize;
	private String displayresolution;
	private String displayprotection;
	
	//software
	private String os;
	private String softwarefeatures;
	
	//chipset
	private String chipset;
	
	//memory and storage
	private String memorystorage;
	private String card;
	
	//camera attributes
	//main camera
	private String maincamera;
	private String maincameraDetails;
	private String maincameraVideo;
	private String maincameraFeatures;
	
	//selfie camera
	private String selfcamera;
	private String selfcameraDetails;
	private String selfcameraVideo;
	private String selfcameraFeatures;
	
	//audio attributes
	private String loudspeaker;
	private String headphonejack;
	
	//communications
	private String wlan;
	private String bluetooth;
	private String gps;
	private String nfc;
	private String radio;
	
	//sensors
	private String sensors;
	
	//battery
	private String batterytype;
	private String charging;
	
	//miscellaneous
	private String colors;
	private String models;
	private String sar;
	
	public PhoneModel() {
		
	}
	
	public PhoneModel(String id, String brandmodel, String brand, String image, String network, String dimensions,
			String weight, String sim, String displaytype, String displaysize, String displayresolution,
			String displayprotection, String os, String softwarefeatures, String chipset, String memorystorage,
			String card, String maincamera, String maincameraDetails, String maincameraVideo, String maincameraFeatures,
			String selfcamera, String selfcameraDetails, String selfcameraVideo, String selfcameraFeatures,
			String loudspeaker, String headphonejack, String wlan, String bluetooth, String gps, String nfc,
			String radio, String sensors, String batterytype, String charging, String colors, String models,
			String sar) {
		super();
		this.id = id;
		this.brandmodel = brandmodel;
		this.brand = brand;
		this.image = image;
		this.network = network;
		this.dimensions = dimensions;
		this.weight = weight;
		this.sim = sim;
		this.displaytype = displaytype;
		this.displaysize = displaysize;
		this.displayresolution = displayresolution;
		this.displayprotection = displayprotection;
		this.os = os;
		this.softwarefeatures = softwarefeatures;
		this.chipset = chipset;
		this.memorystorage = memorystorage;
		this.card = card;
		this.maincamera = maincamera;
		this.maincameraDetails = maincameraDetails;
		this.maincameraVideo = maincameraVideo;
		this.maincameraFeatures = maincameraFeatures;
		this.selfcamera = selfcamera;
		this.selfcameraDetails = selfcameraDetails;
		this.selfcameraVideo = selfcameraVideo;
		this.selfcameraFeatures = selfcameraFeatures;
		this.loudspeaker = loudspeaker;
		this.headphonejack = headphonejack;
		this.wlan = wlan;
		this.bluetooth = bluetooth;
		this.gps = gps;
		this.nfc = nfc;
		this.radio = radio;
		this.sensors = sensors;
		this.batterytype = batterytype;
		this.charging = charging;
		this.colors = colors;
		this.models = models;
		this.sar = sar;
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

	public void setBrandmodel(String brandmodel) {
		this.brandmodel = brandmodel;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getDisplaytype() {
		return displaytype;
	}

	public void setDisplaytype(String displaytype) {
		this.displaytype = displaytype;
	}

	public String getDisplaysize() {
		return displaysize;
	}

	public void setDisplaysize(String displaysize) {
		this.displaysize = displaysize;
	}

	public String getDisplayresolution() {
		return displayresolution;
	}

	public void setDisplayresolution(String displayresolution) {
		this.displayresolution = displayresolution;
	}

	public String getDisplayprotection() {
		return displayprotection;
	}

	public void setDisplayprotection(String displayprotection) {
		this.displayprotection = displayprotection;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getSoftwarefeatures() {
		return softwarefeatures;
	}

	public void setSoftwarefeatures(String softwarefeatures) {
		this.softwarefeatures = softwarefeatures;
	}

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String getMemorystorage() {
		return memorystorage;
	}

	public void setMemorystorage(String memorystorage) {
		this.memorystorage = memorystorage;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getMaincamera() {
		return maincamera;
	}

	public void setMaincamera(String maincamera) {
		this.maincamera = maincamera;
	}

	public String getMaincameraDetails() {
		return maincameraDetails;
	}

	public void setMaincameraDetails(String maincameraDetails) {
		this.maincameraDetails = maincameraDetails;
	}

	public String getMaincameraVideo() {
		return maincameraVideo;
	}

	public void setMaincameraVideo(String maincameraVideo) {
		this.maincameraVideo = maincameraVideo;
	}

	public String getMaincameraFeatures() {
		return maincameraFeatures;
	}

	public void setMaincameraFeatures(String maincameraFeatures) {
		this.maincameraFeatures = maincameraFeatures;
	}

	public String getSelfcamera() {
		return selfcamera;
	}

	public void setSelfcamera(String selfcamera) {
		this.selfcamera = selfcamera;
	}

	public String getSelfcameraDetails() {
		return selfcameraDetails;
	}

	public void setSelfcameraDetails(String selfcameraDetails) {
		this.selfcameraDetails = selfcameraDetails;
	}

	public String getSelfcameraVideo() {
		return selfcameraVideo;
	}

	public void setSelfcameraVideo(String selfcameraVideo) {
		this.selfcameraVideo = selfcameraVideo;
	}

	public String getSelfcameraFeatures() {
		return selfcameraFeatures;
	}

	public void setSelfcameraFeatures(String selfcameraFeatures) {
		this.selfcameraFeatures = selfcameraFeatures;
	}

	public String getLoudspeaker() {
		return loudspeaker;
	}

	public void setLoudspeaker(String loudspeaker) {
		this.loudspeaker = loudspeaker;
	}

	public String getHeadphonejack() {
		return headphonejack;
	}

	public void setHeadphonejack(String headphonejack) {
		this.headphonejack = headphonejack;
	}

	public String getWlan() {
		return wlan;
	}

	public void setWlan(String wlan) {
		this.wlan = wlan;
	}

	public String getBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public String getNfc() {
		return nfc;
	}

	public void setNfc(String nfc) {
		this.nfc = nfc;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getSensors() {
		return sensors;
	}

	public void setSensors(String sensors) {
		this.sensors = sensors;
	}

	public String getBatterytype() {
		return batterytype;
	}

	public void setBatterytype(String batterytype) {
		this.batterytype = batterytype;
	}

	public String getCharging() {
		return charging;
	}

	public void setCharging(String charging) {
		this.charging = charging;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public String getModels() {
		return models;
	}

	public void setModels(String models) {
		this.models = models;
	}

	public String getSar() {
		return sar;
	}

	public void setSar(String sar) {
		this.sar = sar;
	}
	
	
	
	
}
