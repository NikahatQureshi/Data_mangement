
package emp_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import emp_bo.add_emp_bo;
import emp_bo.singup_bo;



public class Employe_dao {

	public static Connection connect(){
		Connection cn=null;
				
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					String url="jdbc:mysql://localhost:3306/project?useSSL=false&allowPublicKeyRetrieval=true";
					String un="root";
					String pss="Muskanq@1";
					
					cn=DriverManager.getConnection(url, un, pss);
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
				
				return cn;}
			
			public static int insert(singup_bo lb)
			{
				int status=0;
				
				try 
				{
					Connection cn=Employe_dao.connect();
					
					String query="insert into  singup values(?,?,?,?,?)";
					
					PreparedStatement ps=cn.prepareStatement(query);
					
					ps.setString(1,lb.getUsername());
					ps.setInt(2,lb.getPassword());
					ps.setString(3,lb.getFull_Name());
					ps.setString(4,lb.getPhone_number());
					ps.setString(5,lb.getEmail());
					
					status = ps.executeUpdate();
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
				
				return status;
			}

			public static boolean userLogin(String Username, int Password) {
				   
			     boolean status=false;
			   
			     try {
					
			    	Connection cn=Employe_dao.connect();
			    	String sql="select *from singup where Username=? And Password=?"; 
			    	PreparedStatement ps=cn.prepareStatement(sql);
			    	ps.setString(1, Username);
			    	ps.setInt(2, Password);
			    	
			    	ResultSet rs=ps.executeQuery();
			    	status=rs.next();
			    	 
				} catch (Exception e) {
					
					System.out.println(e);
					
				}
				return status;
			
		

			
			
}
			
			public static int addEmployee(add_emp_bo eb) {
				   
			      int status=0;
			   
			      try {
			
			    	  Connection con=Employe_dao.connect();
			    	  String query="insert into addemp(id,name,Phone_no,email,Brith_date,Adhare) values(?,?,?,?,?,?)";
			    	  PreparedStatement ps=con.prepareStatement(query);
			    	  ps.setString(1, eb.getId());
			    	  ps.setString(2, eb.getName());
			    	  ps.setString(3, eb.getPhone_no());
			    	  ps.setString(4, eb.getEmail());
			    	  ps.setString(5, eb.getBrith_date());
			    	  ps.setString(6, eb.getAdhare());
			    	 
			    	  
			    	  status=ps.executeUpdate();
			    	  
			     	 
					} catch (Exception e) {
						
						System.out.println(e);
						
					}
					return status;
							
	}
		
			public static List getAllEmployee( ) {
				   
				List<add_emp_bo> list=new ArrayList<add_emp_bo>();
				try {
					Connection cn=Employe_dao.connect();
					PreparedStatement ps=cn.prepareStatement("select * from addemp");
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						add_emp_bo e=new add_emp_bo() ;
							
						e.setId(rs.getString(1));
						e.setName(rs.getString(2));
						e.setPhone_no(rs.getString(3));
						e.setEmail(rs.getString(4));
						e.setBrith_date(rs.getString(5));
						e.setAdhare(rs.getString(6));
						list.add(e);
					}
					cn.close();
				}catch(Exception e) {
					System.out.println(e);
				}
				return list;
				
				
			}
			public static int delete(String id) {
				
				int status=0;
				  try {
				
					  Connection con=Employe_dao.connect();
					  String query="Delete from addemp where id=?";
					  PreparedStatement ps=con.prepareStatement(query);
					  ps.setString(1, id);
					  status=ps.executeUpdate();
					  
				} catch (Exception e) {
				
					   System.out.println(e);
				}
				
				return status;
				
			}
			
			public static add_emp_bo getEmployeeById(String id) {
				 
				add_emp_bo eb= new add_emp_bo();
				 
				   try {
				   	
					   Connection con=Employe_dao.connect();
					   String query="select *from addemp where id=?";
					   
					   PreparedStatement ps=con.prepareStatement(query);
					   ps.setString(1, id);

					   ResultSet rs=ps.executeQuery();
					   
					   if(rs.next()) {
						   
						   eb.setId(rs.getString(1));
						   eb.setName(rs.getString(2));
						   eb.setPhone_no(rs.getString(3));
						   eb.setEmail(rs.getString(4));
						   
						   eb.setBrith_date(rs.getString(5));
						   
						   eb.setAdhare(rs.getString(6));
						   
					   }
				   
						 
				   } catch (Exception e) {
						
					   System.out.println(e);
				}
				
				return eb;
				
			}
			
			public static int Update(add_emp_bo eb) {
				 int status=0;
				 
				 try {
					
					 Connection con=Employe_dao.connect();
					 
					 String query="update addemp  set name=?,Phone_no=?,email=?,Brith_date=?,Adhare=? where id=?";
					 PreparedStatement ps=con.prepareStatement(query);
					 
					 ps.setString(1, eb.getName());
					 ps.setString(2, eb.getPhone_no());
					 ps.setString(3, eb.getEmail());
			      
			         ps.setString(4, eb.getBrith_date());
			         ps.setString(5, eb.getAdhare());
			         ps.setString(6, eb.getId());
			         
					 
			         status=ps.executeUpdate();
			         
			         
			         
				} catch (Exception e) {
					
					System.out.println(e);
					
				}
				 
                 return status;
			
			
			}
}
