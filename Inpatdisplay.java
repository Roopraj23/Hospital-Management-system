import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import jdk.internal.platform.Container;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Inpatdisplay {

	public JFrame frame;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inpatdisplay window = new Inpatdisplay();
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
	public Inpatdisplay() {
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
		        model.addColumn("bill");
		        model.addColumn("adm_date");
		        model.addColumn("sur_date");
		        model.addColumn("Dis_date");
		        model.addColumn("treatment");
		        model.addColumn("final_dig");
		        model.addColumn("weight");
		        model.addColumn("adm_chrg");
		        model.addColumn("anas_chrg");
		        model.addColumn("doc_chrg");
		        model.addColumn("phth_chrg");
		        model.addColumn("nurse_chrg");
		        model.addColumn("other_chrg");
		        model.addColumn("room");
		        model.addColumn("AC");
		        model.addColumn("stay");
		        model.addColumn("stay_cost");
		        
		        try {
		            PreparedStatement pstm = con.prepareStatement("SELECT * FROM Inpatient");
		            ResultSet Rs = pstm.executeQuery();
		            while(Rs.next()){
		                model.addRow(new Object[]{Rs.getInt(1),Rs.getInt(2),Rs.getDate(3), Rs.getDate(4),Rs.getDate(5),Rs.getString(6),Rs.getString(7),Rs.getInt(8),Rs.getInt(9),Rs.getInt(10),Rs.getInt(11),Rs.getInt(12),Rs.getInt(13),Rs.getInt(14),Rs.getInt(15),Rs.getInt(16),Rs.getInt(17),Rs.getInt(18)});
		            }
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
		        JScrollPane pg = new JScrollPane(tbl);
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
