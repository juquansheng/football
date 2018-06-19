/*
package com.yicuojin.football.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.yicuojin.football.Threads.MatchThread;

@WebListener
public class Listener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("------------web start-------");

        new Thread(new MatchThread()).start();

	}

}
*/
