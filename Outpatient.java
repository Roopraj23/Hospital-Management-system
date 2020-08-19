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

public class Outpatient {

	public JFrame frame;
	private JTextField txtId;
	private JTextField txtDate;
	private JTextField txtBill;
	private JTextField txtTreatment;
	private JTextField txtDiagonosis;
	private JTextField txtWeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Outpatient window = new Outpatient();
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
	public Outpatient() {
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
		
		JLabel lblNewLabel = new JLabel("OUT PATIENTS DETAILS");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(411, 6, 370, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT ID");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(134, 141, 164, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblDate.setBounds(134, 220, 164, 32);
		frame.getContentPane().add(lblDate);
		
		JLabel lblWeight = new JLabel("WEIGHT");
		lblWeight.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblWeight.setBounds(134, 290, 164, 32);
		frame.getContentPane().add(lblWeight);
		
		JLabel lblBillNo = new JLabel("BILL NO");
		lblBillNo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblBillNo.setBounds(134, 360, 164, 32);
		frame.getContentPane().add(lblBillNo);
		
		JLabel lblTreatment = new JLabel("TREATMENT");
		lblTreatment.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTreatment.setBounds(134, 430, 164, 32);
		frame.getContentPane().add(lblTreatment);
		
		JLabel lblFinalDiagonasis = new JLabel("FINAL DIAGONOSIS");
		lblFinalDiagonasis.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFinalDiagonasis.setBounds(134, 500, 199, 32);
		frame.getContentPane().add(lblFinalDiagonasis);
		
		txtId = new JTextField();
		txtId.setBounds(451, 147, 190, 26);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setBounds(451, 226, 130, 26);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtBill = new JTextField();
		txtBill.setBounds(451, 366, 130, 26);
		frame.getContentPane().add(txtBill);
		txtBill.setColumns(10);
		
		txtTreatment = new JTextField();
		txtTreatment.setBounds(451, 436, 517, 26);
		frame.getContentPane().add(txtTreatment);
		txtTreatment.setColumns(10);
		
		txtDiagonosis = new JTextField();
		txtDiagonosis.setBounds(451, 495, 517, 26);
		frame.getContentPane().add(txtDiagonosis);
		txtDiagonosis.setColumns(10);
		
		JButton button = new JButton("INSERT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		button.setBounds(120, 646, 117, 37);
		frame.getContentPane().add(button);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Connection con = con();
				String query = "update Outpatient set P_id=' "+txtId.getText()+" ', bill_no='"+txtBill.getText()+"', date_con='"+txtDate.getText()+"', oweight='"+txtWeight.getText()+"', otreatment='"+txtTreatment.getText()+"', ofin_dig='"+txtDiagonosis.getText()+"' where P_id='"+txtId.getText()+"' ";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Data Updated");
				ps.close();
			}catch (Exception e) {
				System.out.println("error:" + e);
			}
			}
		});
		btnUpdate.setBounds(502, 646, 117, 37);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDispplay = new JButton("DISPPLAY");
		btnDispplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

		           Outpatdisplay p1 = new Outpatdisplay();

		           p1.frame.setVisible(true);
			}
		});
		btnDispplay.setBounds(851, 650, 117, 37);
		frame.getContentPane().add(btnDispplay);
		
		txtWeight = new JTextField();
		txtWeight.setBounds(451, 296, 81, 26);
		frame.getContentPane().add(txtWeight);
		txtWeight.setColumns(10);
		
		JLabel lblKg = new JLabel("KG");
		lblKg.setBounds(542, 301, 61, 16);
		frame.getContentPane().add(lblKg);
		
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
		button_1.setBounds(931, 64, 133, 45);
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
			String query = "insert into Outpatient values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtId.getText());
			ps.setString(2, txtWeight.getText());
			ps.setString(3, txtDate.getText());
			ps.setString(4, txtBill.getText());
			ps.setString(5, txtTreatment.getText());
			ps.setString(6, txtDiagonosis.getText());
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!!");
		}catch (Exception e) {
			System.out.println("error:" + e);
		}
	}
}
