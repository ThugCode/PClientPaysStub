<header>
	<a href="index.jsp"><div id="btn_accueil" class="btn_menu" >Accueil</div></a>
	<a href="Controleur?action=afficherPays"><div id="btn_accueil" class="btn_menu" >Liste des pays</div></a>
	<form class="ajax" method="get" action="gestionRecherche.jsp">
		<input id="q" class="rech" type="text" autocomplete="off" name="q" placeholder="  Rechercher" on />
	</form>
	<div id="results" class="results"></div>
</header>