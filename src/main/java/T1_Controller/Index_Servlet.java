package T1_Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import T1_Model.*;
import T1_View.*;
/**
 * Servlet implementation class Index_Servlet
 */
@WebServlet("/index")
public class Index_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String searchID = request.getParameter("ID");
	        Category_View ca = new Category_View();
				try {
					if(ca.Category(searchID)=="")
					{
						request.setAttribute("searchResult", "Không có thông tin nào");
			            request.getRequestDispatcher("/WEB-INF/templates/index.jsp").forward(request, response);
					}
					else
					{
						request.setAttribute("searchResult",ca.Category(searchID));
				       request.getRequestDispatcher("/WEB-INF/templates/index.jsp").forward(request, response);
					}
	    			}
				catch(ClassNotFoundException a)
				{
					a.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String searchID = request.getParameter("ID");
        Category_View ca = new Category_View();
       
			try {
				if(ca.Category(searchID)=="")
				{
					request.setAttribute("searchResult", "Không có thông tin nào");
		            request.getRequestDispatcher("/WEB-INF/templates/index.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("searchResult","Danh sach la:"+ca.Category(searchID));
			       request.getRequestDispatcher("/WEB-INF/templates/index.jsp").forward(request, response);
				}
    			}
			catch(ClassNotFoundException a)
			{
				a.printStackTrace();
			}
 
	}

}
