
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

@WebServlet(urlPatterns = "/updatepage")
public class UpdatePageServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonu", "root", "abhiraja00Y#");
			PreparedStatement ps = con.prepareStatement("select * from details where id = ?");
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();

			if(rs.next())
			{
				req.setAttribute("rs", rs);
				RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
				rd.forward(req, res);
			}
			
			
			rs.close();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
