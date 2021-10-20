package br.com.univesp.valoresreciclaveis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class ValoresReciclaveisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValoresReciclaveisApplication.class, args);
	}

}
