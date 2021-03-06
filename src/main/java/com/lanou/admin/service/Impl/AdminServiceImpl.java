package com.lanou.admin.service.Impl;

import com.lanou.admin.domain.Admin;
import com.lanou.admin.service.AdminService;
import com.lanou.base.mapper.AdminMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/20.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    public Admin checkUser(Admin admin) {
        return adminMapper.checkUser(admin);
    }

    public void updatePassword(Integer admin_id,String newPassword) {
        adminMapper.updatePassword(admin_id,newPassword);
    }

    //修改密码
//    public void findByAdminId(Integer admin_id, String newPassword) {
//        Admin byAdminId = adminMapper.findByAdminId(admin_id);
//        System.out.println(byAdminId);
//        byAdminId.setPassword(newPassword);
//    }


}
