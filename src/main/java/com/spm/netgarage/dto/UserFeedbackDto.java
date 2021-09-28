package com.spm.netgarage.dto;

public class UserFeedbackDto {
	
	private String id;
	private String deviceID;
	private String nickName;
	private String comment;
	
	public UserFeedbackDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserFeedbackDto(String deviceID, String nickName, String comment) {
		this.deviceID = deviceID;
		this.nickName = nickName;
		this.comment = comment;	
	}
	
	public String getId() {
		return id;
	}
	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getNickName() {
		return nickName;
	}
	public String getComment() {
		return comment;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}



}
