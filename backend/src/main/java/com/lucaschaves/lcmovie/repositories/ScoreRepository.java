package com.lucaschaves.lcmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaschaves.lcmovie.entities.Score;
import com.lucaschaves.lcmovie.entities.ScorePk;

public interface ScoreRepository extends JpaRepository<Score, ScorePk>{

}
