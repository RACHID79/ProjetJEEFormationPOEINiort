package fr.Eni.javaee.restaurant.bll;

import java.util.List;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bo.Commentaire;
import fr.Eni.javaee.restaurant.bo.Utilisateur;
import fr.Eni.javaee.restaurant.dal.DAOFactory;
import fr.Eni.javaee.restaurant.dal.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public void insert(Utilisateur utilisateur) throws BusinessException {
		utilisateurDAO.insert(utilisateur);
	}

	public Utilisateur selectUtilisateurByIdUtilisateur(int idUtilisateur) throws BusinessException {
		return utilisateurDAO.selectUtilisateurById(idUtilisateur);
	}

	public List<Commentaire> selectUtilisateurByIdCommentaire(int idCommentaire) throws BusinessException {
		return utilisateurDAO.getCommentairesByIdUtilisateur(idCommentaire);
	}

	public int getUtilisateur(String mail, String password) throws BusinessException
	{
		int idUtilisateur = -1;
		idUtilisateur = utilisateurDAO.getIdUtilisateurByMailPassword(mail, password) == 0 ? idUtilisateur
				: utilisateurDAO.getIdUtilisateurByMailPassword(mail, password);
		return idUtilisateur;
	}

	public Utilisateur insert(String email, String motDePasse, String confirmation, String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}
}
