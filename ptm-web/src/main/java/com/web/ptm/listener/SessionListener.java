package com.web.ptm.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
	private static int count;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("------------banana-------------------");
		System.out.println("---session created count---" + ++count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		count--;
		System.out.println("----------session destroyed count ---" + --count);
		System.out.println("----------done ---" + --count);
	}
}
