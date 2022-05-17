package com.lucaschaves.lcmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaschaves.lcmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
