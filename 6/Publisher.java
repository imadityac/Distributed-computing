package publishersubscriber;

import java.util.Scanner;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
	
	private static String url=ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) throws JMSException{
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		/*JMS messages are sent and recieved using a session*/
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("testt");
		MessageProducer producer = session.createProducer(topic);
		
		//creating small text message
		TextMessage message = session.createTextMessage();
		System.out.println("Enter message to be sent:");
		Scanner input= new Scanner(System.in);
		String text=input.next();
		message.setText(text);
		
		//creating small text message
		producer.send(message);
		System.out.println("Sent message:"+message.getText());
		connection.close();
		
		
		
	}
}
