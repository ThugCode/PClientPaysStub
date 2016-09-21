<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:import url="entete.jsp" />
		<header>
			<a href="index.jsp">Accueil</a>
			Afficher la liste des stages
			<form class="ajax" method="get" action="GestRecherche.jsp">          
	        	<input id="q" class="rech" type="text" autocomplete="off" name="q" placeholder="Rechercher" on/>
	        	<input id="selectionne" type="hidden" name="selectionne" value="1" size="2"/>
	        	<input type="submit" style="display: none;" value="valider"/>
        	</form>
        	<div id="results" class="results">
        	</div>
		</header>
		<div class="corps2">
			<h1>Listing des Pays </h1>
			<table border="1" align="center">
				<caption> Tableau des Stages </caption>
				<tr>
					<th> Nom des pays </th>
					<th> Capitale </th>
					<th> Nombre d'habitant </th>
					<th> </th>
				 </tr>
				<c:forEach items="${liste}" var="item" > 
				<tr>
					<td>${item.nomPays}</td>
				    <td>${item.nomCapitale}</td>
				    <td>${item.nbHabitant}</td>
				    <td><a href="Controleur?action=afficherPaysCarte&nomPays=${item.nomPays}">Afficher sur la carte</a>
				</tr>
				</c:forEach>
			</table>
		</div>
<c:import url="piedpage.jsp" />
