import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class DemoDriverClass {

	public static void main(String[] args) {
		String driverName ="com.mysql.cj.jdbc.Driver";
		try {
			Driver driver=(Driver)Class.forName(driverName).newInstance();
			Properties p= new Properties();
			p.put("user","root");
			p.put("password","ARTI@123root");
			String url="jdbc:mysql:///employee";
			Connection conn = driver.connect(url, p);
			System.out.println("driver available");
			conn.close();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
