package com.cadastroPartidos.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.entites.Partido;
import com.cadastroPartidos.api.repositories.AssociadoRepository;
import com.cadastroPartidos.api.repositories.PartidoRepository;

@Configuration
@Profile("test")
public class AssociadoConfig  implements CommandLineRunner{
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private PartidoRepository partidoRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		Partido p1 = new Partido(null,"Partido Socialismo e Liberdade", "psol", "Esquerda", null, null);
//		Partido p2 = new Partido(null,"Partido dos Trabalhadores", "pt", "Esquerda", null, null);
//		Partido p3 = new Partido(null,"Partido Comunista do Brasil", "PCdoB", "Esquerda", null, null);
//		Partido p4 = new Partido(null,"Partido Socialista Brasileiro", "psb", "Centro", null, null);
		
		
		Associado a1 = new Associado(null, "Marielle Franco", "Vereadora", null, "Feminino");
		Associado a2 = new Associado(null, "Luiz Inácio", "Presidente", null, "Masculino");
		Associado a3 = new Associado(null, "Laina Crisostomo", "Deputado Federal", null, "Feminino");
		Associado a4 = new Associado(null, "Olivia Santana", "Deputado Federal", null, "Feminino");
		Associado a5 = new Associado(null, "Erica Malunguinho", "Deputado Estadual", null, "Feminino");
		Associado a6 = new Associado(null, "Erika Hilton", "Deputado Estadual", null, "Feminino");
		Associado a7 = new Associado(null, "Thabatta Pimenta", "Vereadora", null, "Feminino");
		Associado a8 = new Associado(null, "Dilma Rousseff", "Presidente", null, "Feminino");
		Associado a9 = new Associado(null, "João Campos", "Prefeito", null, "Masculino");
		Associado a10 = new Associado(null, "Marília Arraes", "Prefeito", null, "Feminino");
		Associado a11 = new Associado(null, "Jarbas Vasconcelos ", "Senador", null, "Masculino");
		Associado a12 = new Associado(null, "Geraldo Júlio", "Governador",  null, "Masculino");
			
		
//		partidoRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		associadoRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12));
		

	}
	
	
}
