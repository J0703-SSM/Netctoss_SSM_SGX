package com.lanou.admin.service;

import com.lanou.admin.domain.Admin;

/**
 * Created by dllo on 17/11/20.
 */
public interface AdminService {
    Admin checkUser(Admin admin);

    void updatePassword(Integer admin_id, String newPassword);


    //修改密码
//    void findByAdminId(Integer admin_id, String newPassword);
}
