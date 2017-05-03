package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dao.DaoOrders;
import dao.DaoProducts;
import dao.DaoUsers;
import db.DB;
import entity.Orders;
import entity.Products;
import entity.Users;

public class AdminFrame extends JFrame {

	private JPanel panel;
	private JLabel action;
	private JButton tUser, tProducts, tOrders, exit;
	DB db;
	int il;
	private TableTable table;
	private JScrollPane scroll;

	public AdminFrame(DB db, int il) {
		this.db = db;
		this.il = il;
		setTitle("Управление");
		setSize(600, 500);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		action();
		setVisible(true);

	}

	public void initComponents() {
		panel = new JPanel();

		action = new JLabel("Таблицы");

		tUser = new JButton("Юзеры");
		tProducts = new JButton("Продукты");
		tOrders = new JButton("Заказы");
		exit = new JButton("Выход");

		if (il == 0) {
			table = new TableTable(db.querty("SELECT * FROM users"));
		}
		if (il == 1) {
			table = new TableTable(db.querty("SELECT * FROM products"));
		}
		if (il == 2) {
			table = new TableTable(db.querty("SELECT * FROM orders"));
		}

		scroll = new JScrollPane(table);
		panel.add(action);
		panel.add(tUser);
		panel.add(tProducts);
		panel.add(tOrders);
		panel.add(scroll);
		panel.add(exit);

		add(panel);
	}

	public void action() {
		tUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * panel.remove(scroll); table = new
				 * TableTable(db.querty("SELECT * FROM users")); scroll= new
				 * JScrollPane(table); panel.add(scroll); panel.updateUI();
				 */
				il = 0;
				new AdminFrame(db, il);
				dispose();
			}

		});

		tProducts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * panel.remove(scroll); table = new
				 * TableTable(db.querty("SELECT * FROM products")); scroll= new
				 * JScrollPane(table); panel.add(scroll); panel.updateUI();
				 */
				il = 1;
				new AdminFrame(db, il);
				dispose();
			}

		});

		tOrders.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * panel.remove(scroll); table = new
				 * TableTable(db.querty("SELECT * FROM orders")); scroll= new
				 * JScrollPane(table); panel.add(scroll); panel.updateUI();
				 */
				il = 2;
				new AdminFrame(db, il);
				dispose();
			}

		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame(db);
				dispose();
			}

		});

		table.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (table.getSelectedRow() != -1) {
						if (il == 0) {
							DaoUsers du = new DaoUsers(db);
							du.update(new Users(Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(), 0))), String.valueOf(table.getValueAt(table.getSelectedRow(), 1)), String.valueOf(table.getValueAt(table.getSelectedRow(), 2)),
									String.valueOf(table.getValueAt(table.getSelectedRow(), 3)), String.valueOf(table.getValueAt(table.getSelectedRow(), 4)), String.valueOf(table.getValueAt(table.getSelectedRow(), 5))));
						}
						if (il == 1) {
							DaoProducts dp = new DaoProducts(db);
							dp.update(new Products(Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(), 0))), String.valueOf(table.getValueAt(table.getSelectedRow(), 1)),
									Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(), 2))), Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(), 3))),
									String.valueOf(table.getValueAt(table.getSelectedRow(), 4))));
						}
						if (il == 2) {
							DaoOrders dor = new DaoOrders(db);
							dor.update(new Orders(Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(), 0))), Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(), 1))),
									Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(), 2))), Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(), 3))),
									Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(), 4))), String.valueOf(table.getValueAt(table.getSelectedRow(), 5))));
						}
					}
				}
			}
		});
	}

}
