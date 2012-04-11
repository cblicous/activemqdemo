package de.mgm.activemqtest;

import javax.jms.JMSException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

public class SimpleConsumer {
	 public void start( ) throws JMSException
	    {
	    	ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"activemqdemo-spring.xml"});
		   DefaultMessageListenerContainer dmlc = (DefaultMessageListenerContainer) context.getBean("msgListenerContainer");

		   dmlc.start();
		   
	    }
	 
}
