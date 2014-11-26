import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	private Vector<String> columnNames = new Vector<String>();

	//Eraikitzailea
	public MyTableModel() {
		kargatu();
	}

	class Lag {
		String izena;
		String abizena;
		String kirola;
		Integer tamaina;
		Boolean baiez;

		public Lag(String izena, String abizena, String kirola,
				Integer tamaina, Boolean baiez) {
			super();
			this.izena = izena;
			this.abizena = abizena;
			this.kirola = kirola;
			this.tamaina = tamaina;
			this.baiez = baiez;
		}

		public Object getBalioa(int i) {
			Object objetua=null;
			if (i == 0)
				objetua=this.izena;
			else if (i == 1)
				objetua=this.abizena;
			else if (i == 2)
				objetua=this.kirola;
			else if (i == 3)
				objetua=this.tamaina;
			else if (i == 4)
				objetua=this.baiez;
			
			return objetua;
		}

		public void insertElementAt(Object value, int i) {
			if (i == 0)
				this.izena =(String)value;
			else if (i == 1)
				this.abizena = (String) value;
			else if (i == 2)
				this.kirola = (String) value;
			else if (i == 3)
				this.tamaina = (Integer) value;
			else if (i == 4)
				this.baiez = (Boolean) value;
		}
	}

	private Vector<Lag> data = new Vector<Lag>();

	public void kargatu() {
		columnNames.add("First name");
		columnNames.add("Last name");
		columnNames.add("Sport");
		columnNames.add("of Years");
		columnNames.add("Vegetarian");
		Lag lag1= new Lag("Kathy", "Smith", "Snowboarding", 5, false);
		Lag lag2= new Lag("John", "Doe", "Rowing", 3, true);
		Lag lag3= new Lag("Sue", "Black", "Knitting", 2, true);
		Lag lag4= new Lag("Jane", "White", "Speed reading", 20, true);
		Lag lag5= new Lag("Leire", "Oliden", "Traveling", 7, false);
		Lag lag6= new Lag("Unai", "Guenaga", "Potruk ikutu", 20, false);
		Lag lag7= new Lag("Aitor", "Ortuondo", "Gaming", 21, false);
		Lag lag8= new Lag("Xenki", "Etxaburu", "Eztotzet ostiik pe ulertuten", 23, true);
		Lag lag9= new Lag("Ander", "Beitia", "Pazientzi gitxi", 24, true);
		Lag lag10= new Lag("Jorge", "Nieto", "Gora Athletic", 20, true);
		Lag lag11= new Lag("Ieltzu", "Irazu", "Tximeleta", 2, true);
		Lag lag12= new Lag("Mikel", "De Velasco", "Gora Python", 4, true);
		Lag lag13= new Lag("Juanan", "Pereira", "I love MAC", 20, true);

		data.add(lag1);
		data.add(lag2);
		data.add(lag3);
		data.add(lag4);
		data.add(lag5);
		data.add(lag6);
		data.add(lag7);
		data.add(lag8);
		data.add(lag9);
		data.add(lag10);
		data.add(lag11);
		data.add(lag12);
		data.add(lag13);




		
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	public int getRowCount() {
		return data.size();
	}

	public String getColumnName(int col) {
		return columnNames.get(col);
	}

	public Object getValueAt(int row, int col) {
		return data.get(row).getBalioa(col);
	
	}

	public void setValueAt(Object value, int row, int col) {
		Lag lag=data.get(row);
		lag.insertElementAt(value, col);
		data.setElementAt(lag, row);
	}

	public Class getColumnClass(int col) {
		switch (col) {
		case 0:
		case 1:
		case 2:
			return String.class;
		case 3:
			return Integer.class;
		case 4: 
			return Boolean.class;

		default:
			break;
		}
		return null;
		
	}
	public boolean isCellEditable(int row, int col) {
		if(col<2)
			return false;
		else 
			return true;
	}

	private static void createAndShowGUI() {

		JFrame frame = new JFrame("Kirola");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		TableDemo newContentPane = new TableDemo();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(700, 200);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
