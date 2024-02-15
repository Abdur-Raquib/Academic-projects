package mcq;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.PreparableStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class TSignUpPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtfname;
	private JTextField txtemail;
	private JTextField txtinst;
	private Connection con = null;
	private PreparedStatement pst = null;
	private JButton btnBack;
	private JPasswordField txtpass;
	private JPasswordField txtcpass;
	JLabel lblNewLabel_1 ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TSignUpPage frame = new TSignUpPage();
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
	public TSignUpPage() {
		setTitle("Mcq Evaluation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 50, 1300, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Full Name :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(438, 100, 188, 36);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(438, 152, 188, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New Password :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(438, 201, 188, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(438, 248, 188, 36);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Institute :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(438, 295, 188, 36);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "INSERT INTO `teacherreg`(`fname`, `email`, `password`, `institute`) VALUES (?, ?, ?, ?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost/teacher","root","");
					pst = con.prepareStatement(query);
					pst.setString(1, txtfname.getText());
					pst.setString(2, txtemail.getText());
					pst.setString(3, txtpass.getText());
					pst.setString(4, txtinst.getText());
					if(!txtpass.equals(txtcpass)) {
						lblNewLabel_1.setText("password doesn't match");
					}
					else {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "registered succesfully");
						setVisible(false);
						new TLogInPage().setVisible(true);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(667, 384, 101, 36);
		contentPane.add(btnNewButton);
		
		txtfname = new JTextField();
		txtfname.setBounds(636, 105, 220, 30);
		contentPane.add(txtfname);
		txtfname.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(636, 157, 220, 30);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtinst = new JTextField();
		txtinst.setBounds(636, 305, 220, 30);
		contentPane.add(txtinst);
		txtinst.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LogInAndSignup().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(525, 384, 101, 36);
		contentPane.add(btnBack);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("show");
		rdbtnNewRadioButton.setFocusable(false);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					txtpass.setEchoChar((char)0);
				}
				else {
					txtpass.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton.setBounds(873, 214, 59, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("show");
		rdbtnNewRadioButton_1.setFocusable(false);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					txtcpass.setEchoChar((char)0);
				}
				else {
					txtcpass.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton_1.setBounds(873, 256, 59, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(635, 206, 221, 30);
		contentPane.add(txtpass);
		
		txtcpass = new JPasswordField();
		txtcpass.setBounds(636, 253, 221, 30);
		contentPane.add(txtcpass);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(636, 343, 220, 14);
		contentPane.add(lblNewLabel_1);
	}
}
