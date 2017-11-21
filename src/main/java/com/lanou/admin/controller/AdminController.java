package com.lanou.admin.controller;

import com.lanou.admin.domain.Admin;
import com.lanou.admin.service.AdminService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by dllo on 17/11/20.
 */
@Controller
public class AdminController {
    @Resource
    private AdminService adminService;

    //点击管理员
    @RequestMapping(value = "admin/admin_list")
    public String Jump(){

        return "admin/admin_list";
    }

    //登录
    @RequestMapping("/")
    public String frontPage(){

        return "login";
    }

//    点击退出
    @RequestMapping(value = "login")
    public String exit(){
        return "login";
    }
    //个人信息
    @RequestMapping(value = "user/user_info")
    public String singlePeople(){
        return "user/user_info";
    }

    //修改密码
    @RequestMapping(value = "user/user_modi_pwd")
    public String updatePass()
    {
        return "user/user_modi_pwd";
    }
//    type:"post",
//    url:"/loginu",
//    data:{
//        "admin_code":adim_code,
//                "password":password,
//                "code":code
//    },

    //点击登录
    @RequestMapping(value = "/loginu")
    @ResponseBody
    public AjaxResult loginu( Admin admin, String code, HttpSession session){
        AjaxResult ajaxResult = new AjaxResult();
        if (admin.getAdmin_code()!=null && admin.getPassword() !=null && code !=null){
            Admin admin1 = adminService.checkUser(admin);

            if(admin1 !=null){
                ajaxResult.setErrorCode(0);
                ajaxResult.setData(admin1);
                admin.setAdmin_id(admin1.getAdmin_id());
                ajaxResult.setData(admin);
            }else {
                ajaxResult.setErrorCode(404);
                ajaxResult.setMessage("访问的用户账号不存在"+admin.getAdmin_code()+"或密码错误");
            }

        }

        return ajaxResult;
    }



}
