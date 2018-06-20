package com.Pojo;


import com.sun.xml.internal.ws.developer.Serialization;

import java.util.ArrayList;
import java.util.List;

@Serialization
public class resource {
    private Integer id;

    private String text;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<resource> children = new ArrayList<>();

    public List<resource> getChildren() {
        return children;
    }

    public void setChildren(List<resource> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }


}