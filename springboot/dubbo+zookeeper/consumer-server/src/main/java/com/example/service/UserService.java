package com.example.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //想拿到provider-server提供的票,要去注册中心拿服务
    @Reference //引用：pom坐标，定义路径相同的接口名
    TicketService ticketService;

    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心拿到==>"+ticket);
    }
}
