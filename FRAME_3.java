import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.*;

public class FRAME_3 extends JFrame {
	public void prepareGui() {
		FRAME_3 mainFrame = new FRAME_3();
		mainFrame.setTitle("WELCOME TO OUR RESTAUARNT");
		mainFrame.setBounds(100, 80, 450, 300);
		mainFrame.setSize(400, 400);
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.getContentPane().setBackground(Color.BLACK);
		mainFrame.setForeground(Color.BLACK);
		mainFrame.getContentPane().setForeground(Color.BLACK);
		JLabel photo = new JLabel("New label");
		photo.setIcon(new ImageIcon("C:\\Users\\Malik Yasir\\Desktop\\WhatsApp Image 2022-05-30 at 12.24.57 AM.jpeg"));
		photo.setBounds(128, 90, 251, 142);
		mainFrame.getContentPane().add(photo);
		JPanel panel = new JPanel();
		panel.setBounds(10, 80, 106, 158);
		mainFrame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 0));
		mainFrame.add(panel);
		JButton addButton = new JButton("INSERT ");
		addButton.setFont(new Font("Serif", Font.BOLD, 17));
		panel.add(addButton);
		JButton upButton = new JButton("UPDATE");
		upButton.setFont(new Font("Serif", Font.BOLD, 17));
		panel.add(upButton);
		JButton delButton = new JButton("DELETE");
		delButton.setFont(new Font("Serif", Font.BOLD, 17));
		panel.add(delButton);
		JLabel headerLabel = new JLabel("MALIK'S RESTAURANT");
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		headerLabel.setBounds(30, 11, 360, 55);
		mainFrame.getContentPane().add(headerLabel);
		headerLabel.setForeground(Color.WHITE);
		JButton fdButton = new JButton("FOOD INFO");
		fdButton.setFont(new Font("Serif", Font.BOLD, 18));
		fdButton.setBounds(205, 250, 150, 42);
		mainFrame.getContentPane().add(fdButton);
		fdButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iteminfo ii = new iteminfo();
				ii.itemdata();
			}
		});
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ENTERFOOD add = new ENTERFOOD();
				add.foodbutton();
			}
		});
		upButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updatefood uf = new updatefood();
				uf.foodbutton();
			}
		});
		delButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteFood del = new DeleteFood();
				del.delbutton();
			}
		});
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
	}
}
