package fr.Eni.javaee.restaurant.dal;

public abstract class DAOFactory {

	public static PlatDAO getPlatDAO() {
		return new PlatDAOJdbcImpl();
	}

	public static CommentaireDAO getCommentaireDAO() {
		return new CommentaireDAOJdbcImpl();
	}

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}

}
