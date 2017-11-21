package com.lanou.role.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.role.domain.Role;
import com.lanou.role.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/11/17.
 */

@Controller
public class RoleController {

    @Resource
    private RoleService roleService;


    @RequestMapping(value = "role/role_list")
    public String Jump(){
        return "role/role_list";
    }

    //分页
    @RequestMapping(value = "/pageAllRole")
    @ResponseBody
    public PageInfo<Role> pageAllRole(Integer pageNum,Integer pageSize){
        PageInfo<Role> rolePageInfo = roleService.pageAllRole(pageNum, pageSize);
        System.out.println("rolePageInfo"+rolePageInfo);
        return rolePageInfo;
    }

    //删除
    @RequestMapping(value = "/deleteTheRole")
    @ResponseBody
    public boolean deleteTheRole(@RequestParam("role_id") Integer role_id){
      return  roleService.deleteTheRole(role_id);
    }

    //点击修改
    @RequestMapping(value = "role/role_modi")
    public String modi(Integer role_id,HttpSession session){
        System.out.println("角色id回显 的role_id"+role_id);
        Role roleById = roleService.findRoleById(role_id);
        System.out.println("根据角色id查出来什么东西"+roleById);
        session.setAttribute("role",roleById);

        return "role/role_modi";
    }




    //点击修改回显
    @RequestMapping(value = "/findRoleById")
    @ResponseBody
    public Role findRoleById(HttpSession session){
        Role roleById = (Role) session.getAttribute("role");
//
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("showRole",roleById);
        return roleById;

    }

//      role_id:$("#roleName").attr("choose"),
//    name:$("#roleName").val(),
//    modIds:a
    //点击修改保存
    @RequestMapping(value = "/updateTheRole")
    @ResponseBody
    public boolean updateTheRole(HttpSession session,@RequestParam("name") String name,@RequestParam("modIds") String modIds ){
        Role roleById = (Role) session.getAttribute("role");
        Integer role_id = roleById.getRole_id();

        System.out.println(role_id);
        System.out.println(name);
        System.out.println(modIds);
       return roleService.updateTheRole(role_id, name, modIds);

    }

//    url:"/addRole",
//    data:{
//        name:$("#roleName").val(),
//                modIds:a
//    },
    //点击添加
    @RequestMapping(value = "role/role_add")
    public String addRole(){
        return "role/role_add";
    }

     //点击保存
    @RequestMapping(value = "/addRole")
    @ResponseBody
    public boolean addRoleSave(@RequestParam("name") String name,@RequestParam("modIds") String modIds){

        System.out.println(name);
        System.out.println(modIds);
        return roleService.addRoleSave(name,modIds);
    }






}
