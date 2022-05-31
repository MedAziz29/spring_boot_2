package com.aziz.animateurs.service;

import java.util.List;

import com.aziz.animateurs.entities.Role;

public interface RoleService {
	 List <Role> findAll();
	    
	 Role saveRole(Role r);
	 Role updateRole(Role r);
	     Role getRole (Long idRole);
}
