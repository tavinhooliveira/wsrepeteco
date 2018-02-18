package com.megas.wsrepeteco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megas.wsrepeteco.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	
}
