package fr.Eni.javaee.restaurant.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bll.UtilisateurManager;
import fr.Eni.javaee.restaurant.bo.Utilisateur;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/Inscription.jsp";
	public static final String REDIRECTION = "/RedirigeAccueil";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_PASS = "motdepasse";
	public static final String CHAMP_CONF = "confirmation";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM = "prenom";
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();

		/* Récupération des champs du formulaire. */
		String email = request.getParameter(CHAMP_EMAIL);
		String motDePasse = request.getParameter(CHAMP_PASS);
		String confirmation = request.getParameter(CHAMP_CONF);
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);

		// Début de la transaction avec la base de données
		System.out.println(email);
		/* Validation du champ email. */
		try {
			System.out.println("try validationEmail");
			validationEmail(email);

		} catch (Exception e) {
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}

		/* Validation des champs mot de passe et confirmation. */
		try {
			System.out.println("try validationMotsDePasse");
			validationMotsDePasse(motDePasse, confirmation);
		} catch (Exception e) {
			erreurs.put(CHAMP_PASS, e.getMessage());
		}
		System.out.println(erreurs.toString());

		System.out.println(erreurs.isEmpty());
		/* Initialisation du résultat global de la validation. */
		if (erreurs.isEmpty()) {
			UtilisateurManager um = new UtilisateurManager();
			Utilisateur utilisateur = null;
			try {
				utilisateur = new Utilisateur(nom, prenom, email, motDePasse, null);
				um.insert(utilisateur);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultat = "Succès de l'inscription.";

			// Création ou récuperation de session
			HttpSession session = request.getSession();
			// Mise en session d'une chaîne de caractère
			session.setAttribute("utilisateur", utilisateur);

			session.setMaxInactiveInterval(10 * 60);

		} else {
			resultat = "Échec de l'inscription.";
		}

		/* Stockage du résultat et des messages d'erreur dans l'objet request */
		request.setAttribute(ATT_ERREURS, erreurs);
		request.setAttribute(ATT_RESULTAT, resultat);

		/* Transmission de la paire d'objets request/response à notre JSP */
		this.getServletContext().getRequestDispatcher(REDIRECTION).forward(request, response);
	}

	/**
	 * Valide l'adresse mail saisie.
	 */
	private void validationEmail(String email) throws Exception {
		if (email != null && email.trim().length() != 0) {
			if (false /* !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)") */) {
				throw new Exception("Merci de saisir une adresse mail valide.");
			}
		} else {
			throw new Exception("Merci de saisir une adresse mail.");
		}
	}

	/**
	 * Valide les mots de passe saisis.
	 */
	private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
		if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null
				&& confirmation.trim().length() != 0) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}

}
