package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Account;

/**
 * Servlet implementation class SignupControl
 */
@WebServlet("/SignupControl")
public class SignupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");
		
		
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String repassword = request.getParameter("repass");
		if(!password.equals(repassword)) {
			
			response.sendRedirect("Login.jsp");
		}else {
			
			DAO dao = new DAO();
			Account a = dao.checkAccountExist(username);
			if (a == null) {
				// được insert
				dao.signup(username, repassword);
				response.sendRedirect("HomeControl");
				
			} else {
				// đã tồn tại tài khoản quay về trang login
				response.sendRedirect("Login.jsp");
				
				
			}
			
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
