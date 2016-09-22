package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Listerecherche;
import metier.Pays;
import service.PaysService;

/***
 * Classe contrôleur
 * @author LETOURNEUR - GERLAND
 *
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String ACTION_TYPE = "action";
	private static final String CHERCHE_PAYS = "cherchePays";
	private static final String AFFICHER_PAYS = "afficherPays";
	private static final String AFFICHER_PAYS_CARTE = "afficherPaysCarte";
	private static final String ERROR_PAGE = "/erreur.jsp";

	/***
	 * Redirection vers doPost et doGet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws Exception
	 */
	protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		
		String destinationPage = ERROR_PAGE;
		String actionName = request.getParameter(ACTION_TYPE);
		
		System.out.println("lourd");
		
		if (AFFICHER_PAYS.equals(actionName)) {
			
			PaysService service = new PaysService();
			List<Pays> listePays = service.listePays();
			
			request.setAttribute("liste", listePays);
			request.setAttribute("affichageListe", 1);
			
			destinationPage = "/afficherPays.jsp";
		
		} else if (AFFICHER_PAYS_CARTE.equals(actionName)) {
			
			String nomPays = request.getParameter("nomPays");
			
			PaysService service = new PaysService();
			Pays pays = service.getPays(nomPays);
			
			request.setAttribute("pays", pays);
			
			destinationPage = "/afficherPaysCarte.jsp";
			
		} else if (CHERCHE_PAYS.equals(actionName)) {
			
			String q = request.getParameter("q");
			
			PaysService service = new PaysService();
			
			Listerecherche listeRecherche = service.searchPays(q);
			
			request.setAttribute("listeRecherche", listeRecherche);
			
			System.out.println(listeRecherche);
			
			destinationPage = "/GestRecherche.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);
	}
	
	/***
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			processusTraiteRequete(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	/***
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
	**/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			processusTraiteRequete(request, response);
		}catch( Exception e){
			e.printStackTrace();
		}
	}
}
