package com.aziz.animateurs.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aziz.animateurs.entities.tv;
import com.aziz.animateurs.repos.TvRepository;


@Service
public class TvServiceImpl implements TvService {

    @Autowired
    private TvRepository tvRepository;

    @Override
    public List <tv> findAll() {
        return tvRepository.findAll();
    }

	@Override
	public tv saveTv(tv c) {
		return tvRepository.save(c);
	}

	@Override
	public tv updateTv(tv c) {
		return tvRepository.save(c);
	}

	@Override
	public void deleteTv(tv c) {
		tvRepository.delete(c);
	}

	@Override
	public void deleteTvById(Long idCat) {
		tvRepository.deleteById(idCat);
	}

	@Override
	public tv getTv(Long idTv) {
		return tvRepository.findById(idTv).get();
	}

   
}