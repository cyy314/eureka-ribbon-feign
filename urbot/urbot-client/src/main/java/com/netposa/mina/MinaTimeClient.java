package com.netposa.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Date;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinaTimeClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(MinaTimeClient.class);

	public static void main(String[] args) {
		try {
			IoConnector connector = new NioSocketConnector();
			DefaultIoFilterChainBuilder filterChainBuilder = connector.getFilterChain();
			LoggingFilter loggingFilter = new LoggingFilter();
			loggingFilter.setSessionOpenedLogLevel(LogLevel.DEBUG);
			filterChainBuilder.addLast("logger", loggingFilter);
			filterChainBuilder.addLast("codec",
					new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
			connector.setHandler(new TimeClientHandler(new Date().toString()));
			ConnectFuture future = connector.connect(new InetSocketAddress("localhost", 12306));
			future.addListener(new IoFutureListener<IoFuture>() {

				@Override
				public void operationComplete(IoFuture future) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					IoSession session = future.getSession();
					LOGGER.info(session.toString());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
