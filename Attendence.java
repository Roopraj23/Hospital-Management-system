import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Attendence {

	public JFrame frame;
	private JTextField txtId;
	private JTextField txtDate;
	private JTextField txtBeg;
	private JTextField txtDiff;
	private JTextField txtShift;
	private JTextField txtEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attendence window = new Attendence();
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
	public Attendence() {
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
		
		JLabel lblNewLabel = new JLabel("STAFF ATTENDENCE");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(405, 6, 310, 67);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblStaffId = new JLabel("STAFF ID");
		lblStaffId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStaffId.setBounds(145, 176, 133, 16);
		frame.getContentPane().add(lblStaffId);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblDate.setBounds(145, 260, 133, 16);
		frame.getContentPane().add(lblDate);
		
		JLabel lblBegining = new JLabel("BEGINNING TIME");
		lblBegining.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblBegining.setBounds(145, 338, 161, 16);
		frame.getContentPane().add(lblBegining);
		
		JLabel lblDiffernce = new JLabel("WORKED TIME");
		lblDiffernce.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblDiffernce.setBounds(145, 434, 171, 16);
		frame.getContentPane().add(lblDiffernce);
		
		JLabel lblShift = new JLabel("SHIFT");
		lblShift.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblShift.setBounds(145, 535, 133, 16);
		frame.getContentPane().add(lblShift);
		
		JLabel lblEndTime = new JLabel("END TIME");
		lblEndTime.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEndTime.setBounds(738, 338, 133, 16);
		frame.getContentPane().add(lblEndTime);
		
		JButton button = new JButton("INSERT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		button.setBounds(125, 645, 117, 37);
		frame.getContentPane().add(button);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {Connection con = con();
						String query = "delete from Attendance where Emp_id='"+txtId.getText()+"' ";
						
						PreparedStatement pat=con.prepareStatement(query);
						pat.execute();
						JOptionPane.showMessageDialog(null, "Data Deleted");
						
					}catch (Exception ex) {
						ex.printStackTrace();
					}
				
			}
		});
		btnDelete.setBounds(537, 649, 117, 37);
		frame.getContentPane().add(btnDelete);
		
		JButton button_3 = new JButton("DISPLAY");
		button_3.setBounds(924, 649, 117, 37);
		frame.getContentPane().add(button_3);
		
		txtId = new JTextField();
		txtId.setBounds(373, 174, 130, 26);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setBounds(373, 250, 130, 26);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtBeg = new JTextField();
		txtBeg.setBounds(373, 336, 103, 26);
		frame.getContentPane().add(txtBeg);
		txtBeg.setColumns(10);
		
		txtDiff = new JTextField();
		txtDiff.setBounds(373, 432, 103, 26);
		frame.getContentPane().add(txtDiff);
		txtDiff.setColumns(10);
		
		txtShift = new JTextField();
		txtShift.setBounds(373, 533, 103, 26);
		frame.getContentPane().add(txtShift);
		txtShift.setColumns(10);
		
		txtEnd = new JTextField();
		txtEnd.setBounds(902, 336, 103, 26);
		frame.getContentPane().add(txtEnd);
		txtEnd.setColumns(10);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                          frame.dispose();

                 Home p1 = new Home();

                 p1.frame.setVisible(true);

}

});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(SystemColor.activeCaptionText);
		btnNewButton.setBounds(971, 64, 133, 45);
		frame.getContentPane().add(btnNewButton);
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
			String query = "insert into Attendance values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtId.getText());
			ps.setString(2, txtDate.getText());
			ps.setString(3, txtBeg.getText());
			ps.setString(4, txtDiff.getText());
			ps.setString(5, txtEnd.getText());
			ps.setString(6, txtShift.getText());
			
			
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!!!!");
		}catch (Exception e) {
			System.out.println("error:" + e);
		}
	}
}
