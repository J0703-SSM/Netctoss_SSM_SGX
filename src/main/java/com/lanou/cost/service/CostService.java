package com.lanou.cost.service;

import com.github.pagehelper.PageInfo;
import com.lanou.cost.domain.Cost;

/**
 * Created by dllo on 17/11/11.
 */
public interface CostService {

    //分页 查询所有
    PageInfo<Cost> queryPage(Integer info,Integer pageNum,Integer PagSize);

    void deleteFee(Integer cost_id);

    void updateSave(Cost cost);

    Cost selectById(Integer cost_id);

    void updateQy(Cost cost);

    void insert(Cost cost);

    Cost findById(Integer cost_id);
}
