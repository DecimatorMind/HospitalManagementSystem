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
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewApp extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewApp frame = new ViewApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ViewApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appointments");
		lblNewLabel.setBounds(233, 6, 89, 16);
		contentPane.add(lblNewLabel);
		
		String[] column_names = {"patientid", "patientname", "admissiondate", "admissiontime", "address", "mobileno", "city", "pincode", "loginid", "password", "bloodgroup", "gender", "status"};
		int index = 0;
		String[][] data = new String[70][];
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Project?autoReconnect=true&useSSL=false", "root", "Pranjal1");
			Statement stmt = conn.createStatement();
			String sql = "Select * from appointment";
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()){
				String a = result.getString("appointmentid");
				String b = result.getString("appointmenttype");
				String c = result.getString("patientid");
				String d = result.getString("roomid");
				String e = result.getString("departmentid");
				String f = result.getString("appointmentdate");
				String g = result.getString("appointmenttime");
				String h = result.getString("doctorid");
				String i = result.getString("status");
				String j = result.getString("app_reason");
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
				index += 1;
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		table = new JTable(data,column_names);
		table.setBounds(6, 60, 537, 344);
		contentPane.add(table);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminPortal p = new AdminPortal();
				p.setVisible(true);
			}
		});
		btnNewButton.setBounds(218, 407, 117, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(6, 32, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Type");
		lblNewLabel_2.setBounds(37, 32, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Pat ID");
		lblNewLabel_3.setBounds(99, 32, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Room Id");
		lblNewLabel_4.setBounds(145, 32, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Dep ID");
		lblNewLabel_5.setBounds(218, 34, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Date");
		lblNewLabel_6.setBounds(274, 34, 61, 16);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Time");
		lblNewLabel_7.setBounds(321, 34, 61, 16);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Doc ID");
		lblNewLabel_8.setBounds(364, 34, 61, 16);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Status");
		lblNewLabel_9.setBounds(417, 34, 61, 16);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Reason");
		lblNewLabel_10.setBounds(471, 34, 61, 16);
		contentPane.add(lblNewLabel_10);
	}

}
