package com.beerrun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="am_defaultdetails")
public class DefaultDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Integer id;
	
	@Column(name="country", nullable=true)
	  private String country;
	
	@Column(name="weight", nullable=true)
	  private String weight;
	
	@Column(name="weightunit", nullable=true)
	  private String weightunit;
	
	@Column(name="unitname", nullable=true)
	  private String unitname;
	
	@Column(name="unitshortname", nullable=true)
	  private String unitshortname;
	
	@Column(name="batchstartingno", nullable=true)
	  private String batchstartingno;
	
	@Column(name="billstartingno", nullable=true)
	  private String billstartingno;
	
	@Column(name="postartingno", nullable=true)
	  private String postartingno;
	
	@Column(name="gsttaxvalue", nullable=true)
	  private String gsttaxvalue;
	
	@Column(name="statettb", nullable=true)
	  private String statettb;
	
	@Column(name="salestaxstatusonof", nullable=true)
	  private int salestaxstatusonof;
	
	@Column(name="forecast_setting", nullable=true)
	  private String forecastsetting;
	
	@Column(name="drmshipdatestatus", nullable=true)
	  private int drmshipdatestatus;
	
	@Column(name="gmailusername", nullable=true)
	  private String gmailusername;
	
	@Column(name="gmailpassword", nullable=true)
	  private String gmailpassword;
	
	@Column(name="classname", nullable=true)
	  private String classname;
	
	@Column(name="autoinvoicesignature", nullable=true)
	  private int autoinvoicesignature;
	
	@Column(name="invoicesignature", nullable=true)
	  private int invoicesignature;
	
	@Column(name="blsignature", nullable=true)
	  private int blsignature;
	
	@Column(name="sosignature", nullable=true)
	  private int sosignature;
	
	@Column(name="daysout", nullable=true)
	  private String daysout;
	
	@Column(name="packdatestatus", nullable=true)
	  private int packdatestatus;
	
	@Column(name="brewhousesize", nullable=true)
	  private String brewhousesize;
	
	@Column(name="returnsdays", nullable=true)
	  private String returnsdays;
	
	@Column(name="autoshipdepositstatus", nullable=true)
	  private int autoshipdepositstatus;
	
	@Column(name="defaultshipday", nullable=true)
	  private String defaultshipday;

	@Column(name="volumeunit", nullable=true)
	  private String volumeUnit;
	
	@Column(name="gsttaxvaluestatus", nullable=true)
	  private int gstTaxValueStatus;
	
	@Column(name="psttaxvaluestatus", nullable=true)
	  private int pstTaxValueStatus;
	
	@Column(name="gstbilltax", nullable=true)
	  private int gstBillTax;
	
	@Column(name="pstbilltax", nullable=true)
	  private int pstBillTax;
	
	@Column(name="kegtrackingstatus", nullable=true)
	  private int kegTrackingStatus;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWeightunit() {
		return weightunit;
	}

	public void setWeightunit(String weightunit) {
		this.weightunit = weightunit;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getUnitshortname() {
		return unitshortname;
	}

	public void setUnitshortname(String unitshortname) {
		this.unitshortname = unitshortname;
	}

	public String getBatchstartingno() {
		return batchstartingno;
	}

	public void setBatchstartingno(String batchstartingno) {
		this.batchstartingno = batchstartingno;
	}

	public String getBillstartingno() {
		return billstartingno;
	}

	public void setBillstartingno(String billstartingno) {
		this.billstartingno = billstartingno;
	}

	public String getPostartingno() {
		return postartingno;
	}

	public void setPostartingno(String postartingno) {
		this.postartingno = postartingno;
	}

	public String getGsttaxvalue() {
		return gsttaxvalue;
	}

	public void setGsttaxvalue(String gsttaxvalue) {
		this.gsttaxvalue = gsttaxvalue;
	}

	public String getStatettb() {
		return statettb;
	}

	public void setStatettb(String statettb) {
		this.statettb = statettb;
	}

	public int getSalestaxstatusonof() {
		return salestaxstatusonof;
	}

	public void setSalestaxstatusonof(int salestaxstatusonof) {
		this.salestaxstatusonof = salestaxstatusonof;
	}

	public String getForecastsetting() {
		return forecastsetting;
	}

	public void setForecastsetting(String forecastsetting) {
		this.forecastsetting = forecastsetting;
	}

	public int getDrmshipdatestatus() {
		return drmshipdatestatus;
	}

	public void setDrmshipdatestatus(int drmshipdatestatus) {
		this.drmshipdatestatus = drmshipdatestatus;
	}

	public String getGmailusername() {
		return gmailusername;
	}

	public void setGmailusername(String gmailusername) {
		this.gmailusername = gmailusername;
	}

	public String getGmailpassword() {
		return gmailpassword;
	}

	public void setGmailpassword(String gmailpassword) {
		this.gmailpassword = gmailpassword;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public int getAutoinvoicesignature() {
		return autoinvoicesignature;
	}

	public void setAutoinvoicesignature(int autoinvoicesignature) {
		this.autoinvoicesignature = autoinvoicesignature;
	}

	public int getInvoicesignature() {
		return invoicesignature;
	}

	public void setInvoicesignature(int invoicesignature) {
		this.invoicesignature = invoicesignature;
	}

	public int getBlsignature() {
		return blsignature;
	}

	public void setBlsignature(int blsignature) {
		this.blsignature = blsignature;
	}

	public int getSosignature() {
		return sosignature;
	}

	public void setSosignature(int sosignature) {
		this.sosignature = sosignature;
	}

	public String getDaysout() {
		return daysout;
	}

	public void setDaysout(String daysout) {
		this.daysout = daysout;
	}

	public int getPackdatestatus() {
		return packdatestatus;
	}

	public void setPackdatestatus(int packdatestatus) {
		this.packdatestatus = packdatestatus;
	}

	public String getBrewhousesize() {
		return brewhousesize;
	}

	public void setBrewhousesize(String brewhousesize) {
		this.brewhousesize = brewhousesize;
	}

	public String getReturnsdays() {
		return returnsdays;
	}

	public void setReturnsdays(String returnsdays) {
		this.returnsdays = returnsdays;
	}

	
	public String getDefaultshipday() {
		return defaultshipday;
	}

	public void setDefaultshipday(String defaultshipday) {
		this.defaultshipday = defaultshipday;
	}

	public int getAutoshipdepositstatus() {
		return autoshipdepositstatus;
	}

	public void setAutoshipdepositstatus(int autoshipdepositstatus) {
		this.autoshipdepositstatus = autoshipdepositstatus;
	}

	public String getVolumeUnit() {
		return volumeUnit;
	}

	public void setVolumeUnit(String volumeUnit) {
		this.volumeUnit = volumeUnit;
	}

	public int getGstTaxValueStatus() {
		return gstTaxValueStatus;
	}

	public void setGstTaxValueStatus(int gstTaxValueStatus) {
		this.gstTaxValueStatus = gstTaxValueStatus;
	}

	public int getPstTaxValueStatus() {
		return pstTaxValueStatus;
	}

	public void setPstTaxValueStatus(int pstTaxValueStatus) {
		this.pstTaxValueStatus = pstTaxValueStatus;
	}

	public int getGstBillTax() {
		return gstBillTax;
	}

	public void setGstBillTax(int gstBillTax) {
		this.gstBillTax = gstBillTax;
	}

	public int getPstBillTax() {
		return pstBillTax;
	}

	public void setPstBillTax(int pstBillTax) {
		this.pstBillTax = pstBillTax;
	}

	public int getKegTrackingStatus() {
		return kegTrackingStatus;
	}

	public void setKegTrackingStatus(int kegTrackingStatus) {
		this.kegTrackingStatus = kegTrackingStatus;
	}
	
	
	
}
