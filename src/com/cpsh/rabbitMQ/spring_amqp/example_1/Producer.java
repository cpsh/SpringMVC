package com.cpsh.rabbitMQ.spring_amqp.example_1;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Autowired
    private AmqpTemplate directTemplate;

    @Autowired
    private AmqpTemplate fanoutTemplate;

    private final static Logger logger = Logger.getLogger(Producer.class);

    // Direct
    // =====================================================================================
    public void sendDataToQueue_Direct(String queueKey, Object object) {
        try {
            logger.info("send to queue :" + queueKey
                    + "  ------ direct message : " + object.toString());

            // convertAndSend：将Java对象转换为消息发送到匹配Key的交换机中Exchange，由于配置了JSON转换，这里是将Java对象转换成JSON字符串的形式。
            // 可在template方法体参数指定queue队列名称，也可在xml中<rabbit:template queue="">指定
            directTemplate.convertAndSend(queueKey, object);

            System.out.println("send to queue :" + queueKey
                    + "  ------ direct message : " + object);
        } catch (Exception e) {
            logger.error(e);
        }

    }

    public void sendDataToQueue_Direct(String queueKey, String object) {
        try {
            logger.info("send to queue :" + queueKey
                    + "  ------ direct message : " + object);
            // convertAndSend：将Java对象转换为消息发送到匹配Key的交换机中Exchange，由于配置了JSON转换，这里是将Java对象转换成JSON字符串的形式。
            directTemplate.convertAndSend(queueKey, object);

            System.out.println("send to queue :" + queueKey
                    + "  ------ direct message : " + object);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    // Topic
    // =====================================================================================
    @Autowired
    private AmqpTemplate topicTemplate;
    
    public void sendDataToQueue_Topic(String queueKey, Object object) {
        try {
            logger.info("send to queue :" + queueKey
                    + "  ------ topic message : " + object.toString());
            // convertAndSend：将Java对象转换为消息发送到匹配Key的交换机中Exchange，由于配置了JSON转换，这里是将Java对象转换成JSON字符串的形式。
            topicTemplate.convertAndSend(queueKey, object);
            System.out.println("send to queue :" + queueKey + "  ------ topic message : " + object);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void sendDataToQueue_Topic(String queueKey, String object) {
        try {
            logger.info("send to queue :" + queueKey
                    + "  ------ topic message : " + object);
            topicTemplate.convertAndSend(queueKey, object);
            System.out.println("send to queue :" + queueKey
                    + "  ------ topic message : " + object);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    // Fanout
    // =====================================================================================

    public void sendDataToQueue_Fanout(String queueKey, Object object) {
        try {
            logger.info("send to queue :" + queueKey
                    + "  ------ fanout message : " + object.toString());

            fanoutTemplate.convertAndSend(object);

            System.out.println("send to queue :" + queueKey
                    + "  ------ fanout message : " + object);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void sendDataToQueue_Fanout(String queueKey, String object) {
        try {
            logger.info("send to queue :" + queueKey
                    + "  ------ fanout message : " + object);

            fanoutTemplate.convertAndSend(object);

            System.out.println("send to queue :" + queueKey
                    + "  ------ fanout message : " + object);
        } catch (Exception e) {
            logger.error(e);
        }

    }

}