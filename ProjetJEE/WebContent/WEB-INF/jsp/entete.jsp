<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.Eni.javaee.restaurant.bo.Utilisateur"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<div class="mb-4">
	<nav class="navbar navbar-expand-lg navbar-light bg-info"> <a
		class="navbar-brand"
		href='<%=request.getContextPath() + "/RedirigeAccueil"%>'>RESTAURANT</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href='<%=request.getContextPath() + "/NosPlats"%>'>Nos plats<span
					class="sr-only">(current)</span>
			</a></li>

			<c:if test="${ sessionScope.utilisateur.role[0] eq 'admin'}">
				<li class="nav-item"><a class="nav-link"
					href='<%=request.getContextPath() + "/ServletRedirigeAjoutPlats"%>'>Ajouter
						plats</a></li>
			</c:if>

			<c:if test="${!empty sessionScope.utilisateur.role}">
				<li class="nav-item"><a class="nav-link "
					href='<%=request.getContextPath() + "/ServletMonCompte"%>'>Mon
						compte</a></li>
			</c:if>
		</ul>

	</div>

	<div>
		<c:if test="${empty sessionScope.utilisateur}">
			<a href='<%=request.getContextPath() + "/ServletdeConnexion"%>'
				class="btn btn-dark" role="button">Se connecter</a>
			<a href='<%=request.getContextPath() + "/ServletInscription"%>'
				class="btn btn-dark" role="button">S'inscrire</a>
		</c:if>
		<c:if test="${!empty sessionScope.utilisateur}">
			<div>${ sessionScope.utilisateur.nom}</div>
			<a href='<%=request.getContextPath() + "/ServletDeconnect"%>'
				class="btn btn-dark" role="button">Se déconnecter</a>
		</c:if>


	</div>
	</nav>
</div>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous" type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous" type="text/javascript"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous" type="text/javascript"></script>


