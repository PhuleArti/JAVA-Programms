import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoResultSetEnum {

	public static void main(String[] args) {
		Connection conn= Conn_sql.getConnection();
		try {
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery("select * from employee");
			while(rs.next())
				System.out.println(rs.getInt(1)+""+rs.getString(2));
			System.out.println("movingback to first row");
			rs.first();
			System.out.println("at first:"+rs.getInt(1)+""+rs.getString(2));
			rs.last();
			System.out.println("at last:"+rs.getInt(1)+""+rs.getString(2));
			rs.absolute(4);
			System.out.println("at absolute:4:"+rs.getInt(1)+""+rs.getString(2));
			rs.relative(1);
			System.out.println("at relative:1:"+rs.getInt(1)+""+rs.getString(2));
			rs.relative(-3);
			System.out.println("at relative:-3:"+rs.getInt(1)+""+rs.getString(2));
			//rs.beforeFirst();
			System.out.println(rs.getInt(1)+""+rs.getString(2));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
