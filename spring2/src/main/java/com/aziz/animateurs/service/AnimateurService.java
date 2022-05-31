package com.aziz.animateurs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aziz.animateurs.entities.animateur;
import com.aziz.animateurs.entities.tv;

public interface AnimateurService {
animateur saveAnimateur(animateur p);
animateur updateAnimateur(animateur p);
void deleteAnimateur(animateur p);
 void deleteAnimateurById(Long id);
animateur getAnimateur(Long id);
List<animateur> getAllAnimateurs();
Page<animateur> getAllAnimateursParPage(int page, int size);
List<animateur> findByNomAnimateur(String nom);
}