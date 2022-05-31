package com.aziz.animateurs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aziz.animateurs.entities.tv;


@Repository
public interface TvRepository extends JpaRepository<tv, Long>{

}