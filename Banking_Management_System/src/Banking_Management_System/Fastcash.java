package Banking_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

@SuppressWarnings("serial")
class fast extends JFrame implements ActionListener {

	JLabel l, text;
	JButton deposit, cash, mini, pinchange, inquery, ex, fast1;
	String pinnum;

	fast(String pin) {
		super("AUTOMATED TELLER MACHINE");
		pinnum = pin;
		setSize(800, 750); // width,height
		setLocation(300, 5);
		// setUndecorated(true); //ye frame ka border hatane ke liye hai
		setLayout(null);

		// ********* setting frame and image
		String ai = "C:/Users/Tanishk kumar/Desktop/atm.jpg";
		ImageIcon ic = new ImageIcon(ai);
		Image i2 = ic.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ic = new ImageIcon(i2); // re allotment of image to imageicon object
		l = new JLabel(ic);
		l.setBounds(0, 0, 800, 730); // x,y,width,height
		add(l);

		// **************** setting main Jlabel over the image of the frame
		text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(179, 235, 250, 30);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		l.add(text); // l.add(text) isiliye taaki text image ke uppar aaye na ki niche

		// deposit,fast,cash,mini,pinchange,inquery,ex;
		// ***************** Adding jbutton in the frame *******

		deposit = new JButton("Rs 100");
		deposit.setBounds(150, 310, 130, 25);
		deposit.addActionListener(this);
		l.add(deposit);
		fast1 = new JButton("Rs 500");
		fast1.setBounds(150, 345, 130, 25);
		fast1.addActionListener(this);
		l.add(fast1);
		pinchange = new JButton("Rs 1000");
		pinchange.setBounds(150, 380, 130, 25);
		pinchange.addActionListener(this);
		l.add(pinchange);
		cash = new JButton("Rs 2000");
		cash.setBounds(313, 310, 130, 25);
		cash.addActionListener(this);
		l.add(cash);
		mini = new JButton("Rs 5000");
		mini.setBounds(313, 345, 130, 25);
		mini.addActionListener(this);
		l.add(mini);
		inquery = new JButton("Rs 10000");
		inquery.setBounds(313, 380, 130, 25);
		inquery.addActionListener(this);
		l.add(inquery);

		ex = new JButton("Back");
		ex.setBounds(313, 415, 130, 35);
		ex.addActionListener(this);
		l.add(ex);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ex) {
			setVisible(false);
			new signin(pinnum).setVisible(true);
		}
		else {
			String amt=((JButton)ae.getSource()).getText().substring(3);  //to get only amount not Rs included with it
			Conn  c =new Conn();
			try {
				ResultSet rs=c.s.executeQuery("select * from Bankdata where Pin_Number = '"+pinnum+"'");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("Transaction_Type").equals("Deposit")) {
						balance+=Integer.parseInt(rs.getString("Amount"));
					}
					else {
						balance -=Integer.parseInt(rs.getString("Amount"));
					}
				}
				if(ae.getSource() !=ex && balance < Integer.parseInt(amt)) {
					JOptionPane.showMessageDialog(null,"Insufficient Balance");
					return;
				}
				Date date=new Date();
				String query = "insert into Bankdata  values ('" + pinnum + "','" + date+ "', 'Withdraw','" +amt+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amt+" Debited Successfully");
				setVisible(false);
				new signin(pinnum).setVisible(true);
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
	}
}

public class Fastcash {
	public static void main(String[] args) {
		fast ob = new fast("");
		ob.setVisible(true);
	}
}
