/*
package com.netposa.urbotclient.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InitHttps {
	*/
/**
	     * 配置一个TomcatEmbeddedServletContainerFactory bean
	     * @return
	     *//*

	    */
/*@Bean
	    public EmbeddedServletContainerFactory servletContainer() {
	
	        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
	
	            @Override
	            protected void postProcessContext(Context context) {
	                SecurityConstraint securityConstraint = new SecurityConstraint();
	                securityConstraint.setUserConstraint("CONFIDENTIAL");
	                SecurityCollection collection = new SecurityCollection();
	                collection.addPattern("/*");
	                securityConstraint.addCollection(collection);
	                context.addConstraint(securityConstraint);
	            }
	        };
	        tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
	        return tomcat;
	    }*//*

	
	    */
/**
	     * 让我们的应用支持HTTP是个好想法，但是需要重定向到HTTPS，
	     * 但是不能同时在application.properties中同时配置两个connector，
	     * 所以要以编程的方式配置HTTP connector，然后重定向到HTTPS connector
	     * @return Connector
	     *//*

	    */
/*private Connector initiateHttpConnector() {
	    	//http端口跳转至https接口
	        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	        connector.setScheme("http");
	        //Connector监听的http的端口号
	        connector.setPort(8080);
	        connector.setSecure(false);
	        //监听到http的端口号后转向到的https的端口号
	        connector.setRedirectPort(8762);
	        return connector;
	    }*//*

	    
		*/
/**
		 * 同时支持https和http
		 * @return
		 *//*

	    @Bean
	    public EmbeddedServletContainerCustomizer containerCustomizer() {
	        return new EmbeddedServletContainerCustomizer() {          
				@Override
				public void customize(ConfigurableEmbeddedServletContainer container) {
					if (container instanceof TomcatEmbeddedServletContainerFactory) {
	                    TomcatEmbeddedServletContainerFactory containerFactory =
	                            (TomcatEmbeddedServletContainerFactory) container;
	                    Connector connector = new Connector(TomcatEmbeddedServletContainerFactory.DEFAULT_PROTOCOL);
	                    connector.setPort(8082);
	                    containerFactory.addAdditionalTomcatConnectors(connector);
	                }
				}
	        };
	    }
	
	
}

*/
