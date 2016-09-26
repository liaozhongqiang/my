package activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQUtil {
	
	public static void sendMessage(String msg){
		// 连接工厂
		ConnectionFactory connectionFactory=null;
		// 连接
		Connection conn=null;
		// 会话
		Session session=null;
		// 目的地
		Destination destination=null;
		// 消息的生产者
		MessageProducer messageProducer=null;
		// 创建连接工厂
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
				ActiveMQConnectionFactory.DEFAULT_PASSWORD,ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
		
		try {
			// 创建连接
			conn = connectionFactory.createConnection();
			// 启动连接
			conn.start();
			// 创建会话
			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("firstActivemqQueue");
			messageProducer=session.createProducer(destination);
			messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			TextMessage textMessage=session.createTextMessage(msg);
			messageProducer.send(textMessage);
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
