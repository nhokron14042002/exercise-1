package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.CartBo;
import entity.Cart;
import entity.Category;

/**
 * Servlet implementation class CartControl
 */
@WebServlet("/CartControl")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String pid=request.getParameter("id");
//		   String pname=request.getParameter("name");
//		   String pimage=request.getParameter("image");
//		   
//		   Category category =new Category();
//			request.setAttribute("dsloai", category.getCname() );
//		   if (pid != null && pname!= null) {
//		   long pprice=Long.parseLong(request.getParameter("price"));
//		   CartBo gh;
//		    
//		   
//		   HttpSession session= request.getSession();
//		   
//		   if(session.getAttribute("cart")==null){
//			   gh=new CartBo();
//			   session.setAttribute("cart", gh);
//		   }
//		   //b1: gan session vao bien
//		   gh=(CartBo)session.getAttribute("cart");
//		   //b2: Thao tac tren bien
//		   gh.Them(pid, pname, pname, pprice, (long)1);
//		   //b3: Luu bien vao session
//		   session.setAttribute("cart", gh);
//		
//		
//		   
//		   }
		
		   request.getRequestDispatcher("Cartgh.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
