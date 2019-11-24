package com.iii.demo.modules.user.controller;


import com.iii.demo.modules.user.service.EmployeeService;
import com.iii.demo.modules.user.vo.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //查询所有员工信息
    @RequestMapping("/findAll")
    public List<Employee> findAll() {
        return this.employeeService.findAll();
    }

    //根据姓名查员工信息
    @RequestMapping("/findByUserName")
    public Employee findByUserName(String userName) {
        return this.employeeService.findByUserName(userName);
    }

    //未授权提示页面
    @RequestMapping("/noAuth")
    public String noAuth() {
        return "/noAuth";
    }

    /**
     * 测试方法
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("UserController.hello()");
        return "ok";
    }

    /**
     * 跳转登入
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "/login";
    }

    /**
     * 测试thymeleaf
     */
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model) {
        //把数据存入model
        model.addAttribute("name", "黑马程序员");
        //返回test.html
        return "test";
    }

    /**
     * 添加用户
     *
     * @return
     */
    @RequestMapping("add")
    public String add() {
        return "user/add";
    }

    /**
     * 更新用户信息
     *
     * @return
     */
    @RequestMapping("update")
    public String update() {
        return "user/update";
    }

    /**
     * 登录逻辑处理
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(String name, String password, Model model) {

        //打印数据
        System.out.println("name=" + name + "password=" + password);
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        //3.执行登录方法

        try {
            subject.login(token);

            return "redirect:/testThymeleaf";
            //登陆成功
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登入失败：用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {

            //密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }
}