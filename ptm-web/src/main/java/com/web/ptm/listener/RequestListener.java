package com.web.ptm.listener;

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
		System.out.println("-------request destroyed----------------------" + ((HttpServletRequest) sre.getServletRequest()).getRequestURI());
		System.out.println("-------fuck u khushbu----------------------");
		System.out.println(((HttpServletRequest) sre.getServletRequest()).getRequestURI());
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
//		HttpSession session = request.getSession();
//		if (session != null)
//			System.out.println(session.getAttribute("userDetailVO"));
		System.out.println("-------request Initialized-------" + ((HttpServletRequest) sre.getServletRequest()).getRequestURI());
	}

}
