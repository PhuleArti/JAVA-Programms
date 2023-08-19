import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Democonn {

		public static void main(String[] args) {
		    Connection connection = null;
		    Statement s;

		    try {
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      System.out.println("driver available");

		      connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-N0318MP:1521:XE", "Arti123", "Arti");
		     

		      System.out.println("Connection established successfully");
		      s = connection.createStatement();
		      ResultSet rs=s.executeQuery("SELECT * from Employee");
		      while(rs.next()) {
		    	  System.out.println(rs.getInt(1)+""+rs.getString(2));
		    	  String query1="update table Emp set Emp_id=23 where Emp_name='Arti'";
		    	  int i=s.executeUpdate(query1);
		      }

		    } catch (ClassNotFoundException e) {
		      System.err.println("Unable to load the JDBC driver");
		      e.printStackTrace();
		     } 
		      catch (SQLException e) {
		      System.err.println("Unable to establish a connection");
		      e.printStackTrace();
		    } 
		    finally {
		      // Close the connection
		      try {
		        if (connection != null) {
		          connection.close();
		        }
		      } catch (SQLException e) {
		        System.err.println("Unable to close the connection");
		        e.printStackTrace();
		      }
		    }
		  }

	}
