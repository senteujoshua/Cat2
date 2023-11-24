package formativeLeson11;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Cat2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nametextField;
	private JTextField userNametextField;
	private JTextField PasswordtextField;
	private JTextField ConfirmPasstextField;
	private JTextField Email_textField;
	private JTextField Phone_textField;
	private JTextField Adress_textf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cat2 frame = new Cat2();
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
	public Cat2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(22, 10, 144, 25);
		contentPane.add(lblNewLabel);
		
		JLabel NameLabel = new JLabel("Name:");
		NameLabel.setBounds(32, 44, 45, 13);
		contentPane.add(NameLabel);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setBounds(32, 67, 61, 13);
		contentPane.add(UsernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(32, 90, 61, 13);
		contentPane.add(passwordLabel);
		
		JLabel ConfirmPassLabel = new JLabel("Confirm Password");
		ConfirmPassLabel.setBounds(32, 113, 100, 13);
		contentPane.add(ConfirmPassLabel);
		
		JLabel EmailLabel = new JLabel("Email:");
		EmailLabel.setBounds(32, 136, 45, 13);
		contentPane.add(EmailLabel);
		
		JLabel PhoneNumberLabel = new JLabel("Phone:");
		PhoneNumberLabel.setBounds(32, 159, 45, 13);
		contentPane.add(PhoneNumberLabel);
		
		JLabel Addresslabel = new JLabel("Address");
		Addresslabel.setBounds(32, 182, 45, 13);
		contentPane.add(Addresslabel);
		
		nametextField = new JTextField();
		nametextField.setBounds(142, 41, 185, 19);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		userNametextField = new JTextField();
		userNametextField.setColumns(10);
		userNametextField.setBounds(142, 64, 185, 19);
		contentPane.add(userNametextField);
		
		PasswordtextField = new JTextField();
		PasswordtextField.setToolTipText("");
		PasswordtextField.setColumns(10);
		PasswordtextField.setBounds(142, 87, 185, 19);
		contentPane.add(PasswordtextField);
		
		ConfirmPasstextField = new JTextField();
		ConfirmPasstextField.setColumns(10);
		ConfirmPasstextField.setBounds(142, 110, 185, 19);
		contentPane.add(ConfirmPasstextField);
		
		Email_textField = new JTextField();
		Email_textField.setColumns(10);
		Email_textField.setBounds(142, 133, 185, 19);
		contentPane.add(Email_textField);
		
		Phone_textField = new JTextField();
		Phone_textField.setColumns(10);
		Phone_textField.setBounds(142, 156, 185, 19);
		contentPane.add(Phone_textField);
		
		Adress_textf = new JTextField();
		Adress_textf.setColumns(10);
		Adress_textf.setBounds(142, 179, 185, 19);
		contentPane.add(Adress_textf);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=nametextField.getText();
				String Username=userNametextField.getText();
				String Password=PasswordtextField.getText();
				String Email=Email_textField.getText();
				String PhoneNumb=Phone_textField.getText();
				String Address=Adress_textf.getText();
				String ConfirmPassword=ConfirmPasstextField.getText();
				
				
				
				 try {
	                    
	                    Class.forName("com.mysql.cj.jdbc.Driver");

	                    // Replace the placeholder values with your actual database credentials and connection details
	                    //Class.forName("com.mysql.cj.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration","root","0928");
	    				String sql="select * from login where name=? AND Username=? AND Password=? AND Email=? AND PhoneNumb=? AND Address=?";
	    				PreparedStatement pst=con.prepareStatement(sql);
	    				pst.setString(1,Name);
	    				pst.setString(2,Username);
	    				pst.setString(3,Password);
	    				pst.setString(4,Email);
	    				pst.setString(5,PhoneNumb);
	    				pst.setString(6,Address);
	    				
	    				ResultSet rs=pst.executeQuery();
	                 
	                    

	                  

	                } catch(Exception e1){
						System.out.println(e1);
						}
				}
	            
			}
		);
		submitBtn.setBounds(90, 221, 85, 21);
		contentPane.add(submitBtn);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nametextField.setText("");
				userNametextField.setText("");
				PasswordtextField.setText("");
				ConfirmPasstextField.setText("");
				Email_textField.setText("");
				Phone_textField.setText("");
				Adress_textf.setText("");
		
				
			}
		});
		btnReset.setBounds(204, 221, 85, 21);
		contentPane.add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnClose.setBounds(311, 221, 85, 21);
		contentPane.add(btnClose);
	}
}
