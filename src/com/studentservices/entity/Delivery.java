package com.studentservices.entity;

public class Delivery {
    private  String id;
    private String name;
    private String info;
    private String confirm;

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() { return info; }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getConfirm() { return confirm; }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}
