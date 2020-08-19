import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.sql.*;

public class Staff {

	public JFrame frame;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtDesg;
	private JTextField txtBank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff window = new Staff();
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
	public Staff() {
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
		
		JLabel lblStaffDetails = new JLabel("STAFF DETAILS");
		lblStaffDetails.setFont(new Font("Arial", Font.BOLD, 30));
		lblStaffDetails.setForeground(Color.BLUE);
		lblStaffDetails.setBounds(446, 6, 238, 49);
		frame.getContentPane().add(lblStaffDetails);
		
		JLabel lblNewLabel = new JLabel("STAFF ID");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(104, 171, 87, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblName.setBounds(104, 238, 87, 25);
		frame.getContentPane().add(lblName);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAge.setBounds(104, 306, 87, 25);
		frame.getContentPane().add(lblAge);
		
		JLabel lblDesignation = new JLabel("DESIGNATION");
		lblDesignation.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblDesignation.setBounds(104, 384, 136, 25);
		frame.getContentPane().add(lblDesignation);
		
		JLabel lblBankAccount = new JLabel("BANK ACCOUNT");
		lblBankAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblBankAccount.setBounds(104, 463, 160, 25);
		frame.getContentPane().add(lblBankAccount);
		
		txtId = new JTextField();
		txtId.setBounds(449, 173, 130, 26);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(449, 240, 235, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBounds(449, 308, 75, 26);
		frame.getContentPane().add(txtAge);
		txtAge.setColumns(10);
		
		txtDesg = new JTextField();
		txtDesg.setBounds(449, 386, 341, 26);
		frame.getContentPane().add(txtDesg);
		txtDesg.setColumns(10);
		
		txtBank = new JTextField();
		txtBank.setBounds(449, 465, 270, 26);
		frame.getContentPane().add(txtBank);
		txtBank.setColumns(10);
		
		JLabel lblYears = new JLabel("YEARS");
		lblYears.setBounds(529, 313, 61, 16);
		frame.getContentPane().add(lblYears);
		
		JButton button = new JButton("INSERT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		button.setBounds(120, 639, 117, 37);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("DELETE");
		button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {Connection con = con();
						String query = "delete from Staff where Emp_id='"+txtId.getText()+"' ";
						
						PreparedStatement pat=con.prepareStatement(query);
						pat.execute();
						JOptionPane.showMessageDialog(null, "Data Deleted");
						
					}catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			
		});
		button_1.setBounds(379, 639, 117, 37);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent earg0) {
				try {Connection con = con();
				String query = "update Staff set emp_id=' "+txtId.getText()+" ', emp_name='"+txtName.getText()+"', age='"+txtAge.getText()+"', desg='"+txtDesg.getText()+"', bank_acct='"+txtBank.getText()+"' where emp_id='"+txtId.getText()+"'  ";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Data Updated");
				ps.close();
			}catch (Exception e) {
				System.out.println("error:" + e);
			}
			}
		});
		button_2.setBounds(640, 639, 117, 37);
		frame.getContentPane().add(button_2);
		
		DefaultTableModel model = new DefaultTableModel();

                      model.addColumn("Company ID");

   model.addColumn("Product ID");

   model.addColumn("Name");

   model.addColumn("Contact Number");

		
		JButton button_3 = new JButton("DISPLAY");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				

				 frame.dispose();

                 Staffdisplay p1 = new Staffdisplay();

                 p1.frame.setVisible(true);
			}

			
		});
		button_3.setBounds(895, 643, 117, 37);
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
		button_4.setBounds(955, 73, 133, 45);
		frame.getContentPane().add(button_4);
	}
  //InstantiationException, IllegalException, ClassNotFoundException,
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
			String query = "insert into Staff values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtId.getText());
			ps.setString(2, txtName.getText());
			ps.setString(3, txtAge.getText());
			ps.setString(4, txtDesg.getText());
			ps.setString(5, txtBank.getText());
			
			
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!!");
		}catch (Exception e) {
			System.out.println("error:" + e);
		}
	}
}
