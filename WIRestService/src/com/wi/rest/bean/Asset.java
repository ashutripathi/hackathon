package com.wi.rest.bean;

import javax.xml.bind.annotation.XmlElement;


	public class Asset {
		
		String type;
		String assetid;
		String name;
		String empid;
		String startdate;
		String enddate;
		
		public String getType() {
			return type;
		}
		@XmlElement
		public void setType(String type) {
			this.type = type;
		}
		public String getAssetid() {
			return assetid;
		}
		@XmlElement
		public void setAssetid(String assetid) {
			this.assetid = assetid;
		}
		public String getName() {
			return name;
		}
		@XmlElement
		public void setName(String name) {
			this.name = name;
		}
		public String getEmpid() {
			return empid;
		}
		@XmlElement
		public void setEmpid(String empid) {
			this.empid = empid;
		}
		public String getStartdate() {
			return startdate;
		}
		@XmlElement
		public void setStartdate(String startdate) {
			this.startdate = startdate;
		}
		public String getEnddate() {
			return enddate;
		}
		@XmlElement
		public void setEnddate(String enddate) {
			this.enddate = enddate;
		}
		
	 
		
	 
	}
