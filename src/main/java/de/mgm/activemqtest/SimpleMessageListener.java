package de.mgm.activemqtest;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.jms.listener.DefaultMessageListenerContainer;

/**
 * MessageListener used by DefaultMessageListenerContainer as onMessageHandler  
 * @author cbelka
 *
 */
public class SimpleMessageListener implements MessageListener {

	private ConcurrentHashMap<Long,Integer> threadcount;
	public void init() throws Exception {
		 threadcount = new ConcurrentHashMap<Long,Integer>();
		  System.out.println("Inited SimpleMessageListener");
		}
	
	/** 
	 * Counts the threadusage 
	 * @param threadID
	 */
	private synchronized void  increaseCount(Long threadID) {
		if (threadcount.get(threadID) == null) {
			threadcount.put(threadID, 1);
		} else {
			threadcount.put(threadID, ((Integer)threadcount.get(threadID)) +1);
		}
	}
	
	/**
	 * Prints some stats
	 */
	private synchronized void printStats() {
		System.out.println("Thread/Count");
		for (Entry<Long, Integer> entry : threadcount.entrySet()) {
		
			System.out.print(entry.getKey() + "/"+ entry.getValue() + " |  " );
		}
		System.out.print("\n");
	}
	
	/** reacts on the message */
	
	public void onMessage(Message message) {
		try {
			Long currentThreadId = Thread.currentThread().getId();
			System.out.println("+++ Starting to work on message "+ message.getJMSMessageID() );
			System.out.println("+++ Working 4 4 Seconds , Thread ID :" + currentThreadId);
			Thread.sleep(4000);
			increaseCount(currentThreadId);
			System.out.println("+++ Done ");
			printStats();
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
