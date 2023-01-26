package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton exit ;
    JLabel transactions;
    
    String pinnumber ;
    
    MiniStatement(String pinnumber){
    	        
    	        super("Mini Statement");
    	    	 setLayout(null); 
    	    	 this.pinnumber = pinnumber;
    	    	 
    	
       
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(500 ,20);
        
        transactions = new JLabel();
        add(transactions);
        
        JLabel bankName = new JLabel("Indian Bank");
        bankName.setBounds(150, 20, 100, 20);
        add(bankName);
        
        JLabel cardNumbertxt = new JLabel();
        cardNumbertxt.setBounds(60, 80, 300, 35);
        add(cardNumbertxt);
        
        JLabel balanceshow = new JLabel();
        balanceshow.setBounds(60, 400, 300, 20);
        add(balanceshow);
        
        try{
            BankManagementSystem connect = new BankManagementSystem();
            ResultSet rs = connect.statement.executeQuery("select * from signupthree where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
            	cardNumbertxt.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            BankManagementSystem connection  = new BankManagementSystem();
            ResultSet rs = connection.statement.executeQuery("SELECT * FROM bank where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                transactions.setText(transactions.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
           balanceshow.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
        
        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(20, 500, 100, 25);
        add(exit);
        
       
        
        transactions.setBounds(60, 130, 400, 200);

    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}
