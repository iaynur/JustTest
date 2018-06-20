package com.Service;

import com.Pojo.role;

import java.util.List;

public interface roleService {

    List<role> getRoleById(Integer id);

    int deleteRoleById(Integer id);

    int updateRole(role role);

    int addRole(role role);

    int roleNum();

    List<role> getallrole(int page, int size);

    List<role> getEveryRole();

    role getRoleByUserId(Integer id);

    role getRoleByName(role record);
}
