/**
 * 
 */
package com.wi.rest.resources;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Neel
 *
 */
@XmlRootElement
public class RegistrationResponse {
	private String empId;
	private int status;


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
}
