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
				users.setUpdateData(new Date());
				users.setCreateData(a.getCreateData());
				users.setPreference(a.getPreference());
				users.setFlagDisplayCount(a.isFlagDisplayCount());
				users.setFlagDisplayHot(a.isFlagDisplayHot());
				users.setFlagNotificationFriends(a.isFlagNotificationFriends());
				users.setFlagNotificationMatch(a.isFlagNotificationMatch());
				System.out.println("|Update| Usuario Atualizado:"+users.getId());
				return usersRepository.save(users);
			}
		}
		users.setCreateData(new Date());
		users.setUpdateData(new Date());
		users.setFlagDisplayCount(true);
		users.setFlagDisplayHot(false);
		users.setFlagNotificationFriends(true);
		users.setFlagNotificationMatch(true);
		System.out.println("|Create| Usuario Cadastrado:"+users.getId());
		return usersRepository.save(users);
	}
	
	//Buscar User
	public Users buscar(Long id) {
		Users users = usersRepository.findOne(id);		
		if(users == null) {
			System.out.println("O Usuario não existe.");
			//TODO verificar se esse return causa bug
			return users;
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
		Friends a = friendsRepository.findOne(friends.getId());
		Users users = buscar(usersId);
		if(a != null) {
			friends.setOption(a.getOption());
			friends.setUsers(users);
			friends.setUser_id(usersId);
			System.out.println("|Update| Friends Atualizado:"+friends.getId());
			return friendsRepository.save(friends);
		}
		friends.setUsers(users);
		friends.setUser_id(usersId);
		System.out.println("|Create| Friends Cadastrados:"+friends.getId());
		return friendsRepository.save(friends);
	}
	
	//Listar amigos do user corrente
	public List<Friends> listarFriends(Long usersId) {
		Users users = buscar(usersId);		
		return users.getFriends();
	}
	
	//Deletar usuario
	public void deletar(Long id) {
		try {
			usersRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new OptionNaoEncontradoException("O User não pôde ser Deletado.");
		}
	}
	
	//[Config]Set Preferencia Sexual
	public void preference(Users users) {			
		verificarExistencia(users);
		Users a = usersRepository.findOne(users.getId());
		if(a != null) {
			System.out.println("|Update| Preferencias do Usuario Atualizadas |UserId: "+a.getId_fb_users());
			users.setId_fb_users(a.getId_fb_users());
			users.setName(a.getName());
			users.setImagem(a.getImagem());
			users.setLink(a.getLink());
			users.setEmail(a.getEmail());
			users.setCity(a.getCity());
			users.setGender(a.getGender());
			users.setNationality(a.getNationality());
			users.setFriendsTotalFb(a.getFriendsTotalFb());
			users.setFriendsTotalApp(a.getFriendsTotalApp());
			usersRepository.save(users);
		}
		usersRepository.save(users);
	}
	
}