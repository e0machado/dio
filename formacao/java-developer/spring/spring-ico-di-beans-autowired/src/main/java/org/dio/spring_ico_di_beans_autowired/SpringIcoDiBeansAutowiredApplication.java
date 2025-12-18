package org.dio.spring_ico_di_beans_autowired;

import com.google.gson.Gson;
import org.dio.spring_ico_di_beans_autowired.app.ConversorJson;
import org.dio.spring_ico_di_beans_autowired.app.ViaCepResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringIcoDiBeansAutowiredApplication {

	public static void main(String[] args) { SpringApplication.run(SpringIcoDiBeansAutowiredApplication.class, args); }

	@Bean
	public CommandLineRunner run(ConversorJson conversor) throws Exception {
		return args -> {
			String json = "{\"cep\": \"01001-000\", \"logradouro\": \"Praça da Sé\", \"localidade\": \"Sao Paulo\"}";
			ViaCepResponse response = conversor.converter(json);
			System.out.println("Dados do CEP: " + response);

		};
	}

}
