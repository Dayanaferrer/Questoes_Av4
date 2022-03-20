package com.cadastroPartidos.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastroPartidos.api.controller.dto.AssociadoComPartidoDto;
import com.cadastroPartidos.api.controller.dto.PartidoDto;
import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.entites.Partido;
import com.cadastroPartidos.api.entites.enums.Ideologia;
import com.cadastroPartidos.api.repositories.PartidoRepository;
import com.cadastroPartidos.api.services.exceptions.DeletePartidoException;
import com.cadastroPartidos.api.services.exceptions.EntityNotFoundException;
import com.cadastroPartidos.api.services.exceptions.MethodArgumentNotValidException;

@Service
public class PartidoService {
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	public List<PartidoDto> findByIdeologia(Ideologia ideologia) {
		return partidoRepository.findByIdeologia(ideologia);
	}
	
	public List<PartidoDto> findAll() {
		List<Partido> partidos = partidoRepository.findAll();
		List<PartidoDto> partidosDto = partidos.stream().map(a -> a.converter(a)).collect(Collectors.toList());
		return partidosDto;
	}	
	
	public List<AssociadoComPartidoDto> findByPartidoAssociados(Long id) {
		Partido partido = findByPartido(id);
		List<Associado> associados = partido.getAssociados();
		List<AssociadoComPartidoDto> associadosDto = associados.stream().map(a -> a.converter(a, partido)).collect(Collectors.toList());
		return associadosDto;
	}
	
	public PartidoDto findById(Long id) {
		Partido partido = findByPartido(id);
		return new PartidoDto(partido);
	}
	

	public PartidoDto save(PartidoDto partidoDto) {
		Partido partido = new Partido(partidoDto);
		try {
			partidoRepository.save(partido);
			return new PartidoDto(partido);
		} catch (MethodArgumentNotValidException e) {
			throw new MethodArgumentNotValidException(e.getMessage());
		}
	}
	
	public PartidoDto updateById(Long id, PartidoDto partidoDto) {
		Partido atualizarPartido = findByPartido(id);
		try {
			 atualizarPartido.setNomeDoPartido(partidoDto.getNomeDoPartido());
			 atualizarPartido.setSigla(partidoDto.getSigla());
			 atualizarPartido.setIdeologia(partidoDto.getIdeologia());
			 atualizarPartido.setDataDeFundacao(partidoDto.getDataDeFundacao());
			return new PartidoDto(atualizarPartido);
		} catch (MethodArgumentNotValidException e) {
			throw new MethodArgumentNotValidException(e.getMessage());
		}
	}
	
	public void deleteById(Long id) {
		List<Associado> associados = findByPartido(id).getAssociados();
		if(associados.isEmpty()) {
			partidoRepository.deleteById(id);
		} else {
			throw new DeletePartidoException("Atenção partido contém associados!!! Para deletar desvincule do partido primeiro.");
		}
	}
	
	private Partido findByPartido(Long id) {
		Partido partido = partidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID " + id + " não Localizado."));
		return partido;
	}
}