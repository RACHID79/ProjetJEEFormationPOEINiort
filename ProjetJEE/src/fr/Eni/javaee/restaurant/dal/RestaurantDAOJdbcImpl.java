package fr.Eni.javaee.restaurant.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bo.Restaurant;

public class RestaurantDAOJdbcImpl implements RestaurantDAO {
	// Requete SQL pour la method SelectALL
		private static final String reqSql_selectAll = "SELECT id_restaurant,nom,map_url,url_image FROM restaurant order by id_restaurant";
		
	@Override
	public List<Restaurant> SelectAll() throws BusinessException{
			List<Restaurant> listeRestaurants = new ArrayList<Restaurant>();

			try (Connection cnx = ConnectionProvider.getConnection()) {
				PreparedStatement pstmt = cnx.prepareStatement(reqSql_selectAll);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					listeRestaurants.add(new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				}
			} catch (Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				if (e.getMessage().contains("CK_AVIS_note")) {
					businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
				} else {
					businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
				}
				throw businessException;
			}

		return listeRestaurants;
	}

}
