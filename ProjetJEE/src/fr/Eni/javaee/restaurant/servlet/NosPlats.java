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

import fr.Eni.javaee.restaurant.BusinessException;
import fr.Eni.javaee.restaurant.bll.PlatManager;
import fr.Eni.javaee.restaurant.bo.Plat;

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
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("NosPlatsJSP");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
