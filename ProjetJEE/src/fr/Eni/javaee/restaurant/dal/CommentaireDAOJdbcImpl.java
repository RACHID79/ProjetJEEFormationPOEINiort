package fr.Eni.javaee.restaurant.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bo.Commentaire;

public class CommentaireDAOJdbcImpl implements CommentaireDAO {

		// Requete SQL pour la méthod Insert
		private static final String reqSql_Insert = "INSERT INTO commentaire (id_utilisateur,note,commentaire) VALUES(?,?,?)";
		// Requete SQL pour la m�thod Insert
				private static final String reqSql_Delete = "DELETE FROM commentaire WHERE id_commentaire= ?";

	
	@Override
	public void delete(int idCommentaire) throws BusinessException {
		if (idCommentaire <= 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_AVIS_ECHEC);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_Delete);
			pstmt.setInt(1, idCommentaire);			
			pstmt.executeUpdate();

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

		
	}

	@Override
	public void insert(Commentaire commentaire) throws BusinessException {
		if (commentaire == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_Insert, PreparedStatement.RETURN_GENERATED_KEYS);

	
			pstmt.setInt(1, commentaire.getPlat().getId());
			pstmt.setInt(2, commentaire.getUtilisateur().getId());
			pstmt.setInt(3, commentaire.getNote());
			pstmt.setString(4, commentaire.getCommentaire());
			pstmt.setTimestamp(5, java.sql.Timestamp.valueOf(commentaire.getDate()));
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				commentaire.setId(rs.getInt(1));
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
		
	}

}
