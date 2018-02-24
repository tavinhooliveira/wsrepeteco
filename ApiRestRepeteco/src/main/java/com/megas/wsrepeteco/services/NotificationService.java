package com.megas.wsrepeteco.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.megas.wsrepeteco.domain.Users;
import com.megas.wsrepeteco.repository.NotificationRepository;

public class NotificationService {
	

	
	@Autowired
	private NotificationRepository notificationRepository;
	
		
	//Listar amigos do user corrente
	@SuppressWarnings("null")
	public Set<Users> listFriendsNotification(Long usersId) {
		Users users = notificationRepository.findOne(usersId);
		if(users == null) {
			System.out.println("O Usuario não existe.");
			return users.getFriends();
		}		
		return users.getFriends();
	}
		
	
}
