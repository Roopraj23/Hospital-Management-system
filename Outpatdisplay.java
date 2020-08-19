import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Outpatdisplay {

	public JFrame frame;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Outpatdisplay window = new Outpatdisplay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Outpatdisplay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		  frame.setBounds(100, 100, 475, 458);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.getContentPane().setLayout(null);
		  Connection con =  con();
		  DefaultTableModel model = new DefaultTableModel();
		  java.awt.Container cc = frame.getContentPane();
		  JTable tbl = new JTable(model);
		  tbl.setRowHeight(25);
		  tbl.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		        cc.setLayout(new FlowLayout(FlowLayout.CENTER));
		        model.addColumn("Id");
		        model.addColumn("bill_no");
		        model.addColumn("date_con");
		        model.addColumn("weight");
		        model.addColumn("Treatment");
		        model.addColumn("final_dig");
		        
		        try {
		            PreparedStatement pstm = con.prepareStatement("SELECT * FROM Outpatient");
		            ResultSet Rs = pstm.executeQuery();
		            while(Rs.next()){
		                model.addRow(new Object[]{Rs.getInt(1), Rs.getInt(2),Rs.getDate(3),Rs.getInt(4),Rs.getString(5),Rs.getString(6)});
		            }
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
		        JScrollPane pg = new JScrollPane(tbl);
		        pg.setFont(new Font("Tahoma", Font.PLAIN, 22));
		        pg.setPreferredSize(new Dimension(1080, 960));
		        cc.add(pg);
		        frame.pack();
		 }
		
		/*frame = new JFrame();
		frame.setBounds(100, 100, 1150, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStaffDisplay = new JLabel("STAFF DISPLAY");
		lblStaffDisplay.setFont(new Font("Arial", Font.BOLD, 30));
		lblStaffDisplay.setForeground(Color.BLUE);
		lblStaffDisplay.setBounds(519, 16, 244, 36);
		frame.getContentPane().add(lblStaffDisplay);*/
	

	

	static Connection con() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost/hospital_management";
			Class.forName(driver);
			return DriverManager.getConnection(url,"root", "rajroop23");
		}
		catch (Exception e) {
			System.out.println("Connection failed!" + e);
		}
		return null;
	}
}
