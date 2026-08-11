package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.example.config.WebConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws LifecycleException {

        //Boiler PlateCode
        Tomcat tomcat = new Tomcat();
        tomcat.setHostname("localhost");
        tomcat.setPort(8080);
        tomcat.getConnector();


        //Create a webApp
        String contextPath ="";
        String baseDoc = new File("src/main/webApp").getAbsolutePath();
        Context context = tomcat.addContext(contextPath , baseDoc);

        //IOC container
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
springContext.register(WebConfig.class);


       //Dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);

        //Assign the dispatcher servlet to tomcat server.
        Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);

        //Added the all mapping the tomcat server
        context.addServletMappingDecoded("/*", "dispatcherServlet");

        //Started the tomcat server.
        tomcat.start();
        System.out.println("Tomcat Started on Port: " + tomcat.getConnector().getLocalPort());

        //Keep the server running....
        tomcat.getServer().await();
    }
}











