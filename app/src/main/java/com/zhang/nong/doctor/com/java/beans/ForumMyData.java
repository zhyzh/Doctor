package com.zhang.nong.doctor.com.java.beans;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
public class ForumMyData implements Serializable{
    private int manimage;//贴吧头像（帖子一级）
    private String username;//发帖人
    private  String zansum,huisum;//点赞数，回帖数
    private String fatime;
    private String title;//标题
    private String content;//内容
    private int pic1,pic2,pic3;//贴的图片
    //用一个标志位来判断是否置顶
    private boolean zhiding;

    public ForumMyData(int manimage, String username, String zansum, String huisum, String fatime, String title, String content, int pic1, int pic2, int pic3, boolean zhiding) {
        this.manimage = manimage;
        this.username = username;
        this.zansum = zansum;
        this.huisum = huisum;
        this.fatime = fatime;
        this.title = title;
        this.content = content;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.zhiding = zhiding;
    }

    public int getManimage() {
        return manimage;
    }

    public void setManimage(int manimage) {
        this.manimage = manimage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getZansum() {
        return zansum;
    }

    public void setZansum(String zansum) {
        this.zansum = zansum;
    }

    public String getHuisum() {
        return huisum;
    }

    public void setHuisum(String huisum) {
        this.huisum = huisum;
    }

    public String getFatime() {
        return fatime;
    }

    public void setFatime(String fatime) {
        this.fatime = fatime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPic1() {
        return pic1;
    }

    public void setPic1(int pic1) {
        this.pic1 = pic1;
    }

    public int getPic2() {
        return pic2;
    }

    public void setPic2(int pic2) {
        this.pic2 = pic2;
    }

    public int getPic3() {
        return pic3;
    }

    public void setPic3(int pic3) {
        this.pic3 = pic3;
    }

    public boolean getZhiding() {
        return zhiding;
    }

    public void setZhiding(boolean zhiding) {
        this.zhiding = zhiding;
    }
}
