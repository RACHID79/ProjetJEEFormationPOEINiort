package fr.Eni.javaee.restaurant.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bll.PlatManager;
import fr.Eni.javaee.restaurant.bo.Commentaire;
import fr.Eni.javaee.restaurant.bo.Plat;

@Path("/plats")
public class GestionPlats {
	PlatManager platManager = new PlatManager();

	@GET
	public List<Plat> getPlats() throws BusinessException {
		return platManager.SelectPlats();
	}

	@GET
	@Path("/{id : \\d+}")
	public Plat getFullPlatById(@PathParam("id") int idPlat) throws BusinessException {
		Plat plat = null;
		plat = platManager.SelectPlatByIdPlat(idPlat);
		return plat;
	}

	@GET
	@Path("/{id : \\d+}/commentaire")
	public List<Commentaire> getCommentaireByIdPlat(@PathParam("id") int idPlat) throws BusinessException {
		List<Commentaire> listCommentaire = new ArrayList<Commentaire>();
		listCommentaire = platManager.selectCommentaireByIdPlat(idPlat);
		return listCommentaire;
	}

}
