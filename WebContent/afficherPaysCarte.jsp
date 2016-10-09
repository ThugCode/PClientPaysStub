<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<c:import url="entete.jsp" />
		
	<c:import url="header.jsp" />

		<div class="corps">
			<h1>${pays.nomPays}</h1>
			<p>Capitale : ${pays.nomCapitale} / Nombre d'habitants : ${pays.nbHabitant}</p>
			<div id="map-canvas" style="height: 500px; width: 96%; margin-left: 2%; margin-right: 2%; margin-bottom: 20px;"></div>
			<a href="http://maps.apple.com/?q=${pays.nomCapitale},${pays.nomPays}">Ouvrir dans l'application</a><br/>
		</div>
<c:import url="piedpage.jsp" />
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script>

// Google Map
		var geocoder;
		var map;
		function initialize(latitude, longitude) {
			geocoder = new google.maps.Geocoder();
			var mapOptions = {
				zoom : 8,
				center : new google.maps.LatLng(latitude, longitude)
			};
			map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
		}
		
		function changeCoordonnee(latitude, longitude) {
			google.maps.event.addDomListener(window, 'load', initialize(latitude, longitude));
		}

		function codeAddress(address) {
			geocoder.geocode(
					{'address' : address},
					function(results, status) {
						if (status == google.maps.GeocoderStatus.OK) {
							map.setCenter(results[0].geometry.location);

							var marker = new google.maps.Marker({map : map, position : results[0].geometry.location});							
							var infoWindow = creerInfoWindow();
							
							google.maps.event.addListener(marker, 'click', function() {
								infoWindow.open(map, marker);
							});
						} else {
							alert("Geocode was not successful for the following reason: " + status);
						}
					});
		}


		function creerInfoWindow() {
			var contentS = "${pays.nomCapitale}, ${pays.nomPays}<br/>${pays.nbHabitant} habitants";
			var infoWindows = new google.maps.InfoWindow({
				content : contentS,
				maxWidth : 200
			});
			return infoWindows;
		}
		var adresse = "${pays.nomPays}, ${pays.nomCapitale}";
		changeCoordonnee(0.0, 0.0);
		codeAddress(adresse);
	</script>