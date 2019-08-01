<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList,java.util.List"%>
<%@ page import="fr.Eni.javaee.restaurant.bll.UtilisateurManager"%>
<%@ page import="fr.Eni.javaee.restaurant.bo.Commentaire"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.format.DateTimeFormatter"%>

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
			<div class="col-10 offset-1">
				<h1>Mon Compte</h1>
				<div class="row">
					<div class="col-5 offset-1">
						<form action="/ServletdeConnexion" method="post">
							<div class="form-group">
								<label for="nom">Changer email</label> <input type="email"
									class="form-control" id="Mail" name="Mail"
									placeholder="${sessionScope.utilisateur.email}" required>
							</div>
							<div class="form-group">
								<label for="nom">Ancien mot de passe</label> <input
									type="password" class="form-control" id="AncienMotdePasse"
									name="AncienMotdePasse"
									placeholder="Entrez l'ancien mot de passe svp" required>
							</div>
							<div class="form-group">
								<label for="nom">Nouveau mot de passe</label> <input
									type="password" class="form-control" id="NouveauMotdePasse"
									name="NouveauMotdePasse"
									placeholder="Entrez le nouveau mot de passe svp" required>
							</div>
							<div class="form-group">
								<label for="nom">Confirmation nouveau mot de passe</label> <input
									type="password" class="form-control"
									id="confirmationNouveauMotdePasse"
									name="confirmationNouveauMotdePasse"
									placeholder="Entrez le nouveau mot de passe svp" required>
							</div>
							<p>
								<input type="submit" class="btn btn-primary"
									style="margin-left: 450px" />
							</p>
						</form>
					</div>
					<div class="col-5 offset-1">
						<%
							UtilisateurManager utilisateurManager = new UtilisateurManager();
							List<Commentaire> listeCommentaire = new ArrayList<Commentaire>();
							listeCommentaire = (List<Commentaire>) request.getAttribute("listeCommentaire");

							Boolean isActif = true;
							for (Commentaire commentaire : listeCommentaire) {
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
						%>
						<div class="col-md-5 offset-md-1 mb-2">
							<div class="note" id="card<%=commentaire.getId()%>">
								<div class="card">
									<div class="card-header  bg-info">
										<div class="row">
											<div class="col-2">
												By :
												<%=commentaire.getUtilisateur().getNom()%></div>
											<div class="col-2 offset-3">
												Note :
												<%=commentaire.getNote()%>/5
											</div>
											<div class="col-3 offset-2"><%=commentaire.getDate().format(formatter)%></div>
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