import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class DatabaseTableDisplay extends JFrame {
	Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    
    JPanel pan1=new JPanel();
    JPanel pan2=new JPanel();
    ArrayList<Object>list=new ArrayList<Object>();
    JScrollPane jsp,jsp1;
    JTree tree;
    JTable jt;
    Object[] hierarchy;
    DefaultTableModel model=new DefaultTableModel();
    
    public DatabaseTableDisplay() {
    	Connection conn= Conn_sql.getConnection();
    	
    	pan1.setBackground(Color.LIGHT_GRAY);
    	pan2.setBackground(Color.LIGHT_GRAY);
    	pan1.setPreferredSize(new Dimension(720,10));
    	pan2.setPreferredSize(new Dimension(180,10));
    	add(pan1,BorderLayout.EAST);
    	add(pan2,BorderLayout.WEST);
    	
    	list.add("Database");
    	 jt = new JTable(model);
    	 add(jt);
    	 
    	 String SQL="show databases";
    	 
    	 try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(SQL);
			
			while(rs.next()) {
				Object value[]= {rs.getString(1)};
				list.add(value);
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
    	 Object heirarchy[]=list.toArray();
    	
		DefaultMutableTreeNode root = null;
		try {
			root = processHierarchy(hierarchy);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tree=new JTree(root);
		
		pan2.add(tree);
		pan1.add(jt);
		pan1.add(new JScrollPane(jt));
		
		setLocation(300,20);
		setSize(900,700);
		setVisible(true);
		setDefaultCloseOperation(3);
    }


	private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) throws SQLException{
		DefaultMutableTreeNode node=new DefaultMutableTreeNode();
		DefaultMutableTreeNode child;
		
		for(int i=1;i<hierarchy.length;i++) {
			Object nodeSpecifier = hierarchy[i];
			
			if(nodeSpecifier instanceof Object[]) {
				child=processHierarchy((Object[]) nodeSpecifier);
			}
			else {
				child = new  DefaultMutableTreeNode(nodeSpecifier);
			}
			node.add(child);
		}
		return (node);
		
	}
	public void Display() {
		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				DefaultMutableTreeNode selectnode=(DefaultMutableTreeNode)
						tree.getSelectionPath().getLastPathComponent();
				if(e.getClickCount()==2) {
					model.setRowCount(0);
					model.setColumnCount(0);
					
					String sql="select * from"+selectnode;
					try {
					stmt.execute(sql);
					rs=stmt.getResultSet();
					ResultSetMetaData rsmd=rs.getMetaData();
					int c=rsmd.getColumnCount();
					for(int j=1;j<=c;j++) {
						model.addColumn(rsmd.getColumnLabel(j));
					}
					while(rs.next()) {
						Vector<Object> row=new Vector<>(c);
						for(int i=1;i<=c;i++) {
							row.addElement(rs.getObject(i));
						}
						model.addRow(row);
					  }
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	public static void main(String[] args) {
      new DatabaseTableDisplay();
	}

}
