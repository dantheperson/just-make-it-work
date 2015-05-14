package net.dantheperson;

import javax.jms.ConnectionFactory;

import org.apache.camel.component.jms.JmsComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@EnableAutoConfiguration	(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
@EnableJms
public class Application {

	@Bean
	JmsComponent jmsComponent(ConnectionFactory cf) throws Exception {
		JmsComponent jc = new JmsComponent();
		jc.setConnectionFactory(cf);
		jc.start();
		return jc;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, new String[]{"--debug"});
	}

}
