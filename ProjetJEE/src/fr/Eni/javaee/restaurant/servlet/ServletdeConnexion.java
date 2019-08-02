package fr.Eni.javaee.restaurant.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletdeConnexion")
public class ServletdeConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int tentative = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletdeConnexion() {
		super();

	}

	@Override
	public void init() throws ServletException {
		tentative = 0;
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Connexion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mailAsString = request.getParameter("mail");
		String mot_de_passeAsString = request.getParameter("mot_de_passe");
		// String exemple;

		UtilisateurManager utilisateurmanager = new UtilisateurManager();

		try {
			int idUtilisateur = -1;
			idUtilisateur = utilisateurmanager.getUtilisateur(mailAsString, mot_de_passeAsString);
			System.out.println(mailAsString);
			if (idUtilisateur == -1) {
				String error = null;
				// il ya erreur
				error = "il y a une erreur";
				request.setAttribute("error", error);
				tentative++;

				if (tentative == 3) {
					tentative = 0;

					RequestDispatcher rd = request.getRequestDispatcher("/ServletInscription");

					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Connexion.jsp");
					rd.forward(request, response);
				}
				;

				// erreur
			} else {

				// ok
				try {

					// Création ou récuperation de session
					HttpSession session = request.getSession();
					// Mise en session d'une chaîne de caractère
					Utilisateur utilisateur = utilisateurmanager.selectUtilisateurByIdUtilisateur(idUtilisateur);
					session.setAttribute("utilisateur", utilisateur);
					session.setMaxInactiveInterval(10 * 60);

				} catch (BusinessException e) {

					e.printStackTrace();
				}

				RequestDispatcher rd = request.getRequestDispatcher("/RedirigeAccueil");

				rd.forward(request, response);
			}

		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

}
