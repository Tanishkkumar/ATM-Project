package Banking_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
class sin3 extends JFrame implements ActionListener {
	JLabel l1, type, card, pin, serve, cardmini, pinmini, cno, pno;
	JRadioButton t1, t2, t3, t4;
	JCheckBox s1, s2, s3, s4, s5, s6, last;
	JButton submit, cancel;
	String formno;

	sin3(String formno) {
		super("AUTOMATED TELLER MACHINE");
		this.formno = formno;
		setLayout(null);

		setSize(750, 750);

		setLocation(300, 5);

		l1 = new JLabel("Page3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 25));
		l1.setBounds(230, 15, 530, 45);
		add(l1);

		type = new JLabel("Account Type");
		type.setFont(new Font("Raleway", Font.BOLD, 18));
		type.setBounds(110, 95, 400, 30);
		add(type);

		t1 = new JRadioButton("Saving Account");
		t1.setBounds(115, 130, 150, 20);
		add(t1);
		t2 = new JRadioButton("Current Account");
		t2.setBounds(115, 170, 150, 20);
		add(t2);
		t3 = new JRadioButton("Fixed Deposit Account");
		t3.setBounds(400, 130, 200, 20);
		add(t3);
		t4 = new JRadioButton("Recurring Deposit Account");
		t4.setBounds(400, 170, 200, 20);
		add(t4);

		ButtonGroup b1 = new ButtonGroup();
		b1.add(t1);
		b1.add(t2);
		b1.add(t3);
		b1.add(t4);

		// ************* CARD NUMBER*******
		card = new JLabel("Card Number");
		card.setBounds(110, 238, 400, 30);
		card.setFont(new Font("Raleway", Font.BOLD, 18));
		add(card);
		cardmini = new JLabel("Your 16 Digit Card Number");
		cardmini.setBounds(110, 255, 400, 30);
		cardmini.setFont(new Font("Raleway", Font.BOLD, 10));
		add(cardmini);

		cno = new JLabel("XXXX-XXXX-XXXX-4184");
		cno.setBounds(380, 238, 400, 30);
		cno.setFont(new Font("Raleway", Font.BOLD, 20));
		add(cno);

		// *********** PIN NUMBER ***********
		pin = new JLabel("PIN:");
		pin.setBounds(110, 330, 400, 30);
		pin.setFont(new Font("Raleway", Font.BOLD, 18));
		add(pin);
		pinmini = new JLabel("Your 4 Digit Password");
		pinmini.setBounds(110, 344, 400, 30);
		pinmini.setFont(new Font("Raleway", Font.BOLD, 10));
		add(pinmini);

		pno = new JLabel("XXXX");
		pno.setBounds(380, 330, 400, 30);
		pno.setFont(new Font("Raleway", Font.BOLD, 20));
		add(pno);

		// ************* SERVICE REQUIRED**************
		serve = new JLabel("Service Required:");
		serve.setBounds(110, 433, 400, 30);
		serve.setFont(new Font("Raleway", Font.BOLD, 18));
		add(serve);

		s1 = new JCheckBox("ATM Card");
		s1.setBounds(115, 468, 150, 20);
		add(s1);
		s2 = new JCheckBox("Mobile Banking");
		s2.setBounds(115, 500, 150, 20);
		add(s2);
		s3 = new JCheckBox("Cheque Book");
		s3.setBounds(115, 538, 150, 20);
		add(s3);
		s4 = new JCheckBox("Internet Banking");
		s4.setBounds(400, 468, 150, 20);
		add(s4);
		s5 = new JCheckBox("EMAIL & SMS Alerts");
		s5.setBounds(400, 500, 150, 20);
		add(s5);
		s6 = new JCheckBox("E-Statement");
		s6.setBounds(400, 538, 150, 20);
		add(s6);

		// ************ Last Line***********

		last = new JCheckBox(
				"I hereby declares that the above entered details are correct to the best pf my  knowledge.");
		last.setBounds(110, 620, 610, 20);
		last.setFont(new Font("Raleway", Font.BOLD, 11));
		add(last);

		// *************** submit and cancel jbutton ************
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(200, 660, 100, 30);
		submit.addActionListener(this);
		add(submit);

		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(400, 660, 100, 30);
		cancel.addActionListener(this);
		add(cancel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			String actype = null;
			if (t1.isSelected()) {
				actype = "Saving Account";
			} else if (t2.isSelected()) {
				actype = "Current Account";
			} else if (t3.isSelected()) {
				actype = "Fixed Deposit Account";
			} else if (t4.isSelected()) {
				actype = "Reccuring Deposit Account";
			}

			Random ran = new Random();
			String cardnumber = "" + Math.abs((ran.nextLong() % 90000000L) + 5040936000000000L);

			String pinnumber = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);

			String facility = "";
			if (s1.isSelected()) {
				facility = facility + "ATM Card";
			} else if (s2.isSelected()) {
				facility = facility + "Mobile Banking";
			} else if (s3.isSelected()) {
				facility = facility + "Cheque Book";
			} else if (s4.isSelected()) {
				facility = facility + "Internet Banking";
			} else if (s5.isSelected()) {
				facility = facility + "EMAIL & SMS Alerts";
			} else if (s6.isSelected()) {
				facility = facility + "E-Statement";
			}
			try {
				if (actype == null) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				} else {
					Conn c = new Conn();
					String query1 = "insert into signupThree  values ('" + formno + "','" + actype + "','" + cardnumber
							+ "','" + pinnumber + "','" + facility + "')";

					String query2 = "insert into login  values ('" + formno + "','" + cardnumber + "','" + pinnumber
							+ "')";
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);

					JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);
					setVisible(false);
					new depo(pinnumber).setVisible(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		} else if (ae.getSource() == cancel) {
               setVisible(true);
               new loginpage().setVisible(true);
		}

	}
}

public class SignupThree {
	public static void main(String[] args) {
		sin3 ob = new sin3("");
		ob.setVisible(true);

	}
}
