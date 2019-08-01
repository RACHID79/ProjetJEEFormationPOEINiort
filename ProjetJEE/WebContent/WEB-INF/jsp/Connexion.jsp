<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<h1>Connexion</h1>
				<form action="<%=request.getContextPath()%>/ServletdeConnexion"
					method="post">
					<div class="form-group col-md-4">
						<label for="exampleInputEmail1">Adresse mail</label> <input
							type="email" name="mail" class="form-control" id="mail"
							placeholder="Entrez votre email svp">
					</div>
					<div class="form-group col-md-4">
						<label for="exampleInputPassword1">Mot de passe</label> <input
							type="password" name="mot_de_passe" class="form-control"
							id="mot_de_passe" placeholder="Mot de passe">
					</div>
					<button type="submit" class="btn btn-primary"
						style="margin-left: 450px">Connexion</button>
				</form>
				<c:if test="${!empty error }">
					<p>${error}</p>
				</c:if>
			</div>
		</div>
	</div>
	<%@ include file="piedDePage.html"%>
</body>
</html>