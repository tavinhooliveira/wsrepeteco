package com.megas.wsrepeteco.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.megas.wsrepeteco.domain.Option;
import com.megas.wsrepeteco.repository.OptionRepository;
import com.megas.wsrepeteco.services.exceptions.OptionNaoEncontradoException;

@Service
public class OptionService {

	@Autowired
	private OptionRepository optionRepository;
	
	
	//Listar Todas
	public List<Option> listar() {
		return optionRepository.findAll();
	}
	
	//Buscar opção
	public Option buscar(Long id) {
		Option option = optionRepository.findOne(id);
		
		if(option == null) {
			throw new OptionNaoEncontradoException("O Opção não pôde ser encontrada.");
		}
		
		return option;
	}
	
	//Salvar
	public Option salvar(Option option) {
		option.setId(null);
		option.setData_modify(new Date());
		return optionRepository.save(option);
	}
	
	//Deletar
	public void deletar(Long id) {
		try {
			optionRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new OptionNaoEncontradoException("O Opção não pôde ser Deletado.");
		}
	}
	
	//Atualizar
	public void atualizar(Option option) {
		verificarExistencia(option);
		option.setData_modify(new Date());
		optionRepository.save(option);
	}
	
	//Verificar se Existe
	private void verificarExistencia(Option option) {
		buscar(option.getId());
	}
	

	
	
}
