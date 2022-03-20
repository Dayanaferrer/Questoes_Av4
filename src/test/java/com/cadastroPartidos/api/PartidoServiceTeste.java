package com.cadastroPartidos.api;

import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cadastroPartidos.api.controller.dto.AssociadoComPartidoDto;
import com.cadastroPartidos.api.controller.dto.PartidoDto;
import com.cadastroPartidos.api.entites.Partido;
import com.cadastroPartidos.api.repositories.PartidoRepository;
import com.cadastroPartidos.api.services.PartidoService;

@SpringBootTest
public class PartidoServiceTeste {
	
	@InjectMocks
	private PartidoService service;
	
	@Mock
	private PartidoRepository repository;
	
	@Mock
	private Partido partido;
	
	@Mock
	private PartidoDto partidoDto;
	
	private Optional<Partido> optionalPartido;
	
	@Mock
	private AssociadoComPartidoDto associadoDto;
	

}
