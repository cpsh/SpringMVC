package com.cpsh.activeMQ.example3.queue.receive;

import java.util.Date;
import java.util.Enumeration;

import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;


public class ConsumerServiceImpl implements ConsumerService {
    JmsTemplate jmsTemplate;
    Destination destination;

    @SuppressWarnings("rawtypes")
    @Override
    public void receive() {
        
        try {
            MapMessage message = null;
            boolean isContinue = true;
            while (isContinue) {
                 message = (MapMessage) jmsTemplate.receive(destination);//手动接收消息获取，一次只能接收一条
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
        
        /*try {
            TextMessage msg = null;
            //是否继续接收消息
              boolean isContinue = true;
              while (isContinue) {
                  msg = (TextMessage) jmsTemplate.receive(destination);
                  System.out.println("收到消息 :" + msg.getText());
                  if (msg.getText().equals("end")) {
                      isContinue = false;
                      System.out.println("收到退出消息，程序要退出！");
                  }
              }
        } catch (Exception e) {
            
        }*/
        
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

}
