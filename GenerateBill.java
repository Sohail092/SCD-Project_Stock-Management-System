import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.awt.*;

public class GenerateBill extends JFrame {
	public void billinfo() {
		String[] columnNames = { "Food Name", "Quantity", "Price" };
		// making an array
		Object data[][] = new Object[100][5];
		JFrame mainframe6 = new JFrame();
		mainframe6.setTitle("GENERATEBILL");
		mainframe6.setBounds(100, 100, 450, 300);
		mainframe6.setVisible(true);
		mainframe6.getContentPane().setLayout(null);
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 65, 495, 186);
		mainframe6.getContentPane().add(separator);
		JLabel l1 = new JLabel("FOODNAME");
		l1.setBounds(10, 24, 90, 14);
		mainframe6.getContentPane().add(l1);
		JTextField tf1 = new JTextField();
		tf1.setBounds(95, 21, 86, 20);
		mainframe6.getContentPane().add(tf1);
		tf1.setColumns(10);
		JLabel l2 = new JLabel("QUANTITY");
		l2.setBounds(205, 24, 64, 14);
		mainframe6.getContentPane().add(l2);
		JButton checkButton = new JButton("CHECKOUT");
		checkButton.setFont(new Font("Serif", Font.BOLD, 15));
		checkButton.setBounds(200, 150, 180, 42);
		mainframe6.getContentPane().add(checkButton);
		JTextField tf2 = new JTextField();
		tf2.setBounds(279, 21, 86, 20);
		mainframe6.getContentPane().add(tf2);
		tf2.setColumns(10);
		mainframe6.setVisible(true);
		mainframe6.add(checkButton);
		checkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					Connection c = DriverManager
							.getConnection("jdbc:ucanaccess://C:\\Users\\Malik Yasir\\Desktop\\enterfooddb.accdb");
					System.out.println("ERROR");
					// using select query
					PreparedStatement pst = c.prepareStatement("Select PRICE from iteminfo WHERE F00DNAME = ?");
					pst.setString(1, tf1.getText());
					ResultSet rs = pst.executeQuery();
					int i = 0;
					while (rs.next()) {
						foodcart f = new foodcart();
						// fetching food name and quantity
						f.name = tf1.getText();
						f.quantity = Integer.parseInt(tf2.getText());
						// calculation
						f.totalPer = f.quantity * rs.getDouble("PRICE");
						JOptionPane.showMessageDialog(null, "Total Cost : " + (f.totalPer) + "RUPEES ");
						int count = 1;
						JOptionPane.showMessageDialog(null, (count + ": Food Name : " + f.name + " || " + " Quantity : "
								+ f.quantity + "|| " + " Price : " + f.totalPer + "RUPEES"));
						setDefaultCloseOperation(mainframe6.EXIT_ON_CLOSE);
						mainframe6.dispose();
					}
				} catch (Exception e1) {
					System.out.println("ERROR!!!");
					e1.printStackTrace();
				}
			}
		});
	}

	class foodcart {
		String name;
		Double totalPer;
		int quantity;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateBill gb = new GenerateBill();
	}
}
