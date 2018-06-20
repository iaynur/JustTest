package com.Service.Impl;

import com.Dao.role_resMapper;
import com.Pojo.role_res;
import com.Service.role_resService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: liangliangshuo
 * \* Date: 2018/6/2
 * \* Time: 下午5:12
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
public class role_resServiceimpl implements role_resService {

    @Autowired
    private role_resMapper mapper;


    @Override
    public List<role_res> findRRByRoleId(int id) {
        return mapper.selectRRByRoID(id);
    }

    @Override
    public int addrr(role_res role_res) {
        return mapper.insert(role_res);
    }

    @Override
    public int deleteRR(int id) {
        return mapper.deleteByRoleId(id);
    }
}