import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoRsScrollable {

	public static void main(String[] args) {
		Connection conn= Conn_sql.getConnection();
		java.sql.Statement stmt;
        try {
	     stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    // ResultSet rs= stmt.executeQuery("select Emp_id,Emp_name from Employee");
//	     rs.absolute(6);
//	     System.out.println("at first:"+rs.getInt(1)+""+rs.getString(2));
//	     while(rs.next())
//				System.out.println(rs.getInt(1)+""+rs.getString(2));
//	     System.out.println("all record shown");
//	     rs.moveToInsertRow();
//	     rs.updateInt(1, 111);
//	     rs.updateString(2,"seed");
//	     rs.insertRow();
//	     rs.first();
//	     System.out.println("at first:"+rs.getInt(1)+""+rs.getString(2));
//	     while(rs.next())
//				System.out.println(rs.getInt(1)+""+rs.getString(2));
//	     
	     ResultSet rs=stmt.executeQuery("select Emp_id,Emp_name from employee");
//	     while(rs.next())
//				System.out.println(rs.getInt(1)+""+rs.getString(2));
//	     rs.moveToCurrentRow();
	     rs.absolute(4);
	     System.out.println(rs.getInt(1)+""+rs.getString(2));
	   //  rs.deleteRow();
	     rs.updateInt(1, 001);
	     rs.updateString(2,"wwww");
	     rs.updateRow();
	     while(rs.next())
				System.out.println(rs.getInt(1)+""+rs.getString(2));
	     
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
