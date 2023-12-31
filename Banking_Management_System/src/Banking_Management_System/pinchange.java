package Banking_Management_System;

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
import javax.swing.JTextField;

@SuppressWarnings("serial")
class pinch extends JFrame implements ActionListener {
	String p;
	JLabel l1, l2, ne, re;
	JTextField t1, t2;
	JButton ch, bk;

	pinch(String pin) {
		super("AUTOMATED TELLER MACHINE");
		this.p = pin;
		setSize(800, 750);
		setLocation(300, 0);

		setLayout(null);

		String ai = "C:/Users/Tanishk kumar/Desktop/atm.jpg";
		ImageIcon ic = new ImageIcon(ai);
		Image i2 = ic.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ic = new ImageIcon(i2); // re allotment of image to imageicon object
		l1 = new JLabel(ic);
		l1.setBounds(0, 0, 800, 730); // x,y,width,height
		add(l1);

		l2 = new JLabel("CHANGE YOUR PIN");
		l2.setBounds(220, 235, 300, 30);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Raleway", Font.BOLD, 16));
		l1.add(l2);

		// ************** for new pin and reenter the new pin

		ne = new JLabel("New Pin:");
		ne.setBounds(140, 280, 270, 30);
		ne.setForeground(Color.WHITE);
		ne.setFont(new Font("Raleway", Font.BOLD, 16));
		l1.add(ne);

		t1 = new JTextField();
		t1.setBounds(270, 282, 180, 23);
		t1.setFont(new Font("Raleway", Font.BOLD, 16));
		l1.add(t1);

		re = new JLabel("Re-Enter Pin:");
		re.setBounds(140, 320, 270, 30);
		re.setForeground(Color.WHITE);
		re.setFont(new Font("Raleway", Font.BOLD, 16));
		l1.add(re);

		t2 = new JTextField();
		t2.setBounds(270, 322, 180, 23);
		t2.setFont(new Font("Raleway", Font.BOLD, 16));
		l1.add(t2);

		// ********** Adding change and back button in the frame
		ch = new JButton("Change");
		ch.setBounds(330, 395, 120, 25);
		ch.addActionListener(this);
		l1.add(ch);

		bk = new JButton("Back");
		bk.setBounds(330, 425, 120, 25);
		bk.addActionListener(this);
		l1.add(bk);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == ch) {
			try {
				String npin = t1.getText();
				String rpin = t2.getText();

				if (!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered Re-Enter Pin Does Not Match With New Pin ");
					return;
				}
				if (npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter The Pin");
					return;
				}
				if (rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Your Pin Again In Re-Enter Coloumn");
					return;
				}
				Conn c = new Conn();
				String query1 = "update Bankdata set Pin_Number='" + rpin + "' where Pin_Number='" + p + "'";
				String query2 = "update login set Pin_Number='" + rpin + "' where Pin_Number='" + p + "'";
				String query3 = "update signupthree set Pin_Number='" + rpin + "' where Pin_Number='" + p + "'";

				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);

				JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
				setVisible(false);
				new signin(p).setVisible(true);

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			setVisible(false);
			new signin(p).setVisible(true); // here p is the pin

		}

	}
}

public class pinchange {
	public static void main(String[] args) {
		pinch ob = new pinch("");
		ob.setVisible(true);
	}
}
