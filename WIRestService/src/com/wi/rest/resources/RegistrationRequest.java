package com.wi.rest.resources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegistrationRequest {
	private String androidId;
	private String userName;
	

	public String getAndroidId() {
		return androidId;
	}

	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
		
	
}
