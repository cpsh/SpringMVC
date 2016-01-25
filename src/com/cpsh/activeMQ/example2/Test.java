package com.cpsh.activeMQ.example2;

import javax.jms.JMSException;     

import org.apache.activemq.ActiveMQConnection;  
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

import org.apache.log4j.Logger;

import com.cpsh.utils.LoggerUtil;
    
public class Test {     
//    private static Logger logger = LoggerFactory.getLogger(Test.class);
//    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Test.class);
    
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Test.class);
//    private static Logger infoLogger = Logger.getLogger("info");
    
    /**   
     * @param args   
     */    
    public static void main(String[] args) throws JMSException, Exception {     
       LoggerUtil.info("开始测试ActiveMQ消息队列.......................");//log4j.properties生效
       LoggerUtil.debug("开始测试ActiveMQ消息队列.......................");//log4j.properties生效
       LoggerUtil.error("开始测试ActiveMQ消息队列.......................");//log4j.properties生效
       LoggerUtil.warn("开始测试ActiveMQ消息队列.......................");//log4j.properties生效
       
       logger.info("开始测试ActiveMQ消息队列.......................");
       
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
       
//        consumer.consumeMessage();
             
        // 延时500毫秒之后停止接受消息     
        Thread.sleep(500);     
        consumer.close();     
    }     
}   