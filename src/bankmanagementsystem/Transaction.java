package bankmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Transaction extends JFrame implements ActionListener {
	 
	JButton deposit, withdraw, fastcash, ministatement, pinchange ,balanceenquiry, exit; 
	
	String pinnumber;
	
	Transaction(String pin){
		
		 pinnumber = pin;
		
		setLayout(null);
		
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image iconTwo = icon.getImage().getScaledInstance(900, 830, Image.SCALE_REPLICATE);
		ImageIcon iconThree = new ImageIcon(iconTwo);
		JLabel image = new JLabel(iconThree);
		image.setBounds(0,0,900,830);
		add(image);
		
		JLabel text = new JLabel("Please Select Your Trnsaction");
		text.setFont(new Font("System" , Font.BOLD, 16 ));
		text.setBounds(220, 280 ,700, 35);
		text.setForeground(Color.WHITE);
		image.add(text);
		
	    deposit = new JButton("Deposit");
		deposit.setBounds(170, 374, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		
		withdraw= new JButton("Cash Withdrawal");
		withdraw.setBounds(351, 374, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		fastcash = new JButton("Fast  Cash");
		fastcash.setBounds(170, 408, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(351, 408, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(170, 442, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(351, 442, 150, 30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(351, 476, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		
		setSize(900 ,830);
		setLocation(250,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae ) {
		if(ae.getSource() == exit) {
			System.exit(0);
		}else if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}else if(ae.getSource() == withdraw) {
			setVisible(false);
			new Withdrawal(pinnumber).setVisible(true);
		}else if(ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
			
		}else if(ae.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}else if(ae.getSource() == ministatement) {
			setVisible(false);
			new MiniStatement(pinnumber).setVisible(true);
		}else if(ae.getSource() == balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}
	}
	
	
public static void main(String args[]) {
	new Transaction("");
}
}
