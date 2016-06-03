package com.cpsh.rabbitMQ.spring_amqp.SimpleMain;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

public class JavaProducer {
    
    private final static String QUEUE_NAME = "spring-amqp-queue";
    private final static String MQ_HOST = "192.168.230.131";
    private final static int    MQ_PORT = 5672;
    
    // 交换器名称
    private static final String EXCHANGE_NAME = "spring-amqp-topic";
    
    public static void main(String[] args) throws Exception {

        CachingConnectionFactory cf = new CachingConnectionFactory();
        cf.setHost(MQ_HOST);
        cf.setPort(MQ_PORT);
        
        // set up the queue, exchange, binding on the broker
        RabbitAdmin admin = new RabbitAdmin(cf);
        Queue queue = new Queue(QUEUE_NAME);
        admin.declareQueue(queue);
        
        TopicExchange exchange = new TopicExchange(EXCHANGE_NAME);
        admin.declareExchange(exchange);
        admin.declareBinding(BindingBuilder.bind(queue).to(exchange)
                .with("foo.*"));

        // set up the listener and container
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cf);
        Object listener = new Object() {
            public void handleMessage(String foo) {
                System.out.println(foo);
            }
        };
        MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
        container.setMessageListener(adapter);
        container.setQueueNames(QUEUE_NAME);
        container.start();

        // send something
        RabbitTemplate template = new RabbitTemplate(cf);
        template.convertAndSend(EXCHANGE_NAME, "foo.bar", "Hello, world!");
        Thread.sleep(1000);
        container.stop();
    }
}
