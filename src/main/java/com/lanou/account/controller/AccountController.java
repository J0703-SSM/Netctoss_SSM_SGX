package com.lanou.account.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.account.domain.Account;
import com.lanou.account.service.AccountService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by dllo on 17/11/14.
 */
@Controller
public class AccountController {
    @Resource
    private AccountService accountService;

    //点击账务账号
    @RequestMapping(value = "/account/account_list")
    private String frontPage() {

        return "account/account_list";
    }

    //分页 + 普通查询
    @RequestMapping(value = "/findAllAccount")
    @ResponseBody
    public PageInfo<Account> pagequery(Integer pageNum, Integer pageSize) {
        PageInfo<Account> pageInfo = accountService.queryPage(pageNum, pageSize);
        return pageInfo;
    }


    //连接service表
    @RequestMapping(value = "/findAccount")
    @ResponseBody
    public Account findAccount(Integer account_id){
        Account byId = accountService.findById(account_id);
        return byId;
    }

    //分页+高级查询
    @RequestMapping(value = "/pageAllAccount")
    @ResponseBody
    public PageInfo<Account> pagequeryGJ(Account account, Integer pageNum, Integer pageSize, HttpSession session) {
        System.out.println("双击666" + account);
        System.out.println("card" + account.getIdcard_no());
        System.out.println("real_name" + account.getReal_name());
        System.out.println("login_name" + account.getLogin_name());
        System.out.println("status" + account.getStatus());


        PageInfo<Account> pageInfo = null;

        //这是判断点击第二页以后的操作
        if (!account.getIdcard_no().equals("5") && !account.getReal_name().equals("5") && !account.getLogin_name().equals("5") && !account.getStatus().equals("5")) {
            session.setAttribute("account", account);
            pageInfo = accountService.queryPageGJ(account, pageNum, pageSize);


        } else {
            Account account1 = (Account) session.getAttribute("account");
            pageInfo = accountService.queryPageGJ(account1, pageNum, pageSize);

        }
        System.out.println(pageInfo);
        return pageInfo;
    }
    //修改状态
//    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
//    @ResponseBody
//    public AjaxResult updateStatus(Account account){
//         accountService.updateStatuById(account);
//    }

    //添加
    @RequestMapping(value = "/account/account_add")
    public String account_add() {
        return "account/account_add";
    }


}
