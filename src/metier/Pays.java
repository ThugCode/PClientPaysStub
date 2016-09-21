package metier;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.List;

import meserreurs.MonException;


public class Pays {

    private String nomPays;
    private String nomCapitale;
    private int nbHabitant;
    
    public Pays() {}

    public Pays(String nomP, String nomC, int nbH) {
        this.nomPays = nomP;
        this.nomCapitale = nomC;
        this.nbHabitant = nbH;
    }

    public String getNomPays() {
		return nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	public String getNomCapitale() {
		return nomCapitale;
	}

	public void setNomCapitale(String nomCapitale) {
		this.nomCapitale = nomCapitale;
	}

	public int getNbHabitant() {
		return nbHabitant;
	}

	public void setNbHabitant(int nbHabitant) {
		this.nbHabitant = nbHabitant;
	}
}
