package com.aziz.animateurs.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aziz.animateurs.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}