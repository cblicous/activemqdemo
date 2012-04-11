package de.mgm.activemqtest;

import javax.jms.JMSException;

public class App {

	/**
	 * @param args
	 * @throws JMSException 
	 */
	public static void main(String[] args) throws JMSException {
		// TODO Auto-generated method stub
		SimpleProducer producer = new SimpleProducer();
		producer.createMessages();

	}

}
