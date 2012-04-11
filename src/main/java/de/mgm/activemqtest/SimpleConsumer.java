package de.mgm.activemqtest;

import javax.jms.JMSException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

/** 
 * Demo Consumer to setup DefaultMessageListenerContainer programatically 
 * currently unused (DefaultMessageListenerContainer is configured) 
 * 
 * @author cbelka
 *
 */
public class SimpleConsumer {
	 public void start( ) throws JMSException
	    {
	    	ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"activemqdemo-spring.xml"});
		   DefaultMessageListenerContainer dmlc = (DefaultMessageListenerContainer) context.getBean("msgListenerContainer");

		   dmlc.start();
		   
	    }
	 
}
