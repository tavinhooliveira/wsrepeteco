package com.megas.wsrepeteco.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megas.wsrepeteco.domain.Notification;
import com.megas.wsrepeteco.services.NotificationService;


@RestController
@RequestMapping("/wsrepeteco/notification")
public class NotificationResource {
		
	@Autowired
	private NotificationService notificationService;
	
	
	@CrossOrigin
	@RequestMapping(value = "status/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> status(@RequestBody Notification notification, @PathVariable("id") Long id) {
		notification.setId(id);
		notificationService.status(notification);
		
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		notificationService.deletar(id);

		return ResponseEntity.noContent().build();
	}
	
	
}
