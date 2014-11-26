import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TableDemo extends JPanel{
	public TableDemo(){
		//superra
		super(new GridLayout(1,0));
		
		JTable table = new JTable(new MyTableModel());
		JScrollPane scrollPane= new JScrollPane(table);
		add(scrollPane);
		
	}
}
