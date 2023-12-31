import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

public class iteminfo extends JFrame {
	public void itemdata() {
		iteminfo ii = new iteminfo();
		JFrame mainframe3 = new JFrame();
		mainframe3.setSize(500, 500);
		mainframe3.setTitle("Showing all items");
		mainframe3.getContentPane().setLayout(null);
		mainframe3.getContentPane().setBackground(Color.BLACK);
		mainframe3.setForeground(Color.BLACK);
		mainframe3.getContentPane().setForeground(Color.BLACK);
		JButton updatebtn = new JButton("update");
		updatebtn.setFont(new Font("Serif", Font.BOLD, 15));
		updatebtn.setBounds(320, 350, 108, 42);
		mainframe3.getContentPane().add(updatebtn);
		mainframe3.add(updatebtn);
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatefood up = new updatefood();
				up.foodbutton();
			}
		});
		JLabel headerLabel = new JLabel("MENU LIST");
		headerLabel.setForeground(Color.BLACK);
		headerLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
		headerLabel.setBounds(141, 0, 293, 89);
		headerLabel.setForeground(Color.WHITE);
		mainframe3.getContentPane().add(headerLabel);
		JLabel l1 = new JLabel("ITEMS");
		l1.setBounds(10, 67, 46, 14);
		l1.setForeground(Color.WHITE);
		mainframe3.getContentPane().add(l1);
		JLabel l2 = new JLabel("ITEMS_ID");
		l2.setBounds(115, 67, 66, 14);
		l2.setForeground(Color.WHITE);
		mainframe3.getContentPane().add(l2);
		JLabel l4 = new JLabel("QUANTITY");
		l4.setBounds(325, 67, 80, 14);
		l4.setForeground(Color.WHITE);
		mainframe3.getContentPane().add(l4);
		JLabel l3 = new JLabel("PRICE");
		l3.setBounds(220, 67, 46, 14);
		l3.setForeground(Color.WHITE);
		mainframe3.getContentPane().add(l3);
		String[] columnNames = { "F00DNAME", "FOOD_ID", "PRICE", "QUANTITY" };
		/// making an array
		Object[][] food = new Object[100][5];
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection c = DriverManager
					.getConnection("jdbc:ucanaccess://C:\\Users\\Malik Yasir\\Desktop\\enterfooddb.accdb");
			System.out.println("connection established");
			// using select query
			PreparedStatement s = c.prepareStatement("select * from  iteminfo  ");
			ResultSet rs = s.executeQuery();
			int i = 0;
			while (rs.next()) {
				// fetch from row,column
				food[i][0] = rs.getString("F00DNAME");
				food[i][1] = rs.getString("FOOD_ID");
				food[i][2] = rs.getString("PRICE");
				food[i][3] = rs.getString("QUANTITY");
				i++;
			}
		} catch (Exception e1) {
			System.out.println("ERROR!!!");
			e1.printStackTrace();
		}
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 414, 178);
		mainframe3.getContentPane().add(separator);
		JTable table = new JTable(food, columnNames);
		table.setBounds(10, 90, 414, 178);
		mainframe3.getContentPane().add(table);
		mainframe3.getContentPane().add(table);
		mainframe3.setVisible(true);
		mainframe3.setLocationRelativeTo(null);
		mainframe3.add(l1);
		mainframe3.add(l2);
		mainframe3.add(l3);
		mainframe3.add(l4);
		mainframe3.add(headerLabel);
	}

	public static void main(String[] args) {
	}
}
