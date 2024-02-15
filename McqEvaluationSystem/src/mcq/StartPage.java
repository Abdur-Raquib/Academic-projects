package mcq;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage frame = new StartPage();
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
	public StartPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 50, 1300, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quiz ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(554, 251, 89, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(654, 251, 163, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1 = textField.getText().trim().toLowerCase();
				String str2 = textField_1.getText();
				ExamPage ex = new ExamPage(str1,str2);
				ex.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(612, 308, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblUser = new JLabel("User Name :");
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(525, 202, 118, 23);
		contentPane.add(lblUser);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(654, 205, 163, 23);
		contentPane.add(textField_1);
	}
}
