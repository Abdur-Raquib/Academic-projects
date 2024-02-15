package mcq;



import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExamPage extends JFrame {

	private JPanel contentPane;
	protected JLabel lblNewLabel_5,lblNewLabel_1,lblNewLabel_4 ;
	private JRadioButton rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_2,rdbtnNewRadioButton_3;
	private Connection con, con1;
	private PreparedStatement pst, pst1;
	protected String Q_set;
	protected String user;
	private int id = 2;
	
	private int min = 0;
	private int sec = 59;
	
	private int score = 0;
	private String Q_answer;
	private String selecAnswer;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamPage frame = new ExamPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Timer time;
	
	public ExamPage(String s,String user) {
		this.Q_set = s;
		this.user=user;
		initComponent();
	}
	
	/**
	 * Create the frame.
	 */
	public ExamPage() {
		initComponent();
}

public void initComponent() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(30, 50, 1300, 624);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.PINK);
	panel.setBounds(0, 0, 1284, 84);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Level - ");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel.setBounds(578, 30, 76, 29);
	panel.add(lblNewLabel);
	
	JLabel lblNewLabel_2 = new JLabel("1");
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_2.setBounds(653, 30, 27, 29);
	panel.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3_1 = new JLabel("Times Remain");
	lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_3_1.setBounds(1135, 11, 109, 23);
	panel.add(lblNewLabel_3_1);
	
	JLabel lblNewLabel_3_2 = new JLabel("00");
	lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblNewLabel_3_2.setBounds(10, 30, 109, 23);
	panel.add(lblNewLabel_3_2);
	
	JLabel lblNewLabel_3_1_1 = new JLabel("Score");
	lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_3_1_1.setBounds(10, 11, 109, 23);
	panel.add(lblNewLabel_3_1_1);
	
	JLabel lblNewLabel_3 = new JLabel("00");
	lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_3.setBounds(1145, 41, 21, 18);
	panel.add(lblNewLabel_3);
	
	JLabel lblNewLabel_3_3 = new JLabel(":");
	lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_3_3.setBounds(1168, 41, 5, 18);
	panel.add(lblNewLabel_3_3);
	
	JLabel lblNewLabel_3_4 = new JLabel("00");
	lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.LEFT);
	lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_3_4.setBounds(1176, 41, 21, 18);
	panel.add(lblNewLabel_3_4);
	
	rdbtnNewRadioButton = new JRadioButton("New radio button");
	rdbtnNewRadioButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnNewRadioButton.isSelected()) {
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton_3.setSelected(false);
			}
		}
	});
	rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnNewRadioButton.setBounds(427, 219, 229, 35);
	contentPane.add(rdbtnNewRadioButton);
	
	rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
	rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnNewRadioButton_1.isSelected()) {
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton_3.setSelected(false);
			}
		}
	});
	rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnNewRadioButton_1.setBounds(427, 264, 229, 35);
	contentPane.add(rdbtnNewRadioButton_1);
	
	rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
	rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnNewRadioButton_2.isSelected()) {
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_3.setSelected(false);
			}
		}
	});
	rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnNewRadioButton_2.setBounds(679, 219, 206, 35);
	contentPane.add(rdbtnNewRadioButton_2);
	
	rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
	rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnNewRadioButton_3.isSelected()) {
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton.setSelected(false);
			}
		}
	});
	rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
	rdbtnNewRadioButton_3.setBounds(679, 264, 206, 35);
	contentPane.add(rdbtnNewRadioButton_3);
	
	
	JButton btnNewButton = new JButton("Next");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnNewRadioButton.isSelected()) {
				selecAnswer = rdbtnNewRadioButton.getText();
			}
			
			else if(rdbtnNewRadioButton_1.isSelected()) {
				selecAnswer = rdbtnNewRadioButton_1.getText();
			}
			
			else if(rdbtnNewRadioButton_2.isSelected()) {
				selecAnswer = rdbtnNewRadioButton_2.getText();
			}
			
			else if(rdbtnNewRadioButton_3.isSelected()) {
				selecAnswer = rdbtnNewRadioButton_3.getText();
			}
			time.stop();
			if(selecAnswer.equals(Q_answer)) {
				int sc = Integer.parseInt(lblNewLabel_3_4.getText());
				score +=(sc*100);
				lblNewLabel_3_2.setText(String.valueOf(score));
			}
			
			
			sec = 59;
			time.restart();
			
			rdbtnNewRadioButton.setSelected(false);
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton_2.setSelected(false);
			rdbtnNewRadioButton_3.setSelected(false);
			
		
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/test1","root","");
				pst = con.prepareStatement("SELECT * FROM `"+Q_set+"` WHERE id = "+id+"");
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					lblNewLabel_2.setText(rs.getString(1));
					lblNewLabel_1.setText(rs.getString(2));
					rdbtnNewRadioButton.setText(rs.getString(3));
					rdbtnNewRadioButton_1.setText(rs.getString(4));
					rdbtnNewRadioButton_2.setText(rs.getString(5));
					rdbtnNewRadioButton_3.setText(rs.getString(6));
					Q_answer = rs.getString(7);
				}
				if(id>Integer.parseInt(lblNewLabel_2.getText())) {
					panel.setVisible(false);
					lblNewLabel_1.setVisible(false);
					rdbtnNewRadioButton.setVisible(false);
					rdbtnNewRadioButton_1.setVisible(false);
					rdbtnNewRadioButton_2.setVisible(false);
					rdbtnNewRadioButton_3.setVisible(false);
					btnNewButton.setVisible(false);
					lblNewLabel_4.setVisible(true);
					lblNewLabel_4.setText("Your Score : "+lblNewLabel_3_2.getText()); 
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/teacher","root","");
					pst1 = con1.prepareStatement("UPDATE `student` SET `result`="+lblNewLabel_3_2.getText()+" WHERE fname='"+user+"'");
					pst1.executeUpdate();
				}
								
				id+=1;
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		}
	});
	btnNewButton.setBackground(UIManager.getColor("textHighlight"));
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btnNewButton.setBounds(594, 351, 89, 35);
	contentPane.add(btnNewButton);
	
	lblNewLabel_1 = new JLabel("here will be the question");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_1.setBackground(new Color(50, 205, 50));
	lblNewLabel_1.setBounds(166, 128, 960, 46);
	contentPane.add(lblNewLabel_1);
	
	lblNewLabel_4 = new JLabel("Extra level");
	lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 24));
	lblNewLabel_4.setBounds(476, 219, 252, 80);
	lblNewLabel_4.setVisible(false);
	contentPane.add(lblNewLabel_4);
		
	
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost/test1","root","");
		pst = con.prepareStatement("SELECT * FROM `"+Q_set+"` WHERE id = 1");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			lblNewLabel_2.setText(rs.getString(1));
			lblNewLabel_1.setText(rs.getString(2));
			rdbtnNewRadioButton.setText(rs.getString(3));
			rdbtnNewRadioButton_1.setText(rs.getString(4));
			rdbtnNewRadioButton_2.setText(rs.getString(5));
			rdbtnNewRadioButton_3.setText(rs.getString(6));
			Q_answer = rs.getString(7);
		}
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	}
	
	
	time = new Timer (1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			lblNewLabel_3_4.setText(String.valueOf(sec));
			lblNewLabel_3.setText(String.valueOf(min));
			
			if(sec==0) {
				sec = 59;
	
				time.stop();
				
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton_3.setSelected(false);
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/test1","root","");
					pst = con.prepareStatement("SELECT * FROM `"+Q_set+"` WHERE id = "+id+"");
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						lblNewLabel_2.setText(rs.getString(1));
						lblNewLabel_1.setText(rs.getString(2));
						rdbtnNewRadioButton.setText(rs.getString(3));
						rdbtnNewRadioButton_1.setText(rs.getString(4));
						rdbtnNewRadioButton_2.setText(rs.getString(5));
						rdbtnNewRadioButton_3.setText(rs.getString(6));
						Q_answer = rs.getString(7);
					}
					
					if(id>Integer.parseInt(lblNewLabel_2.getText())) {
						panel.setVisible(false);
						lblNewLabel_1.setVisible(false);
						rdbtnNewRadioButton.setVisible(false);
						rdbtnNewRadioButton_1.setVisible(false);
						rdbtnNewRadioButton_2.setVisible(false);
						rdbtnNewRadioButton_3.setVisible(false);
						btnNewButton.setVisible(false);
						lblNewLabel_4.setVisible(true);
						lblNewLabel_4.setText("Your Score : "+lblNewLabel_3_2.getText());
						con1 = DriverManager.getConnection("jdbc:mysql://localhost/teacher","root","");
						pst1 = con1.prepareStatement("UPDATE `student` SET `result`="+lblNewLabel_3_2.getText()+" WHERE fname='"+user+"'");
						pst1.executeUpdate();
					}
					
					id+=1;
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				sec = 59;
				time.restart();
			}
			sec--;
		}
	});
	
	time.start();
	
}
}