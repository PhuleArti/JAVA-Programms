import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DemoSystemProperties {

	public static void main(String[] args) {
       Properties Props = new Properties();
       try {
		FileInputStream in = new FileInputStream("database.properties");
		Props.load(in);
		in.close();
		String drivers = Props.getProperty("jdbc.drivers");
		if(drivers != null)
			System.setProperty("jdbc.drivers",drivers);
		String url = Props.getProperty("jdbc.url");
		String uername = Props.getProperty("jdbc.username");
		String password = Props.getProperty("jdbc.password");
		String url2 = "jdbc:odbc:employee";
		Connection conn = DriverManager.getConnection(url2);
		 System.out.println("connection established successfully..");
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

}
