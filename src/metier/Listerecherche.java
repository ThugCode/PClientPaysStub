package metier;

import java.util.ArrayList;

/***
 * Classe de service Client
 * @author LETOURNEUR - GERLAND
 *
 */
public class Listerecherche {

	private ArrayList<Pays> retourPays = new ArrayList<Pays>();
	private ArrayList<Pays> retourVille = new ArrayList<Pays>();
	
	public Listerecherche() {
		retourPays = new ArrayList<Pays>();
		retourVille = new ArrayList<Pays>();
	}

	public ArrayList<Pays> getRetourPays() {
		return retourPays;
	}

	public void setRetourPays(ArrayList<Pays> retourPays) {
		this.retourPays = retourPays;
	}

	public ArrayList<Pays> getRetourVille() {
		return retourVille;
	}

	public void setRetourVille(ArrayList<Pays> retourVille) {
		this.retourVille = retourVille;
	}
	
	
}
