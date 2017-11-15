package com.lanou.account.service;

import com.github.pagehelper.PageInfo;
import com.lanou.account.domain.Account;

/**
 * Created by dllo on 17/11/14.
 */
public interface AccountService {
    PageInfo<Account> queryPage(Account account,Integer pageNum,Integer pageSize);
}
