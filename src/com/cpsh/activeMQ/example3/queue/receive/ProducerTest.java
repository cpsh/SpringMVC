package com.cpsh.activeMQ.example3.queue.receive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ProducerTest {
    private static ApplicationContext context=new FileSystemXmlApplicationContext("/WebRoot/WEB-INF/applicationContext.xml"); 
    
    private static void send() {
        /*JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        Destination destination = (Destination) context.getBean("Queue1");*/
        ProducerService service = (ProducerService)context.getBean("producerService");
        service.send();
    }
    
    public static void main(String[] args) {
        send();
    }
}
