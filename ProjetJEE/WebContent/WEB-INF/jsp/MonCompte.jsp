<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Mon Compte</h1>
<form action="/ServletdeConnexion" method="post">
<div class="form-group">
    <label for="nom">Changer eMail</label>
    <input type="text"class="form-control" id="Mail" placeholder="${sessionScope.utilisateur.email}" required>
  </div>

  <div class="form-group">
    <label for="nom">Ancien mot de passe</label>
    <input type="text" class="form-control" id="AncienMotdePasse" placeholder="Entrez l'ancien mot de passe svp" required>
  </div>
  <div class="form-group">
    <label for="nom">Nouveau mot de passe</label>
    <input type="text" class="form-control" id="NouveauMotdePasse" placeholder="Entrez le nouveau mot de passe svp" required>
  </div>
    <div class="form-group">
    <label for="nom">Confirmation nouveau mot de passe</label>
    <input type="text" class="form-control" id="NouveauMotdePasse" placeholder="Entrez le nouveau mot de passe svp" required>
  </div>
  <p><button class="btn" type="submit">valider</button></p>  
  </form>

</body>
</html>