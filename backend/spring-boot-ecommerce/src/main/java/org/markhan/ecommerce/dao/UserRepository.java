package org.markhan.ecommerce.dao;

import java.util.Optional;

import org.markhan.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
}
