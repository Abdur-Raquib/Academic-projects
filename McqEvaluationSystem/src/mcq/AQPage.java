package mcq;

import java.awt.BorderLayout;
import java.util.Date;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;

import com.mysql.cj.protocol.Resultset;

public class AQPage extends JFrame {

	private JPanel contentPane;
	private JTextField text_Qset;
	private JTextField text_op1;
	private JTextField text_op2;
	private JTextField text_op3;
	private JTextField text_op4;
	private Connection con;
	private PreparedStatement pst;
	private JTextField text_Cans;
	private JTextField text_qstn;
	private JLabel qstn_id;
	private String q_id= null;
	private String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AQPage frame = new AQPage();
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
	public AQPage() {
		setUndecorated(true);
		setBounds(50, 138, 1260, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(0.0f);
		panel.setBounds(0, 0, 1260, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("Add Question");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblNewLabel.setBounds(73, 11, 324, 71);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(1070, 25, 94, 42);
		panel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		separator.setBounds(10, 93, 1240, 5);
		panel.add(separator);
		
		JLabel Question_Set = new JLabel("Question Set:");
		Question_Set.setHorizontalAlignment(SwingConstants.LEFT);
		Question_Set.setFont(new Font("Tahoma", Font.BOLD, 14));
		Question_Set.setBounds(149, 140, 106, 27);
		panel.add(Question_Set);
		
		text_Qset = new JTextField();
		text_Qset.setBounds(265, 145, 86, 20);
		panel.add(text_Qset);
		text_Qset.setColumns(10);
		
		JLabel Question_ID = new JLabel("Question ID: ");
		Question_ID.setHorizontalAlignment(SwingConstants.LEFT);
		Question_ID.setFont(new Font("Tahoma", Font.BOLD, 14));
		Question_ID.setBounds(149, 183, 94, 20);
		panel.add(Question_ID);
		
		qstn_id = new JLabel("1");
		qstn_id.setHorizontalAlignment(SwingConstants.CENTER);
		qstn_id.setBackground(Color.LIGHT_GRAY);
		qstn_id.setFont(new Font("Tahoma", Font.BOLD, 14));
		qstn_id.setBounds(253, 183, 35, 20);
		panel.add(qstn_id);
		
		JLabel Question = new JLabel("Question :");
		Question.setAlignmentY(0.0f);
		Question.setHorizontalAlignment(SwingConstants.LEFT);
		Question.setFont(new Font("Tahoma", Font.BOLD, 14));
		Question.setBounds(149, 239, 94, 20);
		panel.add(Question);
		
		JLabel Option_1 = new JLabel("Option 1: ");
		Option_1.setAlignmentY(0.0f);
		Option_1.setHorizontalAlignment(SwingConstants.LEFT);
		Option_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Option_1.setBounds(149, 288, 94, 20);
		panel.add(Option_1);
		
		JLabel Option_2 = new JLabel("Option 2: ");
		Option_2.setAlignmentY(0.0f);
		Option_2.setHorizontalAlignment(SwingConstants.LEFT);
		Option_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		Option_2.setBounds(149, 320, 94, 20);
		panel.add(Option_2);
		
		JLabel Option_3 = new JLabel("Option 3: ");
		Option_3.setAlignmentY(0.0f);
		Option_3.setHorizontalAlignment(SwingConstants.LEFT);
		Option_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		Option_3.setBounds(149, 351, 94, 20);
		panel.add(Option_3);
		
		JLabel Option_4 = new JLabel("Option 4: ");
		Option_4.setAlignmentY(0.0f);
		Option_4.setHorizontalAlignment(SwingConstants.LEFT);
		Option_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		Option_4.setBounds(149, 382, 94, 20);
		panel.add(Option_4);
		
		JButton S_btn = new JButton("Save");
		S_btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/test1","root","");
					name = String.valueOf(text_Qset.getText());
					String create = "CREATE TABLE IF NOT EXISTS "+name+" (id INT(11), question VARCHAR(250), op1 VARCHAR(250), op2 VARCHAR(250), op3 VARCHAR(250), op4 VARCHAR(250), corAns VARCHAR(250),PRIMARY KEY(id))";
					 Statement stm = con.createStatement();
					 stm.executeUpdate(create);
					 q_id = qstn_id.getText();
					 
					 String query = "INSERT INTO `"+name+"` (`id`, `question`, `op1`, `op2`, `op3`, `op4`, `corAns`) VALUES (?,?,?,?,?,?,?)";
					 pst = con.prepareStatement(query);
					 pst.setString(1, q_id);
					 pst.setString(2, text_qstn.getText());
					 pst.setString(3, text_op1.getText());
					 pst.setString(4, text_op2.getText());
					 pst.setString(5, text_op3.getText());
					 pst.setString(6, text_op4.getText());
					 pst.setString(7, text_Cans.getText());
					 pst.executeUpdate();
					 JOptionPane.showMessageDialog(null, "succesfully Save");
					 setVisible(false);
						setVisible(true);
						String str = qstn_id.getText();
						int id = Integer.parseInt(str);
						id+=1;
						qstn_id.setText(String.valueOf(id));
						text_qstn.setText("");
						text_op1.setText("");
						text_op2.setText("");
						text_op3.setText("");
						text_op4.setText("");
						text_Cans.setText("");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		S_btn.setFont(new Font("Tahoma", Font.BOLD, 18));
		S_btn.setBounds(636, 464, 89, 23);
		panel.add(S_btn);
		
		text_op1 = new JTextField();
		text_op1.setBounds(253, 290, 973, 20);
		panel.add(text_op1);
		text_op1.setColumns(10);
		
		text_op2 = new JTextField();
		text_op2.setColumns(10);
		text_op2.setBounds(253, 322, 973, 20);
		panel.add(text_op2);
		
		text_op3 = new JTextField();
		text_op3.setColumns(10);
		text_op3.setBounds(253, 353, 973, 20);
		panel.add(text_op3);
		
		text_op4 = new JTextField();
		text_op4.setColumns(10);
		text_op4.setBounds(253, 384, 973, 20);
		panel.add(text_op4);
		
		JLabel Option_4_1 = new JLabel("Correct Answer:");
		Option_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		Option_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Option_4_1.setAlignmentY(0.0f);
		Option_4_1.setBounds(149, 419, 126, 20);
		panel.add(Option_4_1);
		
		text_Cans = new JTextField();
		text_Cans.setColumns(10);
		text_Cans.setBounds(285, 421, 941, 20);
		panel.add(text_Cans);
		
		text_qstn = new JTextField();
		text_qstn.setColumns(10);
		text_qstn.setBounds(253, 239, 973, 29);
		panel.add(text_qstn);
		
		
	}
}
