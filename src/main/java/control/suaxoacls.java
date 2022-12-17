package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.giohangbo;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class suaxoacls
 */
@WebServlet("/suaxoacls")
public class suaxoacls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suaxoacls() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String ms=request.getParameter("ms");
				
				 HttpSession session= request.getSession();
				   giohangbo gh=(giohangbo)session.getAttribute("gio");
				   if(request.getParameter("butsua")!=null){
					   long sl=Long.parseLong(request.getParameter("txtsl"));
					   gh.capnhatsoluong(ms, sl);
				   }
				  
					   if(request.getParameter("butxoa")!=null){
					 		// ms = request.getParameter("butxoa");  
						   
						   gh.xoa(ms);}
				   if(request.getParameter("butcheck")!=null){
					   String[] check= request.getParameterValues("check");
					   	for(String c:check)
					   	gh.xoa(c);
				   }
				   
				   
				   session.setAttribute("gio", gh);
				   
				   if(gh.ds.size()==0)
					   response.sendRedirect("ctl");
				   else {
					   
					   
						RequestDispatcher rd= request.getRequestDispatcher("htgio.jsp");
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
