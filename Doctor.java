import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Doctor {

	public JFrame frame;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtSpl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor window = new Doctor();
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
	public Doctor() {
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
		
		JLabel lblNewLabel = new JLabel("VISITING DOCTOR DETAILS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(369, 6, 407, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DOCTOR ID");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(130, 201, 122, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDoctorName = new JLabel("DOCTOR NAME");
		lblDoctorName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblDoctorName.setBounds(130, 307, 170, 25);
		frame.getContentPane().add(lblDoctorName);
		
		JLabel lblSp = new JLabel("SPECIALIST");
		lblSp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSp.setBounds(130, 410, 122, 25);
		frame.getContentPane().add(lblSp);
		
		txtId = new JTextField();
		txtId.setBounds(432, 203, 130, 26);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setText("DR.");
		txtName.setBounds(432, 293, 344, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtSpl = new JTextField();
		txtSpl.setBounds(432, 410, 518, 26);
		frame.getContentPane().add(txtSpl);
		txtSpl.setColumns(10);
		
		JButton button = new JButton("INSERT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
			
		});
		button.setBounds(119, 624, 117, 37);
		frame.getContentPane().add(button);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Connection con = con();
				String query = "update Visiting_doctor set doc_id=' "+txtId.getText()+" ', doc_name='"+txtName.getText()+"', doc_spl='"+txtSpl.getText()+"' where doc_id='"+txtId.getText()+"' ";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Data Updated");
				ps.close();
			}catch (Exception e) {
				System.out.println("error:" + e);
			}
			}
		});
		button_2.setBounds(518, 624, 117, 37);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("DISPLAY");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

                Doctordisplay p1 = new Doctordisplay();

       p1.frame.setVisible(true);
			}
		});
		button_3.setBounds(913, 624, 117, 37);
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
		button_1.setBounds(929, 79, 133, 45);
		frame.getContentPane().add(button_1);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con =con();
				PreparedStatement pt;
				try {
					pt = con.prepareStatement("select doc_name, doc_spl from Visiting_doctor where doc_id = ?");
					pt.setString(1, txtId.getText());
					ResultSet rs = pt.executeQuery();
					while(rs.next()) {
						txtName.setText(rs.getString("doc_name"));
						txtSpl.setText(rs.getString("doc_spl"));
					}
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//pt.setString(1, );
			}
		});
		btnSearch.setBounds(605, 203, 117, 37);
		frame.getContentPane().add(btnSearch);
	}

	static Connection con() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
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
			String query = "insert into Visiting_doctor values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtId.getText());
			ps.setString(2, txtName.getText());
			ps.setString(3, txtSpl.getText());
			
			
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!!");
		}catch (Exception e) {
			System.out.println("error:" + e);
		}
	}
}
