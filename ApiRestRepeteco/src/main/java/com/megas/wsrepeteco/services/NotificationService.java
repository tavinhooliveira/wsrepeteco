package com.megas.wsrepeteco.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.megas.wsrepeteco.domain.Notification;
import com.megas.wsrepeteco.repository.NotificationRepository;
import com.megas.wsrepeteco.services.exceptions.OptionNaoEncontradoException;
import com.megas.wsrepeteco.services.exceptions.UsersNaoEncontradoException;

@Service
public class NotificationService {
	

	
	@Autowired
	private NotificationRepository notificationRepository;
	
	// Buscar Friends
	public Notification buscar(Long id) {
		Notification notification = notificationRepository.findOne(id);

		if (notification == null) {
			throw new UsersNaoEncontradoException("Nenhum Notification encontrado.");
		}
		return notification;
	}
	
	// Verificar se Existe
	private void verificarExistencia(Notification notification) {
		buscar(notification.getId());
	}
	
	// Classification status
	public void status(Notification notification) {
		verificarExistencia(notification);
		Notification n = notificationRepository.findOne(notification.getId());
		if (n != null) {
			System.out.println("|Update|Notification Read: "+ " status: " + notification.getStatus());
			notification.setDateNotify(n.getDateNotify());
			notification.setId_fb_friends(n.getId_fb_friends());
			notification.setImagem(n.getImagem());
			notification.setLink(n.getLink());
			notification.setName(n.getName());
			notification.setText(n.getText());
			notification.setType(n.getType());
			notification.setUsers(n.getUsers());
			notificationRepository.save(notification);
		}
		notification.setDateNotify(new Date());
		notificationRepository.save(notification);
	}
	
	// Deletar
	public void deletar(Long id) {
		try {
			notificationRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new OptionNaoEncontradoException("Notification não pode ser Deletado.");
		}
	}	
		
	
}
