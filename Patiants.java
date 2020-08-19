import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.sql.*;

public class Patiants {

	public JFrame frame;
	private JTextField txtMHistory;
	private JTextField txtGender;
	private JTextField txtAge;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtaddres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Patiants window = new Patiants();
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
	public Patiants() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PATIENTS DETAILS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(495, 6, 297, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT ID");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(87, 141, 172, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(87, 201, 101, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAge.setBounds(87, 261, 61, 25);
		frame.getContentPane().add(lblAge);
		
		JLabel lblNewLabel_3 = new JLabel("GENDER");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(87, 331, 101, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ADRESS");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(87, 401, 101, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblMedicalHistory = new JLabel("MEDICAL HISTORY");
		lblMedicalHistory.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblMedicalHistory.setBounds(87, 490, 185, 25);
		frame.getContentPane().add(lblMedicalHistory);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 SaveToDatabase();
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnNewButton.setBounds(90, 595, 143, 56);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Connection con = con();
				String query = "update Patient set P_id=' "+txtId.getText()+" ', name='"+txtName.getText()+"', age='"+txtAge.getText()+"', gender='"+txtGender.getText()+"', address='"+txtaddres.getText()+"', med_his='"+txtMHistory.getText()+"' where P_id='"+txtId.getText()+"' ";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Data Updated");
				ps.close();
			}catch (Exception e) {
				System.out.println("error:" + e);
			}
			}
		});
		btnUpdate.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnUpdate.setBounds(568, 595, 143, 56);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 frame.dispose();

                 Patientdisplay p1 = new Patientdisplay();

                 p1.frame.setVisible(true);

			}
		});
		btnDisplay.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnDisplay.setBounds(960, 595, 143, 56);
		frame.getContentPane().add(btnDisplay);
		
		txtMHistory = new JTextField();
		txtMHistory.setBounds(380, 489, 596, 32);
		frame.getContentPane().add(txtMHistory);
		txtMHistory.setColumns(10);
		
		txtGender = new JTextField();
		txtGender.setBounds(380, 333, 110, 32);
		frame.getContentPane().add(txtGender);
		txtGender.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBounds(378, 257, 61, 32);
		frame.getContentPane().add(txtAge);
		txtAge.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(380, 197, 204, 32);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(381, 141, 130, 32);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton button = new JButton("HOME");
		button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                 Home p1 = new Home();

                 p1.frame.setVisible(true);

}

});
		button.setForeground(Color.GREEN);
		button.setBackground(Color.BLACK);
		button.setBounds(918, 86, 133, 45);
		frame.getContentPane().add(button);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(61, 554, 1, 12);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(61, 554, 1027, 12);
		frame.getContentPane().add(separator_1);
		
		txtaddres = new JTextField();
		txtaddres.setColumns(10);
		txtaddres.setBounds(380, 401, 596, 32);
		frame.getContentPane().add(txtaddres);
		frame.setBounds(100, 100, 1150, 750);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			String query = "insert into Patient values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtId.getText());
			ps.setString(2, txtName.getText());
			ps.setString(3, txtAge.getText());
			ps.setString(4, txtGender.getText());
			ps.setString(5, txtaddres.getText());
			ps.setString(6, txtMHistory.getText());
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!!");
		}catch (Exception e) {
			System.out.println("error:" + e);
		}
	}
}
