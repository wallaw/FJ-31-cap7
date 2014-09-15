package br.com.caelum.jms;


import java.util.Properties;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

public class RegistraTratadorNaFila {

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
		QueueConnectionFactory qcf = (QueueConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		QueueConnection qc = qcf.createQueueConnection("jms", "caelum");
		
		QueueSession qs = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue= (Queue) ic.lookup("jms/queue/loja");
		QueueReceiver qr = qs.createReceiver(queue);
		qr.setMessageListener(new TratadorDeMensagem());
		qc.start();
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Esperando as mensagens na fila JMS. Aperte ENTER para parar");
		teclado.nextLine();
		
		qc.close();
	}

}
