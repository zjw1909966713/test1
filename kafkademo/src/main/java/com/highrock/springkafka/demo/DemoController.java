package com.highrock.springkafka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private  MsgProducer msgProducer;

    @Autowired
    private MsgConsumer msgConsumer;


    /**
     * 发送消息
     * @param message
     * @return
     */
    @RequestMapping("/send")
    public String send(String message){

        boolean flag=msgProducer.sendMessage("topic-11",message);
        if (flag)
            return "success";
        else
            return "error";

    }



}
