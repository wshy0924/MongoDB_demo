package com.ggeit.pay.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import groovy.transform.ToString;


@Document(collection = "disease_info")
public class DiseaseInfo {
    @Id
    private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String SID;
	private String SNAME;
	private String SICK_ID;
	private String DIAGNOSIS;
	private String TREATMENT;
	private String SICK_REASON;
	private String SICK_DESC;
	private String HOSPITAL_ID;
	private String EDITABLE;

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
	public String getSICK_ID() {
		return SICK_ID;
	}
	public void setSICK_ID(String sICK_ID) {
		SICK_ID = sICK_ID;
	}
	public String getDIAGNOSIS() {
		return DIAGNOSIS;
	}
	public void setDIAGNOSIS(String dIAGNOSIS) {
		DIAGNOSIS = dIAGNOSIS;
	}
	public String getTREATMENT() {
		return TREATMENT;
	}
	public void setTREATMENT(String tREATMENT) {
		TREATMENT = tREATMENT;
	}
	public String getSICK_REASON() {
		return SICK_REASON;
	}
	public void setSICK_REASON(String sICK_REASON) {
		SICK_REASON = sICK_REASON;
	}
	public String getSICK_DESC() {
		return SICK_DESC;
	}
	public void setSICK_DESC(String sICK_DESC) {
		SICK_DESC = sICK_DESC;
	}
	public String getHOSPITAL_ID() {
		return HOSPITAL_ID;
	}
	public void setHOSPITAL_ID(String hOSPITAL_ID) {
		HOSPITAL_ID = hOSPITAL_ID;
	}
	public String getEDITABLE() {
		return EDITABLE;
	}
	public void setEDITABLE(String eDITABLE) {
		EDITABLE = eDITABLE;
	}

}
