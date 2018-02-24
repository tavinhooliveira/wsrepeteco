package com.megas.wsrepeteco.resources;

import java.util.List;
import java.util.Set;

import com.megas.wsrepeteco.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megas.wsrepeteco.domain.Friends;
import com.megas.wsrepeteco.services.UsersService;


@RestController
@RequestMapping("/wsrepeteco/notification")
public class NotificationResource {
	

	
	@Autowired
	private  UsersService usersService;
	
	
	@CrossOrigin
	@RequestMapping(value = "/{id}/friends", method = RequestMethod.GET)
	public ResponseEntity<Set<Users>> listFriendsNotification(@PathVariable("id")String usersId) {
		Set<Users> friends =  usersService.listFriendsNotification(usersId);
		
		return ResponseEntity.status(HttpStatus.OK).body(friends);
	}


}