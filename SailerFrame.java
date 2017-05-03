package frame;

public class SailerFrame extends JFrame {

	private JPanel panel;
	private JLabel action;
	private JButton tProducts, tOrders, exit;
	DB db;
	int il;
	private TableTable table;
	private JScrollPane scroll;

	public SailerFrame(DB db, int il) {
		this.db = db;
		this.il = il;
		setTitle("Окно заказа");
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

		action = new JLabel("Выберите продукты");

		tProducts = new JButton("Продукт");
		tOrders = new JButton("Заказ");
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
		panel.add(tProducts);
		panel.add(tOrders);
		panel.add(scroll);
		panel.add(exit);

		add(panel);
	}

	public void action() {

		tProducts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				il = 1;
				new SailerFrame(db, il);
				dispose();
			}

		});

		tOrders.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				il = 2;
				new SailerFrame(db, il);
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
