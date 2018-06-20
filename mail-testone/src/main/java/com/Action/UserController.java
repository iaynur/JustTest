package com.Action;

import com.Common.Constance;
import com.Pojo.myUser;
import com.Pojo.user_role;
import com.Service.Impl.UserServiceimpl;
import com.Service.user_roleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: liangliangshuo
 * \* Date: 2018/5/28
 * \* Time: 下午7:26
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
public class UserController {

    @Autowired
    private UserServiceimpl user_service;

    @Autowired
    private user_roleService ur_service;

    @RequestMapping("/findAllUser")
    @ResponseBody
    public List<myUser> allUser(int page, int size){
        List<myUser> allUser = user_service.allUser(page,size);
        return allUser;
    }




    @RequestMapping("removeUser")
    @ResponseBody
    public String deleteUser(int id){
        try {
            user_service.deleteUserbyId(id);
            ur_service.deleteU_R(id);
        } catch (Exception e) {
            return Constance.RESULT_FAILURE;
        }
        return Constance.RESULT_OK;
    }



    @RequestMapping("saveUser")
    @ResponseBody
    public String saveuser(myUser user) {

            if (user.getId() ==0){
                user_service.addUser(user);

                //根据用户名密码查询到角色ID
                myUser user1 = user_service.login(user);
                user_role ur = ur_service.selectURByUid(user1.getId());

                if (ur == null){
                    user_role role = new user_role();
                    role.setUserId(user1.getId());
                    role.setRoleId(Integer.valueOf(user.getRole()));
                    ur_service.addU_R(role);
                }
            }else {
                user_service.updateUser(user);
                int i = user.getId();

                myUser user1 = user_service.login(user);
                user_role ur = ur_service.selectURByUid(user1.getId());

                int b = ur.getRoleId();
                myUser user2 = user_service.getUserById(user.getId());

                if (user.getRole() != user2.getRole()){
                    ur_service.updateU_R(i,b);
                }

            }
        return Constance.RESULT_OK;

    }




    @RequestMapping("toEdit")
    @ResponseBody
    public myUser getUserById(int id){

        myUser user = user_service.getUserById(id);
        return user;
    }




    //查询表中数量
    @RequestMapping("total")
    @ResponseBody
    public int total(){
        return user_service.allNum();
    }




    @RequestMapping("login")
    @ResponseBody
    public String login(myUser user,HttpSession session){
        try {
            //创建对象
            Subject subject = SecurityUtils.getSubject();
            //交出令牌
            UsernamePasswordToken token=new UsernamePasswordToken(user.getName(),user.getPassword());

            subject.login(token);
            myUser user1 =  user_service.login(user);

           if (user1!=null){
               session.setAttribute("user",user1);
               return Constance.RESULT_OK;
           }else {
               return Constance.RESULT_NO;
           }
        } catch (Exception e) {
            return Constance.RESULT_FAILURE;
        }
    }

    @RequestMapping("logout")
    public String loginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login.html";
    }

}