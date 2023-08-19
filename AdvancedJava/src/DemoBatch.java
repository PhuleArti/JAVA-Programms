import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
//to reduce network traffic
public class DemoBatch {

	public static void main(String[] args) {
		Connection conn=Conn_sql.getConnection();
		Statement stmt;
		try {
			conn.setAutoCommit(false);
		    stmt=conn.createStatement();
			stmt.addBatch("insert into employee values(66,'mnb')");
			stmt.addBatch("insert into employee values(68,'bvc')");
			stmt.addBatch("insert into employee values(72,'cxz')");
			stmt.addBatch("insert into employee values(74,'poi')");
			
			int[]update=stmt.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				//e1.printStackTrace();
				System.out.println("not done");
			}
		}
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
