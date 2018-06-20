package com.Dao;

import com.Pojo.myUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface myUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(myUser record);

    int insertSelective(myUser record);

    myUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(myUser record);

    int updateByPrimaryKey(myUser record);

    List<myUser> selectAllUser(Map<String, Object> args);

    int allTotal();

    myUser login(myUser record);
}