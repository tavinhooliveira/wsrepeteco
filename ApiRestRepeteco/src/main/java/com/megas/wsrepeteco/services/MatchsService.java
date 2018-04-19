package com.megas.wsrepeteco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.megas.wsrepeteco.domain.Matchs;
import com.megas.wsrepeteco.repository.MatchsRepository;
import com.megas.wsrepeteco.services.exceptions.OptionNaoEncontradoException;
import com.megas.wsrepeteco.services.exceptions.UsersNaoEncontradoException;

@Service
public class MatchsService {
	
	@Autowired
	private MatchsRepository matchsRepository;

	// Listar Todos
	public List<Matchs> listar() {
		return matchsRepository.findAll();
	}
	
	//List Matchs
	public List<Matchs> listarMatchrs() {
		List<Matchs> matchs = matchsRepository.findAll();
		
		return matchs;
	}
	
	
	// Salvar Matchs
	public Matchs salvar(Matchs matchs) {
		if (matchs.getId() != null) {
			Matchs a = matchsRepository.findOne(matchs.getId());

			if (a != null) {
				System.out.println("|Update| Matchs Atualizado:" + matchs.getId());
				matchs.setOption(a.getOption());
				return matchsRepository.save(matchs);
			}
		}
		System.out.println("|Create| Matchs Cadastrado:" + matchs.getId());
		return matchsRepository.save(matchs);
	}
	
	// Buscar Matchs
	public Matchs buscar(String id) {
		Matchs matchs = matchsRepository.findOne(id);

		if (matchs == null) {
			throw new UsersNaoEncontradoException("Nenhum Match encontrado.");
		}
		return matchs;
	}
	
	
	// Verificar se Existe
	private void verificarExistencia(Matchs matchs) {
		buscar(matchs.getId());
	}

	// Atuaizar
	public void atualizar(Matchs matchs) {
		verificarExistencia(matchs);
		matchsRepository.save(matchs);
	}
	
	// Deletar
	public void deletar(String id) {
		try {
			matchsRepository.delete(id);
			System.out.println("Matchs desfeito com o amigo: "+id);
		} catch (EmptyResultDataAccessException e) {
			throw new OptionNaoEncontradoException("O match não pode ser Desfeito.");
		}
	}

}
