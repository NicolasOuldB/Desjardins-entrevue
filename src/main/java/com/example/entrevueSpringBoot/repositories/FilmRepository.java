package com.example.entrevueSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.entrevueSpringBoot.models.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {

}
