package com.megas.wsrepeteco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megas.wsrepeteco.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
}
