package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Account;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class ManagerControl
 */
@WebServlet("/ManagerControl")
public class ManagerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Account a =(Account)session.getAttribute("acc");
		int id = a.getId();
		
		DAO dao = new DAO();
		List<Product> list = dao.getProductBySellID(id);
		List<Category> listC = dao.getAllCategory();
		 
		request.setAttribute("listCC", listC);
		request.setAttribute("listcid", list);
		request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
