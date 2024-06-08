package T1_View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import T1_Model.User;

public class Login_View {
	public String loginUser(String user,String Pass ) throws ClassNotFoundException
	{
		String query = String.format("SELECT * FROM public.\"user\" where \"UserName\"='%s' And \"PassWord\"='%s'",user,Pass);
//		System.out.println(query);
		String sql="";
try {
			Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://172.18.0.2:5432/database", "postgres", "");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
            	sql+=rs.getString(1);
            	sql+= " ";
            	sql+=rs.getString(2);
            	sql+= " ";
            	sql+=rs.getString(3);
            	sql+= " ";
            }
             
		}
		catch(Exception a)
		{
		a.printStackTrace();
		}
		return sql;
	}
}
