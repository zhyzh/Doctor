package com.zhang.nong.doctor.com.java.beans;/******************************************************************************* * javaBeans * bookclass --> Bookclass  * <table explanation> * @author 2016-05-20 10:11:20 *  */	public class Bookclass implements java.io.Serializable {	//field	/** 本表的id **/	private int bookclassId;	/** 分类内容：比如经济作物 **/	private String cropclass;	//method		public int getBookclassId() {		return bookclassId;	}	public Bookclass(int bookclassId, String cropclass) {		super();		this.bookclassId = bookclassId;		this.cropclass = cropclass;	}	public void setBookclassId(int bookclassId) {		this.bookclassId = bookclassId;	}	public String getCropclass() {		return cropclass;	}	public void setCropclass(String cropclass) {		this.cropclass = cropclass;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'bookclassId':'"+this.getBookclassId()+"',");		sb.append("'cropclass':'"+this.getCropclass()+"'");		sb.append("}");		return sb.toString();	}}