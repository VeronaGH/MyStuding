package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.DB;

public class LoginFrame extends JFrame {

	private JPanel panel;
	private JTextField login;
	private JPasswordField password;
	private JLabel labelLogin, labelPassword;
	private JButton ok, register;

	public DB db;

	public LoginFrame(DB db) {
		this.db = db;
		setTitle("Авторизация");
		setSize(250, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		action();
		setVisible(true);

	}

	public void initComponents() {
		panel = new JPanel();

		login = new JTextField("Svetik777", 20);

		password = new JPasswordField("45678", 20);

		labelPassword = new JLabel("Пароль");
		labelLogin = new JLabel("Логин");

		ok = new JButton("ОК");
		register = new JButton("Регистрация");

		panel.add(labelLogin);
		panel.add(login);
		panel.add(labelPassword);
		panel.add(password);
		panel.add(ok);
		panel.add(register);

		add(panel);
	}

	public void action() {
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = db.querty("SELECT * FROM users WHERE login='" + login.getText() + "' AND delState='Activ'");
				try {
					if (rs.next()) {
						if (String.valueOf(password.getPassword()).equals(rs.getString("password"))) {
							rs.beforeFirst();
							rs.next();
							String Svar = rs.getString("role");
							rs.beforeFirst();
							rs.next();
							int ivar = rs.getInt("id_user");
							if (Svar.equals("Admin")) {
								new AdminFrame(db, 0);
								dispose();
							}
							if (Svar.equals("Sailer")) {
								new SailerFrame(db, 1);
								dispose();
							}
							if (Svar.equals("Customer")) {
								new CustomerFrame(db, ivar);
								dispose();
							}
						}
					} else {
						JOptionPane.showMessageDialog(panel, "Пароль введен не верно", "ОК", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					System.out.println("err");
					JOptionPane.showMessageDialog(panel, "Ошибка авторизации", "ОК", JOptionPane.ERROR_MESSAGE);

				}
			}

		});
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RegFrame(db);
				dispose();
			}

		});

	}

}
