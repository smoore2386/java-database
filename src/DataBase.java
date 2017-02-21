import java.sql.*;

public class DataBase {
	Connection con;
	Statement stmt;

	DataBase(String driver, String url, String username, String password) throws SQLException{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to find the OracleDriver");
			e.printStackTrace();
		}
	      con = DriverManager.getConnection(url, username, password);
	      stmt = con.createStatement();
	}
	
	DataBase(String username, String password) throws SQLException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to find the OracleDriver");
			e.printStackTrace();
		}
	      con = DriverManager.getConnection("jdbc:oracle:thin:@stu-oracle.cs.ou.edu:1521:cs4513", username, password);
	      stmt = con.createStatement();
	}
	/**
	 * 
	 * @param sql - an SQL statement to be sent to the database, typically a static SQL SELECT statement  
	 * @return a ResultSet object that contains the data produced by the given query; never null unless the sql was wrongly written
	 */
	public ResultSet execute(String sql){
		try {
			stmt = con.createStatement();
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Error executing sql: "+sql);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @param sql - an SQL INSERT, UPDATE or DELETE statement or an SQL statement that returns nothing
	 * @return either the row count for INSERT, UPDATE or DELETE statements, or 0 for SQL statements that return nothing -1 for sql that was wrongly written
	 */
	public int update(String sql){
		try {
			stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);
			return i;
		} catch (SQLException e) {
			System.out.println("Error executing sql: "+sql);
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * @return the Connection
	 */
	public Connection getConnection() {
		return con;
	}

	/**
	 * @return the Statement
	 * @throws SQLException 
	 */
	public Statement getNewStatement() throws SQLException {
		return con.createStatement();
	}
}
