import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.*;
import java.sql.*;

public class FRAME_2 extends JFrame {
	public void signuppage() {
		FRAME_2 f2 = new FRAME_2();
		f2.setTitle("Signup Page");
		f2.getContentPane().setBackground(Color.BLACK);
		JLabel l3 = new JLabel(" Signup");
		l3.setBounds(215, 10, 70, 50);
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel l = new JLabel("NAME");
		l.setBounds(100, 60, 400, 50);
		l.setForeground(Color.WHITE);
		l.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel l2 = new JLabel("EMAIL");
		l2.setBounds(100, 120, 400, 50);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel l4 = new JLabel("CONTACT");
		l4.setBounds(100, 180, 400, 50);
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel l5 = new JLabel("CNIC");
		l5.setBounds(100, 240, 400, 50);
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel l6 = new JLabel("PASSWORD");
		l6.setBounds(100, 300, 400, 50);
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel l7 = new JLabel("CONFIRMPASS");
		l7.setBounds(75, 360, 400, 50);
		l7.setForeground(Color.WHITE);
		l7.setFont(new Font("Serif", Font.BOLD, 20));
		JTextField tf = new JTextField();
		tf.setBounds(220, 60, 250, 40);
		JTextField tf2 = new JTextField();
		tf2.setBounds(220, 120, 250, 40);
		JTextField tf4 = new JTextField();
		tf4.setBounds(220, 180, 250, 40);
		JTextField tf5 = new JTextField();
		tf5.setBounds(220, 240, 250, 40);
		JPasswordField tf6 = new JPasswordField();
		tf6.setBounds(220, 300, 250, 40);
		JPasswordField tf7 = new JPasswordField();
		tf7.setBounds(220, 360, 250, 40);
		JButton submit = new JButton("submit");
		submit.setBounds(369, 445, 100, 50);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					Connection con = DriverManager
							.getConnection("jdbc:ucanaccess://C:\\Users\\Malik Yasir\\Desktop\\register.accdb");
					System.out.println("connected");
					Statement s = con.createStatement();
					PreparedStatement pst = con.prepareStatement(
							"Insert into registerr(NAME,EMAIL,CONTACT,CNIC,PASSWORD,CONFIRMPASSWORD) values(?,?,?,?,?,?)");
					pst.setString(1, tf.getText());
					pst.setString(2, tf2.getText());
					pst.setString(3, tf4.getText());
					pst.setString(4, tf5.getText());
					pst.setString(5, tf6.getText());
					pst.setString(6, tf7.getText());
					int a = pst.executeUpdate();
					if (a > 0) {
						JOptionPane.showMessageDialog(null, "data saved");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "exception error");
					e1.printStackTrace();
				}
			}
		});
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FRAME_1 f1 = new FRAME_1();
				f1.setVisible(true);
				f1.setSize(500, 500);
				f2.dispose();
			}
		});
		f2.add(l3);
		f2.add(submit);
		f2.add(l);
		f2.add(l2);
		f2.add(tf);
		f2.add(tf2);
		f2.add(l4);
		f2.add(tf4);
		f2.add(l5);
		f2.add(tf5);
		f2.add(l6);
		f2.add(tf6);
		f2.add(l7);
		f2.add(tf7);
		setDefaultCloseOperation(f2.EXIT_ON_CLOSE);
		f2.setLayout(null);
		f2.setSize(600, 600);
		f2.setVisible(true);
		f2.setBackground(Color.GRAY);
		f2.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
	}
}
