package com.example.entrevueSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entrevueSpringBoot.dto.FilmDto;
import com.example.entrevueSpringBoot.services.FilmService;

/**
 * @author Nicolas
 * Endpoints des films
 */
@RestController
@RequestMapping("/api")
public class FilmController {

	@Autowired
	FilmService filmService;

	/**
	 * Endpoint pour récupérer un film grâce à son id
	 * 
	 * @param id id du film à récupérer
	 * @return le film si trouvé sinon null
	 */
	@GetMapping("/film/{id}")
	private ResponseEntity<FilmDto> getFilm(@PathVariable("id") Long id) {
		try {
			FilmDto foundFilm = filmService.getFilmById(id);
			if (foundFilm != null) {
				return new ResponseEntity<FilmDto>(foundFilm, HttpStatus.OK);
			} else {
				// On renvoie HttpCode 404 si le film n'existe pas
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// Erreur 500 dans tous les autres cas
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Ajoute un film en base de donnée et retourne le film ajouté
	 * 
	 * @param film le film a ajouté
	 * @return le film si ajouté sinon null
	 */
	@PostMapping("/film")
	private ResponseEntity<FilmDto> saveFilm(@RequestBody FilmDto film) {
		try {
			FilmDto insertedFilm = filmService.saveFilm(film);
			return new ResponseEntity<FilmDto>(insertedFilm, HttpStatus.CREATED);
		} catch (Exception e) {
			// Erreur 500 dans tous les autres cas
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
