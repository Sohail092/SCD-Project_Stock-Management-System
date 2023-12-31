import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

public class updatefood extends JFrame {
	public void foodbutton() {
		JFrame mainframe4 = new JFrame();
		mainframe4.setVisible(true);
		mainframe4.setTitle("UPDATEFOOD");
		mainframe4.setBounds(100, 100, 450, 300);
		mainframe4.getContentPane().setLayout(null);
		JLabel name = new JLabel("F00DNAME");
		name.setFont(new Font("Serif", Font.BOLD, 15));
		name.setBounds(79, 76, 100, 14);
		mainframe4.getContentPane().add(name);
		JLabel id = new JLabel("FOOD_ID");
		id.setFont(new Font("Serif", Font.BOLD, 15));
		id.setBounds(79, 120, 73, 14);
		mainframe4.getContentPane().add(id);
		JLabel q = new JLabel("QUANTITY");
		q.setFont(new Font("Serif", Font.BOLD, 15));
		q.setBounds(79, 200, 150, 14);
		mainframe4.getContentPane().add(q);
		JLabel price = new JLabel("PRICE");
		price.setFont(new Font("Serif", Font.BOLD, 15));
		price.setBounds(79, 162, 73, 14);
		mainframe4.getContentPane().add(price);
		JLabel newdetails = new JLabel("ENTER DETAILS");
		newdetails.setFont(new Font("Serif", Font.BOLD, 18));
		newdetails.setBounds(162, 11, 165, 42);
		mainframe4.getContentPane().add(newdetails);
		JTextField tf1 = new JTextField();
		tf1.setBounds(178, 73, 86, 20);
		mainframe4.getContentPane().add(tf1);
		tf1.setColumns(10);
		JTextField tf2 = new JTextField();
		tf2.setBounds(178, 117, 86, 20);
		mainframe4.getContentPane().add(tf2);
		tf2.setColumns(10);
		JTextField tf4 = new JTextField();
		tf4.setBounds(178, 200, 86, 20);
		mainframe4.getContentPane().add(tf4);
		tf4.setColumns(10);
		JTextField tf3 = new JTextField();
		tf3.setBounds(178, 159, 86, 20);
		mainframe4.getContentPane().add(tf3);
		tf3.setColumns(10);
		JButton updateit = new JButton("UPDATE");
		updateit.setFont(new Font("Serif", Font.BOLD, 15));
		updateit.setBounds(296, 214, 89, 23);
		mainframe4.getContentPane().add(updateit);
		mainframe4.add(name);
		mainframe4.add(tf1);
		mainframe4.add(price);
		mainframe4.add(tf2);
		mainframe4.add(id);
		mainframe4.add(tf3);
		mainframe4.add(q);
		mainframe4.add(tf4);
		updateit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					Connection c = DriverManager
							.getConnection("jdbc:ucanaccess://C:\\Users\\Malik Yasir\\Desktop\\enterfooddb.accdb");
					System.out.println("connection established");
					PreparedStatement pst = c
							.prepareStatement("UPDATE iteminfo SET F00DNAME= ?, PRICE=? ,QUANTITY=? WHERE FOOD_ID= ?");
					pst.setString(1, (tf1.getText()));
					pst.setString(2, (tf3.getText()));
					pst.setString(3, (tf4.getText()));
					pst.setString(4, (tf2.getText()));
					pst.execute();
					JOptionPane.showMessageDialog(null, "Done Updating " + tf2.getText());
					mainframe4.dispose();
				} catch (Exception e1) {
					System.out.println(e1);
					System.out.println("Error");
					JOptionPane.showMessageDialog(null, "Inserting Error : " + tf2.getText());
					e1.printStackTrace();
				}
			}
		});
	} // method

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		updatefood up = new updatefood();
	}
}
