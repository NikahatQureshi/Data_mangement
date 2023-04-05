package emp_handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp_dao.Employe_dao;

/**
 * Servlet implementation class login_severlet
 */
@WebServlet("/login_severlet")
public class login_severlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_severlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        
        String emp_us=request.getParameter("Username");
		int emp_pass=Integer.parseInt(request.getParameter("Password"));
        
     if(Employe_dao.userLogin(emp_us, emp_pass)) {

          RequestDispatcher rd=request.getRequestDispatcher("home.html");
          rd.forward(request, response);
     
     }else {
    	 pw.print("Username or password wrong!!!");
    	 RequestDispatcher rd=request.getRequestDispatcher("login3.html");
          rd.include(request, response);
     }

	}

}
