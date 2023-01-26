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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener {
	
	    JPasswordField pinPasswordFiled,confirmPinJPasswordFiled;
	    JButton changeJButton,backJButton;                               
	    JLabel changeYourPin,newPin,confirmPin ;
	            
	    String pinnumber;
	 PinChange(String pinnumber){
		 
		 this.pinnumber = pinnumber;
		    
		     setLayout(null);
		 
            ImageIcon iconfirst = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		    Image icontwo = iconfirst.getImage().getScaledInstance(900, 830, Image.SCALE_REPLICATE);
		    ImageIcon iconthree = new ImageIcon(icontwo);
		    JLabel image = new JLabel(iconthree);
		    image.setBounds(0, 0, 900, 830);
		    add(image);
		    
	        changeYourPin = new JLabel("CHANGE YOUR PIN");
	        changeYourPin.setFont(new Font("System", Font.BOLD, 16));
	        changeYourPin.setForeground(Color.WHITE);
	        changeYourPin.setBounds(245,270,800,35);
	        image.add(changeYourPin);
	        
	        
	        newPin = new JLabel("New PIN:");
	        newPin.setFont(new Font("System", Font.BOLD, 16));
	        newPin.setForeground(Color.WHITE);
	        newPin.setBounds(170,315,150,35);
	        image.add(newPin);
	        
	        
	        confirmPin = new JLabel("Re-Enter New PIN:");
	        confirmPin.setFont(new Font("System", Font.BOLD, 16));
	        confirmPin.setForeground(Color.WHITE);
	        confirmPin.setBounds(170,355,200,35);
	        image.add(confirmPin);
	        
	        pinPasswordFiled = new JPasswordField();
	        pinPasswordFiled.setFont(new Font("Raleway", Font.BOLD, 25));
	        pinPasswordFiled.setBounds(320,320,180,25);
	        image.add(pinPasswordFiled);
	        
	        
	        confirmPinJPasswordFiled = new JPasswordField();
	        confirmPinJPasswordFiled.setFont(new Font("Raleway", Font.BOLD, 25));
	        confirmPinJPasswordFiled.setBounds(320,360,180,25);
	        image.add(confirmPinJPasswordFiled);
	        
	        
	        changeJButton = new JButton("CHANGE");
	        changeJButton.setBounds(350, 435, 150, 30);
	        changeJButton.addActionListener(this);
	        image.add(changeJButton);
	        
	        backJButton = new JButton("BACK");
	        backJButton.setBounds(350, 473, 150, 30);
	        backJButton.addActionListener(this);
	        image.add(backJButton);
	       
	          
			setSize(900 ,830);
			setLocation(250,0);
			setUndecorated(true);
	 }
	 
	 
	 
	                                  
	    
	 
	 
	 
	 public void actionPerformed(ActionEvent ae){
	        try{        
	            String npin = pinPasswordFiled.getText();
	            String rpin = confirmPinJPasswordFiled.getText();
	            
	            if(!npin.equals(rpin)){
	                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
	                return;
	            }
	            
	            if(ae.getSource() == changeJButton){
	                if (pinPasswordFiled.getText().equals("")){
	                    JOptionPane.showMessageDialog(null, "Enter New PIN");
	                }
	                if (confirmPinJPasswordFiled.getText().equals("")){
	                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
	                }
	                
	                BankManagementSystem connection = new BankManagementSystem();
	                String query1 = "update bank set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
	                String query2 = "update signin set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
	                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";

	                connection.statement.executeUpdate(query1);
	                connection.statement.executeUpdate(query2);
	                connection.statement.executeUpdate(query3);

	                JOptionPane.showMessageDialog(null, "PIN changed successfully");
	                setVisible(false);
	                new Transaction(rpin).setVisible(true);
	            
	            }else if(ae.getSource() == backJButton){
	                new Transaction(pinnumber).setVisible(true);
	                setVisible(false);
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }

	 
	public static void main(String[] args) {
   
		new PinChange("").setVisible(true);
  
	}

}
