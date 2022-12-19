package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.chitietbo;
import bo.giohangbo;
import bo.hoadonbo;
import entity.Account;
import entity.Cart;



/**
 * Servlet implementation class datmuactl
 */
@WebServlet("/datmuactl")
public class datmuactl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datmuactl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		

		Account kh= (Account)session.getAttribute("acc");
		if(kh==null)
			response.sendRedirect("LoginControl");
		else {
			
		
			giohangbo gh=(giohangbo)session.getAttribute("gio");
			hoadonbo hdbo= new hoadonbo();		
			chitietbo ctbo= new chitietbo();
			System.out.println("ma kh: " + kh.getId());
			hdbo.Them(kh.getId());
			long maxhd=hdbo.getmaxhd();
			System.out.println("ma hoa don: " + maxhd);
			for(Cart g: gh.ds) {
				//System.out.println(g.getMasach() +"  abc");
				ctbo.Them(g.getId().trim(), g.getAmount(),maxhd);
			}
			hdbo.capnhat(maxhd);
			session.removeAttribute("gio");
			RequestDispatcher rd= request.getRequestDispatcher("HistoryStoreControl");
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
