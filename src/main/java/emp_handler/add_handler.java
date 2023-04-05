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
 * Servlet implementation class add_handler
 */
@WebServlet("/add_handler")
public class add_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  response.setContentType("text/html");
		    PrintWriter pw=response.getWriter();

		
		String id=request.getParameter("id");
	     String name=request.getParameter("name");
	     
	     String phone=request.getParameter("Phone_no");
	     String email=request.getParameter("email");
	     String brithdate=request.getParameter("Brith_date");
	   
	     String adhare=request.getParameter("Adhare");
	     
	    // pw.print(name+" "+email+" "+phone+" "+doj+" "+dob+" "+adhar);
	     
	     add_emp_bo eb=new add_emp_bo(id,name,phone,email,brithdate,adhare);
	     
	    int status= Employe_dao.addEmployee(eb);
	    
	    if(status>0) {
	    	
	    	pw.print("insert susfully");
	    	 RequestDispatcher rd=request.getRequestDispatcher("home.html");
	    	 rd.forward(request, response);
	    	
	    }else {
	    	pw.print("Something went wrong!!!");
	    	RequestDispatcher rd=request.getRequestDispatcher("Add_emp.html");
	    	rd.include(request, response);
	    }
	}
}