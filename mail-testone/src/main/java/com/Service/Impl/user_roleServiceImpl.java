package com.Service.Impl;

import com.Dao.user_roleMapper;
import com.Pojo.user_role;
import com.Service.user_roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: liangliangshuo
 * \* Date: 2018/6/2
 * \* Time: 上午10:47
 * \*Remember to look up at the stars and not down at your feet.
 * \*Be curious and however difficult life may seem,
 * \*there is always something you can do and succeed at.
 * \*                                ---Stephen William Hawking
 * \*记住要仰望星空，不要低头看脚下。
 * \*无论生活如何艰难，请保持一颗好奇心。你总会找到自己的路和属于你的成功。
 * \*                                ---斯蒂芬·威廉·霍金
 * \
 */

@Service
public class user_roleServiceImpl implements user_roleService {

    @Autowired
    private user_roleMapper mapper;

    @Override
    public int addU_R(user_role user_role) {
        return mapper.insert(user_role);
    }

    @Override
    public int deleteU_R(int u_id) {
        user_role user_role = new user_role();
        user_role.setUserId(u_id);
        return mapper.removeByUid(user_role);
    }

    @Override
    public user_role selectURByUid(int u_id) {
        return mapper.selectURByUid(u_id);
    }

    @Override
    public int updateU_R(int u_id,int r_id) {
        user_role user_role = new user_role();
        user_role.setUserId(u_id);
        user_role.setRoleId(r_id);
        return mapper.updateByUid(user_role);
    }
}