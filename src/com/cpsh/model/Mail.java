package com.cpsh.model;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class Mail {
    
    // 定义发件人、收件人、主题等
    String to = "";
    String cc = "";
    String bcc = "";
    String from = "";
    String host = "";
    String filename = "";
    String subject = "";

    // 用于保存发送附件的文件名的集合
    Vector file = new Vector();
    
    // 发送的内容
    String content = "";

    // 做一个可以传发件人等参数的构造
    public Mail(String to, String from, String smtpServer, String subject) {
        // 初始化发件人、收件人、主题等
        this.to = to;
        this.from = from;
        this.host = smtpServer;
        this.subject = subject;
    }

    //add content
    
    // 该方法用于收集附件名
    public void attachfile(String fname) {
        file.addElement(fname);
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
    // 开始发送信件的方法
    /*
    public boolean startSend() {
        // 创建Properties对象
        Properties props = System.getProperties();
        // 创建信件服务器
        props.put("mail.smtp.host", host);
        // 得到默认的对话对象
        Session session = Session.getDefaultInstance(props, null);
        try {
            // 创建一个消息，并初始化该消息的各项元素
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = { new InternetAddress(to) };
            msg.setRecipients(Message.RecipientType.TO, address);

            msg.setSubject(subject);
            // 后面的BodyPart将加入到此处创建的Multipart中
            Multipart mp = new MimeMultipart();
            // 利用枚举器方便的遍历集合
            Enumeration efile = file.elements();
            // 检查序列中是否还有更多的对象
            while (efile.hasMoreElements()) {
                MimeBodyPart mbp = new MimeBodyPart();
                // 选择出每一个附件名
                filename = efile.nextElement().toString();
                // 得到数据源
                FileDataSource fds = new FileDataSource(filename);
                // 得到附件本身并至入BodyPart
                mbp.setDataHandler(new DataHandler(fds));
                // 得到文件名同样至入BodyPart
                mbp.setFileName(fds.getName());
                mp.addBodyPart(mbp);
            }
            // 移走集合中的所有元素
            file.removeAllElements();
            // Multipart加入到信件
            msg.setContent(mp);
            // 设置信件头的发送日期
            msg.setSentDate(new Date());
            // 发送信件
            Transport.send(msg);
        } catch (MessagingException mex) {
            mex.printStackTrace();
            Exception ex = null;
            if ((ex = mex.getNextException()) != null) {
                ex.printStackTrace();
            }
            return false;
        }
        return true;
    }
    */
}