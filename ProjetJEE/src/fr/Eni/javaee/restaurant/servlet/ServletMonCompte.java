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
 * Servlet implementation class ServletMonCompte
 */
@WebServlet("/ServletMonCompte")
public class ServletMonCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMonCompte() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("utilisateur") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/MonCompte.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/RedirigeAccueil");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("Mail");
		String ancienMotDePasse = request.getParameter("AncienMotdePasse");
		String nouveauMotDePasse = request.getParameter("NouveauMotdePasse");
		String confirmationMotDePasse = request.getParameter("confirmationNouveauMotdePasse");
		System.out.println(email + " " + ancienMotDePasse + " " + nouveauMotDePasse + " " + confirmationMotDePasse);
		HttpSession session = request.getSession();

		Utilisateur oldUtilisateur = (Utilisateur) session.getAttribute("utilisateur");
		Utilisateur newUtilisateur = (Utilisateur) session.getAttribute("utilisateur");
		System.out.println(oldUtilisateur.getEmail() + " " + oldUtilisateur.getMdp());
		if (oldUtilisateur != null) {
			if (email != null && !email.isEmpty() && !email.equals(oldUtilisateur.getEmail())) {
				newUtilisateur.setEmail(email);
				System.out.println("Changement de l'email ");
			}

			if (ancienMotDePasse != null && !ancienMotDePasse.isEmpty()
					&& ancienMotDePasse.equals(oldUtilisateur.getMdp())) {
				System.out.println("ancien mdp OK");
				if (nouveauMotDePasse != null && !nouveauMotDePasse.isEmpty() && confirmationMotDePasse != null
						&& !confirmationMotDePasse.isEmpty() && confirmationMotDePasse.equals(nouveauMotDePasse)
						&& !confirmationMotDePasse.equals(ancienMotDePasse)) {
					System.out.println("Changement du password ");
					newUtilisateur.setMdp(nouveauMotDePasse);
				}
			}
			System.out.println("oldutilisateur : " + oldUtilisateur.getEmail() + " - " + oldUtilisateur.getMdp());
			System.out.println("newUtilisateur : " + newUtilisateur.getEmail() + " - " + newUtilisateur.getMdp());
			// if (!oldUtilisateur.equals(newUtilisateur)) {

			try {
				System.out.println("Mise à jour de l'utilisateur");
				UtilisateurManager um = new UtilisateurManager();
				um.update(newUtilisateur);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// }

		}

		doGet(request, response);
	}

}
