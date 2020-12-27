import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Doctor_Timings extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_Timings frame = new Doctor_Timings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Doctor_Timings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctor Timings");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(164, 6, 116, 16);
		contentPane.add(lblNewLabel);
		
		
		String[] column_names = {"Doctor ID","Start Time","End Time","Status"};
		int index = 0;
		String[][] data = new String[20][];
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Project?autoReconnect=true&useSSL=false", "root", "root");
			Statement stmt = conn.createStatement();
			String sql = "Select * from doctor_timings";
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()){
				String doctor_id = result.getString("doctorid");
				String StartTime = result.getString("start_time");
				String EndTime = result.getString("end_time");
				String Status = result.getString("status");
				data[index] = new String[4];
				data[index][0] = doctor_id;
				data[index][1] = StartTime;
				data[index][2] = EndTime;
				data[index][3] = Status;
				index += 1;
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		
		table = new JTable(data,column_names);
		table.setBounds(38, 67, 371, 232);
		contentPane.add(table);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminPortal ad = new AdminPortal();
				ad.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(163, 304, 117, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Doctor ID");
		lblNewLabel_1.setBounds(38, 39, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Start Time");
		lblNewLabel_2.setBounds(128, 39, 64, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("End Time");
		lblNewLabel_3.setBounds(228, 39, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Status");
		lblNewLabel_4.setBounds(318, 39, 61, 16);
		contentPane.add(lblNewLabel_4);
		
	}
}
