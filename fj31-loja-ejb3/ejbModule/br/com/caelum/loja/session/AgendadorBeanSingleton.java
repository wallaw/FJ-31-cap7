package br.com.caelum.loja.session;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;

/**
 * Não precisa implementar a interface, pois não será necessário 
 * o cliente
 * @author ejb4527
 *
 */
@Singleton
@Startup
public class AgendadorBeanSingleton {
	
	@Schedule(hour="*", minute="*/1", second="0", persistent=false)
	public void enviaEmailCadaMinutoComInformacoesDoDolar() {
		System.out.println("enviando email a cada minuto");
	}

}
