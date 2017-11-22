package com.lanou.admin.controller;

import com.lanou.admin.domain.Admin;
import com.lanou.admin.service.AdminService;
import com.lanou.utils.AjaxResult;
import com.lanou.utils.VerifyCode;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
    @RequestMapping(value = "/login")
    public String exit(HttpSession session){
        session.removeAttribute("loginAdmin");

        return "login";
    }
    //点击个人信息
    @RequestMapping(value = "user/user_info")
    public String singlePeoplee(){
        return "user/user_info";
    }

    //个人信息 回显
    @RequestMapping(value = "/showAdmin")
    @ResponseBody
    public Admin singlePeople(HttpSession session){
        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
        System.out.println("loginAdmin"+loginAdmin);
        return loginAdmin;
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


    private String codeContent;


    //验证码
    @RequestMapping(value = "/verifyCode")
    public void verifyCode(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        System.out.println("啦啦啦啦啦");
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        codeContent = verifyCode.getText().toLowerCase();
        verifyCode.output(image, response.getOutputStream());
    }



    //点击登录
    @RequestMapping(value = "/loginu")
    @ResponseBody
    public AjaxResult loginu( Admin admin, String code, HttpSession session){
        AjaxResult ajaxResult = new AjaxResult();
        if (admin.getAdmin_code()!=null && admin.getPassword() !=null && code !=null) {
            if (!code.trim().equalsIgnoreCase(codeContent)){
                ajaxResult.setErrorCode(404);
                ajaxResult.setMessage("验证码错误");
                return ajaxResult;
            }

            Admin admin1 = adminService.checkUser(admin);
            session.setAttribute("loginAdmin",admin1);
            if (admin1 != null && code.trim().equalsIgnoreCase(codeContent)) {

                    ajaxResult.setErrorCode(0);
                    ajaxResult.setData(admin1);
                    admin.setAdmin_id(admin1.getAdmin_id());
                    ajaxResult.setData(admin);
                } else {
                     ajaxResult.setErrorCode(404);
                    ajaxResult.setMessage("访问的用户账号不存在" + admin.getAdmin_code() + "或密码错误" );
                }

            }

        return ajaxResult;
    }

//    url:"/updatePassword",
//    data:{
//        "oldPassword":oldPassword,
//                "newPassword":newPassword,
//                "repeatPassword":repeatPassword
//    },
    //修改密码
    @RequestMapping(value = "/updatePassword")
    @ResponseBody
    public AjaxResult updatePassword(String oldPassword,String newPassword,String repeatPassword,HttpSession session){
        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");

        AjaxResult ajaxResult = new AjaxResult();
        if (!loginAdmin.getPassword().equals(oldPassword)){
            ajaxResult.setErrorCode(404);
            ajaxResult.setMessage("原始密码不正确");
            return ajaxResult;
        }
        if (!newPassword.equals(repeatPassword)){
            ajaxResult.setErrorCode(404);
            ajaxResult.setMessage("新密码与重复密码不一致");
            return ajaxResult;
        }
        if(oldPassword.equals(newPassword)){
            ajaxResult.setErrorCode(404);
            ajaxResult.setMessage("新旧密码不能一样");
            return ajaxResult;
        }

//        adminService.findByAdminId(loginAdmin.getAdmin_id(),newPassword);
        adminService.updatePassword(loginAdmin.getAdmin_id(),newPassword);

        ajaxResult.setErrorCode(0);
        ajaxResult.setMessage("修改成功");
        return ajaxResult;
    }




    public String getCodeContent() {
        return codeContent;
    }

    public void setCodeContent(String codeContent) {
        this.codeContent = codeContent;
    }
}
