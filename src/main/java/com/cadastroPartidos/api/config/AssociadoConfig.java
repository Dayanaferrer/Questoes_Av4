package com.cadastroPartidos.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.repositories.AssociadoRepository;

@Configuration
@Profile("test")
public class AssociadoConfig  implements CommandLineRunner{
	
	@Autowired
	private AssociadoRepository associadoRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Associado a1 = new Associado(null, "Marielle Franco", "Vereadora", null, "Feminino");
		Associado a2 = new Associado(null, "Luiz Inácio", "Presidente", null, "Masculino");
		
		associadoRepository.saveAll(Arrays.asList(a1,a2));
		
	}
	
	
}
