package com.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //在一个特定的时间执行这个方法 Timer（Thread排序）
    //cron 表达式
    //秒 分 时 日 月 周几
    /*
        0 12 20 * * ?   每天的20点12分0秒执行一次
        0 0/5 20，21 * * ?    每天的20点和21点每隔五分钟执行一次
        0 12 20 ? * 1-6    每个月周一到周六的20点12分0秒执行一次
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void hello(){
        System.out.println("hello,你被执行了~");
    }
}
