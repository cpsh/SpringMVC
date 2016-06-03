package com.cpsh.rabbitMQ.spring_amqp.example_1;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

public class DirectListenter implements MessageListener{

    private final static Logger logger = Logger.getLogger(DirectListenter.class);
    
    @Override
    public void onMessage(Message msg) {
        try{
            
            String str = new String(msg.getBody());
            System.out.println("Direct Linstener Comumer -------- receive message : "+ str);
            logger.info("Direct Linstener Comumer -------- receive message : "+ str);
            Thread.currentThread().sleep(1000);
        }catch(Exception e){
            logger.error(e);
            e.printStackTrace();
        }
    }
    
}
