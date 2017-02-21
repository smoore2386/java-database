import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TableMaker extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane pane;
	private JTable table;
	ResultSet res; 
	public TableMaker(){
		this.table = new JTable();
		this.add(table);
	}
	public TableMaker(ResultSet res){
		
		pane = new JScrollPane();
		this.res = res;
		try {
			this.table = new JTable(this.getRows(),this.getColumnNames());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
		this.pane = new JScrollPane(this.table);
		this.table.setVisible(true);
		this.add(pane);
		
		
		

	}
	private String[][] getRows() throws SQLException{
		ResultSetMetaData meta = this.res.getMetaData();
		
		
		String[][] rows = new String [100][meta.getColumnCount()];

		System.out.println(meta.getColumnCount());
		for(int i = 0; res.next();i++){
			for(int j =1; j <= meta.getColumnCount(); j++){
				System.out.println(this.res.getString(j));
				rows[i][j-1] = this.res.getString(j);
			}
		}
		return rows;
	}
	private String[] getColumnNames() throws SQLException
	{
		ResultSetMetaData meta;

		try {
			meta = this.res.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		String[] col_names = new String[meta.getColumnCount()];

		for(int  i = 1; i <= meta.getColumnCount(); i++)
		{
			System.out.println(meta.getColumnName(i));
			col_names[i-1] = meta.getColumnName(i);

		}

		return col_names;


	}

}
