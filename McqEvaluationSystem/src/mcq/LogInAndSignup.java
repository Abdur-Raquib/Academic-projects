package mcq;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInAndSignup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInAndSignup frame = new LogInAndSignup();
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
	public LogInAndSignup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 50, 1300, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TSignUpPage().setVisible(true);
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(584, 203, 118, 32);
		contentPane.add(btnNewButton);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TLogInPage().setVisible(true);
			}
		});
		btnLogIn.setFocusable(false);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogIn.setBounds(584, 276, 118, 32);
		contentPane.add(btnLogIn);
	}

}
