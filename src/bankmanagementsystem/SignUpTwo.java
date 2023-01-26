package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;

public class SignUpTwo extends JFrame implements ActionListener{
	    
	    JComboBox<String> religion, category, income, education, occupation;
	    JTextField  pan, aadhar;
		JRadioButton seniorYes, seniorNo, ExistingAccountYes, ExistingAccountNo;
		JButton next;
		String formno;
		SignUpTwo(String formno){
			setLayout(null);
			this.formno = formno;
			setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2 "); 
						
			JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
			additionalDetails.setFont(new Font("Ralway", Font.BOLD, 22));
			additionalDetails.setBounds(290, 80, 400, 30);
			add(additionalDetails);
			
			JLabel JReligion = new JLabel("Religion:");
			JReligion.setFont(new Font("Ralway", Font.BOLD, 20));
			JReligion.setBounds(100, 140 , 100, 30);
			add(JReligion);
			
			String valReligion[] = {null , 	"Hindu", "Muslim", "Sikh","Christian", "Other"};
            religion = new JComboBox<String>(valReligion);
            religion.setBackground(Color.WHITE);
            religion.setBounds(300, 140, 400, 30);
			add(religion);	
			
			JLabel JCategory = new JLabel("Category:");
			JCategory.setFont(new Font("Ralway", Font.BOLD, 20));
			JCategory.setBounds(100, 190 , 200, 30);
			add(JCategory);
			
			String valCategory[] = {"General","OBC","ST","NT","SC", "Other"};
		    category = new JComboBox<String>(valCategory);
			category.setBackground(Color.WHITE);
			category.setBounds(300, 190, 400, 30);
			add(category);	
			
			JLabel JIncome = new JLabel("Income:");
			JIncome.setFont(new Font("Ralway", Font.BOLD, 20));
			JIncome.setBounds(100, 240, 200, 30);
			add(JIncome);
			
			
			String incomeCategory[] = {"Null","< 1,50,000","< 2,50,000 ","< 5,00,000","Up to 10,00,000", "Other"};
		    income = new JComboBox<String>(incomeCategory);
			income.setBackground(Color.WHITE);
			income.setBounds(300,240,400,30);
			add(income);
			
			
			JLabel JEducational = new JLabel("Educational:");
			JEducational.setFont(new Font("Ralway", Font.BOLD, 20));
			JEducational.setBounds(100, 290, 200, 30);
			add(JEducational);
			
			JLabel JQualification = new JLabel("Qualification:");
			JQualification.setFont(new Font("Ralway", Font.BOLD, 20));
			JQualification.setBounds(100, 315, 200, 30);
			add(JQualification);
			
			String educationValues[] = {"Non-Graduation","Graduation", "Post-Graduation","Doctrate","Other"};
		    education = new JComboBox<String>(educationValues);
			education.setBackground(Color.WHITE);
			education.setBounds(300, 315, 400, 30);	
			add(education);
	
			
			JLabel JOccupation = new JLabel("Occupation:");
			JOccupation.setFont(new Font("Ralway", Font.BOLD, 20));
			JOccupation.setBounds(100, 390, 200, 30);
			add(JOccupation);
			

			String occupationValue[] = {"Salaried","Self-Employed","Bussiness","Students","Retired","Other"};
		    occupation = new JComboBox<String>(occupationValue);
			occupation.setBackground(Color.WHITE);
			occupation.setBounds(300, 390, 400, 30);	
			add(occupation);
	
			JLabel JPanNumber = new JLabel("Pan Number:");
			JPanNumber.setFont(new Font("Ralway", Font.BOLD, 20));
			JPanNumber.setBounds(100, 440, 200, 30);
			add(JPanNumber);
			
		    pan = new JTextField();
			pan.setFont(new Font("Ralway", Font.BOLD, 14));
			pan.setBounds(300, 440, 400, 30);
			add(pan);	
			
			
			JLabel JAadharNumber = new JLabel("Aadhar Number:");
			JAadharNumber.setFont(new Font("Ralway", Font.BOLD, 20));
			JAadharNumber.setBounds(100, 490, 200, 30);
			add(JAadharNumber);
			
		    aadhar = new JTextField();
		    aadhar.setFont(new Font("Ralway", Font.BOLD, 14));
		    aadhar.setBounds(300, 490, 400, 30);
			add(aadhar);	
			
			
			JLabel JSeniorCitizen = new JLabel("Senior Citizen:");
			JSeniorCitizen.setFont(new Font("Ralway", Font.BOLD, 20));
			JSeniorCitizen.setBounds(100, 540, 200, 30);
			add(JSeniorCitizen);
			
		    seniorYes = new JRadioButton("Yes");
		    seniorYes.setBackground(Color.WHITE);
		    seniorYes.setBounds(300, 540, 60, 30);
		    add(seniorYes);
		    
		    seniorNo = new JRadioButton("No");
		    seniorNo.setBackground(Color.WHITE);
		    seniorNo.setBounds(450, 540, 120, 30);
		    add(seniorNo);
		    
		    ButtonGroup SeniorCitizen = new ButtonGroup();
		    SeniorCitizen.add(seniorYes);
		    SeniorCitizen.add(seniorNo);
             
			JLabel JExistingAccount = new JLabel("Existing Account :");
			JExistingAccount.setFont(new Font("Ralway", Font.BOLD, 20));
			JExistingAccount.setBounds(100, 590, 200, 30);
			add(JExistingAccount);
			

		    ExistingAccountYes = new JRadioButton("Yes");
		    ExistingAccountYes.setBackground(Color.WHITE);
		    ExistingAccountYes.setBounds(300, 590, 60, 30);
		    add(ExistingAccountYes);
		    
		    ExistingAccountNo = new JRadioButton("No");
		    ExistingAccountNo.setBackground(Color.WHITE);
		    ExistingAccountNo.setBounds(450, 590, 120, 30);
		    add(ExistingAccountNo);
		    
		    ButtonGroup ExstingAccountGroup = new ButtonGroup();
		    ExstingAccountGroup.add(ExistingAccountYes);
		    ExstingAccountGroup.add(ExistingAccountNo);
			
		    next = new JButton("Next");
			next.setBackground(Color.BLACK);
			next.setForeground(Color.WHITE);
			next.setFont(new Font("Ralway", Font.BOLD, 14));
			next.setBounds(620, 660, 80, 30);
			next.addActionListener(this);
			add(next);
			
			
			
			 getContentPane().setBackground(Color.WHITE);
			 setSize(850,800);
			 setLocation(350, 10);
			 setVisible(true);
		}
		
	
		public void actionPerformed(ActionEvent ae) {
			String sreligion = (String) religion.getSelectedItem();
			String scategory = (String) category.getSelectedItem();
			String sincome   = (String) income.getSelectedItem();
			String seducation= (String) education.getSelectedItem();
			String soccupation=(String) occupation.getSelectedItem();
			String span       = pan.getText();
			String saadhar    = aadhar.getText();
		    String seniorcitizen = null;
			if(seniorYes.isSelected()) {
				seniorcitizen = "Yes";
			}else if(seniorNo.isSelected()) {
				seniorcitizen = "No";
			} 
			
			String ExistingAccount = null;
			if(ExistingAccountYes.isSelected()) {
				ExistingAccount = "Yes";
			}else if(ExistingAccountNo.isSelected()) {
				ExistingAccount = "No";
				
			}
			
			try {

		   BankManagementSystem  connection = new BankManagementSystem();
		   String SqlQuery = "insert into signuptwo values('"+formno+"', '"+sreligion+"',  '"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"', '"+seniorcitizen+"','"+ExistingAccount+"')";
		   connection.statement.executeUpdate(SqlQuery);
		   
		   setVisible(false);
		   new SignUpThree(formno).setVisible(true);
		   
			}catch(Exception e) {
				System.out.println(e);
			}
			
			setVisible(false);
			
		}
		 
		
	public static void main(String args[]) {
		 new SignUpTwo("");
	 }


	
	
	
	
}
