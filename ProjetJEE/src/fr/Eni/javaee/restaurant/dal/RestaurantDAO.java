package fr.Eni.javaee.restaurant.dal;

import java.util.List;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bo.Restaurant;

public interface RestaurantDAO {

	
	public List<Restaurant> SelectAll() throws BusinessException;
}
