package com.zhang.nong.doctor.com.java.beans;/******************************************************************************* * javaBeans * phase_class --> PhaseClass  * <table explanation> * @author 2016-05-20 10:11:20 *  */	public class PhaseClass implements java.io.Serializable {	//field	/** 本表id **/	private int phaseClassId;	/** 分类名称 **/	private String phaseClassName;	/** 内容 **/	private String content;	/** 日志的阶段表id（外键） **/	private int phaseId;	//method		public int getPhaseClassId() {		return phaseClassId;	}	public PhaseClass(int phaseClassId, String phaseClassName, String content,			int phaseId) {		super();		this.phaseClassId = phaseClassId;		this.phaseClassName = phaseClassName;		this.content = content;		this.phaseId = phaseId;	}	public void setPhaseClassId(int phaseClassId) {		this.phaseClassId = phaseClassId;	}	public String getPhaseClassName() {		return phaseClassName;	}	public void setPhaseClassName(String phaseClassName) {		this.phaseClassName = phaseClassName;	}	public String getContent() {		return content;	}	public void setContent(String content) {		this.content = content;	}	public int getPhaseId() {		return phaseId;	}	public void setPhaseId(int phaseId) {		this.phaseId = phaseId;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'phaseClassId':'"+this.getPhaseClassId()+"',");		sb.append("'phaseClassName':'"+this.getPhaseClassName()+"',");		sb.append("'content':'"+this.getContent()+"',");		sb.append("'phaseId':'"+this.getPhaseId()+"'");		sb.append("}");		return sb.toString();	}}