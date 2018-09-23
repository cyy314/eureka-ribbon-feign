package com.netposa.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.FilterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.spi.Message;

public class TimeClientHandler extends IoHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(TimeClientHandler.class);

    private String message = "";
    
    public TimeClientHandler(){
    	
    }
    
    public TimeClientHandler(String message) {
		this.message = message;
	}
   
    @Override
    public void sessionCreated(IoSession session) throws Exception {
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
    	session.write(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
    }

    @Override
    public void inputClosed(IoSession session) throws Exception {
        session.closeNow();
    }

    @Override
    public void event(IoSession session, FilterEvent event) throws Exception {
    }


}
