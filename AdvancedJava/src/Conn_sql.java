import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn_sql {
	public static Connection getConnection() {//return type of connection should be connection
		Connection conn = null;
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "ARTI@123root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
