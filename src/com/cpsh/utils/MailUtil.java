package com.cpsh.utils;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cpsh.model.SimpleMail;
import com.cpsh.model.rmi.MMRemote;
import com.cpsh.model.rmi.MMSubmitRes;
public class MailUtil {
    public static boolean isEmail(String mail){
        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        Matcher m = pattern.matcher(mail);
        return m.matches();
    }
    
    public static void main(String[] args){
        System.out.println(isEmail("abc@hotmail.com"));
    }
    
    public static void sentSimpleMail(SimpleMail mail) throws MalformedURLException, RemoteException, NotBoundException{
        /**
         * 
        SimpleMail mail = new SimpleMail();
        mail.setSubject("51汽车注册帐号激活");
        mail.setContent(sb.toString());
        mail.setFrom("service@51auto.cn");
        mail.setTo(email);
         */
        //发送Email 个人
       /* Configuration domainconf = ConfigReader.getConfiguration("domain-name");
        String rmiurl = domainconf.getChild("rmiurl").getValue();
        MMRemote RemoteObj = (MMRemote) Naming.lookup(rmiurl);
        MMSubmitRes mmRes = RemoteObj.submit(mail);*/
    }
}
