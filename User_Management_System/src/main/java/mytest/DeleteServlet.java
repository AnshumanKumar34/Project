package mytest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.mysql.cj.protocol.SocksProxySocketFactory;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonu","root","abhiraja00Y#");
			PreparedStatement ps = con.prepareStatement("delete from details where id = ?");
			ps.setString(1, id);
			int row = ps.executeUpdate();
			System.out.println(row +" : Event Deleted");
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("display");
		rd.forward(req, res);
		
		
		
	}
}