import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;

public class Payment {

	public JFrame frame;
	private JTextField txtBill;
	private JTextField txtAdv;
	private JTextField txtTot;
	private JTextField txtSource;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
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
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1150, 750);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPayment = new JLabel("PAYMENT");
		lblPayment.setFont(new Font("Arial", Font.BOLD, 30));
		lblPayment.setForeground(Color.BLUE);
		lblPayment.setBounds(484, 6, 147, 45);
		frame.getContentPane().add(lblPayment);
		
		JLabel lblNewLabel = new JLabel("BILL NO");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(102, 160, 102, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAdvancePayment = new JLabel("ADVANCE PAYMENT");
		lblAdvancePayment.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAdvancePayment.setBounds(102, 242, 203, 25);
		frame.getContentPane().add(lblAdvancePayment);
		
		JLabel lblTotalPaymnet = new JLabel("TOTAL PAYMNET");
		lblTotalPaymnet.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTotalPaymnet.setBounds(102, 326, 203, 25);
		frame.getContentPane().add(lblTotalPaymnet);
		
		JLabel lblSource = new JLabel("SOURCE");
		lblSource.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSource.setBounds(102, 416, 102, 25);
		frame.getContentPane().add(lblSource);
		
		txtBill = new JTextField();
		txtBill.setBounds(388, 162, 130, 26);
		frame.getContentPane().add(txtBill);
		txtBill.setColumns(10);
		
		txtAdv = new JTextField();
		txtAdv.setBounds(388, 244, 130, 26);
		frame.getContentPane().add(txtAdv);
		txtAdv.setColumns(10);
		
		txtTot = new JTextField();
		txtTot.setBounds(388, 325, 130, 26);
		frame.getContentPane().add(txtTot);
		txtTot.setColumns(10);
		
		txtSource = new JTextField();
		txtSource.setBounds(388, 415, 257, 26);
		frame.getContentPane().add(txtSource);
		txtSource.setColumns(10);
		
		JButton button = new JButton("INSERT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		button.setBounds(115, 631, 117, 37);
		frame.getContentPane().add(button);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Connection con = con();
				String query = "update Payment set bill_no=' "+txtBill.getText()+" ', adv_pay='"+txtAdv.getText()+"', tot_pay='"+txtTot.getText()+"', source='"+txtSource.getText()+"' where bill_no='"+txtBill.getText()+"' ";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Data Updated");
				ps.close();
			}catch (Exception e) {
				System.out.println("error:" + e);
			}
					
				
			}
			
		});
		btnUpdate.setBounds(500, 631, 117, 37);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setBounds(927, 631, 117, 37);
		frame.getContentPane().add(btnDisplay);
		
		JButton button_1 = new JButton("HOME");
		button_1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                 Home p1 = new Home();

                 p1.frame.setVisible(true);

}

});
		button_1.setForeground(Color.GREEN);
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(911, 64, 133, 45);
		frame.getContentPane().add(button_1);
	}
	
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
	private void SaveToDatabase() {
		Connection con = con();
		try {
			String query = "insert into Payment values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtBill.getText());
			ps.setString(2, txtAdv.getText());
			ps.setString(3, txtTot.getText());
			ps.setString(4, txtSource.getText());
			
			
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!!");
		}catch (Exception e) {
			System.out.println("error:" + e);
		}
	}

}
