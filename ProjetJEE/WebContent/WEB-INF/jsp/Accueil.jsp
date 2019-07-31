<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


	<div class="row">

		<div class="rounded float-left" style="margin: auto">
				<img src="image/menu-restaurant-vintage-table.jpg"
					alt="Responsive image">
		</div>
		
		<div class="rounded float-right" style="margin: auto">
				<img src="image/menu-restaurant-vintage-table.jpg"
					alt="Responsive image">
		</div>
	</div>
	<div class="row" >
				<h1  style="margin-left: 200px" class="text-center">CHEZ MICHEL NANTES</h1>
				<h1 style="margin-left: 390px" class="text-center">CHEZ MICHEL RENNES</h1>
	</div>
	<div class="row">
				<iframe style="margin-left: 210px"
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1355.1482214539606!2d-1.572658328044985!3d47.21078162845789!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4805ec0f75625621%3A0x25039af3691ae31f!2s10+Rue+Bayard%2C+44100+Nantes!5e0!3m2!1sfr!2sfr!4v1564562693953!5m2!1sfr!2sfr"
					width="400" height="300" frameborder="0"
					 allowfullscreen></iframe>
				<iframe style="margin-left: 400px"
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2664.6160651741498!2d-1.6904758845635448!3d48.09835036187155!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x480edfd09077c0b5%3A0xd18dc61b9729dfc4!2s10+Rue+de+Nantes%2C+35000+Rennes!5e0!3m2!1sfr!2sfr!4v1564562280749!5m2!1sfr!2sfr"
					width="400" height="300" frameborder="0" style="border: 0"
					allowfullscreen></iframe>
	</div>
		


		<%@ include file="piedDePage.html"%>

</body>
</html>