import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn_Oracle {

		public static Connection getConnection() {//return type of connection should be connection
			Connection conn = null;
			 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("driver available");
				 conn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-N0318MP:1521:XE","Arti123","Arti");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		

}

