package com.Pojo;


import com.sun.xml.internal.ws.developer.Serialization;

@Serialization
public class role {
    private Integer id;

    private String name;

    private String power;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}