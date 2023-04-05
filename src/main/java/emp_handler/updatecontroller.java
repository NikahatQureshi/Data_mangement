package emp_handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp_bo.add_emp_bo;
import emp_dao.Employe_dao;

/**
 * Servlet implementation class updatecontroller
 */
@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 
	     response.setContentType("text/html");
           PrintWriter pw=response.getWriter();
            
           String id= request.getParameter("id");
           String name= request.getParameter("name");
           String phone= request.getParameter("phone");
           String email= request.getParameter("email");
          
           String birthdate= request.getParameter("Brith_date");
           String adhar= request.getParameter("adhar");
           
           
           add_emp_bo eb=new add_emp_bo();
           eb.setId(id);
           eb.setName(name);
           eb.setPhone_no(phone);
           eb.setEmail(email);
           
           eb.setBrith_date(birthdate);;
           eb.setAdhare(adhar);
           
          int status= Employe_dao.Update(eb);
          
          if(status>0) {
        	   
        	  RequestDispatcher rd=request.getRequestDispatcher("All_handler");
        	    rd.forward(request, response);
          }
	}
}
	