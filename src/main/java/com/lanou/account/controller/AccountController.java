package com.lanou.account.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.account.domain.Account;
import com.lanou.account.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/14.
 */
@Controller
public class AccountController {
    @Resource
    private AccountService accountService;

    //点击账务账号
   @RequestMapping(value = "/account/account_list")
    private String frontPage(){
       return "account/account_list";
   }
   //分页+查询所有+高级查询
    @RequestMapping(value = "/pageAllAccount")
    @ResponseBody
    public PageInfo<Account> pagequery(Account account,Integer pageNum, Integer pageSize){
//        System.out.println(account);
        PageInfo<Account> pageInfo = accountService.queryPage(account,pageNum, pageSize);
        return pageInfo;
   }


}
