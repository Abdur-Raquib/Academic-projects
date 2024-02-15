package mcq;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AdminPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setTitle("Mcq Evaluation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 50, 1300, 624);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(10, 0, 1264, 54);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Add Question");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AQPage().setVisible(true);
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("All Questions");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Questions");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete Questions");
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("All Student Result");
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Log Out");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TLogInPage().setVisible(true);
			}
		});
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Exit");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel ad = new AdminPanel();
				int a = JOptionPane.showConfirmDialog(ad, "Are You Sure?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_6.setFocusable(false);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnNewButton_6);
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar);
	}

}
