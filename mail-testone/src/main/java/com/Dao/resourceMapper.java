package com.Dao;

import com.Pojo.resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface resourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(resource record);

    int insertSelective(resource record);

    resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(resource record);

    int updateByPrimaryKey(resource record);

    List<resource> selectAll();

    List<resource> selectAllForLogin(Integer id);

    List<resource> selectAllResource();
}