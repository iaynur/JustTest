package com.Dao;

import com.Pojo.role_res;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface role_resMapper {
    int insert(role_res record);

    int insertSelective(role_res record);

    List<role_res> selectRRByRoID(int id);

    int deleteByRoleId(int id);
}