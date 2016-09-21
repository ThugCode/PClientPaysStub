package service;

import java.util.List;

import metier.EnvoiMessageSOAP;
import metier.Pays;

public class PaysService {
	
	private static String destenvoi = "http://localhost:8080/PWSPays/services/WebServices";
	private static String destination = "http://service"; // Nom du package

	private static EnvoiMessageSOAP unAppel = new EnvoiMessageSOAP();
	
	private String operation;
	
	public List<Pays> listePays() {
		operation = "getTousLesPays";
		try {
			unAppel.connexion();
			unAppel.creationMessage(operation, destination);
			unAppel.EmmissionReception(destenvoi, operation);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public Pays getPays(String nomPays) {
		operation = "getUnPays";
		try {
			unAppel.connexion();
			unAppel.creationMessage(operation, destination);
			unAppel.EmmissionReception(destenvoi, operation);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
