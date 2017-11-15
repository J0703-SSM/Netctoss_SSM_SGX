package com.lanou.account.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.account.domain.Account;
import com.lanou.account.service.AccountService;
import com.lanou.base.mapper.AccountMapper;
import com.lanou.cost.domain.Cost;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    //分页
    public PageInfo<Account> queryPage(Account account,Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 5 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Account> all = accountMapper.findAll(account);
        PageInfo<Account> pageInfo = new PageInfo<Account>(all);

        return pageInfo;
    }

}

