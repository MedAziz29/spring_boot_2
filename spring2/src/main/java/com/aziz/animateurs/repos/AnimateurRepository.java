package com.aziz.animateurs.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aziz.animateurs.entities.animateur;
import com.aziz.animateurs.entities.tv;
@Repository
public interface AnimateurRepository extends JpaRepository<animateur, Long> {

	List<animateur> findByNomAnimateur(String nom);

}