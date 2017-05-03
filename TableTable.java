package frame;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableTable extends JTable {

	public TableTable(ResultSet rs) {
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				dtm.addColumn(rsmd.getColumnName(i));
			}
			while (rs.next()) {
				Vector v = new Vector();
				for (int j = 1; j <= rsmd.getColumnCount(); j++) {
					v.add(rs.getString(j));
				}
				dtm.addRow(v);
			}
			setModel(dtm);
			setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);

		} catch (SQLException e) {
			System.out.println("error in constructor TableTable");
		}

	}

}
