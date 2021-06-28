package com.example.entrevueSpringBoot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entrevueSpringBoot.dto.FilmDto;
import com.example.entrevueSpringBoot.mappers.CustomMappers;
import com.example.entrevueSpringBoot.models.Film;
import com.example.entrevueSpringBoot.repositories.FilmRepository;

/**
 * @author Nicolas
 *
 * Service pour les films, traître les données entre la bd et le endpoint
 */
@Service
public class FilmService {
	
	@Autowired
	FilmRepository filmRepository;
	
	@Autowired
	CustomMappers customMappers;
	
	public FilmDto getFilmById(Long id) {
		FilmDto filmDto = null;
		Optional<Film> film = filmRepository.findById(id);
		if (film.isPresent()) {
			filmDto = customMappers.filmToFilmDto(film.get());
		}
		return filmDto;  
	}  
	
	public FilmDto saveFilm(FilmDto filmDto) {  
		Film insterdValue = filmRepository.save(customMappers.filmDtoToFilm(filmDto)); 
		return customMappers.filmToFilmDto(insterdValue); 
	}  

}
