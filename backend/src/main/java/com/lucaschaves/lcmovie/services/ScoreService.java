package com.lucaschaves.lcmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucaschaves.lcmovie.dto.MovieDTO;
import com.lucaschaves.lcmovie.dto.ScoreDTO;
import com.lucaschaves.lcmovie.entities.Movie;
import com.lucaschaves.lcmovie.entities.Score;
import com.lucaschaves.lcmovie.entities.User;
import com.lucaschaves.lcmovie.repositories.MovieRepository;
import com.lucaschaves.lcmovie.repositories.ScoreRepository;
import com.lucaschaves.lcmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		//pegando o movie(filme)
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		//Soma paraa fazeer a media
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		//Média, onde o sum é a soma de todas as notas, e é dividida pelo tamanho do getScores(que é todas as notas(
		double avg = sum / movie.getScores().size();
		
		//Salvando a média
		movie.setScore(avg);
		//Salvando o numero de avalições
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
	
}
