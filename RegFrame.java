package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.DaoUsers;
import db.DB;
import entity.Users;

public class RegFrame extends JFrame {

	private JPanel panel;
	private JTextField user, login, role;
	private JLabel action;
	private JButton reg, esc;
	private JPasswordField password;

	public DB db;

	public RegFrame(DB db) {
		this.db = db;
		setTitle("Регистрация");
		setSize(250, 250);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		action();
		setVisible(true);

	}

	public void initComponents() {
		panel = new JPanel();

		action = new JLabel("Регистрация");
		user = new JTextField("Пользователь", 20);
		login = new JTextField("Логин", 20);
		role = new JTextField("Введите роль", 20);

		password = new JPasswordField("Пароль", 20);

		reg = new JButton("Зарегистрироваться");
		esc = new JButton("Выход");

		panel.add(action);
		panel.add(user);
		panel.add(login);
		panel.add(password);
		panel.add(role);
		panel.add(reg);
		panel.add(esc);
		add(panel);
	}

	public void action() {
		reg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (String.valueOf(user.getText()).equals("Пользователь") == false) {
					if (String.valueOf(login.getText()).equals("Логин") == false) {
						if (String.valueOf(role.getText()).equals("Введите роль") == false) {
							DaoUsers du = new DaoUsers(db);
							du.insert(new Users(user.getText(), login.getText(), password.getText(), role.getText(), "Activ"));
						}
					}

				}

			}

		});

		esc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame(db);
				dispose();
			}

		});

	}

}
