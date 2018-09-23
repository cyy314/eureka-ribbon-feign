package com.netposa.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaTimeServer {

	private static final int PORT = 12306;

	public static void main(String[] args) {
		try {
			IoAcceptor acceptor = new NioSocketAcceptor();
			DefaultIoFilterChainBuilder filterChainBuilder = acceptor.getFilterChain();
			filterChainBuilder.addLast("logger", new LoggingFilter());
			filterChainBuilder.addLast("codec",
					new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
			acceptor.setHandler(new TimeServerHandler());
			IoSessionConfig sessionConfig = acceptor.getSessionConfig();
			sessionConfig.setReadBufferSize(2048);
			sessionConfig.setIdleTime(IdleStatus.BOTH_IDLE, 10);
			acceptor.bind(new InetSocketAddress(PORT));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
