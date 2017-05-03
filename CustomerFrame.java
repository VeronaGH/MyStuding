package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dao.DaoOrders;
import db.DB;
import entity.Orders;

public class CustomerFrame extends JFrame {

	private JPanel panel;
	private JLabel action;
	private JButton exit, create, show;
	private JTextField item, qwontity, prise;
	private TableTable table;
	private JScrollPane scroll;

	DB db;
	int ivar;

	public CustomerFrame(DB db, int ivar) {
		this.db = db;
		this.ivar = ivar;
		setTitle("Оформление покупки");
		setSize(500, 500);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		action();
		setVisible(true);

	}

	public void initComponents() {
		panel = new JPanel();

		action = new JLabel("Выбор продукта");

		create = new JButton("Заказать");
		exit = new JButton("Выход");
		show = new JButton("Показать");
		item = new JTextField("Номер продукта", 35);
		qwontity = new JTextField("Количество", 35);
		prise = new JTextField("Цена", 35);

		panel.add(action);
		panel.add(item);
		panel.add(qwontity);
		panel.add(prise);
		panel.add(create);
		panel.add(exit);
		panel.add(show);
		table = new TableTable(db.querty("SELECT * FROM orders WHERE id_user=" + ivar));
		scroll = new JScrollPane(table);
		panel.add(scroll);

		add(panel);
	}

	public void action() {
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DaoOrders dor = new DaoOrders(db);
				dor.insert(new Orders(ivar, Integer.valueOf(item.getText()), Integer.valueOf(qwontity.getText()), Integer.valueOf(prise.getText()), "notPayed"));
				JOptionPane.showMessageDialog(panel, "Заказ успешно создан", "", JOptionPane.INFORMATION_MESSAGE);
				panel.remove(scroll);
				table = new TableTable(db.querty("SELECT * FROM orders WHERE id_user=" + ivar));
				scroll = new JScrollPane(table);
				panel.add(scroll);
				panel.updateUI();
			}

		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame(db);
				dispose();
			}

		});

		show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.remove(scroll);
				table = new TableTable(db.querty("SELECT * FROM orders WHERE id_user=" + ivar));
				scroll = new JScrollPane(table);
				panel.add(scroll);
				panel.updateUI();
			}

		});
	}
}
