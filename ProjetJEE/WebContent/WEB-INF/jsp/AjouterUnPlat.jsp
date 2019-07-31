<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un plat</title>
</head>
<body>

<%@ include file="entete.jsp"%>

<form action="<%=request.getContextPath()%>/ServletRedirigeAjoutPlats" method="post" >
  <div class="form-group col-md-4">
    <label for="imageURL">Image</label>
    <input type="text" class="form-control" id="imageURL" placeholder="entrez votre Image" required>
  </div>
   <div class="form-group col-md-4">
    <label for="nom">Nom</label>
    <input type="text" class="form-control" id="nom" placeholder="entrez le nom du plat" required>
  </div>
   <div class="form-group col-md-4">
    <label for="presentation">Presentation</label>
    <input type="text" class="form-control" id="presentation" placeholder="entrez votre présentation" required>
  </div>
   <div class="form-group col-md-4">
    <label for="niveau">Niveau</label>
    <input type="text" class="form-control" id="niveau" placeholder="entrez le niveau de difficultés" required>
  </div>
   <div class="form-group col-md-4">
    <label for="cout">Cout</label>
    <input type="text" class="form-control" id="cout" placeholder="entrez le coût du plat " required>
  </div>
  <div class="form-group col-md-4">
    <label for="nbConvive">Nombre de convive</label>
    <input type="text" class="form-control" id="nbConvive" placeholder="entrez le nombre de convive " required>
  </div>
  <div class="form-group col-md-4">
    <label for="listIngredient">Liste ingredient</label>
    <input type="text" class="form-control" id="listIngredient" placeholder="entrez la liste d'ingrédient" required>
  </div>
   <button type="submit" class="btn btn-primary" style="margin-left:450px">Valider</button>
<%@ include file="piedDePage.html"%>
</body>
</html>