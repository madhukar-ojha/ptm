package com.ptm.main.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

/**
 * Application Lifecycle Listener implementation class AppRequestListener
 *
 * 
 */
@WebListener
public class RequestListener implements ServletRequestListener {

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		
	}

}
