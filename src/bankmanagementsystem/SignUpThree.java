package bankmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.*;
public class SignUpThree extends JFrame implements ActionListener {

	 JRadioButton savingaccount , fixedaccount, currentaccount, recurringaccount ;
	 JCheckBox atmcard, internetbanking, mobilebanking, emailandsmsalerts, chequebook, estatement , decalration;
	 JButton submit , cancel;
	 String formno;
	 
	SignUpThree(String formno){
		setLayout(null);
		
		this.formno = formno;
		
		JLabel accountDetails = new JLabel("Account Details");
		accountDetails.setFont( new  Font("Ralway", Font.BOLD, 22));
		accountDetails.setBounds(280, 40, 400, 40);
		add(accountDetails);
		
		savingaccount = new JRadioButton("Saving Account");
		savingaccount.setFont(new Font("Ralway", Font.BOLD, 16));
		savingaccount.setBackground(Color.WHITE);
		savingaccount.setBounds(100, 130, 150, 20);
		add(savingaccount);
		
		fixedaccount = new JRadioButton("Fixed Deposit Account");
		fixedaccount.setFont(new Font("Ralway", Font.BOLD, 16));
		fixedaccount.setBackground(Color.WHITE);
		fixedaccount.setBounds(350, 130, 250, 20);
		add(fixedaccount);
		
		currentaccount = new JRadioButton("Current Account");
		currentaccount.setFont(new Font("Ralway", Font.BOLD, 16));
		currentaccount.setBackground(Color.WHITE);
		currentaccount.setBounds(100,  170, 250, 20);
		add(currentaccount);
		
		recurringaccount = new JRadioButton("Recurring Account");
		recurringaccount.setFont(new Font("Ralway", Font.BOLD, 16));
		recurringaccount.setBackground(Color.WHITE);
		recurringaccount.setBounds(350, 170, 250, 20);
		add(recurringaccount);
		
		ButtonGroup buttongroup = new  ButtonGroup();
		buttongroup.add(savingaccount);
		buttongroup.add(fixedaccount);
		buttongroup.add(currentaccount);
		buttongroup.add(recurringaccount);
		
		JLabel cardnumber = new JLabel("Card Number");
		cardnumber.setFont( new  Font("Ralway", Font.BOLD, 22));
		cardnumber.setBounds(100, 230, 200, 30);
		add(cardnumber);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-8795");
		number.setFont( new  Font("Ralway", Font.BOLD, 22));
		number.setBounds(330, 230, 300, 30);
		add(number);
		
		JLabel carddetails = new JLabel("Your 16 digit card number");
		carddetails.setFont( new  Font("Ralway", Font.BOLD, 12));
		carddetails.setBounds(100, 260, 300, 20);
		add(carddetails);
		
		JLabel pin = new JLabel("PIN");
		pin.setFont( new  Font("Ralway", Font.BOLD, 22));
		pin.setBounds(100, 300, 200, 30);
		add(pin);
		
		JLabel pinnumber = new JLabel("XXXX");
		pinnumber.setFont( new  Font("Ralway", Font.BOLD, 22));
		pinnumber.setBounds(330, 300, 200, 20);
		add(pinnumber);
		
		JLabel pindetails = new JLabel("Your 4 digit password");
		pindetails.setFont( new  Font("Ralway", Font.BOLD, 12));
		pindetails.setBounds(100, 330, 300, 20);
		add(pindetails);
		
		JLabel services = new JLabel("Service Requirements");
		services.setFont( new  Font("Ralway", Font.BOLD, 22));
		services.setBounds(100, 380, 400, 30);
		add(services);
		
		atmcard = new JCheckBox("ATM Card");
		atmcard.setFont(new Font("Ralway", Font.BOLD, 16));
		atmcard.setBackground(Color.WHITE);
		atmcard.setBounds(100, 430, 200, 30);
		add(atmcard);
		
		internetbanking = new JCheckBox("Internet Banking");
		internetbanking.setFont(new Font("Ralway", Font.BOLD, 16));
		internetbanking.setBackground(Color.WHITE);
		internetbanking.setBounds(350, 430, 200, 30);
		add(internetbanking);
		
		mobilebanking = new JCheckBox("Mobile Banking");
		mobilebanking.setFont(new Font("Ralway", Font.BOLD, 16));
		mobilebanking.setBackground(Color.WHITE);
		mobilebanking.setBounds(100, 480, 200, 30);
		add(mobilebanking);
		
		emailandsmsalerts = new JCheckBox("Email & SMS Alerts");
		emailandsmsalerts.setFont(new Font("Ralway", Font.BOLD, 16));
		emailandsmsalerts.setBackground(Color.WHITE);
		emailandsmsalerts.setBounds(350, 480, 200, 30);
		add(emailandsmsalerts);
		
		chequebook = new JCheckBox("Cheque Book");
		chequebook.setFont(new Font("Ralway", Font.BOLD, 16));
		chequebook.setBackground(Color.WHITE);
		chequebook.setBounds(100, 530, 200, 30);
		add(chequebook);
		
		estatement = new JCheckBox("E-Statement");
		estatement.setFont(new Font("Ralway", Font.BOLD, 16));
		estatement.setBackground(Color.WHITE);
		estatement.setBounds(350, 530, 200, 30);
		add(estatement);
		
		decalration = new JCheckBox("I hereby declare that the above entered details are correct to the best of knowledge.");
		decalration.setFont(new Font("Ralway", Font.BOLD, 12));
		decalration.setBackground(Color.WHITE);
		decalration.setBounds(100, 610, 600, 30);
		add(decalration);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.WHITE);
		submit.setFont(new Font("Ralway", Font.BOLD, 14));
		submit.setBounds(250, 660, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.WHITE);
		cancel.setFont(new Font("Ralway", Font.BOLD, 14));
		cancel.setBounds(420, 660, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		
		
		if(ae.getSource() == submit) {
			 String accountType = null ;
			 if(savingaccount.isSelected()) {
				 accountType = "Saving Account";
			 }else if(fixedaccount.isSelected()) {
				 accountType= "Fixed Deposit Account";
			 }else if(currentaccount.isSelected()) {
				 accountType = "Current Account";
			 }else if(recurringaccount.isSelected()) {
				 accountType = "Recurring Account";
			 }
			
			 Random random = new Random();
			 
			 String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
			 String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L ) ; 
			 
			 String Facility = "";
		
			 if(atmcard.isSelected()) {
				 Facility = Facility + "ATM Card";
			 }else if(internetbanking.isSelected()) {
				 Facility = Facility + "Internet Banking";
			 }else if(mobilebanking.isSelected()) {
				 Facility = Facility + "Mobile Banking";
			 }else if(emailandsmsalerts.isSelected()) {
				 Facility = Facility + "SMS & Email Alerts";
			 }else if(chequebook.isSelected()) {
				 Facility = Facility + "Cheque Book";
			 }else if(estatement.isSelected()) {
				 Facility = Facility + "E-Statement";
			 } 
			
			 try {
			
				 BankManagementSystem connection = new BankManagementSystem();
				 String query1 = "insert into signupthree values( '"+formno+"','"+accountType+"', '"+cardnumber+"','"+pinnumber+"','"+Facility+"')";
				 String query2 = "insert into signin values( '"+formno+"','"+cardnumber+"','"+pinnumber+"')";
				 connection.statement.executeUpdate(query1);
				 connection.statement.executeUpdate(query2);
	            
				 JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n PIN: " + pinnumber );
				 
			
				try {
				
					String query = "select * from signin where cardnumber = '"+ cardnumber+"' and pinnumber = '"+pinnumber+"' ";
					ResultSet result1 = connection.statement.executeQuery(query);

					if(result1.next()) {
						setVisible(false);
						new Transaction(pinnumber).setVisible(true);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			
			
				 
			 }catch(Exception e) {
				 System.out.println(e);
			 }
			 
		 }else if(ae.getSource() == cancel) {
			 
		 }
		
		
	}
	
	public static void main(String args[]) {
		new SignUpThree("");
	}
	
}
