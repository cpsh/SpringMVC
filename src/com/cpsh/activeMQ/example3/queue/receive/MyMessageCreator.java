package com.cpsh.activeMQ.example3.queue.receive;

import java.util.Date;
import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.MessageCreator;

import com.cpsh.utils.DateUtil;

/**
 * 消息产生者
 */
public class MyMessageCreator implements MessageCreator {

    @Override
    public Message createMessage(Session session) throws JMSException {
        Date date = new Date();
        String content = DateUtil.getFormattedDateString(date,"yyyy-MM-dd HH:mm:ss SSS");
        MapMessage message = session.createMapMessage();
//        message.setString(date.toString(), content);
        message.setString(content, content);
//        TextMessage message = session.createTextMessage();
//        message.setText(content);
        System.out.println("--发送消息：" +  content);
        return message;
    }

}