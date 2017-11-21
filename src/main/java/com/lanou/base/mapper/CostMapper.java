package com.lanou.base.mapper;

import com.lanou.cost.domain.Cost;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */

public interface CostMapper {

    List<Cost> findAll();


    void deleteFee(Integer cost_id);

    void updateSave(Cost cost);

    Cost selectById(Integer cost_id);

    void updateQy(Cost cost);

    void insert(Cost cost);


}
