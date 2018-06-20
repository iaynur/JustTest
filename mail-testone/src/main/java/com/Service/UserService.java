package com.Service;

import com.Pojo.myUser;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: liangliangshuo
 * \* Date: 2018/5/28
 * \* Time: 下午7:25∑
 * \*Remember to look up at the stars and not down at your feet.
 * \*Be curious and however difficult life may seem,
 * \*there is always something you can do and succeed at.
 * \*                                ---Stephen William Hawking
 * \*记住要仰望星空，不要低头看脚下。
 * \*无论生活如何艰难，请保持一颗好奇心。你总会找到自己的路和属于你的成功。
 * \*                                ---斯蒂芬·威廉·霍金
 * \
 */
public interface UserService {

    myUser getUserById(Integer id);

    int deleteUserbyId(Integer id);

    int updateUser(myUser user);

    int addUser(myUser user);

    List<myUser> allUser(int page, int size);

    int allNum();

    myUser login(myUser user);
}