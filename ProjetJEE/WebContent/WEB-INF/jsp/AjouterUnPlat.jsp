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
	<div class="container-fluid">
		<h1>Ajout d'un plat</h1>

		<form action="<%=request.getContextPath()%>/ServletRedirigeAjoutPlats"
			method="post">
			<div class="form-group col-md-4">
				<label for="imageURL">Image <span class="text-danger">(*)</span></label>
				<input name="imageURL" type="text" class="form-control"
					id="imageURL" placeholder="entrez votre Image" required>
			</div>
			<div class="form-group col-md-4">
				<label for="nom">Nom <span class="text-danger">(*)</span></label> <input
					name="nom" type="text" class="form-control" id="nom"
					placeholder="entrez le nom du plat" required>
			</div>
			<div class="form-group col-md-4">
				<label for="cout">Prix <span class="text-danger">(*)</span></label>
				<input name="prix" type="text" class="form-control" id="prix"
					placeholder="entrez le prix du plat " required>
			</div>
			<div class="form-group col-md-4">
				<label for="presentation">Presentation <span
					class="text-danger">(*)</span></label> <input name="presentation"
					type="text" class="form-control" id="presentation"
					placeholder="entrez votre présentation" required>
			</div>
			<div class="form-group col-md-4">
				<label for="niveau">Niveau <span class="text-danger">(*)</span></label>
				<input name="niveau" type="text" class="form-control" id="niveau"
					placeholder="entrez le niveau de difficultés" required>
			</div>
			<div class="form-group col-md-4">
				<label for="cout">Cout <span class="text-danger">(*)</span></label>
				<input name="cout" type="text" class="form-control" id="cout"
					placeholder="entrez le coût du plat " required>
			</div>
			<div class="form-group col-md-4">
				<label for="nbConvive">Nombre de convive <span
					class="text-danger">(*)</span></label> <input name="nbconvive" type="text"
					class="form-control" id="nbconvive"
					placeholder="entrez le nombre de convive " required>
			</div>
			<div class="form-group col-md-4">
				<label for="listIngredient">Liste ingredient <span
					class="text-danger">(*)</span></label> <input name="listIngredient"
					type="text" class="form-control" id="listIngredient"
					placeholder="entrez la liste d'ingrédient" required>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="ml-4 col-2 text-danger">(*) : requis</div>
					<div class="col-1 offset-1">
						<input type="submit" class="btn btn-primary" />
					</div>
				</div>
			</div>
		</form>
	</div>

	<%@ include file="piedDePage.html"%>
</body>
</html>