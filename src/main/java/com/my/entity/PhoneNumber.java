package com.my.entity;

import javax.validation.constraints.Size;


public class PhoneNumber {
	
	@Size(min=3,max=4,message="区号必须3-4位")
	private String areaCode;
	
	@Size(min=7,max=8,message="号码必须在7-8位")
	private String phoneNumber;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return this.areaCode+"-"+this.phoneNumber;
	}
}
