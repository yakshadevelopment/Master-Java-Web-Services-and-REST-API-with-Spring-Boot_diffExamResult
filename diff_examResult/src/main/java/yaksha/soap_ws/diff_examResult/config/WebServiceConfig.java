package yaksha.soap_ws.diff_examResult.config;


import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@ComponentScan(basePackages = "yaksha.soap_ws.diff_examResult")
public class WebServiceConfig
{
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context)
	{
		MessageDispatcherServlet messageDispatcherServlet=new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet,"/rs/*");
	}
	
	@Bean(name="StudentResult")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema examappSchema) {
		DefaultWsdl11Definition definition=new DefaultWsdl11Definition();
		definition.setPortTypeName("ResultPort");
		definition.setTargetNamespace("http://yaksha.edu/examapp");
		definition.setLocationUri("/rs");
		definition.setSchema(examappSchema);
		return definition;
		
	}
		
	@Bean
	public XsdSchema examappSchema() {
		return new SimpleXsdSchema(new ClassPathResource("exam_result.xsd"));
	}
		
}
