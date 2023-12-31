package Banking_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
class signin extends JFrame implements ActionListener {

	JLabel l, text;
	JButton deposit, fast, cash, mini, pinchange, inquery, ex;
	String pin;

	signin(String pin) {
		super("AUTOMATED TELLER MACHINE");
		this.pin = pin;
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
		text = new JLabel("Please Select Your Transaction");
		text.setBounds(188, 235, 250, 30);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD, 15));
		l.add(text); // l.add(text) isiliye taaki text image ke uppar aaye na ki niche

		// deposit,fast,cash,mini,pinchange,inquery,ex;
		// ***************** Adding jbutton in the frame *******

		deposit = new JButton("Deposit");
		deposit.setBounds(150, 310, 130, 25);
		deposit.addActionListener(this);
		l.add(deposit);
		fast = new JButton("Fast Cash");
		fast.setBounds(150, 345, 130, 25);
		fast.addActionListener(this);
		l.add(fast);
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(150, 380, 130, 25);
		pinchange.addActionListener(this);
		l.add(pinchange);
		cash = new JButton("Cash Withdrawl");
		cash.setBounds(313, 310, 130, 25);
		cash.addActionListener(this);
		l.add(cash);
		mini = new JButton("Mini Statement");
		mini.setBounds(313, 345, 130, 25);
		mini.addActionListener(this);
		l.add(mini);
		inquery = new JButton("Balance Enquiry");
		inquery.setBounds(313, 380, 130, 25);
		inquery.addActionListener(this);
		l.add(inquery);

		ex = new JButton("Exit");
		ex.setBounds(313, 415, 130, 35);
		ex.addActionListener(this);
		l.add(ex);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == ex) {
			System.exit(0);
		} else if (ae.getSource() == deposit) {
			setVisible(false);
			new depo(pin).setVisible(true);
		} else if (ae.getSource() == cash) {
			setVisible(false);
			new with(pin).setVisible(true);
		} else if (ae.getSource() == fast) {
			setVisible(false);
			new fast(pin).setVisible(true);
		} else if (ae.getSource() == pinchange) {
			setVisible(false);
			new pinch(pin).setVisible(true);
		} else if (ae.getSource() == inquery) {
			setVisible(false);
			new balance(pin).setVisible(true);
		} else if (ae.getSource() == mini) {
			new mini(pin).setVisible(true);
		}

	}
}

public class Transaction {
	public static void main(String[] args) {
		signin ob = new signin("");
		ob.setVisible(true);
	}
}
