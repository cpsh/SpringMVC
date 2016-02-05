package com.cpsh.activeMQ.example3.queue.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

public class Test {
    private static ApplicationContext context=new FileSystemXmlApplicationContext("/WebRoot/WEB-INF/applicationContext.xml");
    
    public static void main(String[] args) throws InterruptedException   {
        ProducerService service = (ProducerService)context.getBean("producer_listener");  
        DefaultMessageListenerContainer consumer =   
            (DefaultMessageListenerContainer)context.getBean("consumerListenerContainer");  
//        consumer.start(); 
        
     // 延时500毫秒之后发送消息     
        Thread.sleep(500);  
        service.send();
        
    }
}
