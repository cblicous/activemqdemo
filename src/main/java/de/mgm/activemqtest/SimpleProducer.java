package de.mgm.activemqtest;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class SimpleProducer
{
    private ConnectionFactory factory;
    private Connection connection;
    private Session session;
    private MessageProducer producer;
 
    private static final String  QUEUENAME = "TEST.FOO";
    private static final int MESSAGECOUNT = 10;
    public SimpleProducer() throws JMSException
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"activemqdemo-spring.xml"});
        this.factory =(ConnectionFactory) context.getBean("connectionFactory");
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUENAME);
        producer = session.createProducer(destination);
    }
 
    public void createMessages() throws JMSException
    {
        for (int i = 0; i < MESSAGECOUNT; i++)
        {
            System.out.println("Creating Message " + i);
            Message message = session.createTextMessage("Hello World!");
            producer.send(message);
        }
    }
 
    public void close() throws JMSException
    {
        if (connection != null)
        {
            connection.close();
        }
    }
 
}