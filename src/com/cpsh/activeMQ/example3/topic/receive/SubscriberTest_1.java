package com.cpsh.activeMQ.example3.topic.receive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SubscriberTest_1 {
    private static ApplicationContext context=new FileSystemXmlApplicationContext("/WebRoot/WEB-INF/applicationContext.xml"); 
    
    private static void receive(){
        SubscriberService service = (SubscriberService)context.getBean("subscriberService_1");
        service.receive();
    }
    
    public static void main(String[] args) {
        receive();
    }
}
