package fr.Eni.javaee.restaurant.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bll.CommentaireManager;
import fr.Eni.javaee.restaurant.bll.PlatManager;
import fr.Eni.javaee.restaurant.bo.Plat;
import fr.Eni.javaee.restaurant.bo.Utilisateur;

/**
 * Servlet implementation class NosPlats
 */
@WebServlet("/NosPlats")
public class NosPlats extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PlatManager platManager = new PlatManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NosPlats() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Plat> listePlat = new ArrayList<Plat>();
		HttpSession session = request.getSession();
		try {
			listePlat = platManager.SelectPlats();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!listePlat.isEmpty()) {
			System.out.println(listePlat.toString());
			request.setAttribute("listePlat", listePlat);
		}

		Utilisateur utilisateur = null;
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		String isAdmin = "0";
		if (utilisateur != null) {
			isAdmin = "1";

		}
		request.setAttribute("isAdmin", isAdmin);
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("NosPlatsJSP");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCommentaire = 0;
		idCommentaire = Integer.parseInt(request.getParameter("idCommentaire"));
		System.err.println("Demande de suppression  de l'id commentaire : " + idCommentaire);
		if (idCommentaire > 0) {

			HttpSession session = request.getSession();
			Utilisateur utilisateur = null;
			utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			Boolean isAdmin = false;
			if (utilisateur != null) {
				List<String> listRoles = utilisateur.getRoles();
				if (listRoles != null && listRoles.size() > 0) {
					for (String role : utilisateur.getRoles()) {
						if (role.equals("admin")) {
							isAdmin = true;
						}
					}
				}
			}
			if (isAdmin) {
				CommentaireManager cm = new CommentaireManager();
				try {
					cm.delete(idCommentaire);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		doGet(request, response);
	}

}
