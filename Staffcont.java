import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Staffcont {

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
					Staffcont window = new Staffcont();
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
	public Staffcont() {
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
		
		JLabel lblStaffContact = new JLabel("STAFF CONTACT");
		lblStaffContact.setFont(new Font("Arial", Font.BOLD, 30));
		lblStaffContact.setForeground(Color.BLUE);
		lblStaffContact.setBounds(452, 6, 274, 36);
		frame.getContentPane().add(lblStaffContact);
		
		JLabel lblStaffId = new JLabel("STAFF ID");
		lblStaffId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStaffId.setBounds(191, 211, 123, 36);
		frame.getContentPane().add(lblStaffId);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO");
		lblPhoneNo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPhoneNo.setBounds(191, 272, 123, 36);
		frame.getContentPane().add(lblPhoneNo);
		
		txtId = new JTextField();
		txtId.setBounds(460, 219, 130, 26);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(460, 280, 194, 26);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		JButton button = new JButton("INSERT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		button.setBounds(130, 630, 117, 37);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("DELETE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Connection con = con();
					String query = "delete from Staff_contact where Emp_id='"+txtId.getText()+"' ";
					
					PreparedStatement pat=con.prepareStatement(query);
					pat.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted");
					
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		button_1.setBounds(388, 630, 117, 37);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Connection con = con();
				String query = "update Staff_contact set Emp_id=' "+txtId.getText()+" ', Emp_ph_no='"+txtPhone.getText()+"' where emp_id='"+txtId.getText()+"'  ";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Data Updated");
				ps.close();
			}catch (Exception e) {
				System.out.println("error:" + e);
			}
			}
		});
		button_2.setBounds(666, 630, 117, 37);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("DISPLAY");
		button_3.setBounds(903, 630, 117, 37);
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
		button_4.setBounds(960, 64, 133, 45);
		frame.getContentPane().add(button_4);
		
		JScrollPane scrollPane = new JScrollPane();
		final JTable table = new JTable();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = table.getValueAt(table.getSelectedRow(),0).toString();
				SetTextField(id);
			}
		});
		scrollPane.setBounds(79, 407, 965, 180);
		frame.getContentPane().add(scrollPane);
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
			String query = "insert into Staff_contact values(?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtId.getText());
			ps.setString(2, txtPhone.getText());
			
			
			
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!!");
		}catch (Exception e) {
			System.out.println("error:" + e);
		}
	}
	
	private void SetTextField(String id) {
		Connection con = con();
		try {
			String query = "select * from Staff_contact where id = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				txtId.setText(rs.getString("Emp_id"));
				txtPhone.setText(rs.getString("Emp_ph_no"));
				
			}
			ps.close();
			con.close();
		}catch (Exception e) {
	System.out.println("error:" + e);
        }
	}
}
	
