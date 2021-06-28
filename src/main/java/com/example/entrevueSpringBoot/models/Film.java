package com.example.entrevueSpringBoot.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Nicolas
 *
 * Entité film basée sur la table en bd
 *
 */
@Entity
@Table
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String titre;
	@Column
	private String description;
	@ManyToMany(mappedBy = "films", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Acteur> acteurs;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Acteur> getActeurs() {
		return acteurs;
	}
	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}
}
