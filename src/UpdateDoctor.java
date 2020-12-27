import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDoctor frame = new UpdateDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UpdateDoctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Doctor Information");
		lblNewLabel.setBounds(145, 6, 169, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor ID");
		lblNewLabel_1.setBounds(32, 46, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor Name");
		lblNewLabel_2.setBounds(32, 74, 89, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile No.");
		lblNewLabel_3.setBounds(32, 102, 78, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department ID");
		lblNewLabel_4.setBounds(32, 130, 100, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Login ID");
		lblNewLabel_5.setBounds(32, 158, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setBounds(32, 186, 61, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Status");
		lblNewLabel_7.setBounds(32, 215, 61, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Education");
		lblNewLabel_8.setBounds(32, 244, 78, 16);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Experience");
		lblNewLabel_9.setBounds(32, 272, 78, 16);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Consult. Charge");
		lblNewLabel_10.setBounds(32, 300, 111, 16);
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminPortal m = new AdminPortal();
				m.setVisible(true);
			}
		});
		btnNewButton.setBounds(58, 336, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t1 = Integer.parseInt(textField.getText());
				String t2 = textField_1.getText();
				String t3 = textField_2.getText();
				int t4 = Integer.parseInt(textField_3.getText());
				String t5 = textField_4.getText();
				String t6 = textField_5.getText();
				String t7 = textField_6.getText();
				String t8 = textField_7.getText();
				float t9 = Float.parseFloat(textField_8.getText());
				float t10 = Float.parseFloat(textField_9.getText());
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection conn;
					conn = DriverManager.getConnection("jdbc:mysql://localhost/Project?autoReconnect=true&useSSL=false", "root", "root");
					Statement stmt = conn.createStatement();
					String sql_1 = "Select doctorid from doctor";
					ResultSet result = stmt.executeQuery(sql_1);
					int flag = 0;
					while(result.next()){
						String test = result.getString("doctorid");
						String mark = String.valueOf(t1);
						if(mark.equals(test)) {
							flag = 1;
							break;
						}
					}
					if(flag == 1) {
						String sql = "UPDATE doctor set doctorid = "+ t1 + ", doctorname = '"+t2+ "', mobileno = '"+t3+ "', departmentid = "+t4+", loginid = '" + t5 + "', password = '"+t6+"', status = '"+t7+"', education = '"+t8+"', experience = "+t9+", consultancy_charge = "+t10+ " where doctorid = "+ t1;
						stmt.executeUpdate(sql);
					} else {
						String sql_2 = "Insert into doctor values ('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"','"+t6+"','"+t7+"','"+t8+"','"+t9+"','"+t10+"')";
						stmt.executeUpdate(sql_2);
					}
					
					textField.setText(" ");
					textField_1.setText(" ");
					textField_2.setText(" ");
					textField_3.setText(" ");
					textField_4.setText(" ");
					textField_5.setText(" ");
					textField_6.setText(" ");
					textField_7.setText(" ");
					textField_8.setText(" ");
					textField_9.setText(" ");
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(228, 336, 117, 29);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(145, 41, 256, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 69, 256, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 97, 256, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 125, 256, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(145, 153, 256, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(145, 181, 256, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(145, 210, 256, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(145, 239, 256, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(145, 267, 256, 26);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(145, 295, 256, 26);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
	}

}
