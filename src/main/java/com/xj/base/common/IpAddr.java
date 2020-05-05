package com.xj.base.common;


import java.net.*;

public class IpAddr {

	public static String getHostName() {
		   InetAddress ia=null;
	        try {
	            ia=ia.getLocalHost();
	             
	             String localname=ia.getHostName();
	             String localip=ia.getHostAddress();
	             return localip;
	         } catch (Exception e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	         }
		return null;
	}
	
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();
             
             String localname=ia.getHostName();
             String localip=ia.getHostAddress();
             System.out.println("本机名称是："+ localname);
             System.out.println("本机的ip是 ："+localip);
         } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
     }
 
 }