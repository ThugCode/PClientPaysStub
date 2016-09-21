package metier;

public class Principale {

	private static String operation = "getTousLesPays";
	private static String destenvoi = "http://localhost:8080/PWSPays/services/WebServices";
	private static String destination = "http://service"; // Nom du package

	private static EnvoiMessageSOAP unAppel = new EnvoiMessageSOAP();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			unAppel.connexion();
			unAppel.creationMessage(operation, destination);
			unAppel.EmmissionReception(destenvoi, operation);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
