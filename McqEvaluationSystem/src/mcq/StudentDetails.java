package mcq;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class StudentDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Connection con;
	private PreparedStatement pst;
	private JRadioButton m_btn_1, f_btn_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails frame = new StudentDetails();
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
	public StudentDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 50, 1300, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Full Name :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(428, 149, 130, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(428, 186, 130, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(428, 228, 130, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobail No. :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(428, 271, 130, 20);
		contentPane.add(lblNewLabel_3);
		textField = new JTextField();
		textField.setBounds(568, 149, 312, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(568, 188, 312, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(568, 273, 312, 22);
		contentPane.add(textField_2);
		
		m_btn_1 = new JRadioButton("Male");
		m_btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m_btn_1.isSelected()) {
					f_btn_2.setSelected(false);
				}
			}
		});
		m_btn_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		m_btn_1.setBounds(568, 229, 74, 23);
		contentPane.add(m_btn_1);
		
		f_btn_2 = new JRadioButton("Femal");
		f_btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f_btn_2.isSelected()) {
					m_btn_1.setSelected(false);
				}
			}
		});
		f_btn_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		f_btn_2.setBounds(664, 229, 74, 23);
		contentPane.add(f_btn_2);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String gn=null;
					if(m_btn_1.isSelected()) {
						gn = m_btn_1.getText();
					}
					else if(f_btn_2.isSelected()) {
						gn = f_btn_2.getText();;
					}
					String query = "INSERT INTO `student`(`fname`, `email`, `gender`, `mobile`) VALUES (?,?,?,?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost/teacher","root","");
					pst = con.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, gn);
					pst.setString(4, textField_2.getText());
					pst.executeUpdate();
					setVisible(false);
					new StartPage().setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(643, 319, 95, 29);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HomePage().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(512, 319, 95, 29);
		contentPane.add(btnBack);
		
	}
}
