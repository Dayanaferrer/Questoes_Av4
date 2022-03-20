package com.cadastroPartidos.api.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.entites.enums.CargoPolitico;
import com.cadastroPartidos.api.repositories.AssociadoRepository;
import com.cadastroPartidos.api.repositories.PartidoRepository;

@Service
public class AssociadoService {
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	public List<Associado> findAll (){
		return associadoRepository.findAll();
	}
	public List<Associado> findByCargoPolitico(CargoPolitico cargo) {
		return associadoRepository.findByCargoPolitico(cargo);
	}
	
	public Associado findById(Long id) {
		return associadoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID" + id + " não localizado!"));
	}
	
	public Associado save(Associado associado) {
		try {
			return associadoRepository.save(associado);
		} catch (MethodArgumentNotValidException e) {
			throw new MethodArgumentNotValidException(e.getMessage());
		}
		
		public void deleteById(Long id) {
			findById(id);
			associadoRepository.deleteById(id);
		}
		
}
}
