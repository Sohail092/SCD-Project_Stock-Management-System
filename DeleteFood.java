import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

public class DeleteFood extends JFrame {
	public void delbutton() {
		JFrame mainframe5 = new JFrame();
		mainframe5.setVisible(true);
		mainframe5.setTitle("DELETEFOOD");
		mainframe5.setBounds(100, 100, 450, 300);
		mainframe5.getContentPane().setLayout(null);
		JLabel name = new JLabel("F00DNAME");
		name.setFont(new Font("Serif", Font.BOLD, 15));
		name.setBounds(79, 76, 100, 14);
		mainframe5.getContentPane().add(name);
		JLabel newdetails = new JLabel("ENTER DETAILS");
		newdetails.setFont(new Font("Serif", Font.BOLD, 18));
		newdetails.setBounds(162, 11, 165, 42);
		mainframe5.getContentPane().add(newdetails);
		JTextField tf1 = new JTextField();
		tf1.setBounds(178, 73, 86, 20);
		mainframe5.getContentPane().add(tf1);
		tf1.setColumns(10);
		JButton delit = new JButton("DELETE");
		delit.setFont(new Font("Serif", Font.BOLD, 15));
		delit.setBounds(296, 214, 89, 23);
		mainframe5.getContentPane().add(delit);
		mainframe5.add(name);
		mainframe5.add(tf1);
		delit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					Connection con = DriverManager
							.getConnection("jdbc:ucanaccess://C:\\Users\\Malik Yasir\\Desktop\\enterfooddb.accdb");
					Statement s = con.createStatement();
					PreparedStatement pst = con.prepareStatement("DELETE FROM iteminfo WHERE F00DNAME= ?");
					pst.setString(1, tf1.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Item Deleted " + tf1.getText());
					mainframe5.dispose();
				} catch (Exception e1) {
					System.out.println(e1);
					System.out.println("EEEE");
					JOptionPane.showMessageDialog(null, "Item not found : " + tf1.getText());
					e1.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		DeleteFood del = new DeleteFood();
	}
}
