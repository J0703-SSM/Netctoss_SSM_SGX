package com.lanou.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.cost.domain.Cost;
import com.lanou.base.mapper.CostMapper;
import com.lanou.cost.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Service("costService")
public class CostServiceImpl implements CostService {

    @Resource
    private CostMapper costMapper;

    //分页 +排序
    public PageInfo<Cost> queryPage(Integer info,Integer pageNum, Integer PagSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        PagSize = PagSize == null ? 3 : PagSize;

            if (info ==0){
                PageHelper.startPage(pageNum, PagSize);
            }
            if (info ==1 ) {
                PageHelper.startPage(pageNum, PagSize, "base_cost desc");
            }
            if (info ==2) {
                PageHelper.startPage(pageNum, PagSize, "base_cost asc");
            }
            if (info==3) {
                PageHelper.startPage(pageNum, PagSize, "base_duration desc");
            }
            if (info==4) {
                PageHelper.startPage(pageNum, PagSize, "base_duration asc");
            }

        List<Cost> all = costMapper.findAll();
        PageInfo<Cost> pageInfo = new PageInfo<Cost>(all);

        return pageInfo;
    }

    public void deleteFee(Integer cost_id) {
        costMapper.deleteFee(cost_id);
    }

    public void updateSave(Cost cost) {
        costMapper.updateSave(cost);
    }

    public Cost selectById(Integer cost_id) {

        return costMapper.selectById(cost_id);
    }

    public void updateQy(Cost cost) {
        costMapper.updateQy(cost);
    }

    public void insert(Cost cost) {
        costMapper.insert(cost);
    }

    public Cost findById(Integer cost_id) {
        return costMapper.selectById(cost_id);
    }
}
