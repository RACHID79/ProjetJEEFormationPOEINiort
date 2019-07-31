package fr.Eni.javaee.restaurant.dal;

import java.util.List;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bo.Commentaire;
import fr.Eni.javaee.restaurant.bo.Plat;


public interface PlatDAO {

	
	
	public void insert(Plat plat) throws BusinessException ;

	public List<Plat> selectAll() throws BusinessException ;
	
	public List<Commentaire> getListeCommentaireByIdPlat(int idPlat) throws BusinessException;

	public Plat getPlatById(int idPlat) throws BusinessException;


}
