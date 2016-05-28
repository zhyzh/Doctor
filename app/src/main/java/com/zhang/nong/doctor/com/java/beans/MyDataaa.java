package com.zhang.nong.doctor.com.java.beans;

import java.io.Serializable;

/**
 * Created by XCF on 2016/4/25.
 */
public class MyDataaa implements Serializable {
    private int pic;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public MyDataaa(String content, int pic) {

        this.pic = pic;
        this.content = content;
    }
}
