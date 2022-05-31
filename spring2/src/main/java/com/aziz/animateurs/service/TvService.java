package com.aziz.animateurs.service;

import java.util.List;

import com.aziz.animateurs.entities.tv;


public interface TvService {

    List <tv> findAll();
    tv saveTv(tv c);
    tv updateTv(tv c);
    void deleteTv(tv c);
     void deleteTvById(Long id);
     tv getTv(Long idTv);

}