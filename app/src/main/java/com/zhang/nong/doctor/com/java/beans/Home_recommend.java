package com.zhang.nong.doctor.com.java.beans;

import java.io.Serializable;

/**
 * Created by zhangyunzhen on 2016/5/24.
 */
public class Home_recommend implements Serializable {
private String home_recommend_type;//农机类型
private String home_recommend_linkman;//联系人
private String home_recommend_location;//农机主的位置
private String home_recommend_phone;//联系电话
private int home_recommend_item;

public Home_recommend(String home_recommend_type,
                      String home_recommend_linkman,
                      String home_recommend_location,
                      String home_recommend_phone,
                      int home_recommend_item) {
	this.home_recommend_type = home_recommend_type;
	this.home_recommend_linkman = home_recommend_linkman;
	this.home_recommend_location = home_recommend_location;
	this.home_recommend_phone = home_recommend_phone;
	this.home_recommend_item = home_recommend_item;
}

public String getHome_recommend_type() {
	return home_recommend_type;
}

public void setHome_recommend_type(String home_recommend_type) {
	this.home_recommend_type = home_recommend_type;
}

public String getHome_recommend_linkman() {
	return home_recommend_linkman;
}

public void setHome_recommend_linkman(String home_recommend_linkman) {
	this.home_recommend_linkman = home_recommend_linkman;
}

public String getHome_recommend_location() {
	return home_recommend_location;
}

public void setHome_recommend_location(String home_recommend_location) {
	this.home_recommend_location = home_recommend_location;
}

public String getHome_recommend_phone() {
	return home_recommend_phone;
}

public void setHome_recommend_phone(String home_recommend_phone) {
	this.home_recommend_phone = home_recommend_phone;
}

public int getHome_recommend_item() {
	return home_recommend_item;
}

public void setHome_recommend_item(int home_recommend_item) {
	this.home_recommend_item = home_recommend_item;
}
}
