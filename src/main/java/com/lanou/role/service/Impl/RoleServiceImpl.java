package com.lanou.role.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.base.mapper.RoleMapper;
import com.lanou.role.domain.Role;
import com.lanou.role.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;


    public PageInfo<Role> pageAllRole(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null? 1: pageNum;
        pageSize = pageSize == null? 4:pageSize;

        PageHelper.startPage(pageNum,pageSize);
        List<Role> allRole = roleMapper.findAllRole();
        System.out.println("allRole"+allRole);
        PageInfo<Role> rolePageInfo = new PageInfo<Role>(allRole);


        return rolePageInfo;
    }


    public boolean deleteTheRole(Integer role_id) {
        try {
            roleMapper.deleteByRoleId(role_id);
            roleMapper.deleteForR_MRoleId(role_id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Role findRoleById(Integer role_id) {
        return roleMapper.findRoleBuId(role_id);
    }



    //修改
    public boolean updateTheRole(Integer role_id, String name, String modIds) {
        //分三步 保存 name ,删除 中间表 , for循环添加 中间表
        try {
            Role role = new Role();
            role.setRole_id(role_id);
            role.setName(name);
            roleMapper.updateTheRole(role);

            roleMapper.deleteForR_MRoleId(role_id);

            String[] split = modIds.split(",");
            for (int i = 0; i < split.length; i++) {
                roleMapper.addRole(role_id,Integer.parseInt(split[i]));
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;

    }

    //添加保存
    public boolean addRoleSave(String name, String modIds) {
        //添加失败
        Role roleByName = roleMapper.findRoleByName(name);
        if (roleByName !=null){
            return false;
        }
        try {
            String[] split = modIds.split(",");

            Role role = new Role();
            role.setName(name);
            roleMapper.insertRole(role);


            Integer role_id = role.getRole_id();
            System.out.println("role_id"+role_id);
            for (int i = 0; i < split.length; i++) {
                Integer moduleId = Integer.parseInt(split[i]);
                roleMapper.addRole(role_id, moduleId);
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }


}
