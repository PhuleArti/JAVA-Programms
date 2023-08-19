import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class DemoCacheRowSet {

	public static void main(String[] args) {
		Connection conn=Conn_sql.getConnection();
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employee");
			CachedRowSet crs=RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(rs);
			rs.close();
			stmt.close();
			conn.close();
			while(crs.next()) {
				System.out.println(crs.getInt(1)+" "+crs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
