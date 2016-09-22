<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="entete.jsp" />
		<header>
			Accueil
			<a href="Controleur?action=afficherPays">Affichage liste des pays</a>
			<form class="ajax" method="get" action="Controleur?action=cherchePays">          
	        	<input id="q" class="rech" type="text" autocomplete="off" name="q" placeholder="Rechercher" on/>
	        	<input id="selectionne" type="hidden" name="selectionne" value="1" size="2"/>
	        	<input type="submit" style="display: none;" value="valider"/>
        	</form>
        	<div id="results" class="results">
        	</div>
		</header>
		<div class="corps2">
			<h1> Gestion des Pays HIGH TECH </h1>
			<p>Vous pouvez soit rechercher un pays dans le champ de recherche,
			soit afficher directement la liste de tous les pays si vous avez la flemme.</p>
			<br/>
			<br/>
		</div>
<c:import url="piedpage.jsp" />