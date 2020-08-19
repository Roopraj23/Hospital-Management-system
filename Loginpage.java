import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loginpage {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage window = new Loginpage();
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
	public Loginpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoginPage = new JLabel("LOGIN PAGE");
		lblLoginPage.setFont(new Font("Arial", Font.BOLD, 25));
		lblLoginPage.setForeground(Color.BLUE);
		lblLoginPage.setBounds(161, 6, 156, 30);
		frame.getContentPane().add(lblLoginPage);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsername.setBounds(42, 97, 112, 30);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(40, 170, 114, 30);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(188, 97, 170, 30);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(188, 170, 170, 30);
		frame.getContentPane().add(txtPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 63, 428, 12);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 260, 428, 12);
		frame.getContentPane().add(separator_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
				if(password.contains("12345")&& username.contains("rjcreate")) {
					txtPassword.setText(null);
					txtUsername.setText(null);
					
					//Home info = new Home();
					Home.main(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Eroor", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
				
			}
		});
		btnNewButton.setBounds(17, 299, 117, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(188, 299, 117, 41);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Loginpage = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(Loginpage, "Confirm if you want to exit","Login Page",
					JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(352, 299, 117, 41);
		frame.getContentPane().add(btnExit);
	}
}
