package br.com.caelum.jms;

import java.util.Properties;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EnviaMensagemParaTopico {

	/**
	 * @param args
	 * @throws NamingException 
	 * @throws JMSException 
	 */
	public static void main(String[] args) throws NamingException, JMSException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.SECURITY_PRINCIPAL, "jms");
		jndiProperties.put(Context.SECURITY_CREDENTIALS, "caelum");
		
		InitialContext ic = new InitialContext(jndiProperties);
		
		TopicConnectionFactory tcf = (TopicConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		TopicConnection tc = tcf.createTopicConnection("jms","caelum");
		
		TopicSession ts = tc.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		
		TextMessage textMessage = ts.createTextMessage();
		textMessage.setText("Mensagem de texto para um Topic");
		
		Topic topic = (Topic) ic.lookup("jms/topic/loja");
		
		TopicPublisher tp = ts.createPublisher(topic);
		tp.publish(textMessage);

		
		tc.close();

	}

}
