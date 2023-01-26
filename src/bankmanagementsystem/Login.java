package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	JButton login, clear, signup;
	JTextField  cardTextField ;
	JPasswordField  pinTextField;
	Login(String cardnumber , String pinnumber){
		
		setTitle("ATM");

		setLayout(null);
		
		ImageIcon  iconOne = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		
		Image  iconTwo = iconOne.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT );
		
		// we can not add image directly to JLable that's why we have to ImageIcon again then add it to JLabel
		ImageIcon iconThree = new ImageIcon(iconTwo);
		
		JLabel  label = new JLabel(iconThree);
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setBounds(200, 40, 400, 40);
		add(text);
		text.setFont(new Font("osward", Font.BOLD, 38));
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setBounds(120, 150, 400, 40);
		add(cardno);
		cardno.setFont(new Font("Ralway", Font.BOLD, 28));
		
	    cardTextField = new JTextField(); 
		cardTextField.setBounds(300, 150, 230, 30);
		add(cardTextField);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel pin = new JLabel("PIN:");
		pin.setBounds(120, 220, 400, 40);
		add(pin);
		pin.setFont(new Font("Ralway", Font.BOLD, 28));
		
	    pinTextField = new JPasswordField(); 
		pinTextField.setBounds(300, 220,  230, 30);
		add(pinTextField);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		
	    login = new JButton("Sign In");
		login.setBounds(300, 300, 100, 30 );
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
	    clear = new JButton("Clear");
		clear.setBounds(430, 300, 100, 30 );
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
	    signup = new JButton("Sign Up");
		signup.setBounds(300, 350, 230, 30 );
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.white);           	
		setSize(800 ,480);
		setVisible(true);
		setLocation(350, 200);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == clear ) {
			cardTextField.setText("");
			pinTextField.setText("");
		}else if(ae.getSource() == login) {
			
			BankManagementSystem connection = new BankManagementSystem(); 	
			
			String cardnumber = cardTextField.getText();
//			String pinnumber = pinTextField.getText();
		    char[] pin = pinTextField.getPassword();
			String pinnumber = new String(pin) ;
			
			String query = "select * from signin where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"' ";
			try {
				
				
				ResultSet result = connection.statement.executeQuery(query);
				
				if(result.next()) {
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
				
			}catch(Exception e){
				System.out.println(e);
			}
		}else if(ae.getSource() == signup) {
			setVisible(false);
			new SignUp().setVisible(true);
		}
	}
	
  public static void main(String args[]) {
	  new Login ("","");
  }
}
