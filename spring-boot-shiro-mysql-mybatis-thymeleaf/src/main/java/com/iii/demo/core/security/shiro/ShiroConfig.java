package com.iii.demo.core.security.shiro;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *      常用的过滤器：
         *         anon: 无需认证（登录） 可以访问
         *         authc: 必须认证才能可以访问
         *         user：如果使用rememMe的功能可以直接访问
         *         perms：该资源必须得到资源权限才可以访问
         *         role: 该资源必须得到角色权限才可以访问
       */
        Map<String,String> filterMap = new LinkedHashMap();
//        filterMap.put("/add","authc");
//        filterMap.put("/update","authc");

        filterMap.put("/testThymeleaf","anon");
        //放行login.html页面
        filterMap.put("/login","anon");

        //授权过滤器
        filterMap.put("/add","perms[user:add]");
        filterMap.put("/update","perms[user:update]");

        filterMap.put("/*","authc");

        //修改调整的登入界面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager( @Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect,用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}

