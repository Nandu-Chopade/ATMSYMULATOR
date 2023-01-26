package bankmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener  {
  
	JButton deposit , back ;
	JTextField amount;
	String pinnumber ;
	Deposit(String pinnumber){
		setLayout(null);
		
		 this.pinnumber = pinnumber;
		 
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image iconTwo = icon.getImage().getScaledInstance(900, 830, Image.SCALE_REPLICATE);
		ImageIcon iconThree = new ImageIcon(iconTwo);
		JLabel image = new JLabel(iconThree);
		image.setBounds(0,0,900,830);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System" , Font.BOLD, 16));
		text.setBounds(190, 300, 400, 20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("System" , Font.BOLD, 16));
		amount.setBounds(170, 350 , 330, 30);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(355, 443 , 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(355, 476, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900 ,830);
		setLocation(250,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == deposit) {
			if(deposit.equals("")) {
				JOptionPane.showMessageDialog(null , "Please Enter the amount you want to deposit ");
			}else {
				String amountrupee = amount.getText();
				Date date = new Date();
			BankManagementSystem connection = new BankManagementSystem(); 
			
			 try {
				 String query = "insert into bank values('"+pinnumber+"','"+date+"','deposit','"+amountrupee+"')";
				 connection.statement.executeUpdate(query);
				 JOptionPane.showMessageDialog(null, "Rs " + amountrupee+ " "+ " Deposited Successfully");
				 setVisible(false);
				 new Transaction(pinnumber).setVisible(true);
			 }catch(Exception e) {
				 System.out.println(e);
			 }

			}
		}else if(ae.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String args[]) {
	       
		new	Deposit("");
		
	}
}
