package com.lanou.cost.controller;

import com.github.pagehelper.PageInfo;


import com.lanou.cost.domain.Cost;
import com.lanou.cost.service.CostService;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/11/10.
 */
@Controller
public class CostController {

    @Resource
    private CostService costService;




    @RequestMapping("index")
    public String Jump(){
        return "index";
    }


    //点击咨询费用
    @RequestMapping("/fee/fee_list")
    public String fee_list(){
        return "/fee/fee_list";
    }

    //连接service表 根基costId查询cost信息
    @RequestMapping(value = "/findCost")
    @ResponseBody
    public Cost showCost(Integer cost_id){
        return costService.findById(cost_id);
    }



    //分页+查询所有
    @ResponseBody
    @RequestMapping(value = "/pageAll")
    public PageInfo<Cost> pageAll(@RequestParam("info")Integer info, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, HttpSession session){

        System.out.println("info+++++++"+info);
        System.out.println("pageNum+++"+pageNum);
        System.out.println("pageSize"+pageSize);
//        System.out.println("info2******"+info2);
        PageInfo<Cost> costPageInfo = null;
        //这是判断我点击分页的1,2,3,4,5,6--之后的操作数据(升序,降序)
        if (info != 6) {
            session.setAttribute("info",info);
            costPageInfo = costService.queryPage(info,pageNum,pageSize);

        }else {
            Integer info1 = (Integer) session.getAttribute("info");
            costPageInfo = costService.queryPage(info1, pageNum, pageSize);
        }
        System.out.println("costPageInfo分页"+ costPageInfo);
        return costPageInfo;
    }

    //删除
    @RequestMapping(value = "/deleteFee")
    public void deleteFee(@RequestParam("cost_id")Integer cost_id){
      costService.deleteFee(cost_id);

    }




    //点击修改 + 回显 因为是html 不能用Model $ 只能用session
    @RequestMapping(value = "/fee/fee_modi")
    public String update(@RequestParam("cost_id")Integer cost_id, HttpSession session){
        Cost cost = costService.selectById(cost_id);
        //数据回显
        session.setAttribute("cost",cost);
        return "/fee/fee_modi";
    }
    //回显
    @RequestMapping(value = "/show")
    @ResponseBody
    public Map<String,Object> show(HttpSession session){
        Cost cost = (Cost) session.getAttribute("cost");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("showCost",cost);
        return map;
    }
    //修改保存
    @RequestMapping(value = "/fee/updateSave")
    public String updateSave(Cost cost){
        costService.updateSave(cost);
        //因为写在from表单里可以用redirect
        return "redirect:fee_list";
    }


    //点击启用
    @RequestMapping(value = "/updateQy")
    @ResponseBody
    public Map<String, Object> updateQy(@RequestParam("cost_id")Integer cost_id,HttpSession session){
        Cost cost1 = costService.selectById(cost_id);
        session.setAttribute("cost",cost1);
        Cost cost = (Cost) session.getAttribute("cost");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("showQy",cost);
        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        cost.setStartime(timestamp);
        cost.setStatus("开通");
        costService.updateQy(cost);

        return map;

    }

    //点击资费名称 回显
    @RequestMapping(value = "/fee/fee_detail")
    public String findByname(@RequestParam("cost_id")Integer cost_id,HttpSession session){
        Cost cost2 = costService.selectById(cost_id);
        session.setAttribute("cost2",cost2);
         return "/fee/fee_detail";

    }

    @RequestMapping("/showName")
    @ResponseBody
    public Map<String,Object> showName(HttpSession session){
        Cost cost2 = (Cost) session.getAttribute("cost2");
//        System.out.println(cost2);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("showName",cost2);
        return  map;
    }

    //点击添加
    @RequestMapping("/fee/fee_add")
    public String addCost(){
        return "/fee/fee_add";
    }
    //添加的保存
    @RequestMapping("/fee/addCost")
    public String addCostReal(Cost cost){
        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp= new Timestamp(time);
        cost.setCreatime(timestamp);
        cost.setStatus("未开通");
        costService.insert(cost);
        return "redirect:fee_list";

    }



}
