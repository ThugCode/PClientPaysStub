package service;

import java.util.ArrayList;
import java.util.List;

import metier.EnvoiMessageSOAP;
import metier.Pays;

/***
 * Classe de service Client
 * @author LETOURNEUR - GERLAND
 *
 */
public class PaysService {
	
	private static String destenvoi = "http://localhost:8080/PWSPays/services/WebServices";
	private static String destination = "http://service"; // Nom du package
	private static EnvoiMessageSOAP unAppel = new EnvoiMessageSOAP();
	private String operation;
	
	/***
	 * Appel de l'opération getTousLesPays
	 * @return
	 */
	public List<Pays> listePays() {
		operation = "getTousLesPays";
		
		List<Pays> listePays = null;
		
		try {
			unAppel.connexion();
			unAppel.creationMessage(operation, null, destination);
			listePays = (List<Pays>) unAppel.EmmissionReception(destenvoi, operation);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return listePays;
	}
	
	/***
	 * Appel de l'opération getPays
	 * @return
	 */
	public Pays getPays(String nomPays) {
		operation = "getUnPays";
		
		Pays pays = null;
		
		try {
			unAppel.connexion();
			unAppel.creationMessage(operation, nomPays, destination);
			pays = (Pays)unAppel.EmmissionReception(destenvoi, operation);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return pays;
	}
	
	/***
	 * Appel de l'opération searchPays
	 * @return
	 */
	public ArrayList<Pays> searchPays(String search) {
		operation = "searchPays";
		
		ArrayList<Pays> liste = null;
		
		try {
			unAppel.connexion();
			unAppel.creationMessage(operation, search, destination);
			liste = (ArrayList<Pays>) unAppel.EmmissionReception(destenvoi, operation);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return liste;
	}
}
