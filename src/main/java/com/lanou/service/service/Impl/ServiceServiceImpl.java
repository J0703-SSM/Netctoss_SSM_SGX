package com.lanou.service.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.account.domain.Account;
import com.lanou.base.mapper.ServiceMapper;
import com.lanou.service.domain.Service;
import com.lanou.service.service.ServiceService;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/16.
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Resource
    private ServiceMapper serviceMapper;

    public PageInfo<Service> findAll(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 4 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        System.out.println(pageNum);
        List<Service> all = serviceMapper.findAll();
        PageInfo<Service> pageInfo = new PageInfo<Service>(all);

        return pageInfo;
    }

    public PageInfo<Service> findAllGj(String idcard_no, Service service,Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null? 4 :pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<Service> all = serviceMapper.findAllGj(idcard_no,service.getStatus(),service.getUnix_host(),service.getOs_username());
        PageInfo<Service> pageInfo = new PageInfo<Service>(all);

        return pageInfo;
    }
}
