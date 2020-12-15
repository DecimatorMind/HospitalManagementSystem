import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Main extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Heading = new JLabel("Hospital Management System");
		Heading.setBounds(5, 5, 440, 16);
		Heading.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(Heading);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(78, 86, 78, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(78, 132, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(168, 81, 168, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 127, 168, 26);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Login");
		lblNewLabel_2.setBounds(191, 33, 85, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(178, 165, 117, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection conn;
					conn = DriverManager.getConnection("jdbc:mysql://localhost/Project?autoReconnect=true&useSSL=false", "root", "Pranjal1");
					Statement stmt = conn.createStatement();
					String sql = "Select loginid, password from admin";
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
								AdminPortal admin = new AdminPortal();
								admin.setVisible(true);
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
		
		JButton btnNewButton_2 = new JButton("Doctor Login");
		btnNewButton_2.setBounds(85, 212, 117, 29);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				DoctorLogin doclog = new DoctorLogin();
				doclog.setVisible(true);
				
			}  
		});
		
		JButton btnNewButton_3 = new JButton("Patient Login");
		btnNewButton_3.setBounds(262, 212, 117, 29);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				PatientLogin patlog = new PatientLogin();
				patlog.setVisible(true);
			}  
		});
		 
		
	}
}
