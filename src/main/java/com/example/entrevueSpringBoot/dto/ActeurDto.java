package com.example.entrevueSpringBoot.dto;

import java.util.ArrayList;

/**
 * @author Nicolas
 * DTO des acteurs
 */
public class ActeurDto {

	private Long id;
	private String nom;
	private String prenom;
	private ArrayList<FilmDto> films;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public ArrayList<FilmDto> getFilms() {
		return films;
	}
	public void setFilms(ArrayList<FilmDto> films) {
		this.films = films;
	}
}
