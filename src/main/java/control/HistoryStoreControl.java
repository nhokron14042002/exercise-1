package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.lichsubo;
import entity.Account;
import entity.HistoryStore;


/**
 * Servlet implementation class HistoryStore
 */
@WebServlet("/HistoryStoreControl")
public class HistoryStoreControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryStoreControl() {
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
		Account user = (Account) session.getAttribute("acc");
		if ( user == null) {
			response.sendRedirect("Logincontrol");
		} else {		
			int makh = user.getId();
			
			lichsubo lbo = new lichsubo();
			ArrayList<HistoryStore> dsls = lbo.getlichsu(makh);
			if ( dsls != null) {
				request.setAttribute("dsls", dsls);
			}
			RequestDispatcher rd= request.getRequestDispatcher("lichsu.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
