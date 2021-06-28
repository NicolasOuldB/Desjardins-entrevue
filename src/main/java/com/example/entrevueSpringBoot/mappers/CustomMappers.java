package com.example.entrevueSpringBoot.mappers;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.entrevueSpringBoot.dto.ActeurDto;
import com.example.entrevueSpringBoot.dto.FilmDto;
import com.example.entrevueSpringBoot.models.Acteur;
import com.example.entrevueSpringBoot.models.Film;

@Mapper(componentModel = "spring")
public interface CustomMappers {
	
	CustomMappers INSTANCE = Mappers.getMapper(CustomMappers.class);
	
	/* 
	 * On appel ces mappeurs quand on parcours une liste de films ou d'acteurs
	 * depuis une entité parent afin d'éviter de boucler à l'infine
	 */
	@Named("filmToFilmDtoWithoutActeur")
    @Mapping(target = "acteurs", ignore = true)
	FilmDto filmToFilmDtoWithoutActeur(Film film);
	
	@Named("filmDtoToFilmWithoutActeur")
    @Mapping(target = "acteurs", ignore = true)
	Film filmDtoToFilmWithoutActeur(FilmDto filmDto);
	
	@Named("acteurToActeurDtoWithoutFilm")
    @Mapping(target = "films", ignore = true)
	ActeurDto acteurToActeurDtoWithoutFilm(Acteur acteur);
	
	@Named("acteurDtoToActeurWithoutFilm")
    @Mapping(target = "films", ignore = true)
	Acteur acteurDtoToActeurWithoutFilm(ActeurDto acteurDto);
	
	/* 
	 * On définit les mappeurs des listes afin d'appeler des mappeurs spéciaux
	 * pour ne pas faire de boucle infinie
	 */
	@IterableMapping(qualifiedByName="acteurToActeurDtoWithoutFilm")
	ArrayList<ActeurDto> acteursToActeurDtos(List<Acteur> acteurs);
	
	@IterableMapping(qualifiedByName="acteurDtoToActeurWithoutFilm")
	List<Acteur> acteurDtosToActeurs(ArrayList<ActeurDto> acteurDtos);
	
	@IterableMapping(qualifiedByName="filmToFilmDtoWithoutActeur")
	ArrayList<FilmDto> filmsToFilmDtos(List<Film> films);
	
	@IterableMapping(qualifiedByName="filmDtoToFilmWithoutActeur")
	List<Film> filmDtosToFilms(ArrayList<FilmDto> filmDtos);
	
	// Les mappeurs de base des entités
	Film filmDtoToFilm(FilmDto filmDto);
	
	ActeurDto acteurToActeurDto(Acteur acteur);
	
	Acteur acteurDtoToActeur(ActeurDto acteurDto);
	
	FilmDto filmToFilmDto(Film film);
}
