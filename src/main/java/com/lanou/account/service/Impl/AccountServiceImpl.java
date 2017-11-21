package com.lanou.account.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.account.domain.Account;
import com.lanou.account.service.AccountService;
import com.lanou.base.mapper.AccountMapper;
import com.lanou.cost.domain.Cost;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    //高级分页
    public PageInfo<Account> queryPageGJ(Account account,Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 4 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        System.out.println(account.getIdcard_no()+"+++++++++");
        List<Account> all = accountMapper.findAllGJ(account);
        PageInfo<Account> pageInfo = new PageInfo<Account>(all);

        return pageInfo;
    }

    public PageInfo<Account> queryPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 4 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Account> all = accountMapper.findAll();
        PageInfo<Account> pageInfo = new PageInfo<Account>(all);

        return pageInfo;
    }

    public Account findById(Integer account_id) {
        return accountMapper.findById(account_id);
    }


//    public Account updateStatuById(Account account) {
//        if (account.getStatus().equals("0")){
//             account.setPause_date(Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())));
//        }
//        if (account.getStatus().equals("1")){
//            account.setPause_date(Timestamp.valueOf(""));
//        }
//        return null;
//    }

}

