package com.megas.wsrepeteco.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.megas.wsrepeteco.domain.Friends;
import com.megas.wsrepeteco.domain.Matchs;
import com.megas.wsrepeteco.domain.Notification;
import com.megas.wsrepeteco.domain.Users;
import com.megas.wsrepeteco.repository.FriendsRepository;
import com.megas.wsrepeteco.repository.MatchsRepository;
import com.megas.wsrepeteco.repository.NotificationRepository;
import com.megas.wsrepeteco.repository.UsersRepository;
import com.megas.wsrepeteco.services.exceptions.OptionNaoEncontradoException;
import com.megas.wsrepeteco.services.exceptions.UsersNaoEncontradoException;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private FriendsRepository friendsRepository;
	
	@Autowired
	private MatchsRepository matchsRepository;
	
	@Autowired
	private NotificationRepository notificationRepository;
	
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
				users.setNumberWhats(a.getNumberWhats());
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
			System.out.println("O Usuario não encontrado.");
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
		Friends a = friendsRepository.findOne(friends.getId());
		Users users = buscar(usersId);
		if(a != null) {
			friends.setOption(a.getOption());
			friends.setUsers(users);
			friends.setUser_id(usersId);
			friends.setUpdateDataOption(a.getUpdateDataOption());
			System.out.println("|Update| Friends Atualizado:"+friends.getId());
			return friendsRepository.save(friends);
		}
		friends.setUsers(users);
		friends.setUser_id(usersId);
		friends.setUpdateDataOption(new Date());
		System.out.println("|Create| Friends Cadastrados:"+friends.getId());
		return friendsRepository.save(friends);
	}
	
	//Salvar Matchs
	public Matchs salvarMatchs(Long usersId, Matchs matchs) {
		Matchs a = matchsRepository.findOne(matchs.getId());
		Users users = buscar(usersId);
		if(a != null) {
			matchs.setOption(a.getOption());
			matchs.setUsers(users);
			matchs.setUser_id(usersId);
			matchs.setDataMatch(a.getDataMatch());
			matchs.setRead(a.getRead());
			System.out.println("|Update| Matchs Atualizado:"+matchs.getId());
			return matchsRepository.save(matchs);
		}
		matchs.setUsers(users);
		matchs.setUser_id(usersId);
		matchs.setDataMatch(new Date());
		System.out.println("|Create| Matchs Cadastrados:"+matchs.getId());
		return matchsRepository.save(matchs);
	}
	
	//Salvar Matchs
	public Matchs salvarMatchsUpdate(Long usersId, Matchs matchs) {
		Matchs a = matchsRepository.findOne(matchs.getId());
		Users users = buscar(usersId);
		if(a != null) {
			matchs.setOption(a.getOption());
			matchs.setUsers(users);
			matchs.setUser_id(usersId);
			matchs.setDataMatch(a.getDataMatch());
			matchs.setRead(a.getRead());
			System.out.println("|Update| Matchs Atualizado:"+matchs.getId());
			return matchsRepository.save(matchs);
		}
		matchs.setUsers(users);
		matchs.setUser_id(usersId);
		matchs.setDataMatch(new Date());
		System.out.println("|Update| Matchs:");
		return matchsRepository.save(matchs);
	}
	
	//Salvar Notification
	public Notification salvarNotification(Long usersId, Notification notification) {
		Users users = buscar(usersId);
		notification.setUsers(users);
		notification.setDateNotify(new Date());
		System.out.println("|Notification:");
		return notificationRepository.save(notification);
	}
	
	
	//Listar Matchs do user corrente
	public List<Matchs> listarMatchs(Long usersId) {
		Users users = buscar(usersId);		
		return users.getMatchs();
	}
	
	//Listar Notification do user corrente
	public List<Notification> listarNotification(Long usersId) {
		Users users = buscar(usersId);		
		return users.getNotification();
	}
	
	//Listar amigos do user corrente
	public List<Friends> listarFriends(Long usersId) {
		Users users = buscar(usersId);		
		return users.getFriends();
	}
	
	//Listar notificações do user corrente
	public List<Friends> listFriendsNotification(Long usersId) {
			Users users = buscar(usersId);
			if(users.getFriends() == null){				
				System.out.println("Nenhum amigo encontrado!");
			}
						
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
	
	//[Config]Set Preferencia Sexual
		public void updatePerfil(Users users) {			
			verificarExistencia(users);
			Users a = usersRepository.findOne(users.getId());
			if(a != null) {
				System.out.println("|Update| User perfil |UserId: "+a.getId_fb_users());
				users.setId_fb_users(a.getId_fb_users());
				users.setName(a.getName());
				users.setImagem(a.getImagem());
				users.setLink(a.getLink());
				users.setGender(a.getGender());
				users.setNationality(a.getNationality());
				users.setFriendsTotalFb(a.getFriendsTotalFb());
				users.setFriendsTotalApp(a.getFriendsTotalApp());
				usersRepository.save(users);
			}
			usersRepository.save(users);
		}
	
}