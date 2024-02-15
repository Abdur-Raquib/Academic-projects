package mcq;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Window.Type;

public class HomePage extends JFrame {

	private JPanel HomePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setTitle("Mcq Evaluation System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/mcq/quiz.jpg")));
		setSize(new Dimension(886, 511));
		setBackground(SystemColor.controlText);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 50, 1300, 624);
		HomePage = new JPanel();
		HomePage.setBackground(new Color(153, 204, 51));
		HomePage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(HomePage);
		
		JButton btnNewButton = new JButton("Play Now");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new StudentDetails().setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnSignup = new JButton("Create Question");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LogInAndSignup().setVisible(true);
			}
		});
		btnSignup.setFocusable(false);
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSignup.setBackground(new Color(0, 255, 153));
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jf = new JFrame();
				int a =JOptionPane.showConfirmDialog(jf, "Are you sure?","confirm",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout gl_HomePage = new GroupLayout(HomePage);
		gl_HomePage.setHorizontalGroup(
			gl_HomePage.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_HomePage.createSequentialGroup()
					.addGap(548)
					.addGroup(gl_HomePage.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_HomePage.createParallelGroup(Alignment.LEADING)
							.addComponent(btnSignup, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
							.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
						.addGroup(gl_HomePage.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 70, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_1)
							.addGap(68)))
					.addGap(523))
		);
		gl_HomePage.setVerticalGroup(
			gl_HomePage.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_HomePage.createSequentialGroup()
					.addGap(198)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(btnSignup, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addGap(29)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addGap(185))
		);
		HomePage.setLayout(gl_HomePage);
	}
}
