package T1_Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import T1_Model.User;
import T1_View.Login_View;

/**
 * Servlet implementation class Login_Servlet
 */
@WebServlet("/")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Login_View lg = new Login_View();
    /**
     * Default constructor. 
     */
    public Login_Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/templates/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 TODO Auto-generated method stub
		String user = request.getParameter("username_login");
		String pass = request.getParameter("password_login");
		System.out.println(user+pass);
		try {
			if(lg.loginUser(user, pass)=="")
			{
				request.setAttribute("errorMessage", "Sai mật khẩu");
	            request.getRequestDispatcher("/WEB-INF/templates/login.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("errorMessage",lg.loginUser(user, pass));
		       request.getRequestDispatcher("/WEB-INF/templates/index.jsp").forward(request, response);
			}
		}
		catch(ClassNotFoundException a)
		{
			a.printStackTrace();
		}
		
	
	}

}
