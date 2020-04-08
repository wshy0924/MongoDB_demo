package com.ggeit.pay.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "body_detail")
public class Bodydetail {
	
	private String id;
	private String SID;
	private String SNAME;
	private String BODY_ID;
	private String BODY_NAME;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSID() {
		return SID;
	}
	public void setSID(String sID) {
		SID = sID;
	}
	public String getSNAME() {
		return SNAME;
	}
	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}
	public String getBODY_ID() {
		return BODY_ID;
	}
	public void setBODY_ID(String bODY_ID) {
		BODY_ID = bODY_ID;
	}
	public String getBODY_NAME() {
		return BODY_NAME;
	}
	public void setBODY_NAME(String bODY_NAME) {
		BODY_NAME = bODY_NAME;
	}

}
