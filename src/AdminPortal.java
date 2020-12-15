import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPortal extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPortal frame = new AdminPortal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdminPortal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(195, 6, 61, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Doctor Timings");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Doctor_Timings doctim = new Doctor_Timings();
				doctim.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(25, 74, 179, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Patients Log");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				ViewPAt pat = new ViewPAt();
				pat.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(133, 153, 179, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Appointments");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				ViewApp view = new ViewApp();
				view.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(25, 194, 179, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update Doctor Info");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				UpdateDoctor updoc = new UpdateDoctor();
				updoc.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(245, 74, 179, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update Appointment");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				UpdateApp upapp = new UpdateApp();
				upapp.setVisible(true);
				
			}
		});
		btnNewButton_4.setBounds(253, 194, 171, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Logout");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Main m = new Main();
				m.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(164, 276, 117, 29);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Delete Doctor Info");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DeleteDoctor a = new DeleteDoctor();
				a.setVisible(true);
				
			}
		});
		btnNewButton_6.setBounds(133, 112, 179, 29);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Delete Appointment");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DeleteAppointment b = new DeleteAppointment();
				b.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(133, 235, 179, 29);
		contentPane.add(btnNewButton_7);
	}
}
