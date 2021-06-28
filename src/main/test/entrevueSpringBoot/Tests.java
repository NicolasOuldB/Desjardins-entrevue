package entrevueSpringBoot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.example.entrevueSpringBoot.dto.FilmDto;
import com.example.entrevueSpringBoot.mappers.CustomMappers;
import com.example.entrevueSpringBoot.models.Acteur;
import com.example.entrevueSpringBoot.models.Film;

class Tests {

	@Test
	void test() {
		Film film = new Film();
		Long filmId = Long.valueOf(1);
		film.setId(filmId);
		film.setDescription("Rapide et dangereux");
		film.setTitre("Fast and Furious");
		film.setActeurs(null);
		
		Acteur acteur = new Acteur();
		Long acteurId = Long.valueOf(1);
		acteur.setId(acteurId);
		acteur.setNom("Rodriguez");
		acteur.setPrenom("Michelle");
		acteur.setFilms(null);
		
		ArrayList<Acteur> acteurs = new ArrayList<Acteur>();
		acteurs.add(acteur);
		
		ArrayList<Film> films = new ArrayList<Film>();
		films.add(film);
		
		film.setActeurs(acteurs);
		acteur.setFilms(films);
		
		FilmDto dto = CustomMappers.INSTANCE.filmToFilmDto(film);
		
		assertNotEquals(dto, null);
	    assertEquals(dto.getTitre(), "Fast and Furious");
	    assertEquals(dto.getDescription(), "Rapide et dangereux");
	    assertNotEquals(dto.getActeurs(), null);
	    assertEquals(dto.getActeurs().get(0).getPrenom(), "Michelle");
	    assertEquals(dto.getActeurs().get(0).getNom(), "Rodriguez");
	}

}
