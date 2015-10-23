package com.cpsh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cpsh.utils.ParamUtil;

@Controller
public class HelloAction {

    @RequestMapping(value = "/hello/")
    public String hello() {

        System.out.println("spring mvc hello world!");
        return "front/hello";

    }

    @RequestMapping(value = "/hello/forward/")
    public String forwardURL() {
        System.out.println("进入HelloAction。。。开始Action转发");
        return "forward:/forward/"; 
    }
    
    
    @RequestMapping(value = "/hello/redirect/")
    public String redirectURL(HttpServletRequest request) {
        System.out.println("进入HelloAction。。。开始Action重定向");
        String param = ParamUtil.getParameter(request, "param");
        System.out.println("param = " + param);
        request.setAttribute("param", "这是一个转发的页面");

        /**
         * web.xml配置listener方式
         */
        ServletContext sc = request.getServletContext();
        WebApplicationContext attr1 = WebApplicationContextUtils.getWebApplicationContext(sc);
        
        return "redirect:/index.jsp"; 
    }
    
    
    
    /**
     * 处理ajax请求
     * 
     * 包含下面两个jar包。spring的配置文件开启<mvc:annotation-driven/>,使用spring的内置json准换
     * jackson-core-asl-1.7.2.jar
       jackson-mapper-asl-1.7.2.jar
     * @return
     */
    @RequestMapping(value = "/hello/ok")
    @ResponseBody
    public Object ok() {
        System.out.println("ok");
        List<String> list = new ArrayList<String>();
        list.add("电视机");
        list.add("冰箱");
        list.add("山东省");
        list.add("多发点");
        list.add("D大调");
        list.add("规范");
        list.add("啦啦啦");
        list.add("咯就是");
        list.add("阿瓦尔");

        return list;

    }
    
    @RequestMapping(value = "/hello/exception")
    public void exception() {
        try {
            throw new Exception("抛出异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

}
