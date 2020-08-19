import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Doctorpay {

	public JFrame frame;
	private JTextField txtId;
	private JTextField txtAdm;
	private JTextField txtDid;
	private JTextField txtPay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctorpay window = new Doctorpay();
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
	public Doctorpay() {
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
		
		JLabel lblVisitingDoctorPayment = new JLabel("VISITING DOCTOR PAYMENT");
		lblVisitingDoctorPayment.setFont(new Font("Arial", Font.BOLD, 30));
		lblVisitingDoctorPayment.setForeground(Color.BLUE);
		lblVisitingDoctorPayment.setBounds(354, 6, 493, 60);
		frame.getContentPane().add(lblVisitingDoctorPayment);
		
		JLabel lblNewLabel = new JLabel("DOCTOR ID");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(106, 370, 182, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPatientId = new JLabel("PATIENT ID");
		lblPatientId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPatientId.setBounds(106, 140, 182, 32);
		frame.getContentPane().add(lblPatientId);
		
		JLabel lblAdmissionDate = new JLabel("ADMISSION DATE");
		lblAdmissionDate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAdmissionDate.setBounds(106, 248, 182, 32);
		frame.getContentPane().add(lblAdmissionDate);
		
		JLabel lblCasePayment = new JLabel("CASE PAYMENT");
		lblCasePayment.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCasePayment.setBounds(120, 499, 182, 32);
		frame.getContentPane().add(lblCasePayment);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(-11, 441, 34, 26);
		frame.getContentPane().add(spinner);
		
		txtId = new JTextField();
		txtId.setBounds(462, 146, 130, 26);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtAdm = new JTextField();
		txtAdm.setBounds(462, 254, 130, 26);
		frame.getContentPane().add(txtAdm);
		txtAdm.setColumns(10);
		
		txtDid = new JTextField();
		txtDid.setBounds(462, 376, 130, 26);
		frame.getContentPane().add(txtDid);
		txtDid.setColumns(10);
		
		txtPay = new JTextField();
		txtPay.setBounds(462, 499, 130, 26);
		frame.getContentPane().add(txtPay);
		txtPay.setColumns(10);
		
		JButton button = new JButton("INSERT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		button.setBounds(120, 637, 117, 37);
		frame.getContentPane().add(button);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Connection con = con();
				String query = "update Visiting_doctor_Payment set P_id=' "+txtId.getText()+" ', adm_date='"+txtAdm.getText()+"', doc_id='"+txtDid.getText()+"' , case_paym='"+txtPay.getText()+"' where P_id='"+txtId.getText()+"' and adm_date='"+txtAdm.getText()+"' ";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Data Updated");
				ps.close();
			}catch (Exception e) {
				System.out.println("error:" + e);
			}
			}
		});
		button_2.setBounds(512, 637, 117, 37);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("DISPLAY");
		button_3.setBounds(909, 637, 117, 37);
		frame.getContentPane().add(button_3);
		
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
		button_1.setBounds(931, 84, 133, 45);
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
			String query = "insert into Visiting_doctor_Payment values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtId.getText());
			ps.setString(2, txtAdm.getText());
			ps.setString(3, txtDid.getText());
			ps.setString(4, txtPay.getText());
			
			
			
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!!");
		}catch (Exception e) {
			System.out.println("error:" + e);
		}
	}
}
