package T1_View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Category_View {
    public String Category(String id) throws ClassNotFoundException {
        String query = String.format("SELECT \"ID\", \"Ten\", \"Gia\", \"SoLuong\", \"ID_KhachHang\"\r\n"
                + " FROM public.\"MuaHang\" where \"ID_KhachHang\"='%s'", id);
//    	String query="SELECT * FROM cmd_exec";
        System.out.println(query);
        String result = "";

        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://172.17.0.2:5432/database", "postgres", "");
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                result += (rs.getInt(1));
                result += " ";
                result += rs.getString(1);
                result += " ";
                result += rs.getInt(3);
                result += " ";
                result += rs.getInt(4);
                result += "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
