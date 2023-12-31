package Banking_Management_System;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
class balance extends JFrame implements ActionListener {
	String p;
	JLabel l1;
	JButton  bk;

	balance(String pin) {
		super("AUTOMATED TELLER MACHINE");
		this.p = pin;
		setSize(800, 750);
		// setUndecorated(true); /// for complete window of the frame
		setLocation(300, 0);

		setLayout(null);

		String ai = "C:/Users/Tanishk kumar/Desktop/atm.jpg";
		ImageIcon ic = new ImageIcon(ai);
		Image i2 = ic.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ic = new ImageIcon(i2); // re allotment of image to imageicon object
		l1 = new JLabel(ic);
		l1.setBounds(0, 0, 800, 730); // x,y,width,height
		add(l1);

		bk = new JButton("Back");
		bk.setBounds(330, 425, 120, 25);
		bk.addActionListener(this);
		l1.add(bk);

		Conn c = new Conn();
		int balance = 0;
		try {
			ResultSet rs = c.s.executeQuery("select * from Bankdata where Pin_Number = '" + p + "'");

			while (rs.next()) {
				if (rs.getString("Transaction_Type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("Amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("Amount"));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		JLabel t1 = new JLabel("Your Current Balance is Rs " + balance);
		t1.setBounds(170, 300, 400, 30);
		t1.setForeground(Color.WHITE);
		l1.add(t1);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new signin(p).setVisible(true);

	}
}

public class Balance_enquiry {
	public static void main(String[] args) {
		balance ob = new balance("");
		ob.setVisible(true);
	}
}
