package com.cpsh.activeMQ.example3.queue.listener;

import java.util.Date;
import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class ConsumerMessageListener implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        if (msg instanceof MapMessage) {
            try {
//                boolean isContinue = true;
                MapMessage message = (MapMessage)msg;
//                while (isContinue) {
                    if (msg != null) {
                        Enumeration en = message.getMapNames();
                        while (en.hasMoreElements()) {
                            String name = (String) en.nextElement();
                            System.out.println("--收到消息：messageId="+message.getJMSMessageID() + " ,name=" + name +" ,message=" + message.getString(name));
                        }
                   /*}else {
                       isContinue = false;
                       System.out.println("------------队列中没有消息-----------");
                   }*/
               }
            } catch (Exception e) {
            }
        }
        
        
        /*if (msg instanceof MapMessage) {
            MapMessage message = (MapMessage) msg;
            try {
                System.out.println("--MessageListener收到信息："+ new Date(message.getLong("count")));
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }*/
    }

}
