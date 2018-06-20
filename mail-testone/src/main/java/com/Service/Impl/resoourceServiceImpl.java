package com.Service.Impl;

import com.Dao.resourceMapper;
import com.Pojo.resource;
import com.Service.resourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: liangliangshuo
 * \* Date: 2018/5/29
 * \* Time: 下午5:14
 * \*Remember to look up at the stars and not down at your feet.
 * \*Be curious and however difficult life may seem,
 * \*there is always something you can do and succeed at.
 * \*                                ---Stephen William Hawking
 * \*记住要仰望星空，不要低头看脚下。
 * \*无论生活如何艰难，请保持一颗好奇心。你总会找到自己的路和属于你的成功。
 * \*                                ---斯蒂芬·威廉·霍金
 * \
 */
@Controller
public class resoourceServiceImpl implements resourceService {

    @Autowired
    private resourceMapper mapper;


    @Override
    public List<resource> allResources() {
        List<resource> allResources = mapper.selectAll();
        return allResources;
    }

    @Override
    public List<resource> allResourcrLogin(int uid){
        List<resource> allResources = mapper.selectAllForLogin(uid);
        return allResources;
    }

    @Override
    public List<resource> getAllResources() {
        return mapper.selectAllResource();
    }
}