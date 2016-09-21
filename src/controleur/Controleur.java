package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Pays;
import service.PaysService;

@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACTION_TYPE = "action";
	private static final String CHERCHE_PAYS = "cherchePays";
	private static final String AFFICHER_PAYS = "afficherPays";
	private static final String AFFICHER_PAYS_CARTE = "afficherPaysCarte";
	private static final String ERROR_PAGE = "/erreur.jsp";

	protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = ERROR_PAGE;
			// execute l'action
		
		if (AFFICHER_PAYS.equals(actionName)) {
			request.setAttribute("affichageListe", 1);
			
			PaysService service = new PaysService();
			
			List<Pays> listePays = service.listePays();
			
			for(int i = 0; i < listePays.size(); i++){
				System.out.println("pays :" + listePays.get(i).getNomPays());
			}
			
			request.setAttribute("liste", listePays);
			destinationPage = "/afficherPays.jsp";
		
		} else if (AFFICHER_PAYS_CARTE.equals(actionName)) {
			
			String nomPays = request.getParameter("nomPays");
			
			PaysService service = new PaysService();
			
			Pays pays = service.getPays(nomPays);
			
			System.out.println("pays : " + pays.getNomPays());
			request.setAttribute("pays", pays);
			
			destinationPage = "/afficherPaysCarte.jsp";
		} else if (CHERCHE_PAYS.equals(actionName)) {
			String q = request.getParameter("q");
			
			destinationPage = "/GestRecherche.jsp";
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			processusTraiteRequete(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			processusTraiteRequete(request, response);
		}catch( Exception e){
			e.printStackTrace();
		}
	}
}
