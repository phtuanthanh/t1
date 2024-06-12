package T1_View;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Messages;

public class Category_View {
    public String Category(String id) throws ClassNotFoundException {
        String result = "";
        String sql = "{CALL DynamicQuery1(?)}";
        
        // Sử dụng driver mới cho MySQL
		Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://172.17.0.3:3306/my_data", "root", "root");
             CallableStatement stmt = connection.prepareCall(sql)) {
             
            // Thiết lập giá trị cho tham số đầu vào
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result += rs.getInt(1) + " ";
                    result += rs.getString(2) + " ";  // Cột thứ 2 là Ten
                    result += rs.getLong(3) + " ";    // Cột thứ 3 là Gia
                    result += rs.getInt(4) + " ";     // Cột thứ 4 là SoLuong
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
