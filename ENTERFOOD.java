import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

public class ENTERFOOD extends JFrame {
	public void foodbutton() {
		JFrame mainframe2 = new JFrame();
		mainframe2.setVisible(true);
		mainframe2.setTitle("ENTERFOOD");
		mainframe2.setBounds(100, 100, 450, 300);
		mainframe2.getContentPane().setLayout(null);
		JLabel name = new JLabel("F00DNAME");
		name.setFont(new Font("Serif", Font.BOLD, 15));
		name.setBounds(79, 76, 100, 14);
		mainframe2.getContentPane().add(name);
		JLabel id = new JLabel("FOOD_ID");
		id.setFont(new Font("Serif", Font.BOLD, 15));
		id.setBounds(79, 120, 73, 14);
		mainframe2.getContentPane().add(id);
		JLabel q = new JLabel("QUANTITY");
		q.setFont(new Font("Serif", Font.BOLD, 15));
		q.setBounds(79, 200, 150, 14);
		mainframe2.getContentPane().add(q);
		JLabel price = new JLabel("PRICE");
		price.setFont(new Font("Serif", Font.BOLD, 15));
		price.setBounds(79, 162, 73, 14);
		mainframe2.getContentPane().add(price);
		JLabel newdetails = new JLabel("ENTER DETAILS");
		newdetails.setFont(new Font("Serif", Font.BOLD, 18));
		newdetails.setBounds(162, 11, 165, 42);
		mainframe2.getContentPane().add(newdetails);
		JTextField tf1 = new JTextField();
		tf1.setBounds(178, 73, 86, 20);
		mainframe2.getContentPane().add(tf1);
		tf1.setColumns(10);
		JTextField tf2 = new JTextField();
		tf2.setBounds(178, 117, 86, 20);
		mainframe2.getContentPane().add(tf2);
		tf2.setColumns(10);
		JTextField tf4 = new JTextField();
		tf4.setBounds(178, 200, 86, 20);
		mainframe2.getContentPane().add(tf4);
		tf4.setColumns(10);
		JTextField tf3 = new JTextField();
		tf3.setBounds(178, 159, 86, 20);
		mainframe2.getContentPane().add(tf3);
		tf3.setColumns(10);
		JButton submit = new JButton("ADD");
		submit.setFont(new Font("Serif", Font.BOLD, 15));
		submit.setBounds(296, 214, 89, 23);
		mainframe2.getContentPane().add(submit);
		mainframe2.add(name);
		mainframe2.add(tf1);
		mainframe2.add(price);
		mainframe2.add(tf2);
		mainframe2.add(id);
		mainframe2.add(tf3);
		mainframe2.add(q);
		mainframe2.add(tf4);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					Connection con = DriverManager
							.getConnection("jdbc:ucanaccess://C:\\Users\\Malik Yasir\\Desktop\\enterfooddb.accdb");
					System.out.println("connected");
					Statement s = con.createStatement();
					PreparedStatement pst = con
							.prepareStatement("Insert into iteminfo(F00DNAME,FOOD_ID,PRICE,QUANTITY) values(?,?,?,?)");
					pst.setString(1, tf1.getText());
					pst.setString(2, tf2.getText());
					pst.setString(3, tf3.getText());
					pst.setString(4, tf4.getText());
					int a = pst.executeUpdate();
					if (a > 0) {
						JOptionPane.showMessageDialog(null, "ITEMS SAVED");
						mainframe2.dispose();
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please ADD any ITEM");
					e1.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		ENTERFOOD add = new ENTERFOOD();
	}
}
