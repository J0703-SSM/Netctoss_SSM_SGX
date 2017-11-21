package com.lanou.service.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.service.domain.Service;
import com.lanou.service.service.ServiceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/11/16.
 */
@Controller
public class ServiceController {

    @Resource
    private ServiceService serviceService;

    @RequestMapping(value = "service/service_list")
    public String  Jump(){
        return "service/service_list";
    }


    //普通分页
    @RequestMapping(value = "/findAllService")
    @ResponseBody
    public PageInfo<Service> findAllService(Integer pageNum,Integer pageSize){
        System.out.println(pageNum);
        System.out.println(pageSize);
        PageInfo<Service> pageInfo = serviceService.findAll(pageNum, pageSize);
        System.out.println("pageInfoPT"+pageInfo);
        return pageInfo;

    }
    //高级分页
    @RequestMapping(value = "/pageAllService")
    @ResponseBody
    public PageInfo<Service> pageAllService( String idcard_no, Service service,Integer pageNum , @Param("pageSize") Integer pageSize, HttpSession session){
//        System.out.println(service);
//        System.out.println("Os"+service.getOs_username());
//        System.out.println("Ip"+service.getUnix_host());
//
//        System.out.println("身份证"+idcard_no);
//         session.setAttribute("Os",service.getOs_username());
//         session.setAttribute("Ip",service.getUnix_host());
//         session.setAttribute("status",service.getStatus());
//         session.setAttribute("idcard_no",idcard_no);

        PageInfo<Service> pageInfo = null;

        if (!idcard_no.equals("5") && !service.getOs_username().equals("5") && !service.getUnix_host().equals("5") && !service.getStatus().equals("5")){
            session.setAttribute("service",service);
            session.setAttribute("idcard_no",idcard_no);
            pageInfo = serviceService.findAllGj(idcard_no, service, pageNum, pageSize);

        }else {

            Service service1 = (Service) session.getAttribute("service");
            String idcard_no1 = (String) session.getAttribute("idcard_no");
            pageInfo=  serviceService.findAllGj(idcard_no1,service1,pageNum,pageSize);
        }
        System.out.println("pageInfoGJ"+pageInfo);




        return pageInfo;

    }



}
