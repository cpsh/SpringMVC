package com.cpsh.activeMQ.example3.topic.receive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class PublisherTest {
    private static ApplicationContext context=new FileSystemXmlApplicationContext("/WebRoot/WEB-INF/applicationContext.xml"); 
    
    private static void send() {
        PublisherService service = (PublisherService)context.getBean("publisherService");
        service.send();
    }
    
    public static void main(String[] args) {
        send();
    }
}
