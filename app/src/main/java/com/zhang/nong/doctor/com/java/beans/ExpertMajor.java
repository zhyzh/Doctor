package com.zhang.nong.doctor.com.java.beans;/******************************************************************************* * javaBeans * expert_major --> ExpertMajor  * <table explanation> * @author 2016-05-20 10:11:20 *  */	public class ExpertMajor implements java.io.Serializable {	//field	/** 本表的id **/	private int expertMajorId;	/** 专家的id外键 **/	private int expertId;	/** 特长二级分类id（水稻）（外键） **/	private int cropId;	//method		public int getExpertMajorId() {		return expertMajorId;	}	public ExpertMajor(int expertMajorId, int expertId, int cropId) {		super();		this.expertMajorId = expertMajorId;		this.expertId = expertId;		this.cropId = cropId;	}	public void setExpertMajorId(int expertMajorId) {		this.expertMajorId = expertMajorId;	}	public int getExpertId() {		return expertId;	}	public void setExpertId(int expertId) {		this.expertId = expertId;	}	public int getCropId() {		return cropId;	}	public void setCropId(int cropId) {		this.cropId = cropId;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'expertMajorId':'"+this.getExpertMajorId()+"',");		sb.append("'expertId':'"+this.getExpertId()+"',");		sb.append("'cropId':'"+this.getCropId()+"'");		sb.append("}");		return sb.toString();	}}