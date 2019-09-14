package com.lifengming.springtomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * @author lifengming
 * @since 14.09.2019
 */
public class MyTomcatServer {
    public static void main(String[] args) {
        Tomcat tomcat=new Tomcat();
        tomcat.setPort(9090);
        tomcat.addWebapp("/","E:\\data\\code\\study\\spring-all\\");

        try {
            tomcat.start();
            //阻塞，底层socket
            tomcat.getServer().await();
        }catch (LifecycleException e){
            e.printStackTrace();
        }
    }
}
