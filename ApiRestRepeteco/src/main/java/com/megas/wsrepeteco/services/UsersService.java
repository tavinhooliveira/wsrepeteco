package com.megas.wsrepeteco.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.megas.wsrepeteco.domain.Friends;
import com.megas.wsrepeteco.domain.Users;
import com.megas.wsrepeteco.repository.FriendsRepository;
import com.megas.wsrepeteco.repository.UsersRepository;
import com.megas.wsrepeteco.services.exceptions.OptionNaoEncontradoException;
import com.megas.wsrepeteco.services.exceptions.UsersNaoEncontradoException;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private FriendsRepository friendsRepository;
	
	//Listar Todos
	public List<Users> listar() {
		
		return usersRepository.findAll();
	}	
		
	//Salvar User
	public Users salvar(Users users) {
		if(users.getId() != null) {
			Users a = usersRepository.findOne(users.getId());			
			if(a != null) {
				System.out.println("|Update| Usuario Atualizado:"+users.getId());
				users.setUpdateData(new Date());
				users.setCreateData(a.getCreateData());
				users.setPreference(a.getPreference());
				return usersRepository.save(users);
			}
		}
		System.out.println("|Create| Usuario Cadastrado:"+users.getId());
		users.setCreateData(new Date());
		users.setUpdateData(new Date());
		return usersRepository.save(users);
	}
	
	//Buscar User
	public Users buscar(Long id) {
		Users users = usersRepository.findOne(id);
		
		if(users == null) {
			throw new UsersNaoEncontradoException("O usuario não pôde ser encontrado.");
		}
		return users;
	}
		
	//Verificar se Existe
	private void verificarExistencia(Users users) {
		buscar(users.getId());
	}
		
	//Atuaizar
	public void atualizar(Users users) {
		verificarExistencia(users);
		usersRepository.save(users);
	}
	
	//Salvar Amigos
	public Friends salvarFriends(Long usersId, Friends friends) {
		Users users = buscar(usersId);
		friends.setUsers(users);
		friends.setUser_id(usersId);
		return friendsRepository.save(friends);
	}
	
	//Listar amigos do user corrente
	public List<Friends> listarFriends(Long usersId) {
		Users users = buscar(usersId);		
		return users.getFriends();
	}
	
	//Deletar
	public void deletar(Long id) {
		try {
			usersRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new OptionNaoEncontradoException("O User não pôde ser Deletado.");
		}
	}
	
}