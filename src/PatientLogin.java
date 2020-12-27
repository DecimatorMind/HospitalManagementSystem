import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PatientLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientLogin frame = new PatientLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public PatientLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(156, 21, 138, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(77, 74, 79, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(77, 116, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(178, 69, 177, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 111, 177, 26);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection conn;
					conn = DriverManager.getConnection("jdbc:mysql://localhost/Project?autoReconnect=true&useSSL=false", "root", "root");
					Statement stmt = conn.createStatement();
					String sql = "Select loginid, password from patient";
					ResultSet result = stmt.executeQuery(sql);
					String login = textField.getText();
					String password = passwordField.getText();
					int flag = 0;
					while(result.next()){
						String log = result.getString("loginid");
						String pass = result.getString("password");
						if(log.equals(login)){
							flag = 1;
							if(password.equals(pass)){
								setVisible(false);
								PatientView patview = new PatientView();
								patview.setVisible(true);
							} else {
								JFrame f = new JFrame("Error");
								JDialog d = new JDialog(f, "Wrong Password"); 
							}
						}
					}
					if(flag == 0){
						JFrame f = new JFrame("Error");
						JDialog d = new JDialog(f, "User not found");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(166, 161, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Register reg = new Register();
				reg.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(61, 214, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main ma = new Main();
				ma.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(261, 214, 117, 29);
		contentPane.add(btnNewButton_2);
	}

}
