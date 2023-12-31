package Banking_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
class mini extends JFrame {

	JLabel t1, card, mini, total;
	String pin;

	mini(String pin) {
		// super("AUTOMATED TELLER MACHINE");
		setTitle("Mini Statement");
		this.pin = pin;
		setLayout(null);
		setSize(400, 600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.WHITE);

		t1 = new JLabel("Indian Bank");
		t1.setBounds(150, 20, 100, 20);
		t1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(t1);

		card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		// card.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(card);

		mini = new JLabel();
		add(mini);

		total = new JLabel();
		total.setBounds(20, 400, 300, 20);
		add(total);

		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from login where Pin_Number='" + pin + "'");
			while (rs.next()) {
				card.setText("Card Number: " + rs.getString("Card_Number").substring(0, 4) + "XXXXXXXX"
						+ rs.getString("Card_Number").substring(12));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
    
		int bal = 0;
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from Bankdata where Pin_Number='" + pin + "'");
			while (rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("Entry_Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("Transaction_Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount")
						+ "<br><br><html>");

				if (rs.getString("Transaction_Type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("Amount"));
				} else {
					bal -= Integer.parseInt(rs.getString("Amount"));
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		mini.setBounds(20, 140, 400, 200);
		total.setText("Your Current Account Balance is: "+bal);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class Mini_Statement {
	public static void main(String[] args) {
		mini ob = new mini("");
		ob.setVisible(true);
	}
}
