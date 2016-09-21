<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<table>
	<tr>
		<td bgcolor="D0D0D0"><i>Pays</i></td>
	</tr>
	<c:forEach items="${listeRecherche.retourPays}" var="item">
		<tr>
			<td><a href="Controleur?action=afficherPaysCarte&nomPays=${item.nomPays}">${item.nomPays}</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td bgcolor="D0D0D0"><i>Capitale</i></td>
	</tr>
	<c:forEach items="${listeRecherche.retourVille}" var="item">
		<tr>
			<td><a href="Controleur?action=afficherPaysCarte&nomPays=${item.nomPays}">${item.nomCapitale}</a></td>
		</tr>
	</c:forEach>
</table>