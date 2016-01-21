package com.cpsh.activeMQ.example2;

import javax.jms.JMSException;     
import org.apache.activemq.ActiveMQConnection;  
    
public class Test {     
    
    /**   
     * @param args   
     */    
    public static void main(String[] args) throws JMSException, Exception {     
       
     // TODO Auto-generated method stub     
        ConsumerTool consumer = new ConsumerTool();     
        ProducerTool producer = new ProducerTool();    
        System.out.println(ActiveMQConnection.DEFAULT_BROKER_URL+"------------");  
        // 开始监听     
        consumer.consumeMessage();     
             
        // 延时500毫秒之后发送消息     
        Thread.sleep(500);     
        producer.produceMessage("Hello, world!");     
        producer.close();     
             
        // 延时500毫秒之后停止接受消息     
        Thread.sleep(500);     
        consumer.close();     
    }     
}   