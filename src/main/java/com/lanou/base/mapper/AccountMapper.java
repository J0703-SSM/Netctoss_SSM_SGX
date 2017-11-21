package com.lanou.base.mapper;

import com.github.pagehelper.PageInfo;
import com.lanou.account.domain.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
public interface AccountMapper {

    List<Account> findAllGJ(Account account);

    List<Account> findAll();

    Account findById(Integer account_id);
}
