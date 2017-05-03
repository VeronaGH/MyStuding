package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.DB;
import db.WorkDB;

public class StartFrame extends JFrame {

	private JPanel panel;
	private JTextField url, nameDB, nameUser;
	private JPasswordField password;
	private JLabel labelUrl, labelNameDB, labelName, labelPassword;
	private JButton create, delete, connect;

	public StartFrame() {
		setTitle("Подключение к базе");
		setSize(250, 290);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		action();
		setVisible(true);

	}

	public void initComponents() {
		panel = new JPanel();

		url = new JTextField("jdbc:mysql://127.0.0.1/", 20);
		nameDB = new JTextField("shop", 20);
		nameUser = new JTextField("root", 20);

		password = new JPasswordField("12345", 20);

		labelNameDB = new JLabel("База данных");
		labelName = new JLabel("Имя");
		labelPassword = new JLabel("Пароль");
		labelUrl = new JLabel("URL");

		create = new JButton("Создать");
		delete = new JButton("Удалить");
		connect = new JButton("Подключить");

		panel.add(labelUrl);
		panel.add(url);
		panel.add(labelNameDB);
		panel.add(nameDB);
		panel.add(labelName);
		panel.add(nameUser);
		panel.add(labelPassword);
		panel.add(password);
		panel.add(create);
		panel.add(delete);
		panel.add(connect);

		add(panel);
	}

	DB db;

	public void action() {
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				db = WorkDB.createDB(url.getText(), nameDB.getText(), nameUser.getText(), String.valueOf(password.getPassword()));
				WorkDB.prepareDB(db);
			}
		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				db = WorkDB.saveURL(url.getText(), nameDB.getText(), nameUser.getText(), String.valueOf(password.getPassword()));
				WorkDB.deleteDB(url.getText(), nameDB.getText(), nameUser.getText(), String.valueOf(password.getPassword()));

			}
		});

		connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				db = WorkDB.saveURL(url.getText(), nameDB.getText(), nameUser.getText(), String.valueOf(password.getPassword()));
				JOptionPane.showMessageDialog(panel, "Подключение к базе выполнено", "", JOptionPane.INFORMATION_MESSAGE);
				new LoginFrame(db);
				dispose();

			}
		});
	}

}
