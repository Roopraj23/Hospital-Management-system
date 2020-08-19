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

public class Patientcont {

	public JFrame frame;
	private JTextField txtId;
	private JTextField txtPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patientcont window = new Patientcont();
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
	public Patientcont() {
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
		
		JLabel lblNewLabel = new JLabel("PATIENT CONTACT");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(482, 6, 283, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT ID");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(197, 172, 123, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO");
		lblPhoneNo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPhoneNo.setBounds(197, 276, 123, 36);
		frame.getContentPane().add(lblPhoneNo);
		
		txtId = new JTextField();
		txtId.setBounds(525, 180, 130, 26);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(525, 284, 156, 26);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		JButton button = new JButton("INSERT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SaveToDatabase();	
			}
		});
		button.setBounds(123, 622, 117, 37);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("DELETE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Connection con = con();
				String query = "delete from Patient_phone where P_id='"+txtId.getText()+"' ";
				
				PreparedStatement pat=con.prepareStatement(query);
				pat.execute();
				JOptionPane.showMessageDialog(null, "Data Deleted");
				
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			}
		});
		button_1.setBounds(396, 626, 117, 37);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Connection con = con();
					String query = "update Patient_phone set P_id=' "+txtId.getText()+" ', phone='"+txtPhone.getText()+"' where P_id='"+txtId.getText()+"' ";
					PreparedStatement ps = con.prepareStatement(query);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					ps.close();
				}catch (Exception e) {
					System.out.println("error:" + e);
				}
			}
		});
		button_2.setBounds(648, 626, 117, 37);
		frame.getContentPane().add(button_2); 
		
		JButton button_3 = new JButton("DISPLAY");
		button_3.setBounds(882, 626, 117, 37);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("HOME");
		button_4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                 Home p1 = new Home();

                 p1.frame.setVisible(true);

}

});
		button_4.setForeground(Color.GREEN);
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(934, 89, 133, 45);
		frame.getContentPane().add(button_4);
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
			String query = "insert into Patient_phone values(?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtId.getText());
			ps.setString(2, txtPhone.getText());
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!!");
		}catch (Exception e) {
			System.out.println("error:" + e);
		}
	}
}
