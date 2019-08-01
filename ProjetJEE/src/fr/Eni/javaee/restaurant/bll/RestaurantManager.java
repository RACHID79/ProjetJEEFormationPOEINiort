package fr.Eni.javaee.restaurant.bll;

import java.util.ArrayList;
import java.util.List;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bo.Restaurant;
import fr.Eni.javaee.restaurant.dal.DAOFactory;
import fr.Eni.javaee.restaurant.dal.RestaurantDAO;

public class RestaurantManager{
	private RestaurantDAO restaurantDAO;
	
	
	public RestaurantManager() {
		this.restaurantDAO = DAOFactory.getRestaurantDAO();
	}
		
	public List<Restaurant> SelectAll() throws BusinessException {
		List<Restaurant> listeRestaurants = new ArrayList<Restaurant>();
		listeRestaurants = restaurantDAO.SelectAll();
		System.out.println("Liste des restaurant : "+listeRestaurants.toString());
		return listeRestaurants;	
	}

}
