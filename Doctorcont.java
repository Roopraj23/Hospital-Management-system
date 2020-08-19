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

public class Doctorcont {

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
					Doctorcont window = new Doctorcont();
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
	public Doctorcont() {
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
		
		JLabel lblVisitinDoctorContact = new JLabel("VISITING DOCTOR CONTACT");
		lblVisitinDoctorContact.setFont(new Font("Arial", Font.BOLD, 30));
		lblVisitinDoctorContact.setForeground(Color.BLUE);
		lblVisitinDoctorContact.setBounds(320, 6, 430, 52);
		frame.getContentPane().add(lblVisitinDoctorContact);
		
		JLabel lblNewLabel = new JLabel("DOCTOR ID");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(159, 221, 114, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO");
		lblPhoneNo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPhoneNo.setBounds(159, 332, 114, 25);
		frame.getContentPane().add(lblPhoneNo);
		
		txtId = new JTextField();
		txtId.setBounds(460, 223, 130, 26);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(460, 334, 130, 26);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		JButton button = new JButton("INSERT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		button.setBounds(148, 626, 117, 37);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("DELETE");
		button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {Connection con = con();
						String query = "delete from Visiting_doctor_contact where doc_id='"+txtId.getText()+"' ";
						
						PreparedStatement pat=con.prepareStatement(query);
						pat.execute();
						JOptionPane.showMessageDialog(null, "Data Deleted");
						
					}catch (Exception ex) {
						ex.printStackTrace();
					}
				
			}
			
		});
		button_1.setBounds(388, 626, 117, 37);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Connection con = con();
				String query = "update Visiting_doctor_contact set doc_id=' "+txtId.getText()+" ', doc_ph_no='"+txtPhone.getText()+"' where doc_id='"+txtId.getText()+"' ";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Data Updated");
				ps.close();
			}catch (Exception e) {
				System.out.println("error:" + e);
			}
			}
		});
		button_2.setBounds(659, 626, 117, 37);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("DISPLAY");
		button_3.setBounds(899, 630, 117, 37);
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
		button_4.setBounds(921, 95, 133, 45);
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
			String query = "insert into Visiting_doctor_contact values(?,?)";
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
