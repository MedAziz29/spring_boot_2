package com.aziz.animateurs.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aziz.animateurs.entities.Role;
public interface RoleRepository extends JpaRepository<Role, Long>  {

}
