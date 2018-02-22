package com.megas.wsrepeteco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megas.wsrepeteco.domain.Users;


public interface NotificationRepository extends JpaRepository<Users, Long> {
	
	
}
