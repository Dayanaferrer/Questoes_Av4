package com.cadastroPartidos.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.cadastroPartidos.api.controller.dto.PartidoDto;
import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.entites.Partido;
import com.cadastroPartidos.api.entites.enums.Ideologia;
import com.cadastroPartidos.api.repositories.PartidoRepository;

@Service
public class PartidoService {
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	public List<PartidoDto> findByIdeologia(Ideologia ideologia) {
		return partidoRepository.findByIdeologia(ideologia);
	}
	
	public List<PartidoDto> findAll() {
		List<Partido> partidos = partidoRepository.findAll();
		List<PartidoDto> partidosDTO = partidos.stream().map(a -> a.converter(a)).collect(Collectors.toList());
		return partidosDTO;
	}
	
	public PartidoDto findById(Integer id) {
		Partido partido = findByPartido(id);
		return new PartidoDto(partido);
	}
	
	public PartidoDto save(@Valid PartidoDTO partidoDto) {
		Partido partido = new Partido(partidoDto);
		try {
			partidoRepository.save(partido);
			return new PartidoDto(partido);
		} catch (MethodArgumentNotValidException e) {
			throw new MethodArgumentNotValidException(e.getMessage());
		}
		
		public PartidoDto updateById(Integer id, @Valid PartidoDto partidoDto) {
			Partido partidoParaAtualizar = findByPartido(id);
			try {
				partidoParaAtualizar.setNomeDoPartido(partidoDto.getNomeDoPartido());
				partidoParaAtualizar.setSigla(partidoDto.getSigla());
				partidoParaAtualizar.setIdeologia(partidoDto.getIdeologia());
				partidoParaAtualizar.setDataDeFundacao(partidoDto.getDataDeFundacao());
				return new PartidoDto(partidoParaAtualizar);
			} catch (MethodArgumentNotValidException e) {
				throw new MethodArgumentNotValidException(e.getMessage());
			}
		}

		public void deleteById(Integer id) {
			List<Associado> associados = findByPartido(id).getAssociados();
			if(associados.isEmpty()) {
				partidoRepository.deleteById(id);
			} else {
				throw new DeletePartidoException("Atenção: partido contém associados. Para excluir o partido desvincule os associados primeiro.");
			}
			private Partido findByPartido(Integer id) {
				Partido partido = partidoRepository.findById(id)
						.orElseThrow(() -> new EntityNotFoundException("ID " + id + " não Localizado."));
				return partido;
			}
		}
	}
}