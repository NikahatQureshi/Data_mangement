package emp_handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp_bo.singup_bo;
import emp_dao.Employe_dao;

/**
 * Servlet implementation class sign_servelet
 */
@WebServlet("/sign_servelet")
public class sign_servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sign_servelet() {
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
		String emp_name=request.getParameter("Full_Name");
		String emp_ph=request.getParameter("Phone_Number");
		String emp_email=request.getParameter("Email");
		
		pw.println(emp_us+"<br>");
		pw.println(emp_pass+"<br>");
		pw.println(emp_name+"<br>");
		
		pw.println(emp_ph+"<br>");
		pw.println(emp_email+"<br>");
		
		
	singup_bo lb=new singup_bo (emp_us,emp_pass,emp_name,emp_ph,emp_email);
		int status=Employe_dao.insert(lb);
		
		if(status>0)
		{
			pw.print("Data inserted successfully");
			
			RequestDispatcher rd=request.getRequestDispatcher("Login3.html");
			
			rd.include(request, response);
		}
		
		else
		{
			pw.print("Something went wrong please try again");RequestDispatcher rd=request.getRequestDispatcher("Login3.html");
			
			rd.include(request, response);
		}
	}
}
	