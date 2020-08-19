import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Staffdisplay {

	public JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staffdisplay window = new Staffdisplay();
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
	public Staffdisplay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		  frame.setBounds(100, 100, 475, 458);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.getContentPane().setLayout(null);
		  Connection con =  con();
		  DefaultTableModel model = new DefaultTableModel();
		  java.awt.Container cc = frame.getContentPane();
		  JTable tbl = new JTable(model);
		  tbl.setRowHeight(25);
		  tbl.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		        cc.setLayout(new FlowLayout(FlowLayout.CENTER));
		        model.addColumn("Id");
		        model.addColumn("name");
		        model.addColumn("age");
		        model.addColumn("desg");
		        model.addColumn("bank");
		        model.addColumn("Id");
		        model.addColumn("SalaryId");
		        model.addColumn("month");
		        model.addColumn("year");
		        model.addColumn("Basic");
		        model.addColumn("ESI");
		        model.addColumn("Incen");
		        model.addColumn("Addi_amt");
		        model.addColumn("Id");
		        model.addColumn("Phone");
		        model.addColumn("Id");
		        model.addColumn("Beg_date");
		        model.addColumn("Beg_time");
		        model.addColumn("Diff_time");
		        model.addColumn("End_time");
		        model.addColumn("Shift");
		        
		        
		        try {
		            PreparedStatement pstm = con.prepareStatement("SELECT * FROM ((staff inner join payroll on staff.emp_id=payroll.emp_id) inner join staff_contact on staff.emp_id=staff_contact.emp_id)inner join attendance on attendance.emp_id=staff.emp_id");
		            ResultSet Rs = pstm.executeQuery();
		            while(Rs.next()){
		                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getInt(3),Rs.getString(4),Rs.getInt(5),Rs.getInt(6),Rs.getInt(7),Rs.getInt(8),Rs.getInt(9),Rs.getInt(10),Rs.getInt(11),Rs.getInt(12),Rs.getInt(13),Rs.getInt(14),Rs.getInt(15),Rs.getInt(16),Rs.getDate(17),Rs.getTime(18),Rs.getTime(19),Rs.getTime(20),Rs.getInt(21)});
		            }
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
		        JScrollPane pg = new JScrollPane(tbl);
		        pg.setLocation(5, 300);
		        pg.setFont(new Font("Tahoma", Font.PLAIN, 22));
		        pg.setPreferredSize(new Dimension(1500, 980));
		        cc.add(pg);
		        frame.pack();
	}
		
		/*frame = new JFrame();
		//frame.setBounds(100, 100, 1150, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStaffDisplay = new JLabel("STAFF DISPLAY");
		lblStaffDisplay.setFont(new Font("Arial", Font.BOLD, 30));
		lblStaffDisplay.setForeground(Color.BLUE);
		lblStaffDisplay.setBounds(519, 16, 244, 36);
		frame.getContentPane().add(lblStaffDisplay);
	

	}*/

	static Connection con() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
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
