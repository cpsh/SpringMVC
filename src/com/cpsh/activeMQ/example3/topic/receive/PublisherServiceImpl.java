package com.cpsh.activeMQ.example3.topic.receive;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

import com.cpsh.activeMQ.example3.queue.receive.MyMessageCreator;

public class PublisherServiceImpl implements PublisherService {
    JmsTemplate jmsTemplate;
    Destination destination;
    
    @Override
    public void send() {
        for (int i = 0; i < 10; i++) {
            MyMessageCreator myMessageCreator = new MyMessageCreator();
            jmsTemplate.send(this.destination,myMessageCreator);
        }

    }
    
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

}
