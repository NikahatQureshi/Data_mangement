package emp_handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp_bo.add_emp_bo;
import emp_dao.Employe_dao;

/**
 * Servlet implementation class All_handler
 */
@WebServlet("/All_handler")
public class All_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		   
		   pw.print("<a href='home.html'>Back</a>");
		   
		   pw.print("<body style=\"background-color: rgb(229 208 217 / 18%); backdrop-filter: blur(1px);\">");
		   pw.print("<centre><div style=\"border: solid 2px; background-color: #2dcaf912;color: #c7b0e3; height: fit-content;width: fit-content;margin-left: 250px;margin-top: 100px;border-radius: 20px;padding: 20px;\">");
		   
		   pw.print("<table border='1px' width='100%'> ");
		    

		   
		   pw.print("<table border='2px' width='100%'> ");
		   
		    
		    pw.print("<tr> <th> Id </th> <th> Name </th> <th> Phone_number</th> <th> Email </th> <th> Brithdate</th> <th> Adhare_number</th>  <th> Actions</th></tr>");
		   
		   
		   
		  List<add_emp_bo> list= Employe_dao.getAllEmployee();
		   
		  for(add_emp_bo eb:list) {
			  
			   pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getPhone_no()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getBrith_date()+"</td><td>"+eb.getAdhare()+"</td><td><a href='Delete_servelet?id="+eb.getId()+"'>delete </a> </td><td><a href='Edit_servelet?id="+eb.getId()+"'>Edit </a> </td></tr>"); 

		  }
		   
		  pw.print("</table>");
	}

	}

