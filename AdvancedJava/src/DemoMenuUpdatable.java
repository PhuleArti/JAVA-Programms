import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DemoMenuUpdatable extends JFrame implements ActionListener{
	static Connection conn= Conn_sql.getConnection();
	//static Connection conn= Conn_Oracle.getConnection();
    JLabel lbl1;
    static JTextField tf1;
    static JTextArea ta1;
    JButton Show,Insert,Update,Delete,First,Last,Clear,Count;
	DemoMenuUpdatable(){
		JFrame jf1 = new JFrame("application");
		
		lbl1=new JLabel("Enter query");
		tf1=new JTextField(50);
		ta1=new JTextArea(15,30);
		
		Show=new JButton("Show all");
		Show.setBackground(Color.black);
		Show.setForeground(Color.white);
		Show.addActionListener(this);
		
		Insert=new JButton("INsert");
		Insert.setBackground(Color.black);
		Insert.setForeground(Color.white);
		Insert.addActionListener(this);
		
		Update = new JButton("Update");
		Update.setBackground(Color.black);
		Update.setForeground(Color.white);
		Update.addActionListener(this);
		
		Delete=new JButton("Delete");
		Delete.setBackground(Color.black);
		Delete.setForeground(Color.white);
		Delete.addActionListener(this);
		
		First=new JButton("First");
		First.setBackground(Color.black);
		First.setForeground(Color.white);
		First.addActionListener(this);
		
		Last=new JButton("Last");
		Last.setBackground(Color.black);
		Last.setForeground(Color.white);
		Last.addActionListener(this);
		
		Count=new JButton("Count");
		Count.setBackground(Color.black);
		Count.setForeground(Color.white);
		Count.addActionListener(this);
		
		Clear=new JButton("Clear");
		Clear.setBackground(Color.black);
		Clear.setForeground(Color.white);
		Clear.addActionListener(this);
		
		add(lbl1);add(tf1);add(Show);add(Insert);
		add(Update);add(Delete);add(First);add(Last);
		add(Clear);add(Count);add(ta1);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(600,400);
		setLocation(100,100);
		setForeground(Color.green);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	private void setForeground() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
	  new DemoMenuUpdatable();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String query=tf1.getText();
		
	        try {
		     Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		    
		     if(e.getSource()==Insert) {		
		     boolean ans=stmt.execute(query);
	    	 ResultSet rs;
			 if(ans) {
				 rs= stmt.executeQuery(query);
				 rs.moveToInsertRow();
			     rs.updateInt(1, 543);
			     rs.updateString(2,"ARTI");
			     rs.insertRow();
			     rs.first();
			     ta1.setText(ta1.getText()+"at first:"+rs.getInt(1)+""+rs.getString(2));
			     while(rs.next())
						ta1.setText(ta1.getText()+"\n"+rs.getInt(1)+"\t"+rs.getString(2));
			     ta1.setText("record inserted successfully...");
		          }
			 else {
				 int row=stmt.getUpdateCount();
				 ta1.setText(row+" cannot insert duplicate record ..");
		        }
		     }
		     else if(e.getSource()==Show) {
		    	 boolean ans=stmt.execute(query);
		    	 ResultSet rs;
				 if(ans) {
					 rs= stmt.executeQuery(query);
					 ta1.setText("all records");
			    	 while(rs.next())
				    	 ta1.setText(ta1.getText()+"\n"+rs.getInt(1)+"\t"+rs.getString(2));
			  }
				 else {
					 int row=stmt.getUpdateCount();
					 ta1.setText(row+" cannot shows records..");
			   }
		    	 
		     }
		     else if(e.getSource()==Update) {
			     boolean ans=stmt.execute(query);
			    	ResultSet rs;
					if(ans) {
					 rs= stmt.executeQuery(query);
					 rs.absolute(2);
					 System.out.println(rs.getInt(1)+""+rs.getString(2));
					 rs.updateInt(1, 003);
				     rs.updateString(2,"mmmm");
					 rs.updateRow();
					 ta1.setText(" row updated successfully..");
					 while(rs.next())
				   ta1.setText(ta1.getText()+"\n"+rs.getInt(1)+"\t"+rs.getString(2));
				}
				 else {
					int row=stmt.getUpdateCount();
				   ta1.setText(row+" cannot update record..");
					 }
			     }
		     else if(e.getSource()==Delete) {
		     boolean ans=stmt.execute(query);
		    	ResultSet rs;
				if(ans) {
				 rs= stmt.executeQuery(query);
				 rs.absolute(2);
				 System.out.println(rs.getInt(1)+""+rs.getString(2));
				 rs.deleteRow();
				 ta1.setText(" second record deleted successfully..");
//				 while(rs.next())
//			   ta1.setText(ta1.getText()+"\n"+rs.getInt(1)+"\t"+rs.getString(2));
			}
			 else {
				int row=stmt.getUpdateCount();
			   ta1.setText(row+" cannot delete record..");
				 }
		     }
		     else if(e.getSource()==First) {
		    	 boolean ans=stmt.execute(query);
		    	 ResultSet rs;
				 if(ans) {
				  rs = stmt.getResultSet();
				 System.out.println("first record");
				 rs.first();
				 ta1.setText("first record"+ta1.getText()+"\n"+rs.getInt(1)+"\t"+rs.getString(2));
			  }
				 else {
					 int row=stmt.getUpdateCount();
					 ta1.setText(row+" cannot display record..");
			   }
		     }
		     else if(e.getSource()==Last) {
		    	 boolean ans=stmt.execute(query);
		    	 ResultSet rs;
					if(ans) {
					rs = stmt.getResultSet();
					System.out.println("last record");
					rs.last();
					ta1.setText("Last rescord"+ta1.getText()+"\n"+rs.getInt(1)+"\t"+rs.getString(2));
				   }
			     else {
				   int row=stmt.getUpdateCount();
				   ta1.setText(row+" cannot display record..");
				 }
		     }
		     else if(e.getSource()==Clear) {
		    	 ta1.setText(" ");
		     }
		     else if(e.getSource()==Count) {
		    	 boolean ans=stmt.execute(query);
		    	 ResultSet rs;
		    	 int cnt = 0;
				 if(ans) {
					 rs= stmt.executeQuery(query);
					 ta1.setText("Total records");
			    	 while(rs.next()) {
				    	 ta1.setText(ta1.getText()+"\n"+rs.getInt(1)+"\t"+rs.getString(2));
			    	 cnt++;
			    	 }
			    	 ta1.setText("\nTotal count is : "+cnt);
			  }
				 else {
					 int row=stmt.getUpdateCount();
					 ta1.setText(row+" cannot show count");
			   } 
		     }
		     
		   }catch (SQLException e1) {
				//e.printStackTrace();
	        	ta1.setText("Insert Query properly...or constraint get violated");
		  }
		}
	}

