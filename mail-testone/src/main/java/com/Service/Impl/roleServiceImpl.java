package com.Service.Impl;

import com.Dao.roleMapper;
import com.Pojo.role;
import com.Service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: liangliangshuo
 * \* Date: 2018/5/31
 * \* Time: 上午10:03
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
public class roleServiceImpl implements roleService {

    @Autowired
    private roleMapper mapper;

    @Override
    public List<role> getRoleById(Integer id) {
        List<role> role = mapper.selectByPrimaryKey(id);
        return role;
    }

    @Override
    public int deleteRoleById(Integer id) {
        int i = mapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int updateRole(role role) {
        int i = mapper.updateByPrimaryKey(role);
        return i;
    }

    @Override
    public int addRole(role role) {
        int i = mapper.insert(role);
        return i;
    }

    @Override
    public int roleNum() {
        return mapper.roleNum();
    }

    @Override
    public List<role> getallrole(int page, int size) {
        int start = (page-1)*size;
        Map<String, Object> args = new HashMap<>();
        args.put("start",start);
        args.put("size",size);

        List<role> gallrole = mapper.allrole(args);

        return gallrole;
    }

    @Override
    public List<role> getEveryRole() {
        List<role> getEveryrole = mapper.everyRole();
        return getEveryrole;
    }

    @Override
    public role getRoleByUserId(Integer id) {
        role role = mapper.getRoleByUserid(id);
        return role;
    }

    @Override
    public role getRoleByName(role record) {
        role role = mapper.selectByName(record);
        return role;
    }


}