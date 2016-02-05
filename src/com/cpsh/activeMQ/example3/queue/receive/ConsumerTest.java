package com.cpsh.activeMQ.example3.queue.receive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ConsumerTest {
    private static ApplicationContext context=new FileSystemXmlApplicationContext("/WebRoot/WEB-INF/applicationContext.xml"); 
    
    private static void receive() {
        ConsumerService service = (ConsumerService)context.getBean("consumerService");
        service.receive();
    }
    
    public static void main(String[] args) {
        receive();
    }
}
