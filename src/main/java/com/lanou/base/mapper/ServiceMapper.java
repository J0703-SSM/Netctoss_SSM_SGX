package com.lanou.base.mapper;

import com.lanou.account.domain.Account;
import com.lanou.service.domain.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dllo on 17/11/16.
 */

public interface ServiceMapper {


    List<Service> findAll();

    //@Param很重要 拼接参数
    List<Service> findAllGj(@Param("idcard_no") String idcard_no, @Param("status") String status, @Param("unix_host") String unix_host, @Param("os_username") String os_username);
}
