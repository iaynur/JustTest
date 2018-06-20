package com.Pojo;

import com.sun.xml.internal.ws.developer.Serialization;

@Serialization
public class role_res {
    private Integer roleId;

    private Integer resId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }
}