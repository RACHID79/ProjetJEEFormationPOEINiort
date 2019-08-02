<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList,java.util.List"%>
<%@ page import="fr.Eni.javaee.restaurant.bll.UtilisateurManager"%>
<%@ page import="fr.Eni.javaee.restaurant.bo.Commentaire"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="fr.Eni.javaee.restaurant.bo.Utilisateur"%>
<%@ page import="fr.Eni.javaee.restaurant.dal.UtilisateurDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="entete.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<h1>Mon Compte</h1>
				<div class="row ml-4">
					<div class="col-3">
						<form action="ServletMonCompte" method="post">
							<div class="form-group">
								<label for="nom">Changer email <span class="text-danger">(*)</span></label> <input type="email"
									class="form-control" id="Mail" name="Mail"
									value="${sessionScope.utilisateur.email}" required>
							</div>
							<div class="form-group">
								<label for="nom">Ancien mot de passe <span class="text-danger">(*)</span></label> <input
									type="password" class="form-control" id="AncienMotdePasse"
									name="AncienMotdePasse"
									placeholder="Entrez l'ancien mot de passe svp" required>
							</div>
							<div class="form-group">
								<label for="nom">Nouveau mot de passe</label> <input
									type="password" class="form-control" id="NouveauMotdePasse"
									name="NouveauMotdePasse"
									placeholder="Entrez le nouveau mot de passe svp">
							</div>
							<div class="form-group">
								<label for="nom">Confirmation nouveau mot de passe</label> <input
									type="password" class="form-control"
									id="confirmationNouveauMotdePasse"
									name="confirmationNouveauMotdePasse"
									placeholder="Entrez le nouveau mot de passe svp">
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-3 text-danger">(*) : requis</div>
									<div class="col-3 offset-6">
										<input type="submit" class="btn btn-primary" />

									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-7 offset-md-1 mb-2">

						<%
							UtilisateurManager um = new UtilisateurManager();
							Utilisateur user = null;
							user = (Utilisateur) session.getAttribute("utilisateur");

							List<Commentaire> listeCommentaire = new ArrayList<Commentaire>();
							if (utilisateur != null) {
								listeCommentaire = um.getCommentairesByIdUtilisateur(user.getId());
							}
							for (Commentaire commentaire : listeCommentaire) {
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
						%>
						<div class="col-md-12 mb-2 mt-4">
							<div class="note" id="card<%=commentaire.getId()%>">
								<div class="card rounded border border-info">
									<div class="card-header ">
										<div class="row">
											<div class="col-2">
												Note :
												<%=commentaire.getNote()%>/5
											</div>
											<div class="col-5 offset-1">
												<%=commentaire.getPlat().getNom()%>
											</div>
											<div class="col-3 offset-1"><%=commentaire.getDate().format(formatter)%></div>
										</div>
									</div>
									<div class="card-body"><%=commentaire.getCommentaire()%></div>
									<div class="card-footer"></div>
								</div>
							</div>
						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>