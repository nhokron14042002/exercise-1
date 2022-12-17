package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

import dao.DAO;

/**
 * Servlet implementation class giohangctl
 */
@WebServlet("/giohangctl")
public class giohangctl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohangctl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   String pid=request.getParameter("ms");
		   String pname=request.getParameter("ts");
		   String pimage =request.getParameter("anh");
		   
		   DAO lbo=new DAO();
			request.setAttribute("dsloai", lbo.getAllCategory());
		   if (pid != null && pname!= null && pimage!= null) {
		   double pprice=Double.parseDouble(request.getParameter("gia"));
		   giohangbo gh;
		   
		 
		   HttpSession session= request.getSession();
		   
		   if(session.getAttribute("gio")==null){
			   gh=new giohangbo();
			   session.setAttribute("gio", gh);
		   }
		   //b1: gan session vao bien
		   gh=(giohangbo)session.getAttribute("gio");
		   //b2: Thao tac tren bien
		   gh.Them(pid, pname , pimage,(long) pprice, (long)1);
		  
		   //b3: Luu bien vao session
		   session.setAttribute("gio", gh);
		
		   
		   }
		   
		RequestDispatcher rd= request.getRequestDispatcher("htgio.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
