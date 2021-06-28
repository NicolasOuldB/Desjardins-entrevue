DROP TABLE IF EXISTS FILM;  
CREATE TABLE FILM (  
	film_id INT AUTO_INCREMENT  PRIMARY KEY,  
	film_titre VARCHAR(50) NOT NULL,  
	film_description INT(8) NOT NULL  
);  

DROP TABLE IF EXISTS ACTEUR;  
CREATE TABLE ACTEUR (  
	acteur_id INT AUTO_INCREMENT  PRIMARY KEY,  
	acteur_nom VARCHAR(50) NOT NULL,  
	acteur_prenom INT(8) NOT NULL  
);  

DROP TABLE IF EXISTS A_JOUE;  
CREATE TABLE A_JOUE (  
	acteur_id INT NOT NULL,  
	film_id INT NOT NULL,
    PRIMARY KEY (acteur_id, film_id),
    FOREIGN KEY (film_id) REFERENCES FILM(film_id),
    FOREIGN KEY (acteur_id) REFERENCES ACTEUR(acteur_id)
);  