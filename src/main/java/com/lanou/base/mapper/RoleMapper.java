package com.lanou.base.mapper;

import com.lanou.role.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
public interface RoleMapper {


    List<Role> findAllRole();

    void deleteForR_MRoleId(Integer role_id);

    int deleteByRoleId(Integer role_id);

    Role findRoleBuId(Integer role_id);

    int updateTheRole(Role role);

    int addRole(@Param("role_id") Integer role_id, @Param("moduleId") Integer moduleId);

    Role findRoleByName(String name);

    int insertRole(Role role);
}
