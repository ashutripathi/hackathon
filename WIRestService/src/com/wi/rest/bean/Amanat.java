package com.wi.rest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Amanat {

	List<Asset> asset = new ArrayList<Asset>();

	public List<Asset> getAsset() {
		return asset;
	}
	@XmlElement
	public void setAsset(List<Asset> asset) {
		this.asset = asset;
	}
	
}
