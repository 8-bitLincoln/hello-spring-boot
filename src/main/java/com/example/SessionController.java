package com.example;

import com.example.beans.BeanScopeCustom;
import com.example.beans.BeanScopeRequest;
import com.example.beans.BeanScopeSession;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

@Controller
@EnableAutoConfiguration
public class SessionController
{

   @Autowired
   private ApplicationContext applicationContext;

    /*
    Spring Session provides the following features:

    1. HttpSession - allows replacing the HttpSession in an application container (i.e. Tomcat) neutral way
        a. Clustered Sessions - Spring Session makes it trivial to support clustered sessions without being tied to
           an application container specific solution.
        b. Multiple Browser Sessions - Spring Session supports managing multiple users' sessions in a single browser
           instance (i.e. multiple authenticated accounts similar to Google).
        c. RESTful APIs - Spring Session allows providing session ids in headers to work with RESTful APIs
    2. WebSocket - provides the ability to keep the HttpSession alive when receiving WebSocket messages
     */

    @RequestMapping("/session")
    @ResponseBody
    public String session(HttpServletRequest request, HttpServletResponse response) {
/*
        request.getSession() will return a current session. if current session does not exist, then it will create a new one.
        request.getSession(true) will return current session. If current session does not exist, then it will create a new session.
        request.getSession(false) will return current session if current session does not exist, then it will not create a new session.
*/
        HttpSession session = request.getSession(true);
        session.setAttribute("miu" + RandomUtils.nextInt(0, 9), "miu-miu");

        StringBuilder stringBuilder = new StringBuilder();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            stringBuilder.append(attributeNames.nextElement()).append("<br/>");
        }

        return "Session id: " + session.getId() +
                "<br/> creation time: " + getPrettyDateString(session.getCreationTime()) +
                "<br/> last accessed time: " + getPrettyDateString(session.getLastAccessedTime()) +
                "<br/> Attributes: <br/>" + stringBuilder.toString() +
                "<br/>" + BeanScopeSession.class.getName() + ", creation time : " + applicationContext.getBean(BeanScopeSession.class).getCreated() +
                "<br/>" + BeanScopeRequest.class.getName() + ", creation time : " + applicationContext.getBean(BeanScopeRequest.class).getCreated() +
                "<br/>" + BeanScopeCustom.class.getName() + ", creation time : " + applicationContext.getBean(BeanScopeCustom.class).getCreated();
    }

   private String getPrettyDateString(long creationTime)
   {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
      return Instant.ofEpochMilli(creationTime).atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter);
   }

   @RequestMapping("/piu")
    public String piu() {
        return "StrategyAndTemplateMethodPatterns";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SessionController.class, args);
    }
}