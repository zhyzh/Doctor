package com.zhang.nong.doctor.com.java.beans;/******************************************************************************* * javaBeans * replyimage --> Replyimage  * <table explanation> * @author 2016-05-20 10:11:20 *  */	public class Replyimage implements java.io.Serializable {	//field	/** 回帖的照片表 **/	private int replyimageId;	/** 地址 **/	private String url;	/** 回复的id **/	private int replyId;	//method	public int getReplyimageId() {		return replyimageId;	}	public Replyimage(int replyimageId, String url, int replyId) {		super();		this.replyimageId = replyimageId;		this.url = url;		this.replyId = replyId;	}	public void setReplyimageId(int replyimageId) {		this.replyimageId = replyimageId;	}	public String getUrl() {		return url;	}	public void setUrl(String url) {		this.url = url;	}	public int getReplyId() {		return replyId;	}	public void setReplyId(int replyId) {		this.replyId = replyId;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'replyimageId':'"+this.getReplyimageId()+"',");		sb.append("'url':'"+this.getUrl()+"',");		sb.append("'replyId':'"+this.getReplyId()+"'");		sb.append("}");		return sb.toString();	}}