package de.mgm.activemqtest;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

public class SimpleMessageListener implements MessageListener {

	public void init() throws Exception {
		  System.out.println("Inited SimpleMessageListener");
		}
	 
	public void onMessage(Message message) {
		try {

			System.out.println("+++ Starting to work on message "+ message.getJMSMessageID() +" +++");
			System.out.println("+++ Working 4 4 Seconds  +++");
			Thread.sleep(4000);
			System.out.println("+++ Done +++");
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}