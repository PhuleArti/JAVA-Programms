import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DemoRowSet {

	public static void main(String[] args) {
	 String url="jdbc:mysql:///employee";
	 
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		RowSetFactory rf=RowSetProvider.newFactory();
		JdbcRowSet rws= rf.createJdbcRowSet();
		rws.setUrl(url);
		rws.setUsername("root");
		rws.setPassword("ARTI@123root");
		rws.setCommand("select * from employee");
		rws.execute();
		System.out.println("\ndata forword only");
		while(rws.next()) {//next leads to next record
			System.out.println(rws.getInt(1)+"\t"+rws.getString(2));
		}
		System.out.println("\ndata Reverse way");
		while(rws.previous()) {
			System.out.println(rws.getInt(1)+"\t"+rws.getString(2));
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	}

}
/*connection pool-
//disconnected architecture=row set-row set object holds tabular data
//row set objects are 
//disconnected pannel-
//webpage =going to give you info by connecting to network.
//webpage -informative,it can be dynamic as well as static,decorative
//webapplication-running on some web server.
//IIs=it is a server capable to handle webservices
//apache -webserver deliver webpages.static pages-content are same,html-it ia interpreted language get executed through browser
through the browser we can interprete html .
*/