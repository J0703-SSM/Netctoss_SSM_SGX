package com.lanou.role.service;

import com.github.pagehelper.PageInfo;
import com.lanou.role.domain.Role;

import javax.management.relation.RoleInfo;

/**
 * Created by dllo on 17/11/17.
 */
public interface RoleService {
    PageInfo<Role> pageAllRole(Integer pageNum, Integer pageSize);

    boolean deleteTheRole(Integer role_id);

    Role findRoleById(Integer role_id);

    boolean updateTheRole(Integer role_id, String name, String modIds);

    boolean addRoleSave(String name, String modIds);
}
