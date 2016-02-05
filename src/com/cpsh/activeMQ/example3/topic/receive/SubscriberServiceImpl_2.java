package com.cpsh.activeMQ.example3.topic.receive;

import java.util.Enumeration;

import javax.jms.Destination;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;

public class SubscriberServiceImpl_2 implements SubscriberService {
    JmsTemplate jmsTemplate;
    Destination destination;
    
    @Override
    public void receive() {
        try {
            MapMessage message = null;
            boolean isContinue = true;
            while (isContinue) {
                 message = (MapMessage) jmsTemplate.receive();//手动接收消息获取，一次只能接收一条
                 if (message != null) {
                     Enumeration en = message.getMapNames();
                     while (en.hasMoreElements()) {
                         String name = (String) en.nextElement();
                         System.out.println("--收到消息：messageId="+message.getJMSMessageID() + " ,name=" + name +" ,message=" + message.getString(name));
                     }
                }else {
                    isContinue = false;
                    System.out.println("------------队列中没有消息-----------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
