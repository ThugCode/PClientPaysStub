package metier;

/***
 * Classe de service Client
 * @author LETOURNEUR - GERLAND
 *
 */
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
