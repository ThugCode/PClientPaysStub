<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:import url="entete.jsp" />

		<c:import url="header.jsp" />
		
		<div class="corps">
			<h1>Listing des Pays</h1>
			<table id="table_pays" align="center">
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
