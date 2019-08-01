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

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	// Requete SQL pour la m�thod Insert
	private static final String reqSql_Insert = "INSERT INTO utilisateur(nom,prenom,email,mdp,commentaire) VALUES(?,?,?,?,?)";
	// Requete SQL pour la m�thod reqSql_gteIdUtilisateurByMailPassword
	private static final String reqSql_getIdUtilisateurByMailPassword = "SELECT id_utilisateur FROM utilisateur where email=? AND mdp=?";
	// Requete SQL pour la m�thod reqSql_gteIdUtilisateurByMailPassword
	private static final String reqSql_selectUtilisateurById = "SELECT id_utilisateur,nom,prenom,email,commentaire FROM utilisateur where id_utilisateur=?";
	// Requete SQL pour la m�thod reqSql_gteIdUtilisateurByMailPassword
	private static final String reqSql_selectCommentaireByIdUtilisateur = "SELECT id_utilisateur,nom,prenom,email,commentaire FROM utilisateur where id_utilisateur=?";
	// Requete SQL pour la m�thod reqSql_selectRolesByIdUtilisateur
	private static final String reqSql_selectRolesByIdUtilisateur = "SELECT code_role FROM role_utilisateur WHERE id_utilisateur = ?";

	@Override
	public void selectRolesByIdUtilisateur(Utilisateur utilisateur) throws BusinessException {
		List<String> listRoles= new ArrayList<String>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_selectRolesByIdUtilisateur);
			pstmt.setInt(1, utilisateur.getId());
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				listRoles.add(rs.getString(1));
			}
			System.out.println("Retour BDD des roles" + listRoles.toString());
			utilisateur.setRoles(listRoles);
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
	public Utilisateur selectUtilisateurById(int idUtilisateur) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_selectUtilisateurById);
			pstmt.setInt(1, idUtilisateur);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				utilisateur = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
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

		System.out.println("Retour BDD " + utilisateur.toString());
		selectRolesByIdUtilisateur(utilisateur);
		return utilisateur;
	}

	@Override
	public void insert(Utilisateur utilisateur) throws BusinessException {
		if (utilisateur == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_Insert, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, utilisateur.getNom());
			pstmt.setString(2, utilisateur.getPrenom());
			pstmt.setString(3, utilisateur.getEmail());
			pstmt.setString(4, utilisateur.getMdp());
			pstmt.setString(5, utilisateur.getCommentaire());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setId(rs.getInt(1));
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
	public List<Commentaire> getCommentairesByIdUtilisateur(int idUtilisateur) throws BusinessException {
		List<Commentaire> listCommentaire = new ArrayList<Commentaire>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_selectCommentaireByIdUtilisateur);
			pstmt.setInt(1, idUtilisateur);
			ResultSet rs = pstmt.executeQuery();
			Plat newPlat = null;

			while (rs.next()) {
				if (newPlat == null) {
					newPlat = new Plat(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getInt(7),rs.getInt(8), rs.getString(9), rs.getString(10));
					System.out.println("newPlat pour l'id utilisateur " + idUtilisateur + " : \n" + newPlat.toString());
				}
				Utilisateur newUtilisateur = new Utilisateur(rs.getInt(14), rs.getString(15), rs.getString(16),
						rs.getString(17), rs.getString(18));
				System.out.println("newUtilisateur du commentaire pour l'id utilisateur " + idUtilisateur + " : \n"
						+ newUtilisateur.toString());
				listCommentaire.add(new Commentaire(rs.getInt(1), rs.getInt(2), rs.getString(3), newUtilisateur,
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

		System.out.println("Retour BDD " + listCommentaire.toString());
		return listCommentaire;
	}

	@Override
	public int getIdUtilisateurByMailPassword(String mail, String password) throws BusinessException {
		int IdUtilisateur = -1;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_getIdUtilisateurByMailPassword);
			pstmt.setString(1, mail);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				IdUtilisateur = rs.getInt(1);
				System.out.println("Id de l'utilisateur trouvé en BDD : " + rs.getInt(1));
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

		return IdUtilisateur;

	}

}
