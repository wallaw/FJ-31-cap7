package br.com.caelum.loja.session;

import java.io.StringWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.util.Livros;

@Stateless
@Local(Mensageiro.class)
public class MensageiroBean implements Mensageiro {

	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory fabrica;
	
	//Injeção de dependência
	@Resource(mappedName="java:/queue/loja")
	private Destination destination;
	
	public void enviaMensagem(List<Livro> livros) {
		
		
		try {
			//Criando a sessão
			Connection conexao;
			conexao = this.fabrica.createConnection("jms","caelum");
			Session session = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//Criando o wrapper jaxb
			Livros wrapper = new Livros();
			wrapper.adicionaLivros(livros);
			
			//Gerando XML
			Marshaller marshaller = JAXBContext.newInstance(Livros.class).createMarshaller();
			StringWriter sw = new StringWriter();
			marshaller.marshal(wrapper, sw);
			
			//Criando Mensagem JMS
			TextMessage tm = session.createTextMessage(sw.toString());
			
			//Criando Produtor de MEnsagens
			MessageProducer produtor = session.createProducer(this.destination);
			produtor.send(tm);
			
			//Fechando Conexao
			produtor.close();
			conexao.close();
			
		} catch (JMSException ex){
			throw new EJBException(ex); 
		} catch (JAXBException ex) {
			throw new EJBException(ex);
		}
		
	}

}
