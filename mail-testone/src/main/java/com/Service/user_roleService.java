package com.Service;

import com.Pojo.user_role;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: liangliangshuo
 * \* Date: 2018/6/2
 * \* Time: 上午10:46
 * \*Remember to look up at the stars and not down at your feet.
 * \*Be curious and however difficult life may seem,
 * \*there is always something you can do and succeed at.
 * \*                                ---Stephen William Hawking
 * \*记住要仰望星空，不要低头看脚下。
 * \*无论生活如何艰难，请保持一颗好奇心。你总会找到自己的路和属于你的成功。
 * \*                                ---斯蒂芬·威廉·霍金
 * \
 */
public interface user_roleService {
    int addU_R(user_role user_role);

    int deleteU_R(int u_id);

    user_role selectURByUid(int u_id);

    int updateU_R(int u_id,int r_id);
}