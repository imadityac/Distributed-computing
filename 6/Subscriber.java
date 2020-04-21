package publishersubscriber;

import java.io.IOException;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Subscriber {

	//url of JMS Server
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	//Name of the topic from which we will recieve message:"testt"
		
	public static void main(String[] args) throws JMSException{
		//getting JMS connection from the server
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("testt");
		
		MessageConsumer consumer = session.createConsumer(topic);
		MessageListener listener = new MessageListener(){
			
			public void onMessage(Message message){
				try{
					if(message instanceof TextMessage){
						TextMessage textMessage = (TextMessage) message;
						System.out.print("Recieved message:"+textMessage.getText());
					}
				} 
				catch(JMSException e){
					System.out.println(e);
					
				}
				
			}
			
		};
		
		consumer.setMessageListener(listener);
		try{
			System.in.read();
		} catch(IOException e){
			System.out.println(e);
		}
		connection.close();
		

	}

}
