package com.Action;

import com.Pojo.myUser;
import com.Pojo.resource;
import com.Service.resourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: liangliangshuo
 * \* Date: 2018/5/29
 * \* Time: 下午5:15
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
public class resourceAction {

    @Autowired
    private resourceService service;
//
//    @RequestMapping("allResource")
//    @ResponseBody
//    public List<resource> allResource(){
//        List<resource> allResources = service.allResources();
//        return allResources;
//    }


    @RequestMapping("findAllResLogin")
    @ResponseBody
    public List<resource> findAllRes(HttpSession session){

        myUser user = (myUser) session.getAttribute("user");

        List<resource> allResources = service.allResourcrLogin(user.getId());

        return allResources;
    }
    @RequestMapping("getEveryPower")
    @ResponseBody
    public List<resource> getEveryPower(){

        List<resource> allResources = service.getAllResources();

        return allResources;
    }

}