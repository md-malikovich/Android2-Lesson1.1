package com.android2_lesson1;

import java.io.Serializable;

public class Task implements Serializable {

    private String title;
    private String desc;

    public Task() {
        //
    }

    public Task(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}

