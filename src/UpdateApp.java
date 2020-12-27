import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateApp extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateApp frame = new UpdateApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Appointment");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(176, 6, 150, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Appointment ID");
		lblNewLabel_1.setBounds(27, 38, 115, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Appointment Type");
		lblNewLabel_2.setBounds(27, 65, 127, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Patient ID");
		lblNewLabel_3.setBounds(27, 93, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Room ID");
		lblNewLabel_4.setBounds(27, 121, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Department ID");
		lblNewLabel_5.setBounds(27, 148, 105, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Appointment Date");
		lblNewLabel_6.setBounds(27, 173, 127, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Appointment Time");
		lblNewLabel_7.setBounds(27, 201, 127, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Doctor ID");
		lblNewLabel_8.setBounds(27, 229, 61, 16);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Status");
		lblNewLabel_9.setBounds(27, 256, 61, 16);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Appointment Reason");
		lblNewLabel_10.setBounds(27, 284, 144, 16);
		contentPane.add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setBounds(190, 34, 257, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 60, 257, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 88, 257, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 116, 257, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(190, 143, 257, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(190, 168, 257, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(190, 196, 257, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(190, 224, 257, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(190, 251, 257, 26);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(190, 279, 257, 26);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminPortal o = new AdminPortal();
				o.setVisible(true);
			}
		});
		btnNewButton.setBounds(85, 334, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ef) {
				
				String t1 = textField.getText();
				String t2 = textField_1.getText();
				String t3 = textField_2.getText();
				String t4 = textField_3.getText();
				String t5 = textField_4.getText();
				String t6 = textField_5.getText();
				String t7 = textField_6.getText();
				String t8 = textField_7.getText();
				String t9 = textField_8.getText();
				String t10 = textField_9.getText();
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection conn;
					conn = DriverManager.getConnection("jdbc:mysql://localhost/Project?autoReconnect=true&useSSL=false", "root", "root");
					Statement stmt = conn.createStatement();
					String sql_1 = "Select appointmentid from appointment";
					ResultSet result = stmt.executeQuery(sql_1);
					int flag = 0;
					while(result.next()){
						String test = result.getString("appointmentid");
						String mark = String.valueOf(t1);
						if(mark.equals(test)) {
							flag = 1;
							break;
						}
					}
					if(flag == 1) {
						String sql = "UPDATE appointment set appointmentid = "+ t1 + ", appointmenttype = '"+t2+ "', patientid = '"+t3+ "', roomid = "+t4+", departmentid = '" + t5 + "', appointmentdate = '"+t6+"', appointmenttime = '"+t7+"', doctorid = '"+t8+"', status = '"+t9+"', app_reason = '"+t10+ "' where appointmentid = "+ t1;
						stmt.executeUpdate(sql);
					} else {
						String sql_2 = "Insert into appointment values ('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"','"+t6+"','"+t7+"','"+t8+"','"+t9+"','"+t10+"')";
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
		btnNewButton_1.setBounds(266, 334, 117, 29);
		contentPane.add(btnNewButton_1);
	}

}
