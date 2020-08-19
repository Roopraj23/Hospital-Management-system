import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1150, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setFont(new Font("Arial", Font.BOLD, 30));
		lblHome.setForeground(Color.RED);
		lblHome.setBounds(516, 6, 99, 36);
		frame.getContentPane().add(lblHome);
		
		JButton pat = new JButton("PATIENT");
		pat.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                 Patiants p1 = new Patiants();

                 p1.frame.setVisible(true);

}

});
		pat.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		pat.setBounds(257, 116, 221, 36);
		frame.getContentPane().add(pat);
		
		JButton inp = new JButton("IN PATIENT");
		inp.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                 Inpatient p1 = new Inpatient();

                 p1.frame.setVisible(true);

}

});
		inp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		inp.setBounds(257, 204, 221, 36);
		frame.getContentPane().add(inp);
		
		JButton btnOutPatient = new JButton("OUT PATIENT");
		btnOutPatient.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                 Outpatient p1 = new Outpatient();

                 p1.frame.setVisible(true);

}

});
		btnOutPatient.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnOutPatient.setBounds(257, 291, 221, 36);
		frame.getContentPane().add(btnOutPatient);
		
		JButton btnVisitingDoctor = new JButton("VISITING DOCTOR");
		btnVisitingDoctor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                 Doctor p1 = new Doctor();

                 p1.frame.setVisible(true);

}

});
		btnVisitingDoctor.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnVisitingDoctor.setBounds(257, 374, 221, 36);
		frame.getContentPane().add(btnVisitingDoctor);
		
		JButton btnDoctorContact = new JButton("DOCTOR CONTACT");
		btnDoctorContact.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                 Doctorcont p1 = new Doctorcont();

                 p1.frame.setVisible(true);

}

});
		btnDoctorContact.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnDoctorContact.setBounds(257, 467, 221, 36);
		frame.getContentPane().add(btnDoctorContact);
		
		JButton btnDoctorPayment = new JButton("DOCTOR PAYMENT");
		btnDoctorPayment.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                 Doctorpay p1 = new Doctorpay();

                 p1.frame.setVisible(true);

}

});
		btnDoctorPayment.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnDoctorPayment.setBounds(257, 557, 221, 36);
		frame.getContentPane().add(btnDoctorPayment);
		
		JButton btnPatientPhone = new JButton("PATIENT PHONE");
		btnPatientPhone.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                          Patientcont p1 = new Patientcont();

                 p1.frame.setVisible(true);

}

});
		btnPatientPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnPatientPhone.setBounds(651, 123, 201, 36);
		frame.getContentPane().add(btnPatientPhone);
		
		JButton btnPayment = new JButton("PAYMENT");
		btnPayment.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                          Payment p1 = new Payment();

                 p1.frame.setVisible(true);

}

});
		btnPayment.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnPayment.setBounds(651, 211, 214, 36);
		frame.getContentPane().add(btnPayment);
		
		JButton btnStaff = new JButton("STAFF");
		btnStaff.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                          Staff p1 = new Staff();

                 p1.frame.setVisible(true);

}

});
		btnStaff.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnStaff.setBounds(651, 298, 214, 36);
		frame.getContentPane().add(btnStaff);
		
		JButton btnAttendence = new JButton("ATTENDENCE");
		btnAttendence.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                          Attendence p1 = new Attendence();

                 p1.frame.setVisible(true);

}

});
		btnAttendence.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnAttendence.setBounds(651, 381, 214, 36);
		frame.getContentPane().add(btnAttendence);
		
		JButton btnPayroll = new JButton("PAYROLL");
		btnPayroll.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                          Payroll p1 = new Payroll();

                 p1.frame.setVisible(true);

}

});
		btnPayroll.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnPayroll.setBounds(651, 474, 214, 36);
		frame.getContentPane().add(btnPayroll);
		
		JButton btnStaffContact = new JButton("STAFF CONTACT");
		btnStaffContact.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                          Staffcont p1 = new Staffcont();

                 p1.frame.setVisible(true);

}

});
		btnStaffContact.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnStaffContact.setBounds(651, 557, 214, 36);
		frame.getContentPane().add(btnStaffContact);
		
		JButton button = new JButton("EXIT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Loginpage = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(Loginpage, "Confirm if you want to exit","Login Page",
					JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		button.setBounds(968, 651, 117, 41);
		frame.getContentPane().add(button);
	}

}
