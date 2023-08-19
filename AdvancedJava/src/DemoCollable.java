import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class DemoCollable {

	public static void main(String[] args) throws SQLException {
		Connection conn=Conn_sql.getConnection();
		System.out.println("connected successfully...");
        
		CallableStatement Cstmt = conn.prepareCall("{call addIt(?,?,?)}");
		Cstmt.registerOutParameter(3,Types.INTEGER);
		Cstmt.setInt(1, 35);
		Cstmt.setInt(2, 5);
		Cstmt.execute();
		System.out.println("Addition is-"+Cstmt.getInt(3));
	}

}
