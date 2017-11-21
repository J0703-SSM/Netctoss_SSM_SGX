package com.lanou.service.service;

import com.github.pagehelper.PageInfo;
import com.lanou.service.domain.Service;

/**
 * Created by dllo on 17/11/16.
 */
public interface ServiceService {
    PageInfo<Service> findAll(Integer pageNum, Integer pageSize);

    PageInfo<Service> findAllGj(String idcard_no,Service service,Integer pageNum, Integer pageSize);
}
