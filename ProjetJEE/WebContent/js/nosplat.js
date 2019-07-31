	let idAffiche = -1;
		function AfficherDetail(idPlat) {			
			$.getJSON("rest/plats/"+idPlat, function(data){
				$("#noteAvg").empty();
				$("#nbCommande").empty();
				$("#nomPlat").empty();
				$("#CommentaireCarousel").empty();
				if(idAffiche != -1)
					{
						$("#PlatCarousel").empty();
						$("#CommentaireCarousel").empty();
					}
				if(data.id != 0 && idAffiche != data.id)
					{
						$("#PlatCarousel").empty();
						idAffiche = data.id;
						ajouterBaliseDetailPlat(data);
						AfficherCommentaire(idPlat);
					}
				else
					{
					idAffiche = -1;
					}
			});
			}
		
		function AfficherCommentaire(idPlat)
		{
			$.getJSON("rest/plats/"+idPlat+"/commentaire", function(data){
				
				if(data.length > 0 )
					{					
						ajouterBaliseCom(data);
					}
			});
		}
		
		function ajouterBaliseDetailPlat(data) {
			var listIngredientHTML = "";
			var listIngredientTab = data.listIngredient.split('&&');
	

		    for(var i=0;i<listIngredientTab.length;i++)
		    	{
		    	listIngredientHTML = listIngredientHTML + '	<div class="col-12">'  +listIngredientTab[i] + '</div>';
		    	}
		   
			
			
			var newContent = '<div class="col-md-12 note" id="card' + data.id + '">' +
			'	<div class="card">' +
			'	<div class="card-header">' +
			'	<h3><u>' + data.nom + '</u></h3>' +
			'	<div class="col-12">'  + data.presentation + '</div>' +
			'	<div class="col-10">Niveau '  + data.niveau + ' et '+data.cout + '. Pour '  + data.nbConvive + ' personnes.</div>' +
			'	<p><u>Prix restaurant : ' + data.prix +' euros</u></p>' +
			'	</div>' +
			'	<div class="card-body">' +
				listIngredientHTML +
			'	</div>' +
			'	<div class="card-footer">' +
			'	</div>' +
			'	</div>' +
			'</div>';
			$("#PlatCarousel").append(newContent);
			   $("#nomPlat").empty();
			   $("#nomPlat").append(data.nom);
			   $("#nbCommande").empty();
			   $("#nbCommande").append(data.nbCommande+ ' fois command&eacute;');
			
			
			}
		
		
		function ajouterBaliseCom(data) {
			var newCommentairecontent = '';
			var sumNote = 0;
			   for(var j=0;j<data.length;j++)
		    	{
				   sumNote += data[j].note;	
				   var dateCommentaire = data[j].date.dayOfMonth+'/'+data[j].date.monthValue+'/'+data[j].date.year+' '+data[j].date.hour+':'+data[j].date.minute;
					   var newCommentairecontent = newCommentairecontent+'	<div class="col-md-5 offset-md-1 mb-2"><div class=" note" id="card' + data[j].id + '">' +
					'	<div class="card">' +
					'	<div class="card-header  bg-info">' +
					'	<div class="row">'+
					'	<div class="col-2">By : ' + data[j].utilisateur.nom + '</div>' +
					'	<div class="col-2 offset-3"> Note : '  + data[j].note + '/5</div>' +
					'	<div class="col-3 offset-2">'  + dateCommentaire + '</div>' +
					'	</div></div>' +
					'	<div class="card-body">' +
					data[j].commentaire +
					'	</div>' +
					'	<div class="card-footer">' +
					'	</div>' +
					'	</div>' +
					'</div>	</div>';
		    	}
			   
			   
			   var newCommentairecontent =  newCommentairecontent+'</div>';
			   let avg = sumNote/data.length;
			   $("#noteAvg").append('Note moyenne : '+avg+'/5');
				$("#CommentaireCarousel").append(newCommentairecontent);

			   
			}