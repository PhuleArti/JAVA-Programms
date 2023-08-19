import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class DemoDMLmenu {
	static Connection conn= Conn_sql.getConnection();
	
	public static void demoInsert(int id,String name) {
		Connection conn= Conn_sql.getConnection();
		try {
			String query="insert into employee values(?,?)";
			PreparedStatement ps= conn.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2,name);
			boolean ans=ps.execute();//always false
			if(!ans)
				System.out.println(ps.getUpdateCount()+"row inserted..");
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("duplicate values not allowed1");
		}

	}
	public static void demoDelete(int id) {
		try {
			String query="delete from Employee where Emp_id=?";
			PreparedStatement ps= conn.prepareStatement(query);
			ps.setInt(1,id);
			//ps.setString(2,name);
			boolean ans=ps.execute();//always false
			if(!ans)
				System.out.println(ps.getUpdateCount()+"row deleted..");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void demoUpdate(int id,String name) {
		Connection conn= Conn_sql.getConnection();
		try {
			String query="update employee set Emp_name=? where Emp_id=?";
			PreparedStatement ps= conn.prepareStatement(query);
			
			ps.setString(1,name);
			ps.setInt(2,id);
			boolean ans=ps.execute();//always false
			if(!ans)
				System.out.println(ps.getUpdateCount()+"row updated");
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("duplicate values not allowed1");
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int id;
		String name;
			
		while(true) {
			
		System.out.println("--------------------------------");
		System.out.println("1:Insert");
		System.out.println("2:Update");
		System.out.println("3:Delete");
		System.out.println("0:exit");
		System.out.println("--------------------------------");
		System.out.println("Enter choice");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter Emp_id");
		    id=sc.nextInt();
			System.out.println("Enter Emp_name");
			name=sc.next();
			demoInsert(id,name);
			break;
		case 2:
			System.out.println("Enter Emp_id");
		    id=sc.nextInt();
			demoDelete(id);
			break;
		case 3:
			System.out.println("Enter Emp_id");
		    id=sc.nextInt();
			System.out.println("Enter Emp_name");
			name=sc.next();
			demoUpdate(id,name);
			break;
		case 0:
			System.out.println("exit appliction");
			System.exit(0);
			break;
		default:
			System.out.println("invalid choice");
		}
		
		}
		
	}
}
