package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.WebServicesStub;

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
			//SOAPReader reader = new SOAPReader();
			//List<Pays> listePays = reader.getPays();
			
			// on se connecte au stub
			WebServicesStub unStub = new WebServicesStub();
			// on d�finit une r�f�rence sur la m�thode � appeler
			WebServicesStub.GetTousLesPays mesPays = new WebServicesStub.GetTousLesPays();
			// on d�nit un objet pour r�cup�rer les donn�es de la m�thode getTousLesPays ()
			WebServicesStub.GetTousLesPaysResponse sr; 
			// On construit une collection avec le type fourni par le web service
			List<service.WebServicesStub.Pays> listePays = new ArrayList<service.WebServicesStub.Pays>();
			// On construit une r�f�rence sur la m�thode getTousLesPays ()
			sr = unStub.getTousLesPays(mesPays);
			// On r�cup�re les donn�es dans un tableau 
			service.WebServicesStub.Pays[]  tabPays = sr.get_return();
			// contr�le des donn�es 
			System.out.println("pays : " +tabPays[0].getNomPays());
		     // on transforme en liste 
			for ( int i=0; i < tabPays.length;i++)
			{
				listePays.add(tabPays[i]);
			}
			request.setAttribute("liste", listePays);
			destinationPage = "/afficherPays.jsp";
		
		} else if (AFFICHER_PAYS_CARTE.equals(actionName)) {
			
			String nomPays = request.getParameter("nomPays");
			// on se connecte au stub
			WebServicesStub unStub = new WebServicesStub();
			// on d�finit une r�f�rence sur la m�thode � appeler
			WebServicesStub.GetUnPays unPays = new WebServicesStub.GetUnPays();
			// on d�nit un objet pour r�cup�rer les donn�es de la m�thode getUnPays()
			WebServicesStub.GetUnPaysResponse sr; 
			// On passe le param�tre 
			unPays.setNomPays(nomPays);
			// construit une r�f�rence sur la m�thode getUnPays()
			sr= unStub.getUnPays(unPays);
			// On r�cup�re les donn�es dans un tableau 
			service.WebServicesStub.Pays  lePays = sr.get_return();
			System.out.println("pays : " + lePays.getNomPays());
			request.setAttribute("pays", lePays);
			
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
