package mytest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
		
		String x=req.getParameter("id");
		String a=req.getParameter("fname");
		String b=req.getParameter("lname");
		String c= req.getParameter("password");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonu", "root", "abhiraja00Y#");
			
			PreparedStatement ps=con.prepareStatement("insert into details values(?,?,?,?)");
			
			ps.setString(1,x);
			ps.setString(2,a);
			ps.setString(3,b);
			ps.setString(4,c);
			
			int row=ps.executeUpdate();
			System.out.println(row + " : User Inserted");
			
			ps.close();
			con.close();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
	}	
	}
}
