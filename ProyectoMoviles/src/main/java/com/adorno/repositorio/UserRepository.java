package com.adorno.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.sqlSecurity.UserEntity;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
//	public List<UserEntity> findByUsername(String username);
	public boolean existsByUsername(String username);
	void deleteByUsername(String username);
}
