package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {

   
    JButton back;
    JLabel balanceTextJLabal , balanceis;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
    	
        setLayout(null);
    	
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 830);
        add(image);

        balanceTextJLabal = new JLabel();
        balanceTextJLabal.setForeground(Color.WHITE);
        balanceTextJLabal.setFont(new Font("System", Font.BOLD, 16));
        balanceTextJLabal.setBounds(190, 330, 400, 35);
        image.add(balanceTextJLabal);
 

        back = new JButton("BACK");
        back.setBounds(350, 468, 150, 30);
        image.add(back);
        
        
        int balance = 0;
        try{
            BankManagementSystem connection = new BankManagementSystem();
            ResultSet rs = connection.statement.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        balanceTextJLabal.setText("Your Current Account Balance is ");
       
        balanceis = new JLabel("Rs  " + balance);
        balanceis.setForeground(Color.WHITE);
        balanceis.setFont(new Font("System", Font.BOLD, 16));
        balanceis.setBounds(280, 355, 400, 35);
        image.add(balanceis);

        back.addActionListener(this);

        setSize(900, 900);
        setUndecorated(true);
        setLocation(200, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
