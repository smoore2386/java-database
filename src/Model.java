import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import com.sun.org.apache.bcel.internal.generic.Type;

public class Model {

	private DataBase db;


	public Model(int choice) 
	{	

		// Create db and connect
		try {
			//create new database
			db =  new DataBase("moor8958","EErr3Tw3");
		} catch (SQLException e) {

			e.printStackTrace();
		}	
	}
	public String[] get_teams()
	{	
		ResultSet res_teams = db.execute("Select t_name from teams");	
		ArrayList<String> teams = new ArrayList<String>();
		try {
			while(res_teams.next())
			{

				//get the results for output
				teams.add(res_teams.getString("t_name"));
			}
		} 
		catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teams.toArray(new String[teams.size()]);
	}
	public String[] get_donations()
	{	
		// get the donations for the people
		ResultSet res_dons = db.execute("Select * from donation");	
		ArrayList<String> dons = new ArrayList<String>();
		try {
			while(res_dons.next())
			{

				//get the results for output
				dons.add(res_dons.getString("campaign") + "_"+res_dons.getString("amount")+"_"+res_dons.getString("p_date")+"_"+res_dons.getString("typ"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return dons.toArray(new String[dons.size()]);
	}

	public void selection1(HashMap<String,String> s)
	{	
		// Insert new team into database
		String cmd = "insert into teams values(\'%s\',\'%s\',to_date(\'%s\','yyyymmdd'))";


		cmd = String.format(cmd, s.get("NAME"),s.get("Type"),s.get("DATE"));
		System.out.println(cmd);
		db.update(cmd);

		// Get Resultset output to table maker
		ResultSet res = db.execute("select * from teams");
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 1 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	public void selection1plsql(HashMap<String,String> s)
	{
		try {
			CallableStatement stmt = db.con.prepareCall("{call INSERTTEAM(?,?,?)}");
			stmt.setString(1,s.get("NAME"));
			stmt.setString(2,s.get("TYPE"));
			stmt.setString(3, s.get("DATE"));
			
			
			stmt.executeUpdate();
			stmt.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void selection10plsql(HashMap<String,String> s)
	{
		
		try {
			CallableStatement stmt = db.con.prepareCall("{call query10(?,?,?)}");
			stmt.setInt(1, Integer.parseInt(s.get("SSN")));
			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.registerOutParameter(3, Types.INTEGER);
			stmt.executeUpdate();
			String name = stmt.getString(2);
			String phone = stmt.getString(3);
			System.out.println("DOC NAME:" + name + "  "+ "DOC PHONE: "+ phone);
			stmt.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void selection2(HashMap<String,String> s,ArrayList<String> teams)
	{


		// Format our strings and input the data
		String cmd = "insert into person values(%s,'%s',%s," +
				"'%s','%s','%s',%s,%s,'%s','%s',%s,'%s','%s','%s')";

		cmd =String.format(cmd, s.get("SSN"),s.get("NAME"),s.get("STR NUM"),s.get("STREET"),s.get("CITY"),s.get("STATE"),
				s.get("ZIP"),"to_date(\'"+s.get("DOB")+"\','yyyymmdd')",s.get("RACE"),
				s.get("EMAIL"),s.get("PHONE"),s.get("MAILING"),s.get("PROFESSION"),
				s.get("GENDER"));
		db.update(cmd);

		cmd = "insert into client values(%s,%s,'%s',%s,'%s',%s)";
		
		cmd =String.format(cmd,s.get("SSN"),"to_date(\'"+s.get("DATE ASSIGN")+"\','yyyymmdd')",
				s.get("DOC NAME"),s.get("DOC PHONE"),s.get("LAW NAME"),s.get("LAW PHONE"));
		db.update(cmd);

		// Now command two will associate these people with the teams
		String cmd2 = "insert into care_for values(%s,\'%s\',\'%s\')";
		
		for(int i = 0; i <teams.size();i++)
		{
			// now in put the data for the teams stuff
			db.update(String.format(cmd2,s.get("SSN"),teams.get(i),"T"));
		}	

		// Output both tables after selection 2
		ResultSet res = db.execute("select * from care_for");
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 2 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ResultSet res2 = db.execute("select * from client");
		TableMaker maker2 = new TableMaker(res2);
		maker2.setTitle("Selection 2 Output");
		maker2.setSize(700,400);
		maker2.setLocationRelativeTo(null);
		maker2.setVisible(true);
		maker2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


	}
	public void selection3(HashMap<String,String> s,ArrayList<String> teams)

	{
		// Add the volunteer
		String cmd = "insert into person values(%s,\'%s\',%s," +
				"\'%s\',\'%s\',\'%s\',%s,%s,\'%s\'," +
				"\'%s\',%s,\'%s\',\'%s\',\'%s\')";

		cmd =String.format(cmd, s.get("SSN"),s.get("NAME"),s.get("STR NUM"),s.get("STREET"),
				s.get("CITY"),s.get("STATE"),s.get("ZIP"),"to_date(\'"+s.get("DOB")+"\','yyyymmdd')",s.get("RACE"),s.get("EMAIL"),
				s.get("PHONE"),s.get("MAILING"),s.get("PROFESSION"),s.get("GENDER"));
		
		
		db.update(cmd);
		
		cmd = "insert into volunteer values(%s,%s,%s,'%s')";
		
		db.update(String.format(cmd,s.get("SSN"),"to_date(\'"+s.get("DATE JOINED")+"\','yyyymmdd')",
				"to_date(\'"+s.get("TRAIN DATE")+"\','yyyymmdd')",s.get("TRAIN LOC")));

		

		// Now associate the volunteer with a team
		String cmd2 = "insert into assn_team values(%s,\'%s\','1')";
		for(int i = 0; i <teams.size();i++)
		{
			db.update(String.format(cmd2,s.get("SSN"),teams.get(i)));
			System.out.println(cmd2);
		}


		// Output both tables after selection 2
		ResultSet res = db.execute("select * from assn_team");
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 3 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ResultSet res2 = db.execute("select * from volunteer");
		TableMaker maker2 = new TableMaker(res2);
		maker2.setTitle("Selection 3 Output");
		maker2.setSize(700,400);
		maker2.setLocationRelativeTo(null);
		maker2.setVisible(true);
		maker2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void selection4(HashMap<String,String> s,ArrayList<String> teams)
	{
		// insert the hours worked into hours worked table for month so we can search by month
		String cmd = "insert into hour_worked values(%s,%s)";
		cmd = String.format(cmd,s.get("MONTH"),s.get("HOURS WORKED"));
		db.update(cmd);

		System.out.println(cmd);
		// Now relate team to SSN
		cmd = String.format("insert into work values(%s,'%s',%s,%s)", s.get("SSN"),
				teams.get(0), s.get("MONTH"),s.get("HOURS WORKED"));
		System.out.println(cmd);
		db.update(cmd);

		ResultSet res = db.execute("select * from work");
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 4 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void selection5(HashMap<String,String> s, ArrayList<String> teams)
	{

		// format our string and execute
		System.out.println("Selection 5 doing its stuff");
		String cmd = "insert into person values(%s,\'%s\',%s," +
				"\'%s\',\'%s\',\'%s\',%s,%s,\'%s\'," +
				"\'%s\',%s,\'%s\',\'%s\',\'%s\')";

		cmd =String.format(cmd, s.get("SSN"),s.get("NAME"),s.get("STR NUM"),s.get("STREET"),
				s.get("CITY"),s.get("STATE"),s.get("ZIP"),"to_date(\'"+s.get("DOB")+"\','yyyymmdd')",s.get("RACE"),s.get("EMAIL"),
				s.get("PHONE"),s.get("MAILING"),s.get("PROFESSION"),s.get("GENDER"));

		db.update(cmd);
		System.out.println(cmd);
		cmd = "insert into employee values(%s,'%s',%s,%s)";
				
		
		cmd = String.format(cmd,s.get("SSN"),s.get("MARITAL"),"to_date(\'"+s.get("HIRE DATE")+"\','yyyymmdd')",s.get("SALARY"));
		System.out.println(cmd);
		db.execute(cmd);

		// added new volunteer now assign that person to a team

		String cmd2 = "insert into reports_to values('%s',%s)";

		for(int i = 0; i <teams.size();i++)
		{

			db.update(String.format(cmd2,teams.get(i),s.get("SSN"),"T"));

		}
		ResultSet res = db.execute("select * from reports_to");
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 5 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ResultSet res2 = db.execute("select * from employee");
		TableMaker maker2 = new TableMaker(res2);
		maker2.setTitle("Selection 5 Output");
		maker2.setSize(700,400);
		maker2.setLocationRelativeTo(null);
		maker2.setVisible(true);
		maker2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void selection6(HashMap<String,String> s) 
	{
		String cmd = "insert into expense values(%s,%s,'%s')";
		String cmd2 = "insert into charge values(%s,%s,%s,'%s')";

		cmd = String.format(cmd,"to_date(\'"+s.get("DATE")+"\','yyyymmdd')",s.get("AMOUNT"),s.get("DESCRIPTION"));
		cmd2 = String.format(cmd2,s.get("SSN"),"to_date(\'"+s.get("DATE")+"\','yyyymmdd')",s.get("AMOUNT"),
				s.get("DESCRIPTION"));

		db.execute(cmd);
		System.out.println(cmd);
		db.execute(cmd2);
		System.out.println(cmd2);

		ResultSet res = db.execute("select * from expense");
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 6 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ResultSet res2 = db.execute("select * from charge");
		TableMaker maker2 = new TableMaker(res2);
		maker2.setTitle("Selection 6 Output");
		maker2.setSize(700,400);
		maker2.setLocationRelativeTo(null);
		maker2.setVisible(true);
		maker2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


	}
	public void selection7(HashMap<String,String> s, ArrayList<String> teams) 
	{
		String cmd = "";
		if (s.get("TYPE") == "Business"){
			cmd = "insert into orgs values(\'%s\',%s,\'%s\',\'%s\'," +
					"\'%s\',%s,%s,\'%s\')";

			cmd = String.format(cmd,s.get("NAME"),s.get("STR NUM"),s.get("STREET"),s.get("CITY"),
					s.get("STATE"),s.get("ZIP"),s.get("PHONE"),s.get("CONTACT"));
			
			db.update(cmd);
			
			cmd  = "insert into business values('%s',%s,'%s','%s')";
			
			cmd = String.format(cmd,s.get("NAME"),s.get("SIZE"),s.get("BTYPE"),s.get("WEB"));

			db.update(cmd);
		}
		else if(s.get("TYPE") == "Church")
		{
			cmd = "insert into orgs values(\'%s\',%s,\'%s\',\'%s\'," +
					"\'%s\',%s,%s,\'%s\')";

			cmd = String.format(cmd,s.get("NAME"),s.get("STR NUM"),s.get("STREET"),s.get("CITY"),
					s.get("STATE"),s.get("ZIP"),s.get("PHONE"),s.get("CONTACT"));
			db.update(cmd);

			cmd = "insert into churchs values('%s','%s')";
			cmd = String.format(cmd, s.get("NAME"),s.get("AFFIL"));

			db.update(cmd);	
		}
		//now relate to teams
		cmd = "insert into sponsors values('%s','%s')";
		for(int i = 0; i <teams.size();i++)
		{

			db.update(String.format(cmd,s.get("NAME"),teams.get(i)));

		}
		ResultSet res;
		if (s.get("TYPE") == "Business"){
			res = db.execute("select * from business");
		}
		else
		{
			res = db.execute("select * from churchs");
		}

		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 7 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ResultSet res2 = db.execute("select * from sponsors");
		TableMaker maker2 = new TableMaker(res2);
		maker2.setTitle("Selection 7 Output");
		maker2.setSize(700,400);
		maker2.setLocationRelativeTo(null);
		maker2.setVisible(true);
		maker2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void selection9(HashMap<String,String> s,ArrayList<String> dons) 
	{
		String cmd = "";
		if (s.get("TYPE") == "Business"){
			cmd = "insert into orgs values(\'%s\',%s,\'%s\',\'%s\'," +
					"\'%s\',%s,%s,\'%s\')";

			cmd = String.format(cmd,s.get("NAME"),s.get("STR NUM"),s.get("STREET"),s.get("CITY"),
					s.get("STATE"),s.get("ZIP"),s.get("PHONE"),s.get("CONTACT"));
			
			db.update(cmd);
			
			cmd  = "insert into business values('%s',%s,'%s','%s')";
			
			cmd = String.format(cmd,s.get("NAME"),s.get("SIZE"),s.get("BTYPE"),s.get("WEB"));

			db.update(cmd);
		}
		else if(s.get("TYPE") == "Church")
		{
			cmd = "insert into orgs values(\'%s\',%s,\'%s\',\'%s\'," +
					"\'%s\',%s,%s,\'%s\')";

			cmd = String.format(cmd,s.get("NAME"),s.get("STR NUM"),s.get("STREET"),s.get("CITY"),
					s.get("STATE"),s.get("ZIP"),s.get("PHONE"),s.get("CONTACT"));
			db.update(cmd);

			cmd = "insert into churchs values('%s','%s')";
			cmd = String.format(cmd, s.get("NAME"),s.get("AFFIL"));

			db.update(cmd);	
		}
		cmd = "insert into donates values('%s',null,'%s',to_date('%s','yyyymmdd'),%s,'%s')";
		for (int i =0; i< dons.size();i++)
		{
			
			String[] temp = dons.get(i).split("_");
			String date = temp[2].replaceAll("-", "");
			date = date.substring(0,8);
			cmd = String.format(cmd, s.get("NAME"),s.get("ANON"),date,temp[1],temp[3]);
			db.execute(cmd);
		}
		ResultSet res = db.execute("select * from donates");
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 6 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

	}
	public void selection8(HashMap<String,String> s,ArrayList<String> dons)
	{
		
		//Enter the Donor first
		String cmd = "insert into person values(%s,\'%s\',%s," +
				"\'%s\',\'%s\',\'%s\',%s,%s,\'%s\'," +
				"\'%s\',%s,\'%s\',\'%s\',\'%s\')";
	
	
		cmd =String.format(cmd, s.get("SSN"),s.get("NAME"),s.get("STR NUM"),s.get("STREET"),
				s.get("CITY"),s.get("STATE"),s.get("ZIP"),"to_date(\'"+s.get("DOB")+"\','yyyymmdd')"
				,s.get("RACE"),s.get("EMAIL"),s.get("PHONE"),s.get("MAILING"),s.get("PROFESSION"),
				s.get("GENDER"));
		
		
		db.execute(cmd);
		
		cmd = "insert into donor values(" + s.get("SSN") + ")";
		
		db.execute(cmd);
		
		
		cmd = "insert into donates values(null,%s,'%s',to_date('%s','yyyymmdd'),%s,'%s')";
		
		
		for (int i =0; i< dons.size();i++)
		{
			
			String[] temp = dons.get(i).split("_");
			String date = temp[2].replaceAll("-", "");
			date = date.substring(0,8);
			cmd = String.format(cmd, s.get("SSN"),s.get("ANON"),date,temp[1],temp[3]);
			db.execute(cmd);
		}
		
		ResultSet res = db.execute("select * from donates");
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 6 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
	}
	public void  selection10(HashMap<String,String> s) 
	{


		String cmd = "Select doc_name,doc_phone from client where client.ssn = %s";
		cmd = String.format(cmd, s.get("SSN"));
		System.out.println(cmd);
		ResultSet res = db.execute(cmd);



		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 10 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	public void selection11(HashMap<String,String> s) 
	{
		String cmd = "select * from charge where e_date between to_date('%s','yyyymmdd')" +
				" and to_date('%s','yyyymmdd') order by amount";
		System.out.println(s.get("FROM"));

		ResultSet res = db.execute(String.format(cmd,s.get("FROM"),s.get("TO")));

		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 11 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	public void selection12(HashMap<String,String> s) 
	{

		//get the client SSN then show volunteers that work or him
		String cmd = "select distinct e_name from volunteers v, assn_team ast, care_for cf " +
				" where cf.ssn=%s and ast.t_name = cf.t_name and ast.ssn = v.ssn";

		cmd = String.format(cmd, s.get("SSN"));
		System.out.println(cmd);
		ResultSet res = this.db.execute(cmd);

		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 12 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


	}
	public void selection13() 
	{

		String cmd = "select distinct  e_name, street_num,street_name,city,state,zip  from person p,  teams t,  care_for cf " +
				"where  cf.ssn= p.ssn and cf.t_name in" +
				" (select t_name  from sponsors s where s.o_name  between 'B'and 'K') order by e_name";
		
		
		ResultSet res = db.execute(cmd);
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 13 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	public void selection14() 
	{
		String cmd = "select person.e_name, donates.amount from person inner join donates on person.ssn=donates.ssn order by amount";
		ResultSet res = db.execute(cmd);
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 14 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public void selection15() 
	{
		String cmd = "select e_name from person p, works w  where w.mnth between 3 and 6 and p.ssn=w.ssn";
		ResultSet res = db.execute(cmd);
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 15 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	public void selection16() 
	{
		ResultSet res1 = db.execute("select * from employee");
		TableMaker maker1 = new TableMaker(res1);
		maker1.setTitle("Selection 16 Output");
		maker1.setSize(700,400);
		maker1.setLocationRelativeTo(null);
		maker1.setVisible(true);
		maker1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		String cmd = "update employee e set salary = salary * 1.1" +
				"where  e.ssn in (select ssn from reports_to group by(ssn)having count(t_name)>=2)";
		this.db.execute(cmd);
		
		ResultSet res = db.execute("select * from employee");
		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 16 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void selection17()
	{
		// Implement Static Query
		 String cmd = "delete from client  where ssn in " +
		 		"(select ca.ssn from client ca,  client_has_need cn " +
		 		"where cn.typ = 'transportation' and cn.score < 5 and ca.ssn= cn.ssn and " +
		 		" cn.ssn in (select ssn from insures i, policys p " +
		 		" where p.p_type != 'health' and i.pid = p.pid))";
		 db.execute(cmd);
		 ResultSet res = db.execute("select * from client");
			TableMaker maker = new TableMaker(res);
			maker.setTitle("Selection 17 Output");
			maker.setSize(700,400);
			maker.setLocationRelativeTo(null);
			maker.setVisible(true);
			maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 
		 
	}
	public void writeCsv(String filename) throws SQLException, FileNotFoundException
	{


		String cmd = "select e_name, street_num,street_name,city,state,zip from person p" +
				" where p.mailing ='T'";
		System.out.println(filename);
		ResultSet res = db.execute(cmd);
		String output_str = "";
		for(int i = 0; res.next();i++){
			for(int j =1; j <= res.getMetaData().getColumnCount(); j++){
				output_str += res.getString(j) +',';
			}
			//output_str =output_str.substring(output_str.length()-1);
			output_str+="\n";
		}

		FileWriter fstream;
		try {
			fstream = new FileWriter(filename);
			BufferedWriter out = new BufferedWriter(fstream);
			System.out.println(output_str);
			out.write(output_str);
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}



	}
	public void readCsv(String filename) throws IOException{

		// Read in a file of teams and enter it into the database
		String cmd = "insert into teams values(\'%s\',\'%s\',to_date(\'%s\','yyyymmdd'))";
		System.out.println(cmd);

		// typical file reading stuff 
		FileInputStream fstream = new FileInputStream(filename);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;

		// since we are implying it is a csv for each line stick the team into db
		while((strLine = br.readLine())!= null)
		{
			String[] data = strLine.split(",");
			db.update(String.format(cmd,data[0],data[1],data[2]));
		}
		br.close();
		ResultSet res = this.db.execute("select * from teams");

		TableMaker maker = new TableMaker(res);
		maker.setTitle("Selection 12 Output");
		maker.setSize(700,400);
		maker.setLocationRelativeTo(null);
		maker.setVisible(true);
		maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	public void any_query(String cmd){
		
			System.out.println(cmd);
			ResultSet res = db.execute(cmd);

			TableMaker maker = new TableMaker(res);
			maker.setTitle("Any Query");
			maker.setSize(700,400);
			maker.setLocationRelativeTo(null);
			maker.setVisible(true);
			maker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
