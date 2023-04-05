package emp_handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp_bo.add_emp_bo;
import emp_dao.Employe_dao;

/**
 * Servlet implementation class Edit_servelet
 */
@WebServlet("/Edit_servelet")
public class Edit_servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit_servelet() {
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
           
	      String eid= (id);
	    
	      add_emp_bo eb= Employe_dao.getEmployeeById(eid);
	    
		 
		pw.print("<form  action='updatecontroller' method='get'> ");
	    
		//pw.print("<center><table  border='1px' width='30%'>");
		
		pw.print("<body style=\"background-color: rgb(229 208 217 / 18%); backdrop-filter: blur(1px);\">");
		pw.print("<centre><div style=\"border: solid 4px; background-color: #2dcaf912;color: #c7b0e3; height: '40%';width: '40%';margin-left: 250px;margin-top: 200px;border-radius: 20px;padding: 20px;\">");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
		pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone_no' value='"+eb.getPhone_no()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
	   	
	   	pw.print("<tr><td>Date of birth : </td><td><input type='text' name='Brith_date' value='"+eb.getBrith_date()+"'/></td></tr>");
	   
	   	pw.print("<tr><td>Adhar Card: </td> <td><input type='text' name='adhar' value='"+eb.getAdhare()+"'/></td></tr>");
		
	    pw.print("<tr><td><center><input type='submit' value='Update'/></center></td></tr><"); 
	    
	   	pw.print("</table>");
	   	pw.print("</form>");


		
	}

}
