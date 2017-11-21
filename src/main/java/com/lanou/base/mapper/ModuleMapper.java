package com.lanou.base.mapper;

import com.lanou.role.domain.Module;

import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
public interface ModuleMapper {

    List<Module> findModuleByRoleId();


}
