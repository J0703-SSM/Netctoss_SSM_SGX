package com.lanou.base.mapper;

import com.lanou.admin.domain.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by dllo on 17/11/20.
 */
public interface AdminMapper {
    Admin checkUser(Admin admin);


    Admin findByAdminId(Integer admin_id);

    void updatePassword(@Param("admin_id") Integer admin_id, @Param("newPassword") String newPassword);
}
