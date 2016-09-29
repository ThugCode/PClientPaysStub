package metier;

public class Pays {
	
	private boolean recherchePays;
	private String nomPays;
	private String nomCapitale;
	private int nbHabitant;
	
	
	public Pays(String nomPays, String nomCapitale, int nbHabitants, boolean recherche) {
		this.recherchePays = recherche;
		this.nomPays = nomPays;
		this.nomCapitale = nomCapitale;
		this.nbHabitant = nbHabitants;
	}

	public String getNomPays() {
		return nomPays;
	}

	public String getNomCapitale() {
		return nomCapitale;
	}

	public int getNbHabitant() {
		return nbHabitant;
	}

	public boolean isRecherchePays() {
		return recherchePays;
	}
	
	public String toString() {
		return nomPays+" : "+nomCapitale+" / "+nbHabitant+" -> "+recherchePays;
	}
}
