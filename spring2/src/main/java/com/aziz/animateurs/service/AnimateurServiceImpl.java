package com.aziz.animateurs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aziz.animateurs.entities.animateur;
import com.aziz.animateurs.entities.tv;
import com.aziz.animateurs.repos.AnimateurRepository;

@Service
public class AnimateurServiceImpl implements AnimateurService {
@Autowired
AnimateurRepository animateurRepository;
@Override
public animateur saveAnimateur(animateur p) {
	return animateurRepository.save(p);
	}
	@Override
	public animateur updateAnimateur(animateur p) {
	return animateurRepository.save(p);
	}
	@Override
	public void deleteAnimateur(animateur p) {
	animateurRepository.delete(p);
	}
	 @Override
	public void deleteAnimateurById(Long id) {
	animateurRepository.deleteById(id);
	}
	@Override
	public animateur getAnimateur(Long id) {
	return animateurRepository.findById(id).get();
	}
	@Override
	public List<animateur> getAllAnimateurs() {
	return animateurRepository.findAll();
	}
	@Override
	public Page<animateur> getAllAnimateursParPage(int page, int size) {
		return animateurRepository.findAll(PageRequest.of(page, size));

	}
	public List<animateur> findByNomAnimateur(String nom) {
		return animateurRepository.findByNomAnimateur(nom);
		}
	
	

	
}