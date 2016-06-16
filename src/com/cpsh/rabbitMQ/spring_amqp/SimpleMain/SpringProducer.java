package com.cpsh.rabbitMQ.spring_amqp.SimpleMain;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class SpringProducer {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext context = new FileSystemXmlApplicationContext(
                "/WebRoot/WEB-INF/spring-rabbitmq.xml");
//        RabbitTemplate template = context.getBean(RabbitTemplate.class);
        RabbitTemplate template = (RabbitTemplate)context.getBean("amqpTemplate");
        /*
        ConnectionFactory factory = (CachingConnectionFactory)context.getBean("connectionFactory");
        RabbitTemplate template = new RabbitTemplate(factory);*/
//        for (int i = 0; i < 10; i++) {
            template.convertAndSend("spring-amqp-consumer-listen--- message : Hello, world !");
//        }
        context.destroy();
    }
}
