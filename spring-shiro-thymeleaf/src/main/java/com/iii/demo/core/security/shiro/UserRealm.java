package com.iii.demo.core.security.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行验证逻辑");

        //假设数据库的用户名和密码
        String name = "eric";
        String password = "123456";

        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token1 = (UsernamePasswordToken)token;

        //打印身份验证令牌信息 AuthenticationToken token1
        System.out.println("token1:"+"name="+token1.getUsername()+"|||"+"password="+token1.getPassword());
        if (!token1.getUsername().equals(name)) {
            //用户名不存在
            return null;//shiro底层会抛出异常UnKnowAccountException [module/controller ->出现异常返回被login方法捕获异常]
       }

        //2.判断密码
        //第一个参数是返回给登录的参数，第二个数据库密码，第三个shiro的名字
        return new SimpleAuthenticationInfo("",password,"");

    }
}


