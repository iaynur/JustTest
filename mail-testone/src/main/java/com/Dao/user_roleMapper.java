package com.Dao;

import com.Pojo.user_role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface user_roleMapper {
    int insert(user_role record);

    int removeByUid(user_role record);

    int insertSelective(user_role record);


    user_role selectURByUid(int id);

    int updateByUid(user_role record);
}