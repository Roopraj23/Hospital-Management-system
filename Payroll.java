import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Payroll {

	public JFrame frame;
	private JTextField txtId;
	private JTextField txtSid;
	private JTextField txtYear;
	private JTextField txtMonth;
	private JTextField txtBasic;
	private JTextField txtEsi;
	private JTextField txtIncen;
	private JTextField txtAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payroll window = new Payroll();
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
	public Payroll() {
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
		
		JLabel lblPayroll = new JLabel("PAYROLL");
		lblPayroll.setFont(new Font("Arial", Font.BOLD, 30));
		lblPayroll.setForeground(Color.BLUE);
		lblPayroll.setBounds(486, 16, 198, 36);
		frame.getContentPane().add(lblPayroll);
		
		JLabel lblStaffId = new JLabel("STAFF ID");
		lblStaffId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStaffId.setBounds(86, 107, 92, 16);
		frame.getContentPane().add(lblStaffId);
		
		JLabel lblSalaryId = new JLabel("SALARY ID");
		lblSalaryId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSalaryId.setBounds(86, 180, 130, 16);
		frame.getContentPane().add(lblSalaryId);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblYear.setBounds(86, 256, 92, 16);
		frame.getContentPane().add(lblYear);
		
		JLabel lblMonth = new JLabel("MONTH");
		lblMonth.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblMonth.setBounds(86, 339, 92, 16);
		frame.getContentPane().add(lblMonth);
		
		JLabel lblBasicSalary = new JLabel("BASIC SALARY");
		lblBasicSalary.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblBasicSalary.setBounds(86, 423, 138, 16);
		frame.getContentPane().add(lblBasicSalary);
		
		JLabel lblEsi = new JLabel("ESI");
		lblEsi.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEsi.setBounds(86, 513, 92, 16);
		frame.getContentPane().add(lblEsi);
		
		JLabel lblIncentives = new JLabel("INCENTIVES");
		lblIncentives.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblIncentives.setBounds(613, 426, 138, 16);
		frame.getContentPane().add(lblIncentives);
		
		JLabel lblAdditional = new JLabel("ADDITIONAL ");
		lblAdditional.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAdditional.setBounds(613, 513, 138, 16);
		frame.getContentPane().add(lblAdditional);
		
		JButton button = new JButton("INSERT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		button.setBounds(86, 640, 117, 37);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("DELETE");
		button_1.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					try {Connection con = con();
						String query = "delete from Payroll where Emp_id='"+txtId.getText()+"' ";
						
						PreparedStatement pat=con.prepareStatement(query);
						pat.execute();
						JOptionPane.showMessageDialog(null, "Data Deleted");
						
					}catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			
		});
		button_1.setBounds(340, 644, 117, 37);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Connection con = con();
				String query = "update Payroll set emp_id=' "+txtId.getText()+" ', sal_id='"+txtSid.getText()+"', paymonth='"+txtMonth.getText()+"', pay_year='"+txtYear.getText()+"', basic='"+txtBasic.getText()+"', ESI_ded='"+txtEsi.getText()+"', incen='"+txtIncen.getText()+"', add_amt='"+txtAdd.getText()+"' where emp_id='"+txtId.getText()+"' and sal_id='"+txtSid.getText()+"' ";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Data Updated");
				ps.close();
			}catch (Exception e) {
				System.out.println("error:" + e);
			}
			}
			
		});
		button_2.setBounds(632, 644, 117, 37);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("DISPLAY");
		button_3.setBounds(904, 644, 117, 37);
		frame.getContentPane().add(button_3);
		
		txtId = new JTextField();
		txtId.setBounds(281, 105, 130, 26);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtSid = new JTextField();
		txtSid.setBounds(281, 178, 130, 26);
		frame.getContentPane().add(txtSid);
		txtSid.setColumns(10);
		
		txtYear = new JTextField();
		txtYear.setBounds(281, 254, 130, 26);
		frame.getContentPane().add(txtYear);
		txtYear.setColumns(10);
		
		txtMonth = new JTextField();
		txtMonth.setBounds(281, 337, 130, 26);
		frame.getContentPane().add(txtMonth);
		txtMonth.setColumns(10);
		
		txtBasic = new JTextField();
		txtBasic.setBounds(281, 421, 130, 26);
		frame.getContentPane().add(txtBasic);
		txtBasic.setColumns(10);
		
		txtEsi = new JTextField();
		txtEsi.setBounds(281, 511, 130, 26);
		frame.getContentPane().add(txtEsi);
		txtEsi.setColumns(10);
		
		txtIncen = new JTextField();
		txtIncen.setBounds(880, 421, 130, 26);
		frame.getContentPane().add(txtIncen);
		txtIncen.setColumns(10);
		
		txtAdd = new JTextField();
		txtAdd.setBounds(880, 511, 130, 26);
		frame.getContentPane().add(txtAdd);
		txtAdd.setColumns(10);
		
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
		button_4.setBounds(920, 78, 133, 45);
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
			String query = "insert into Payroll values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtId.getText());
			ps.setString(2, txtSid.getText());
			ps.setString(3, txtMonth.getText());
			ps.setString(4, txtYear.getText());
			ps.setString(5, txtBasic.getText());
			ps.setString(6, txtEsi.getText());
			ps.setString(7, txtIncen.getText());
			ps.setString(8, txtAdd.getText());
			
			
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!!");
		}catch (Exception e) {
			System.out.println("error:" + e);
		}
	}

}
