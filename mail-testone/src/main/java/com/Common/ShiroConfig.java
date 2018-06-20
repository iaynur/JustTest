package com.Common;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: liangliangshuo
 * \* Date: 2018/6/7
 * \* Time: 下午7:58
 * \*Remember to look up at the stars and not down at your feet.
 * \*Be curious and however difficult life may seem,
 * \*there is always something you can do and succeed at.
 * \*                                ---Stephen William Hawking
 * \*记住要仰望星空，不要低头看脚下。
 * \*无论生活如何艰难，请保持一颗好奇心。你总会找到自己的路和属于你的成功。
 * \*                                ---斯蒂芬·威廉·霍金
 * \
 */
@Configuration
public class ShiroConfig  {

    //得到数据库访问权限
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource createDS(){
        DruidDataSource ds = new DruidDataSource();

        return ds;
    }

    //创建realm
    @Bean
    public JdbcRealm createRealm(DruidDataSource ds){
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(ds);
        //登陆
        realm.setAuthenticationQuery("select password from myUser where name=?");
        //角色
        realm.setUserRolesQuery("select r.name from role r left join user_role ur on r.id=ur.role_id left join myUser u on ur.user_id = u.id where u.name = ?");
        //权限
        realm.setPermissionsQuery("select res.text from resource res left join role_res rr on rr.res_id = res.id left join role r on r.id = rr.role_id where r.name = ?");
        realm.setPermissionsLookupEnabled(true);

        return realm;
    }

    //安全管理器
    @Bean
    public DefaultWebSecurityManager createManager(JdbcRealm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return  manager;
    }

    //实现Shiro过滤器
    @Bean
    public ShiroFilterFactoryBean createFilter(DefaultWebSecurityManager manager){
        //得到对象
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        //将安全管理器使用上
        bean.setSecurityManager(manager);

        //设置登陆措施
        bean.setLoginUrl("../login.html");
        //未授权措施
        bean.setUnauthorizedUrl("../noqx.html");

        //设置访问的页面
        Map<String,String> urls=new LinkedHashMap<>();

        //设置哪个目录下的东西必须登陆后才可以访问
        urls.put("/user/**","authc");
        urls.put("/**","anon");
        bean.setFilterChainDefinitionMap(urls);
        return bean;

    }
}