package com.cpsh.rabbitMQ.spring_amqp.example_1;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpsh.rabbitMQ.spring_amqp.example_1.Producer;

@Controller
public class RabbitMQController {
    
    @Resource
    private Producer producer;
    
    private final static String QUEUE_NAME_1 = "queue_1";
    private final static String QUEUE_NAME_2 = "queue_2";
    
    private final static String QUEUE_NAME_3 = "queue_3";
    private final static String QUEUE_NAME_4 = "queue_4";
    
    
    @RequestMapping("/direct")
    @ResponseBody
    public Object direct() throws Exception {
        List<String> list = new ArrayList<String>() ;
        for(int i=0;i<5;i++){
            String msg = "dirext data"+i;
            list.add(msg);
            producer.sendDataToQueue_Direct(QUEUE_NAME_1,msg);
        }
        
        producer.sendDataToQueue_Direct(QUEUE_NAME_1,list);
        
        return list;
    }
    
    @RequestMapping("/topic")
    @ResponseBody
    public Object topic() throws Exception {
        List<String> list = new ArrayList<String>() ;
        for(int i=0;i<5;i++){
            String msg = "topic data"+i;
            list.add(msg);
            producer.sendDataToQueue_Topic(QUEUE_NAME_2,msg);
        }
        
        producer.sendDataToQueue_Topic(QUEUE_NAME_2,list);
        
        return list;
    }
    
    @RequestMapping("/fanout")
    @ResponseBody
    public Object fanout() throws Exception {
        List<String> list = new ArrayList<String>() ;
        for(int i=0;i<5;i++){
            String msg = "fanout data"+i;
            list.add(msg);
            producer.sendDataToQueue_Fanout(QUEUE_NAME_3,msg);
        }
        producer.sendDataToQueue_Fanout(QUEUE_NAME_3,list);
        
        return list;
    }
}
