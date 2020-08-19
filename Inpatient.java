import java.awt.EventQueue;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.sql.*;

public class Inpatient {

	public JFrame frame;
	private JTextField txtId;
	private JTextField txtAcchar;
	private JTextField txtweight;
	private JTextField txtRoom;
	private JTextField txtStay;
	private JTextField txtAdm;
	private JTextField txtDish;
	private JTextField txtSurg;
	private JTextField txtTreatment;
	private JTextField txtBill;
	private JTextField txtAdmchar;
	private JTextField txtAneschar;
	private JTextField txtDoctorchar;
	private JTextField txtNursechar;
	private JTextField txtOtherchar;
	private JTextField txtPathchar;
	private JTextField txtStaychar;
	private JTextField txtDiagonesis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Inpatient window = new Inpatient();
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
	public Inpatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1150, 750);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("AC CHARGE");
		lblName.setBounds(145, 98, 93, 20);
		frame.getContentPane().add(lblName);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		btnInsert.setBounds(132, 619, 117, 37);
		frame.getContentPane().add(btnInsert);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Connection con = con();
				String query = "update Inpatient set P_id=' "+txtId.getText()+" ', bill_no='"+txtBill.getText()+"', adm_date=' "+txtAdm.getText()+" ', sur_date=' "+txtSurg.getText()+" ', dis_date=' "+txtDish.getText()+" ', itreatment=' "+txtTreatment.getText()+" ', ifin_dig=' "+txtDiagonesis.getText()+" ', iweight=' "+txtweight.getText()+" ', adm_chrg=' "+txtAdmchar.getText()+" ', anas_chrg=' "+txtAneschar.getText()+" ', tariff_vist_doc_chrg=' "+txtDoctorchar.getText()+" ', phth_chrg=' "+txtPathchar.getText()+" ', nurs_chrg=' "+txtNursechar.getText()+" ', oth_chrg=' "+txtOtherchar.getText()+" ', room_no=' "+txtRoom.getText()+" ', ac_cost=' "+txtAcchar.getText()+" ', no_day=' "+txtStay.getText()+" ', stay_cost=' "+txtStaychar.getText()+" ' where P_id='"+txtId.getText()+"' ";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Data Updated");
				ps.close();
			}catch (Exception e) {
				System.out.println("error:" + e);
			}
			}
		});
		btnUpdate.setBounds(454, 619, 117, 37);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
		
				public void actionPerformed(ActionEvent e) {

                    frame.dispose();

                    Inpatdisplay p1 = new Inpatdisplay();

           p1.frame.setVisible(true);
			}
		});
		btnDisplay.setBounds(819, 619, 117, 37);
		frame.getContentPane().add(btnDisplay);
		
		JLabel lblNewLabel = new JLabel("PATIENT ID");
		lblNewLabel.setBounds(145, 65, 84, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WEIGHT");
		lblNewLabel_1.setBounds(145, 130, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ROOM ");
		lblNewLabel_2.setBounds(145, 158, 84, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NUMBER OF STAYING DAYS");
		lblNewLabel_3.setBounds(564, 158, 203, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("BILL ID");
		lblNewLabel_5.setBounds(145, 278, 93, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ADMISSION CHAGRE");
		lblNewLabel_6.setBounds(145, 317, 130, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("ANESTHESIA CHARGE");
		lblNewLabel_7.setBounds(145, 354, 147, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("DOCTOR CHARGE");
		lblNewLabel_8.setBounds(145, 391, 130, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("NURSE CHARGE");
		lblNewLabel_9.setBounds(564, 380, 111, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("OTHER CHARGE");
		lblNewLabel_10.setBounds(564, 429, 111, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		txtId = new JTextField();
		txtId.setBounds(311, 65, 130, 26);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtAcchar = new JTextField();
		txtAcchar.setBounds(311, 95, 199, 26);
		frame.getContentPane().add(txtAcchar);
		txtAcchar.setColumns(10);
		
		txtweight = new JTextField();
		txtweight.setBounds(311, 125, 69, 26);
		frame.getContentPane().add(txtweight);
		txtweight.setColumns(10);
		
		txtRoom = new JTextField();
		txtRoom.setBounds(311, 153, 93, 26);
		frame.getContentPane().add(txtRoom);
		txtRoom.setColumns(10);
		
		txtStay = new JTextField();
		txtStay.setBounds(806, 153, 130, 26);
		frame.getContentPane().add(txtStay);
		txtStay.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("ADMISSION DATE");
		lblNewLabel_12.setBounds(564, 70, 159, 16);
		frame.getContentPane().add(lblNewLabel_12);
		
		txtAdm = new JTextField();
		txtAdm.setBounds(806, 65, 130, 26);
		frame.getContentPane().add(txtAdm);
		txtAdm.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("DISCHARGE DATE");
		lblNewLabel_13.setBounds(564, 100, 117, 16);
		frame.getContentPane().add(lblNewLabel_13);
		
		txtDish = new JTextField();
		txtDish.setColumns(10);
		txtDish.setBounds(806, 95, 130, 26);
		frame.getContentPane().add(txtDish);
		
		JLabel lblNewLabel_14 = new JLabel("SURGERY DATE");
		lblNewLabel_14.setBounds(564, 130, 117, 16);
		frame.getContentPane().add(lblNewLabel_14);
		
		txtSurg = new JTextField();
		txtSurg.setColumns(10);
		txtSurg.setBounds(806, 125, 130, 26);
		frame.getContentPane().add(txtSurg);
		
		JLabel lblNewLabel_4 = new JLabel("TREATMENT DETAILS");
		lblNewLabel_4.setBounds(145, 207, 158, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtTreatment = new JTextField();
		txtTreatment.setBounds(155, 235, 542, 26);
		frame.getContentPane().add(txtTreatment);
		txtTreatment.setColumns(10);
		
		txtBill = new JTextField();
		txtBill.setBounds(364, 273, 166, 26);
		frame.getContentPane().add(txtBill);
		txtBill.setColumns(10);
		
		txtAdmchar = new JTextField();
		txtAdmchar.setBounds(364, 312, 130, 26);
		frame.getContentPane().add(txtAdmchar);
		txtAdmchar.setColumns(10);
		
		txtAneschar = new JTextField();
		txtAneschar.setBounds(364, 349, 130, 26);
		frame.getContentPane().add(txtAneschar);
		txtAneschar.setColumns(10);
		
		txtDoctorchar = new JTextField();
		txtDoctorchar.setBounds(364, 386, 130, 26);
		frame.getContentPane().add(txtDoctorchar);
		txtDoctorchar.setColumns(10);
		
		txtNursechar = new JTextField();
		txtNursechar.setBounds(806, 375, 130, 26);
		frame.getContentPane().add(txtNursechar);
		txtNursechar.setColumns(10);
		
		txtOtherchar = new JTextField();
		txtOtherchar.setBounds(806, 424, 130, 26);
		frame.getContentPane().add(txtOtherchar);
		txtOtherchar.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("PATHALOGIST CHARGE");
		lblNewLabel_15.setBounds(564, 342, 147, 16);
		frame.getContentPane().add(lblNewLabel_15);
		
		txtPathchar = new JTextField();
		txtPathchar.setBounds(806, 337, 130, 26);
		frame.getContentPane().add(txtPathchar);
		txtPathchar.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("STAY CHARGE");
		lblNewLabel_16.setBounds(145, 429, 117, 16);
		frame.getContentPane().add(lblNewLabel_16);
		
		txtStaychar = new JTextField();
		txtStaychar.setBounds(364, 424, 130, 26);
		frame.getContentPane().add(txtStaychar);
		txtStaychar.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("FINAL DIAGONESIS");
		lblNewLabel_17.setBounds(145, 488, 204, 16);
		frame.getContentPane().add(lblNewLabel_17);
		
		txtDiagonesis = new JTextField();
		txtDiagonesis.setBounds(164, 516, 542, 26);
		frame.getContentPane().add(txtDiagonesis);
		txtDiagonesis.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("IN PATIENT DETAILS");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_11.setForeground(new Color(0, 0, 255));
		lblNewLabel_11.setBounds(458, 6, 212, 16);
		frame.getContentPane().add(lblNewLabel_11);
		
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
		button.setBounds(974, 30, 133, 45);
		frame.getContentPane().add(button);
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
			String query = "insert into Inpatient values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtId.getText());
			ps.setString(2, txtBill.getText());
			ps.setString(3, txtAdm.getText());
			ps.setString(4, txtSurg.getText());
			ps.setString(5, txtDish.getText());
			ps.setString(6, txtTreatment.getText());
			ps.setString(7, txtDiagonesis.getText());
			ps.setString(8, txtweight.getText());
			ps.setString(9, txtAdmchar.getText());
			ps.setString(10, txtAneschar.getText());
			ps.setString(11, txtDoctorchar.getText());
			ps.setString(12, txtPathchar.getText());
			ps.setString(13, txtNursechar.getText());
			ps.setString(14, txtOtherchar.getText());
			ps.setString(15, txtRoom.getText());
			ps.setString(16, txtAcchar.getText());
            ps.setString(17, txtStay.getText());
			ps.setString(18, txtStaychar.getText());
			
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!!");
		}catch (Exception e) {
			System.out.println("error:" + e);
		}
	}
}
