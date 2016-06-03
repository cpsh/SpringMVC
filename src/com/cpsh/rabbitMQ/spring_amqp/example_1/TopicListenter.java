package com.cpsh.rabbitMQ.spring_amqp.example_1;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class TopicListenter implements MessageListener{

    private final static Logger logger = Logger.getLogger(TopicListenter.class);
    
    @Override
    public void onMessage(Message msg) {
        try{
            
            String str = new String(msg.getBody());
            System.out.println("Topic Linstener Comumer -------- receive message : "+ str);
            logger.info("Topic Linstener Comumer -------- receive message : "+ str);
            Thread.currentThread().sleep(1000);
        }catch(Exception e){
            logger.error(e);
            e.printStackTrace();
        }
    }
    
}
