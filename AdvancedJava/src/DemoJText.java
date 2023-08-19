import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DemoJText extends JFrame implements ActionListener{
	JButton execute,clear;
	JLabel lbl1;
	JTextField tf1;
	static JTextArea ta1;
	
	Connection conn= Conn_sql.getConnection();
	Statement stat=null;
	ResultSet rs;
	String query;
	
	public DemoJText() {
		JFrame jf1= new JFrame("Application");
	     setLayout(new FlowLayout());
			
			lbl1= new JLabel("Enter query");
			add(lbl1);
			
			tf1=new JTextField(40);
			add(tf1);
			tf1.addActionListener(this);
			
			
			execute=new JButton("Execute");
			add(execute);
			execute.addActionListener(this);
			
			ta1=new JTextArea(5,40);
			add(ta1);
			
			setSize(500, 500);
			setLocation(100,100);
	        setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			
	}

	public static void main(String[] args) {
	  new DemoJText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//String str=e.getActionCommand();
		String query=tf1.getText();
		  try {
			Statement stat=conn.createStatement();
		    if(e.getSource()==execute) {
			try {
				query=tf1.getText();
				boolean ans=stat.execute(query);
				if(ans) {
				     rs = stat.getResultSet();
				    while(rs.next()) {
				    	ta1.setText(ta1.getText()+"\n"+rs.getInt(1)+"\t"+rs.getString(2));
				    }
				   }
				    else {
				    	int row=stat.getUpdateCount();
				    	ta1.setText(row+" data updated..");
				    }
			} catch (SQLException e1) {
				//e1.printStackTrace();
				ta1.setText("ENter query again...");
			}
	       }
		  } catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
}
