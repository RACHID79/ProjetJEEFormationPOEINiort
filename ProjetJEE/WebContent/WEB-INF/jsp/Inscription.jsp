<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<h1>Inscription</h1>
				<form method="post"
					action="<%=request.getContextPath()%>/ServletInscription">
					<div class="form-group col-md-4">
						<label for="nom">Nom<span class="requis">*</span></label> <input
							type="text" class="form-control" id="nom" name="nom"
							placeholder="Nom" required>
					</div>
					<br>
					<div class="form-group col-md-4">
						<label for="prenom">Prénom<span class="requis">*</span></label> <input
							type="text" class="form-control" id="prenom" name="prenom"
							placeholder="Prénom" required>
					</div>
					<br>
					<div class="form-group col-md-4">
						<label for="prenom">Email<span class="requis">*</span></label> <input
							type="text" class="form-control" id="email" name="email"
							value='<c:out value="${param.email}"/>' placeholder="email"
							required> <span class="erreur">${erreurs['email']}</span>
					</div>
					<br>
					<div class="form-group col-md-4">
						<label for="exampleInputPassword1">Mot de passe<span
							class="requis">*</span></label> <input type="password"
							class="form-control" id="motdepasse1" name="motdepasse"
							placeholder="Mot de passe" required> <span class="erreur">${erreurs['motdepasse']}</span>
					</div>
					<br>
					<div class="form-group col-md-4">
						<label for="exampleInputPassword1">Confirmation Mot de
							passe<span class="requis">*</span>
						</label> <input type="password" class="form-control" id="confirmation"
							name="confirmation" placeholder="Confirmer Mot de passe" required>
						<span class="erreur">${erreurs['confirmation']}</span>
					</div>


					<p>
						<input type="submit" class="btn btn-primary"
							style="margin-left: 450px" />
					</p>
					<br>

					<textarea class="form-group col-md-4" cols="40" rows="5"
						class="form-control" aria-label="With textarea"
						placeholder="Ajouter un commentaire svp"></textarea>




					<div></div>
					<p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
				</form>
			</div>
			<%@ include file="piedDePage.html"%>
		</div>
	</div>
</body>
</html>