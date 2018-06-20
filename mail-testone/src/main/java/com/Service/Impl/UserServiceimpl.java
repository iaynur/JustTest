package com.Service.Impl;

import com.Dao.myUserMapper;
import com.Pojo.myUser;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: liangliangshuo
 * \* Date: 2018/5/28
 * \* Time: 下午7:28
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
public class UserServiceimpl implements UserService {

    @Autowired
    private myUserMapper mapper;


    @Override
    public myUser getUserById(Integer id) {
        myUser user = mapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int deleteUserbyId(Integer id) {
        int i = mapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int updateUser(myUser user) {
        int i = mapper.updateByPrimaryKey(user);
        return i;
    }

    @Override
    public int addUser(myUser user) {
        int i = mapper.insert(user);
        return i;
    }

    @Override
    public List<myUser> allUser(int page, int size) {
        int start = (page-1)*size;
        Map<String, Object> args = new HashMap<>();
        args.put("start",start);
        args.put("size",size);

        List<myUser> allUser = mapper.selectAllUser(args);

        return allUser;
    }

    @Override
    public int allNum() {
        return mapper.allTotal();
    }

    @Override
    public myUser login(myUser user) {
        myUser user1 = mapper.login(user);
        return user1;
    }
}