import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPAt extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JButton btnNewButton;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPAt frame = new ViewPAt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ViewPAt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient's Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(202, 6, 149, 16);
		contentPane.add(lblNewLabel);
		
		
		String[] column_names = {"patientid", "patientname", "admissiondate", "admissiontime", "address", "mobileno", "city", "pincode", "loginid", "password", "bloodgroup", "gender", "status"};
		int index = 0;
		String[][] data = new String[40][];
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Project?autoReconnect=true&useSSL=false", "root", "root");
			Statement stmt = conn.createStatement();
			String sql = "Select * from patient";
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()){
				String a = result.getString("patientid");
				String b = result.getString("patientname");
				String c = result.getString("admissiondate");
				String d = result.getString("address");
				String e = result.getString("mobileno");
				String f = result.getString("city");
				String g = result.getString("pincode");
				String h = result.getString("loginid");
				String i = result.getString("password");
				String j = result.getString("bloodgroup");
				String k = result.getString("gender");
				String l = result.getString("status");
				data[index] = new String[13];
				data[index][0] = a;
				data[index][1] = b;
				data[index][2] = c;
				data[index][3] = d;
				data[index][4] = e;
				data[index][5] = f;
				data[index][6] = g;
				data[index][7] = h;
				data[index][8] = i;
				data[index][9] = j;
				data[index][10] = k;
				data[index][11] = l;
				index += 1;
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		table = new JTable(data,column_names);
		table.setBounds(6, 68, 546, 353);
		contentPane.add(table);
		
		lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setBounds(6, 45, 17, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(28, 45, 44, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Add Date");
		lblNewLabel_3.setBounds(67, 45, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Add Time");
		lblNewLabel_4.setBounds(131, 45, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setBounds(198, 45, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Mobile");
		lblNewLabel_6.setBounds(257, 45, 61, 16);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("City");
		lblNewLabel_7.setBounds(311, 45, 32, 16);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Pin");
		lblNewLabel_8.setBounds(347, 45, 61, 16);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Login");
		lblNewLabel_9.setBounds(377, 45, 61, 16);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Pass");
		lblNewLabel_10.setBounds(420, 45, 61, 16);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Blood");
		lblNewLabel_11.setBounds(450, 45, 61, 16);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Gender");
		lblNewLabel_12.setBounds(491, 45, 61, 16);
		contentPane.add(lblNewLabel_12);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminPortal n = new AdminPortal();
				n.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(219, 433, 117, 29);
		contentPane.add(btnNewButton);
	}

}
