package com.netposa.mina;

import java.util.Date;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.FilterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeServerHandler extends IoHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(TimeServerHandler.class);
	
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		logger.info("idle count:{}",session.getIdleCount(status));
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String receMsg = message.toString();
		logger.info("receive message:{}",receMsg);
		Date date = new Date();
		session.write(date.toString());
		logger.info("send message:{}",date.toString());
		//session.closeOnFlush();
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		
	}

	@Override
	public void event(IoSession session, FilterEvent event) throws Exception {
		
	}

}
