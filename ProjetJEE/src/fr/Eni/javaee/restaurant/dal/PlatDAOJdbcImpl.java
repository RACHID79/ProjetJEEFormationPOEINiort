package fr.Eni.javaee.restaurant.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bo.Commentaire;
import fr.Eni.javaee.restaurant.bo.Plat;
import fr.Eni.javaee.restaurant.bo.Utilisateur;

public class PlatDAOJdbcImpl implements PlatDAO {
	// Requete SQL pour la method Insert
	private static final String reqSql_Insert = "INSERT INTO plat(prix,nom,presentation,niveau,cout,nbconvive,nbcommande,listingredient,imageurl) VALUES(?,?,?,?,?,?,?,?,?)";
	// Requete SQL pour la method reqSql_getListeCommentaireByIdPlat
	private static final String reqSql_getListeCommentaireByIdPlat = "SELECT c.id_commentaire,c.note,c.commentaire,c.date, "
			+ "		p.id_plat, p.prix, p.nom, p.presentation, p.niveau, p.cout, p.nbconvive, p.nbcommande, p.listingredient, p.imageurl,"
			+ "		u.id_utilisateur, u.nom, u.prenom, u.email,u.mdp, u.commentaire"
			+ "		FROM commentaire c "
			+ "			inner join utilisateur u on u.id_utilisateur = c.id_utilisateur "
			+ "			inner join plat p on p.id_plat = c.id_plat  " 
			+ "		WHERE c.id_plat =?";
	// Requete SQL pour la method SelectALL
	private static final String reqSql_selectAll = "SELECT id_plat,prix,nom,presentation,niveau,cout,nbconvive,nbcommande,listIngredient,imageURL FROM plat order by id_plat";
	// Requete SQL pour la method reqSql_getPlatByIdPlat
	private static final String reqSql_getPlatByIdPlat = "SELECT id_plat,prix,nom,presentation,niveau,cout,nbconvive,nbcommande,listingredient,imageurl FROM plat where id_plat=?";

	@Override
	public void insert(Plat plat) throws BusinessException {
		if (plat == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_Insert, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setFloat(1, plat.getPrix());
			pstmt.setString(2, plat.getNom());
			pstmt.setString(3, plat.getPresentation());
			pstmt.setString(4, plat.getNiveau());
			pstmt.setString(5, plat.getCout());
			pstmt.setInt(6, plat.getNbConvive());
			pstmt.setInt(7, 0);
			pstmt.setString(8, plat.getListIngredient());
			pstmt.setString(9, plat.getImageURL());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				plat.setId(rs.getInt(1));
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

	@Override
	public List<Plat> selectAll() throws BusinessException {
		List<Plat> listePlats = new ArrayList<Plat>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_selectAll);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				listePlats.add(new Plat(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7),rs.getInt(8), rs.getString(9), rs.getString(10)));
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

		return listePlats;
	}

	@Override
	public List<Commentaire> getListeCommentaireByIdPlat(int idPlat) throws BusinessException {
		List<Commentaire> listeCommentaires = new ArrayList<Commentaire>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_getListeCommentaireByIdPlat);
			pstmt.setInt(1, idPlat);
			ResultSet rs = pstmt.executeQuery();
			Plat newPlat = null;
			while (rs.next()) {
				
	/*			private static final String reqSql_getListeCommentaireByIdPlat = "SELECT c.id_commentaire,c.note,c.commentaire,c.date, "
						+ "		p.id_plat, p.prix, p.nom, p.presentation, p.niveau, p.cout, p.nbconvive, p.nbcommande, p.listingredient, p.imageurl,"
						+ "		u.id_utilisateur, u.nom, u.prenom, u.email, u.commentaire" + "	" + "		"
						+ "		FROM commentaire c "
						+ "			inner join utilisateur u on u.id_utilisateur = c.id_utilisateur "
						+ "			inner join plat p on p.id_plat = c.id_plat  " + "	" + "		WHERE c.id_plat =?";*/
				
				
				if (newPlat == null) {
					newPlat = new Plat(rs.getInt(5), rs.getFloat(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getInt(11),rs.getInt(12), rs.getString(13), rs.getString(14));
					System.out.println("newPlat pour l'id " + idPlat + " : \n" + newPlat.toString());
				}
				Utilisateur newUtilisateur = new Utilisateur(rs.getInt(15), rs.getString(16), rs.getString(17),
						rs.getString(18), rs.getString(19),rs.getString(20));
				System.out.println(
						"newUtilisateur du commentaire pour l'id plat " + idPlat + " : \n" + newUtilisateur.toString());
				listeCommentaires.add(new Commentaire(rs.getInt(1), rs.getInt(2), rs.getString(3), newUtilisateur,
						newPlat, rs.getTimestamp(4).toLocalDateTime()));
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
		System.out.println("Liste des commentaires pour l'id " + idPlat + " : \n" + listeCommentaires.toString());
		return listeCommentaires;
	}

	@Override
	public Plat getPlatById(int idPlat) throws BusinessException {
		Plat plat = new Plat();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_getPlatByIdPlat);
			pstmt.setInt(1, idPlat);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				plat = new Plat(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7),rs.getInt(8), rs.getString(9), rs.getString(10));
				System.out.println(rs.getInt(1));
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

		System.out.println("Retour BDD " + plat.toString());
		return plat;
	}

}
