package T1_Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import T1_Model.User;
import T1_View.Resgister_View;

/**
 * Servlet implementation class Resgister_Servlet
 */
@WebServlet("/resgister")
public class Resgister_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Resgister_View Resgi = new Resgister_View();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resgister_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/templates/resgister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String user = request.getParameter("username_Login");
		String pass = request.getParameter("password_Login");
		System.out.println("thffffffffff");
		User User = new User();
		User.setPassWord(pass);
		User.setUserName(user);
		
		try {
			Resgi.resisterEmployee(User);
		}
		catch(ClassNotFoundException a)
		{
			a.printStackTrace();
		}
	}

}
