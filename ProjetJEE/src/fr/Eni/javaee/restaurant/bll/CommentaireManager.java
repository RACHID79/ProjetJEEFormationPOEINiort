package fr.Eni.javaee.restaurant.bll;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bo.Commentaire;
import fr.Eni.javaee.restaurant.dal.CommentaireDAO;
import fr.Eni.javaee.restaurant.dal.DAOFactory;

public class CommentaireManager {
	private CommentaireDAO commentaireDAO;



	public CommentaireManager() {
		this.commentaireDAO = DAOFactory.getCommentaireDAO();
	}
	
	
	public void insert(Commentaire commentaire) throws BusinessException {
		commentaireDAO.insert(commentaire);
	}
	
	public void delete(int idCommentaire) throws BusinessException {
		commentaireDAO.delete(idCommentaire);
	}
		



}
