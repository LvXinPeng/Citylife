package com.xinpeng.util;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CountLisenter
 *
 */
@WebListener
public class CountLisenter implements HttpSessionListener {

    /**
     * Default constructor. 
     */
	
	private int count = 0;
	
    public CountLisenter() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    	count++;
    	arg0.getSession().setAttribute("count", count);
    	//System.out.println(count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    	count--;
    	arg0.getSession().setAttribute("count", count);
    	//System.out.println(count);

    }
	
}
