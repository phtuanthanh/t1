package T1_View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import T1_Model.User;

public class Resgister_View {
	public int resisterEmployee(User e) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO public.\"user\"(\r\n"
        		+ "\"UserName\", \"PassWord\")\r\n"
        		+ "	VALUES (?, ?);";
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://172.17.0.2:5432/database", "postgres", "123456789");
            PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL);
            statement.setString(1, e.getUserName());
            statement.setString(2, e.getPassWord());
                     result = statement.executeUpdate();
        } catch (SQLException b) {
            System.out.println(b);
        }
        return result;
    }
}
