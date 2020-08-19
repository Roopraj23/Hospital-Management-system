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

public class Patientdisplay {

	public JFrame frame;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patientdisplay window = new Patientdisplay();
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
	public Patientdisplay() {
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
		        model.addColumn("Name");
		        model.addColumn("age");
		        model.addColumn("gender");
		        model.addColumn("address");
		        model.addColumn("med_his");
		        
		        
		        try {
		            PreparedStatement pstm = con.prepareStatement("SELECT * FROM Patient ");
		            ResultSet Rs = pstm.executeQuery();
		            while(Rs.next()){
		                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getInt(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
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


/*
 * import java.awt.EventQueue;
 

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Doctordisplay {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctordisplay window = new Doctordisplay();
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
/*
	public Doctordisplay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
/*
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1150, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDoctorDisplay = new JLabel("DOCTOR DISPLAY");
		lblDoctorDisplay.setFont(new Font("Arial", Font.BOLD, 30));
		lblDoctorDisplay.setForeground(Color.BLUE);
		lblDoctorDisplay.setBounds(530, 6, 273, 36);
		frame.getContentPane().add(lblDoctorDisplay);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                frame.dispose();

       Doctor p1 = new Doctor();

       p1.frame.setVisible(true);
			}
		});
		button.setBounds(79, 59, 161, 43);
		frame.getContentPane().add(button);
		
		JLabel lblDoctorId = new JLabel("DOCTOR ID:");
		lblDoctorId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblDoctorId.setBounds(60, 155, 133, 25);
		frame.getContentPane().add(lblDoctorId);
		
		JButton button_1 = new JButton("DISPLAY");
		button_1.setForeground(Color.RED);
		button_1.setBackground(Color.GREEN);
		button_1.setBounds(225, 208, 117, 40);
		frame.getContentPane().add(button_1);
		
		textField = new JTextField();
		textField.setBounds(205, 155, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDisplayAll = new JButton("DISPLAY ALL");
		btnDisplayAll.setForeground(Color.RED);
		btnDisplayAll.setBackground(Color.GREEN);
		btnDisplayAll.setBounds(917, 208, 117, 40);
		frame.getContentPane().add(btnDisplayAll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 310, 1074, 457);
		frame.getContentPane().add(scrollPane);
	}
}*/
