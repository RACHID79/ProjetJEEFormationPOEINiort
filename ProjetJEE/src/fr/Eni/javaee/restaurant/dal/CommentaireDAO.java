package fr.Eni.javaee.restaurant.dal;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bo.Commentaire;

public interface CommentaireDAO {

	public void delete(int idCommentaire)  throws BusinessException ;

	public void insert(Commentaire commentaire) throws BusinessException ;

}
