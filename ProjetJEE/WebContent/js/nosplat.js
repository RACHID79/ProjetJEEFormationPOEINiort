let idAffiche = -1;

function AfficherDetail(idPlat) {
    $.getJSON("rest/plats/" + idPlat, function(data) {
        $("#noteAvg").empty();
        $("#nbCommande").empty();
        $("#nomPlat").empty();
        $("#CommentaireCarousel").empty();
        if (idAffiche != -1) {
            $("#PlatCarousel").empty();
            $("#CommentaireCarousel").empty();
        }
        if (data.id != 0 && idAffiche != data.id) {
            $("#PlatCarousel").empty();
            idAffiche = data.id;
            ajouterBaliseDetailPlat(data);
            AfficherCommentaire(idPlat);
            AfficherFormNewCom(idPlat);

        } else {
            idAffiche = -1;
        }
    });
}

function AfficherFormNewCom(idPlat) {

    var FormNewCom = '<form name="FormNewCom" action="">' +
        ';<input type="texte" id="commentaire" name="commentaire">' +
        ';<input type="number" max="5" id="note" name="note">' +
        '<input type="button" name="bouton" value="Valider" onclick="ajouterCommentaire(this.form)">' +
        '</form>;'

}

function ajouterCommentaire(commentaire) {
    $.ajax({
        url: '/ServletMonCompte',
        data: {
            newCommentaire: commentaire.commentaire.value,
            newNote: commentaire.note.value,
            idUtilisateur: $('#idUtilisateur').val(),
            idPlat: $('#idPlat').val(),

        },
        success: function(responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        }
    });
}

function AfficherCommentaire(idPlat) {
    $.getJSON("rest/plats/" + idPlat + "/commentaire", function(data) {

        if (data.length > 0) {
            ajouterBaliseCom(data);
        }
    });
}

function ajouterBaliseDetailPlat(data) {
    var listIngredientHTML = "";
    var listIngredientTab = data.listIngredient.split('&&');

    for (var i = 0; i < listIngredientTab.length; i++) {
        listIngredientHTML = listIngredientHTML + '	<div class="col-12">' +
            listIngredientTab[i] + '</div>';
    }

    var newContent = '<div class="col-md-12 note" id="card' + data.id + '">' +
        '	<div class="card">' + '	<div class="card-header">' + '	<h3><u>' +
        data.nom + '</u></h3>' + '	<div class="col-12">' +
        data.presentation + '</div>' + '	<div class="col-10">Niveau ' +
        data.niveau + ' et ' + data.cout + '. Pour ' + data.nbConvive +
        ' personnes.</div>' + '	<p><u>Prix restaurant : ' + data.prix +
        ' euros</u></p>' + '	</div>' + '	<div class="card-body">' +
        listIngredientHTML + '	</div>' + '	<div class="card-footer">' +
        '	</div>' + '	</div>' + '</div>';
    $("#PlatCarousel").append(newContent);
    $("#nomPlat").empty();
    $("#nomPlat").append(data.nom);
    $("#nbCommande").empty();
    $("#nbCommande").append(data.nbCommande + ' fois command&eacute;');

    var formNewCom = '	<form id="newCom">' +
        ' Note (0 à 5): <input type="number" max="5" id="note" value="0"/>' +
        ' Commentaire: <input type="text" id="commentaire" />' +
        '</form>';
    $("#divNewCom").empty();
    $("#divNewCom").append(formNewCom);

}

function ajouterBaliseCom(data) {
    var newCommentairecontent = '';
    var sumNote = 0;
    for (var j = 0; j < data.length; j++) {
        sumNote += data[j].note;
        var date = new Date(Date.UTC(data[j].date.year,
            data[j].date.monthValue, data[j].date.dayOfMonth,
            data[j].date.hour, data[j].date.minute, data[j].date.second));
        options = {
            year: "numeric",
            month: "numeric",
            day: "numeric",
            hour: "numeric",
            minute: "numeric",
            second: "numeric",
            hour12: false
        };
        var dateCommentaire = new Intl.DateTimeFormat('fr-FR', options)
            .format(date);

        $("#card-footer").empty();


        lienDelete = '<a href="#" onclick="supprimerCommentaire(' +
            data[j].id + '); return false;">' + txtLienDelete + '</a>';


        var newCommentairecontent = newCommentairecontent +
            '	<div class="col-md-5 offset-md-1 mb-2"><div class=" note" id="card' +
            data[j].id +
            '">' +
            '	<div class="rounded border border-info card">' +
            '	<div class="card-header ">' +
            '	<div class="row">' +
            '	<div class="col-4">By : ' +
            data[j].utilisateur.nom +
            '</div>' +
            '	<div class="col-2 offset-1"> Note : ' +
            data[j].note +
            '/5</div>' +
            '	<div class="col-4 offset-1">' +
            dateCommentaire +
            '</div>' +
            '	</div></div>' +
            '	<div class="card-body">' +
            data[j].commentaire +
            '	</div>' +
            '	<div class="card-footer id="card-footer">' + lienDelete + '	</div>' +
            '	</div>' + '</div>	</div>';
    }

    var newCommentairecontent = newCommentairecontent + '</div>';
    let avg = Math.round(100*sumNote / data.length)/100;
    $("#noteAvg").append('Note moyenne : ' + avg + '/5');
    $("#CommentaireCarousel").append(newCommentairecontent);
    $("#card-footer").append(lienDelete);

}

function supprimerCommentaire(idCommentaire) {
    var form = $('<form></form>');

    form.attr("method", "post");
    form.attr("action", "NosPlats");

    var field = $('<input></input>');

    field.attr("type", "hidden");
    field.attr("name", "idCommentaire");
    field.attr("value", idCommentaire);

    form.append(field);

    $(document.body).append(form);
    form.submit();

}