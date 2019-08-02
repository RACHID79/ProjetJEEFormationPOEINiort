<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,java.util.List"%>
<%@ page import="fr.Eni.javaee.restaurant.bll.RestaurantManager"%>
<%@ page import="fr.Eni.javaee.restaurant.bo.Restaurant"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>RESTAURANT</title>
<!-- <style type="text/css"> -->
<!-- body { -->
<!-- background : url(image/menu-restaurant-vintage-table.jpg)  -->

<!-- })</style> -->


</head>
<body>

	<%@ include file="entete.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-10 offset-1">
				<div class="row">
					<%
						RestaurantManager RestaurantManager = new RestaurantManager();
						List<Restaurant> listeResto = new ArrayList<Restaurant>();
						listeResto = (List<Restaurant>) request.getAttribute("listeResto");

						Boolean isActif = true;
						for (Restaurant restaurant : listeResto) {
					%>
					<div id="restaurant<%=restaurant.getId()%>" class="col-xs-12 col-lg-6 mb-4">
						<div class="row">
							<div class="col-md-10">
								<img src="<%=request.getContextPath()%>/image/<%=restaurant.getImageURL()%>"
									width="500" height="380" alt="Responsive image">
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<h1><%=restaurant.getNom()%></h1>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 align-center">
								<iframe
									src="<%=restaurant.getMapURL()%>"
									 frameborder="0" allowfullscreen></iframe>
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






	<%@ include file="piedDePage.html"%>

</body>
</html>