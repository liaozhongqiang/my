package activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ReciverTest {

	public static void main(String[] args) {
		// 连接工厂
		ConnectionFactory connectionFactory = null;
		// 连接
		Connection conn = null;
		// 会话
		Session session = null;
		// 目的地
		Destination destination = null;
		// 消息的消费者
		MessageConsumer messageConsumer = null;
		// 创建连接工厂
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
				ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

		try {
			conn = connectionFactory.createConnection();
			conn.start();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			destination = session.createQueue("firstActivemqQueue");

			messageConsumer = session.createConsumer(destination);

			while (true) {
				TextMessage message = (TextMessage) messageConsumer.receive(100000);
				if (null != message) {
					System.out.println(message.getText());
				} else {
					break;
				}
			}
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
