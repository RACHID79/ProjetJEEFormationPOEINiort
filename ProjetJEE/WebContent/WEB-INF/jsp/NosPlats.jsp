<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,java.util.List"%>
<%@ page import="fr.Eni.javaee.restaurant.bll.PlatManager"%>
<%@ page import="fr.Eni.javaee.restaurant.bo.Plat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nos plats</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>
	<%@ include file="entete.jsp"%>
	<div class="container-fluid mt-4 ">
		<div class="row">
			<div class="col-md-5 offset-md-1">
				<div class="mb-4">
					<div id="carouselExampleIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleIndicators" data-slide-to="0"
								class="active"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<%
								PlatManager platManager = new PlatManager();
								List<Plat> listePlat = new ArrayList<Plat>();
								listePlat = (List<Plat>) request.getAttribute("listePlat");

								Boolean isActif = true;
								for (Plat plat : listePlat) {
							%><div id="<%=plat.getId()%>"
								class="carousel-item <%if (isActif) {
					isActif = false;%>active<%}%>"
								onclick="AfficherDetail(<%=plat.getId()%>)">
								<img class="d-block w-100"
									src="<%=request.getContextPath()%>/image/<%=plat.getImageURL()%>"
									alt="<%=plat.getNom()%>">
								<div class="carousel-caption d-none d-md-block">
									<h5><%=plat.getNom()%></h5>
								</div>
							</div>


							<%
								}
							%>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleIndicators"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next"
							href="#carouselExampleIndicators" role="button" data-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
				</div>

			</div>
			<div class="col-md-5">
				<div id="PlatCarousel"></div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-10 offset-1">
				<div class="row mt-4 mb-4 ">
					<div class="col-md-2 offset-md-1 bg-light" id="noteAvg"></div>
					<div class="col-md-4  bg-light" id="nomPlat"></div>
					<div class="col-md-3  bg-light"></div>
					<div class="col-md-2  bg-light" id="nbCommande"></div>
				</div>
			</div>
			<div class="col-md-10 offset-1">
				<div class="row" id="CommentaireCarousel"></div>
			</div>
		</div>
	</div>
	<%
		String reqIsAdmin = (String) request.getAttribute("isAdmin");
		if (reqIsAdmin != null && reqIsAdmin.equals("1")) {
	%>
	<script type="text/javascript">
    var txtLienDelete = 'Delete';
	</script>

	<%
		} else {
	%>
	<script type="text/javascript">
    var txtLienDelete = '';
	</script>
	<%
		}
	%>




	<script src="jquery/jquery.min.js" type="text/javascript"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous" type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/nosplat.js"
		type="text/javascript"></script>

</body>
</html>