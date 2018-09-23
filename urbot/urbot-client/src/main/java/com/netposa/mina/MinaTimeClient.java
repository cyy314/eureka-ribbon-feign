package com.netposa.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Date;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaTimeClient {

	public static void main(String[] args) {
		try {
			IoConnector connector = new NioSocketConnector();
			DefaultIoFilterChainBuilder filterChainBuilder = connector.getFilterChain();
			filterChainBuilder.addLast("logger", new LoggingFilter());
			filterChainBuilder.addLast("codec",
					new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
			connector.setHandler(new TimeClientHandler(new Date().toString()));
			connector.connect(new InetSocketAddress("localhost", 12306));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
