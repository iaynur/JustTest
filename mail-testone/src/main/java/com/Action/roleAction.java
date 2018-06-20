package com.Action;

import com.Common.Constance;
import com.Pojo.role;
import com.Pojo.role_res;
import com.Service.Impl.roleServiceImpl;
import com.Service.role_resService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: liangliangshuo
 * \* Date: 2018/5/31
 * \* Time: 上午10:04
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
public class roleAction {

    @Autowired
    private roleServiceImpl role_service;

    @Autowired
    private role_resService rr_service;

    @RequestMapping("getallrole")
    @ResponseBody
    public List<role> getAllrole(int page, int size){
        List<role> getAlrole = role_service.getallrole(page,size);
        return getAlrole;
    }


    @RequestMapping("removeRole")
    @ResponseBody
    public String deleteRole(int id){
        try{
            role_service.deleteRoleById(id);
            rr_service.deleteRR(id);
        } catch (Exception e) {
            return Constance.RESULT_FAILURE;
        }
        return Constance.RESULT_OK;
    }


    @RequestMapping("saveRole")
    @ResponseBody
    public String saveRole(role role) {
        System.out.println(role.getPower());
        try {
            if (role.getId() ==0){
                role_service.addRole(role);

                role role1 = role_service.getRoleByName(role);
                System.out.println(role1.getId());

                List<role_res> all = rr_service.findRRByRoleId(role1.getId());

                //有个判断
                if (all.size() <= 0) {
                    //获得String字符串转为数组
                    String reID = role.getPower();
                    String[] data = reID.split(",");
//                System.out.println("这里是Spring转的数组" + data.toString());
                    role_res role_res = new role_res();
                    role_res.setRoleId(role1.getId());


                    for (String a : data) {
//                    System.out.println("这里是for循环出来的元素" + a);
                        role_res.setResId(Integer.valueOf(a));
                        rr_service.addrr(role_res);
                    }
                }

            }else {
                role_service.updateRole(role);
                int roID = role.getId();
                //这里删除
                rr_service.deleteRR(roID);

                //这里添加
                String reID = role.getPower();
                String[] data = reID.split(",");
                role_res role_res = new role_res();
                role_res.setRoleId(roID);
                for (String a : data) {
                    role_res.setResId(Integer.valueOf(a));
                    rr_service.addrr(role_res);
                }

            }

        } catch (Exception e) {
            return Constance.RESULT_FAILURE;
        }
        return Constance.RESULT_OK;
    }


    @RequestMapping("roleToEdit")
    @ResponseBody
    public List<role> getRoleById(int id){
        List<role> role = role_service.getRoleById(id);
        return role;
    }


    //查询表中数量
    @RequestMapping("getRoleNum")
    @ResponseBody
    public int getTotal(){
        return role_service.roleNum();
    }

    //查询所有的role
    @RequestMapping("getEveryRole")
    @ResponseBody
    public List<role> getEveryRole(){
        List<role> allRole = role_service.getEveryRole();
        return allRole;
    }

}