package com.lanou.base.mapper;

import com.github.pagehelper.PageInfo;
import com.lanou.account.domain.Account;

import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
public interface AccountMapper {

    List<Account> findAll(Account account);
}
