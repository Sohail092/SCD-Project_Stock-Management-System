import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FRAME_1 extends JFrame {
	JLabel idLabel;
	JLabel passwordLabel;
	JLabel background;
	JLabel headerLabel;
	JTextField id;
	JPasswordField password;
	JButton submit;
	JButton register;

	public FRAME_1() {
		setTitle("Restaurant Management System");
		setDefaultCloseOperation(FRAME_1.EXIT_ON_CLOSE);
		setVisible(true);
		// Background
		this.background = new JLabel(new ImageIcon(
				"C:\\Users\\Malik Yasir\\Desktop\\vecteezy_wood-table-top-for-display-with-blurred-restaurant-background_1948406.jpg"));
		loginpage();
		add(background);
		background.setVisible(true);
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
	}

	public void loginpage() {
		headerLabel = new JLabel();
		this.headerLabel.setText("MALIK RESTAURANT");
		this.headerLabel.setBounds(130, 1, 350, 100);
		this.headerLabel.setFont(new Font("Geomanist", Font.BOLD, 25));
		headerLabel.setForeground(Color.BLACK);
		add(headerLabel);
		idLabel = new JLabel();
		this.idLabel.setText("Username");
		this.idLabel.setBounds(20, 110, 100, 50);
		this.idLabel.setFont(new Font(null, Font.BOLD, 20));
		idLabel.setForeground(Color.BLACK);
		add(idLabel);
		passwordLabel = new JLabel("Password");
		this.passwordLabel.setBounds(20, 165, 100, 50);
		this.passwordLabel.setFont(new Font(null, Font.BOLD, 20));
		passwordLabel.setForeground(Color.BLACK);
		add(passwordLabel);
		id = new JTextField();
		this.id.setBounds(130, 125, 200, 30);
		add(id);
		this.id.setVisible(true);
		password = new JPasswordField();
		this.add(password);
		this.password.setBounds(130, 175, 200, 30);
		register = new JButton("create new account");
		this.register.setBounds(230, 280, 250, 50);
		this.register.setFont(new Font(null, Font.BOLD, 20));
		register.setForeground(Color.BLACK);
		add(register);
		this.submit = new JButton("Login");
		this.submit.setBounds(130, 230, 100, 25);
		this.submit.setFont(new Font(null, Font.BOLD, 20));
		add(submit);
//	    add submit frames
		submit.addActionListener(this::submitActionPerformed);
		register.addActionListener(this::registerActionListener);
	}

//   register 
	void registerActionListener(ActionEvent actionevent1) {
		this.dispose();
		FRAME_2 f2 = new FRAME_2();
		f2.signuppage();
	}

// submit
	public void submitActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection c = DriverManager
					.getConnection("jdbc:ucanaccess://C:\\Users\\Malik Yasir\\Desktop\\register.accdb");
			System.out.println("connection established");
			// using select query
			PreparedStatement s = c.prepareStatement("select * from registerr where NAME='" + id.getText()
					+ "' and PASSWORD='" + password.getText() + "' ");
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				String name = rs.getString("NAME");
				String PASSWORD = rs.getString("PASSWORD");
				this.dispose();
				FRAME_3 mainFrame = new FRAME_3();
				mainFrame.prepareGui();
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "INFO NOT FOUND Please Signup First");
			e1.printStackTrace();
		}
	}
}

class MyGui {
	public static void main(String[] args) {
		FRAME_1 f = new FRAME_1();
		f.setVisible(true);
	}
}
