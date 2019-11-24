package com.iii.demo.core.security.shiro;

import com.iii.demo.modules.user.service.EmployeeService;
import com.iii.demo.modules.user.vo.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //添加授权字符串
        //info.addStringPermission("user:add");
        System.out.println(info.toString());

        //到数据库查询当前登入用户的授权字符串
        //获取当前登入用户
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        employeeService.findByUserName(employee.getUserName());

        info.addStringPermission(employee.getPerms());
        return info;
    }

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行验证逻辑");

        //假设数据库的用户名和密码
        String name = "eric";
        String password = "123456";

        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token1 = (UsernamePasswordToken)token;
        System.out.println("token1:"+"name="+token1.getUsername()+"|||"+"password="+token1.getPassword());

        Employee employee = employeeService.findByUserName(token1.getUsername());
        if (employee==null) {
            //用户名不存在
            return null;//shiro底层会抛出异常UnKnowAccountException
        }

        //2.判断密码
        //第一个参数是返回给登录的参数，第二个数据库密码，第三个shiro的名字
        return new SimpleAuthenticationInfo(employee,employee.getPassword(),"");

    }
}


