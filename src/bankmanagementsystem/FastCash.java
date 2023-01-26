package bankmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class FastCash extends JFrame implements ActionListener {
	 
	JButton hundred , fivehundred , onethousand, twothousand , fivethousand , tenthousand , back; 
	
	String pinnumber;
	
	FastCash(String pinnumber){
		
		 this.pinnumber = pinnumber;
		
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
		
	    hundred = new JButton("Rs 100");
	    hundred.setBounds(170, 374, 150, 30);
	    hundred.addActionListener(this);
		image.add(hundred);
		
		
		fivehundred= new JButton("Rs 500");
		fivehundred.setBounds(351, 374, 150, 30);
		fivehundred.addActionListener(this);
		image.add(fivehundred);
		
		onethousand = new JButton("Rs 1000");
		onethousand.setBounds(170, 408, 150, 30);
		onethousand.addActionListener(this);
		image.add(onethousand);
		
		
		twothousand = new JButton("Rs 2000");
		twothousand.setBounds(351, 408, 150, 30);
		twothousand.addActionListener(this);
		image.add(twothousand);
		
		fivethousand = new JButton("Rs 5000");
		fivethousand.setBounds(170, 442, 150, 30);
		fivethousand.addActionListener(this);
		image.add(fivethousand);
		
		
		tenthousand = new JButton("Rs 10000");
		tenthousand.setBounds(351, 442, 150, 30);
		tenthousand.addActionListener(this);
		image.add(tenthousand);
		
		back = new JButton("Back");
		back.setBounds(351, 476, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		
		
		
		setSize(900 ,830);
		setLocation(250,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            BankManagementSystem connection = new BankManagementSystem();
            ResultSet rs = connection.statement.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == back) {
                this.setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }else{
                Date date = new Date();
                connection.statement.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	
	
public static void main(String args[]) {
	new FastCash("");
}
}
