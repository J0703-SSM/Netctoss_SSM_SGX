package com.lanou.account.service;

import com.github.pagehelper.PageInfo;
import com.lanou.account.domain.Account;

/**
 * Created by dllo on 17/11/14.
 */
public interface AccountService {
    PageInfo<Account> queryPageGJ(Account account,Integer pageNum,Integer pageSize);

    PageInfo<Account> queryPage(Integer pageNum, Integer pageSize);

    Account findById(Integer account_id);

//    Account updateStatuById(Account account);
}
