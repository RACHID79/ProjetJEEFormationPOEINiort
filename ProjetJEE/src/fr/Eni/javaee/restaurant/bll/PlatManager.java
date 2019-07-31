package fr.Eni.javaee.restaurant.bll;

import java.util.ArrayList;
import java.util.List;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bo.Commentaire;
import fr.Eni.javaee.restaurant.bo.Plat;
import fr.Eni.javaee.restaurant.dal.DAOFactory;
import fr.Eni.javaee.restaurant.dal.PlatDAO;

public class PlatManager {

	private PlatDAO platDAO;
	private UtilisateurManager utilisateurManager = new UtilisateurManager();

	public PlatManager() {
		this.platDAO = DAOFactory.getPlatDAO();
	}

	public void insert(Plat plat) throws BusinessException {
		platDAO.insert(plat);

	}

	public Plat SelectPlatByIdPlat(int idPlat) throws BusinessException {
		Plat plat;
		plat = platDAO.getPlatById(idPlat);
		System.out.println("Plat manager " + plat.toString());
		return plat;
	}

	public List<Plat> SelectPlats() throws BusinessException {
		List<Plat> listePlats = new ArrayList<Plat>();
		listePlats = platDAO.selectAll();
		System.out.println(listePlats.toString());
		return listePlats;

	}

	public List<Commentaire> selectCommentaireByIdPlat(int idPlat) throws BusinessException {
		List<Commentaire> listeCommentaire = new ArrayList<Commentaire>();
		listeCommentaire = platDAO.getListeCommentaireByIdPlat(idPlat);
		return listeCommentaire;
	}

}
