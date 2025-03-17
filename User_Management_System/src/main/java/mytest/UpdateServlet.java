package mytest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String id= req.getParameter("id");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String password = req.getParameter("password");

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonu","root","abhiraja00Y#");
			PreparedStatement ps = con.prepareStatement("update details set first_name= ? , last_name = ? , password = ? where id = ?");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, password);
			ps.setString(4,id);
			
			int row = ps.executeUpdate();
			System.out.println(row + " : Event Updated");
			
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("display");
		rd.forward(req, res);
		
	}
}