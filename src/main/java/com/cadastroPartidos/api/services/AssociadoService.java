package com.cadastroPartidos.api.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.entites.enums.CargoPolitico;
import com.cadastroPartidos.api.repositories.AssociadoRepository;
import com.cadastroPartidos.api.repositories.PartidoRepository;
import com.cadastroPartidos.api.services.exceptions.MethodArgumentNotValidException;

@Service
public class AssociadoService {
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	
	public List<Associado> findByCargoPolitico(CargoPolitico cargo) {
		return associadoRepository.findByCargoPolitico(cargo);
	}
	
	public List<Associado> findAll (){
		return associadoRepository.findAll();
	}
		
	public Associado findById(Long id) {
		return associadoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID" + id + " não localizado!"));
	}
	
	public Associado save (Associado associado) {
		try {
			return associadoRepository.save(associado);
		}catch (MethodArgumentNotValidException e) {
			throw new MethodArgumentNotValidException(e.getMessage());
		}
		
	}	
	public Associado updateById(Long id, Associado associado) {
		Associado atualizarAssociado = findById(id);
		try {
			atualizarAssociado.setNome(associado.getNome());
			atualizarAssociado.setCargoPolitico(associado.getCargoPolitico());
			atualizarAssociado.setDataDeNascimento(associado.getDataDeNascimento());
			atualizarAssociado.setSexo(associado.getSexo());
			return atualizarAssociado;
		} catch (MethodArgumentNotValidException e) {
			throw new MethodArgumentNotValidException(e.getMessage());
		}
	}
		public void deleteById(Long id) {
			findById(id);
			associadoRepository.deleteById(id);
		}
}
