package com.Dao;

import com.Pojo.role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(role record);

    int insertSelective(role record);

    List<role> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(role record);

    int updateByPrimaryKey(role record);

    List<role> allrole(Map<String,Object> args);

    List<role> everyRole();

    int roleNum();

    role getRoleByUserid(Integer id);

    role selectByName(role record);

}