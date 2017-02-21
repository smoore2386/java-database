import java.awt.BorderLayout; 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Option extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private static final String[] MONTHS = {"January","February",
		"March","April","May",
		"June","July","August",
		"September","October",
		"November","December"};
	//States for easy selection of the combo box
	private static final String[] STATES = {"AK", "AL", "AR", "AZ", 
		"CA", "CO", "CT", "DC", "DE", 
		"FL", "GA", "HI", "IA", "ID", 
		"IL", "IN", "KS", "KY", "LA", 
		"MA", "MD", "ME", "MI", "MN", 
		"MO", "MS", "MT", "NC", "ND", 
		"NE", "NH", "NJ", "NM", "NV", 
		"NY", "OH", "OK", "OR", "PA", 
		"RI", "SC", "SD", "TN", "TX", 
		"UT", "VA", "VT", "WA", "WI", 
		"WV", "WY"};

	//Organizations
	private static final String[]  ORGS = {"Business","Church"};
	//TF values formailing list
	private static final String[] MAIL_LIST = {"T","F"};
	// Gender selection options
	private static final String[] GENDER = {"M","F"};

	// Declare all of the fields we will need at most 16
	private JButton button1;
	private JTextField field1; 
	private JTextField field2; 		
	private JTextField field3;
	private JTextField field4;
	private JTextField field5;
	private JTextField field6;
	private JTextField field7;
	private JTextField field8;
	private JTextField field9;
	private JTextField field10;
	private JTextField field11;
	private JTextField field12;
	private JTextField field13;
	private JTextField field14;
	private JTextField field15;
	private JTextField field16;
	private JTextField field17;

	private HashMap<String, String> vals;
	private ArrayList<JTextField> fields = new ArrayList<JTextField>();
	//Define up to 4 panels
	private JPanel p;

	// Just need one list for the teams

	private JList list;

	// define couple combo boxes

	private JComboBox combo1;

	private JComboBox combo2;

	private JComboBox combo3;

	private JComboBox org_box;
	private JCheckBox ckbox;
	private JCheckBox ckbox2;
	private JButton button;
	private int choice;
	private GridBagConstraints c = null;
	private Front_End fe;
	private Model mod;
	private JTable table;

	public Option(Front_End fe,int choice) 
	{
		this.button = new JButton("Submit");
		this.fe = fe;
		this.choice = choice;
		this.mod = new Model(this.choice);
		switch(choice)
		{

		// Build the option panel based on what the choice was 
		case 1:		this.selection1();
		break;

		case 2:		this.selection2();
		break;

		case 3:		this.selection3();
		break;

		case 4:		this.selection4();
		break;

		case 5:		this.selection5();
		break;

		case 6:		this.selection6();
		break;

		case 7:		this.selection7();
		break;

		case 8:		this.selection8();
		break;

		case 9:		this.selection9();
		break;

		case 10:	this.selection10();
		break;

		case 11:	this.selection11();
		break;

		case 12:	this.selection12();
		break;

		case 13:	this.selection13();
		break;

		case 14:	this.selection14();
		break;

		case 15:	this.selection15();
		break;

		case 16:	this.selection16();
		break;

		case 17:	this.selection17();
		break;
		case 18:	this.selection18();
		break;
		case 19:	this.selection19();
		break;
		case 20: this.selection20();
		break;
		}
	}
	public void selection1(){

		//Enter new team into DB
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();


		this.c.gridx =0;
		this.c.gridy =0;
		p.add(new JLabel("Name:"),c);
		this.c.gridx =1;
		this.c.gridy =0;
		this.field1 =  new JTextField(10);
		p.add(field1,c);
		this.fields.add(field1);


		this.c.gridx =2;
		this.c.gridy =0;
		p.add(new JLabel("Type:"),c);
		this.field2= new JTextField(10);
		this.c.gridx =3;
		this.c.gridy =0;
		p.add(field2,c);
		this.fields.add(field2);

		this.c.gridx =0;
		this.c.gridy =1;
		p.add(new JLabel("Form Date:"),c);
		this.field3 = new JTextField(10);
		this.c.gridx =1;
		this.c.gridy =1;
		p.add(field3,c);
		this.fields.add(field3);

		this.c.gridx =3;
		this.c.gridy =1;
		button.addActionListener(this);
		p.add(button,c);


	}

	public void selection2(){
		// Enter a new client into the db and assoc with one or more teams

		System.out.println("hello");
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		//////////////////////////////////////////////////////////////
		/////			Build Option Gui        //////////////////////
		//////////////////////////////////////////////////////////////

		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("SSN:"),c);
		field1 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		p.add(field1,c);
		this.fields.add(field1);


		c.gridx = 2;
		c.gridy = 0;
		p.add(new JLabel("Name:"),c);
		field2 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 0;
		p.add(field2,c);
		this.fields.add(field2);

		c.gridx = 0;
		c.gridy = 1;
		p.add(new JLabel("Street Number:"),c);
		field3 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 1;
		p.add(field3,c);
		this.fields.add(field3);


		c.gridx = 2;
		c.gridy = 1;
		p.add(new JLabel("Street:"),c);
		field4 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 1;
		p.add(field4,c);
		this.fields.add(field4);

		c.gridx = 0;
		c.gridy = 2;
		p.add(new JLabel("City:"),c);
		field5 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 2;
		p.add(field5,c);
		this.fields.add(field5);

		c.gridx = 2;
		c.gridy = 2;
		p.add(new JLabel("State:"),c);
		c.gridx = 3;
		c.gridy = 2;
		combo3 = new JComboBox(STATES);
		p.add(combo3,c);



		c.gridx = 0;
		c.gridy = 3;
		p.add(new JLabel("Zip:"),c);
		field7 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 3;
		p.add(field7,c);
		this.fields.add(field7);

		c.gridx = 2;
		c.gridy = 3;
		p.add(new JLabel("Race:"),c);
		field8 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 3;
		p.add(field8,c);
		this.fields.add(field8);

		c.gridx = 0;
		c.gridy = 4;
		p.add(new JLabel("Email:"),c);
		field9 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 4;
		p.add(field9,c);
		this.fields.add(field9);



		c.gridx = 2;
		c.gridy = 4;
		p.add(new JLabel("Phone:"),c);
		field10 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 4;
		p.add(field10,c);
		this.fields.add(field10);


		c.gridx = 0;
		c.gridy = 5;
		p.add(new JLabel(" Profession:"),c);
		field11 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 5;
		p.add(field11,c);
		this.fields.add(field11);


		c.gridx = 2;
		c.gridy = 5;
		p.add(new JLabel("Gender:"),c);
		combo1 = new JComboBox(GENDER);
		c.gridx = 3;
		c.gridy = 5;
		p.add(combo1,c);

		c.gridx = 0;
		c.gridy = 6;
		p.add(new JLabel("Mailing List:"),c);
		combo2 = new JComboBox(MAIL_LIST);
		c.gridx = 1;
		c.gridy = 6;
		p.add(combo2,c);

		c.gridx = 2;
		c.gridy = 6;
		p.add(new JLabel("Doctor Name:"),c);
		field12 = new JTextField(10);
		c.gridx = 3;
		c.gridy = 6;
		p.add(field12,c);
		this.fields.add(field12);

		c.gridx = 0;
		c.gridy = 7;
		p.add(new JLabel("Doctor Phone:"),c);
		field13 = new JTextField(10);
		c.gridx = 1;
		c.gridy = 7;
		p.add(field13,c);
		this.fields.add(field13);

		c.gridx = 2;
		c.gridy = 7;
		p.add(new JLabel("Attorney Name:"),c);
		field14 = new JTextField(10);
		c.gridx = 3;
		c.gridy = 7;
		p.add(field14,c);
		this.fields.add(field14);

		c.gridx = 0;
		c.gridy = 8;
		p.add(new JLabel("Attorney Phone:"),c);
		field15 = new JTextField(10);
		c.gridx = 1;
		c.gridy = 8;
		p.add(field15,c);
		this.fields.add(field15);

		c.gridx = 2;
		c.gridy = 8;
		p.add(new JLabel("Date Assigned:"),c);
		field16 = new JTextField(10);
		c.gridx = 3;
		c.gridy = 8;
		p.add(field16,c);
		this.fields.add(field16);



		c.gridx = 0;
		c.gridy = 9;
		p.add(new JLabel("Teams:"),c);
		list = new JList(mod.get_teams());
		c.gridx = 1;
		c.gridy = 9;
		p.add(list,c);

		c.gridx = 2;
		c.gridy = 9;
		p.add(new JLabel("Active:"),c);
		ckbox = new JCheckBox();
		p.add(ckbox);
		c.gridx = 3;
		c.gridy = 9;
		p.add(ckbox,c);		

		c.gridx = 0;
		c.gridy = 10;
		p.add(new JLabel("DOB:"),c);
		field17 = new JTextField(10);
		c.gridx = 1;
		c.gridy = 10;
		p.add(field17,c);
		this.fields.add(6,field17);


		c.gridx = 3;
		c.gridy = 10;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);



	}

	public void selection3(){


		//enter new volunteer and assoc with one or more teams
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();


		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("SSN:"),c);
		field1 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		p.add(field1,c);
		this.fields.add(field1);


		c.gridx = 2;
		c.gridy = 0;
		p.add(new JLabel("Name:"),c);
		field2 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 0;
		p.add(field2,c);
		this.fields.add(field2);

		c.gridx = 0;
		c.gridy = 1;
		p.add(new JLabel("Street Number:"),c);
		field3 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 1;
		p.add(field3,c);
		this.fields.add(field3);


		c.gridx = 2;
		c.gridy = 1;
		p.add(new JLabel("Street:"),c);
		field4 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 1;
		p.add(field4,c);
		this.fields.add(field4);

		c.gridx = 0;
		c.gridy = 2;
		p.add(new JLabel("City:"),c);
		field5 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 2;
		p.add(field5,c);
		this.fields.add(field5);

		c.gridx = 2;
		c.gridy = 2;
		p.add(new JLabel("State:"),c);
		c.gridx = 3;
		c.gridy = 2;
		field6 =  new JTextField(10);
		p.add(field6,c);
		this.fields.add(field6);


		c.gridx = 0;
		c.gridy = 3;
		p.add(new JLabel("Zip:"),c);
		field7 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 3;
		p.add(field7,c);
		this.fields.add(field7);

		c.gridx = 2;
		c.gridy = 3;
		p.add(new JLabel("DOB:"),c);
		field8 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 3;
		p.add(field8,c);
		this.fields.add(field8);

		c.gridx = 0;
		c.gridy = 4;
		p.add(new JLabel("Race:"),c);
		field9 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 4;
		p.add(field9,c);
		this.fields.add(field9);



		c.gridx = 2;
		c.gridy = 4;
		p.add(new JLabel("Email:"),c);
		field10 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 4;
		p.add(field10,c);
		this.fields.add(field10);


		c.gridx = 0;
		c.gridy = 5;
		p.add(new JLabel("Phone:"),c);
		field11 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 5;
		p.add(field11,c);
		this.fields.add(field11);


		c.gridx = 2;
		c.gridy = 5;
		p.add(new JLabel("Gender:"),c);
		combo1 = new JComboBox(GENDER);
		c.gridx = 3;
		c.gridy = 5;
		p.add(combo1,c);

		c.gridx = 0;
		c.gridy = 6;
		p.add(new JLabel("Mailing List:"),c);
		combo2 = new JComboBox(MAIL_LIST);
		c.gridx = 1;
		c.gridy = 6;
		p.add(combo2,c);

		c.gridx = 2;
		c.gridy = 6;
		p.add(new JLabel("Profession:"),c);
		field12 = new JTextField(10);
		c.gridx = 3;
		c.gridy = 6;
		p.add(field12,c);
		this.fields.add(field12);

		c.gridx = 0;
		c.gridy = 7;
		p.add(new JLabel("Date Joined:"),c);
		field13 = new JTextField(10);
		c.gridx = 1;
		c.gridy = 7;
		p.add(field13,c);
		this.fields.add(field13);

		c.gridx = 2;
		c.gridy = 7;
		p.add(new JLabel("Training Date:"),c);
		field14 = new JTextField(10);
		c.gridx = 3;
		c.gridy = 7;
		p.add(field14,c);
		this.fields.add(field14);

		c.gridx = 0;
		c.gridy = 8;
		p.add(new JLabel("Training Loc:"),c);
		field15 = new JTextField(10);
		c.gridx = 1;
		c.gridy = 8;
		p.add(field15,c);
		this.fields.add(field15);


		c.gridx = 0;
		c.gridy = 9;
		p.add(new JLabel("Teams:"),c);
		list = new JList(mod.get_teams());
		c.gridx = 1;
		c.gridy = 9;
		p.add(list,c);



		c.gridx = 3;
		c.gridy = 10;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);


	}

	public void selection4(){
		//enter number of hours volunteer worked for this month for particular team
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("SSN:"),c);
		field1 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		p.add(field1,c);

		c.gridx = 2;
		c.gridy = 0;
		p.add(new JLabel("Hours Worked:"),c);
		field2 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 0;
		p.add(field2,c);

		c.gridx = 0;
		c.gridy = 1;
		p.add(new JLabel("Month:"),c);
		combo1 = new JComboBox(MONTHS);
		c.gridx = 1;
		c.gridy = 1;
		p.add(combo1,c);

		c.gridx = 0;
		c.gridy = 2;
		p.add(new JLabel("Teams:"),c);
		list = new JList(mod.get_teams());
		c.gridx = 1;
		c.gridy = 2;
		p.add(list,c);

		c.gridx = 3;
		c.gridy = 2;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);


	}

	public void selection5(){


		// Enter new Employee and assoc with one or more teams
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();


		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("SSN:"),c);
		field1 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		p.add(field1,c);
		this.fields.add(field1);


		c.gridx = 2;
		c.gridy = 0;
		p.add(new JLabel("Name:"),c);
		field2 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 0;
		p.add(field2,c);
		this.fields.add(field2);

		c.gridx = 0;
		c.gridy = 1;
		p.add(new JLabel("Street Number:"),c);
		field3 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 1;
		p.add(field3,c);
		this.fields.add(field3);


		c.gridx = 2;
		c.gridy = 1;
		p.add(new JLabel("Street:"),c);
		field4 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 1;
		p.add(field4,c);
		this.fields.add(field4);

		c.gridx = 0;
		c.gridy = 2;
		p.add(new JLabel("City:"),c);
		field5 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 2;
		p.add(field5,c);
		this.fields.add(field5);

		c.gridx = 2;
		c.gridy = 2;
		p.add(new JLabel("State:"),c);
		c.gridx = 3;
		c.gridy = 2;
		field6 =  new JTextField(10);
		p.add(field6,c);
		this.fields.add(field6);


		c.gridx = 0;
		c.gridy = 3;
		p.add(new JLabel("Zip:"),c);
		field7 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 3;
		p.add(field7,c);
		this.fields.add(field7);

		c.gridx = 2;
		c.gridy = 3;
		p.add(new JLabel("DOB:"),c);
		field8 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 3;
		p.add(field8,c);
		this.fields.add(field8);

		c.gridx = 0;
		c.gridy = 4;
		p.add(new JLabel("Race:"),c);
		field9 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 4;
		p.add(field9,c);
		this.fields.add(field9);



		c.gridx = 2;
		c.gridy = 4;
		p.add(new JLabel("Email:"),c);
		field10 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 4;
		p.add(field10,c);
		this.fields.add(field10);


		c.gridx = 0;
		c.gridy = 5;
		p.add(new JLabel("Phone:"),c);
		field11 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 5;
		p.add(field11,c);
		this.fields.add(field11);


		c.gridx = 2;
		c.gridy = 5;
		p.add(new JLabel("Gender:"),c);
		combo1 = new JComboBox(GENDER);
		c.gridx = 3;
		c.gridy = 5;
		p.add(combo1,c);

		c.gridx = 0;
		c.gridy = 6;
		p.add(new JLabel("Mailing List:"),c);
		combo2 = new JComboBox(MAIL_LIST);
		c.gridx = 1;
		c.gridy = 6;
		p.add(combo2,c);

		c.gridx = 2;
		c.gridy = 6;
		p.add(new JLabel("Profession:"),c);
		field12 = new JTextField(10);
		c.gridx = 3;
		c.gridy = 6;
		p.add(field12,c);
		this.fields.add(field12);

		c.gridx = 0;
		c.gridy = 7;
		p.add(new JLabel("Marital Status:"),c);
		field13 = new JTextField(10);
		c.gridx = 1;
		c.gridy = 7;
		p.add(field13,c);
		this.fields.add(field13);

		c.gridx = 2;
		c.gridy = 7;
		p.add(new JLabel("Hire Date:"),c);
		field14 = new JTextField(10);
		c.gridx = 3;
		c.gridy = 7;
		p.add(field14,c);
		this.fields.add(field14);

		c.gridx = 0;
		c.gridy = 8;
		p.add(new JLabel("Salary:"),c);
		field15 = new JTextField(10);
		c.gridx = 1;
		c.gridy = 8;
		p.add(field15,c);
		this.fields.add(field15);


		c.gridx = 0;
		c.gridy = 9;
		p.add(new JLabel("Teams:"),c);
		list = new JList(mod.get_teams());
		c.gridx = 1;
		c.gridy = 9;
		p.add(list,c);



		c.gridx = 3;
		c.gridy = 10;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);
	}
	public void selection6(){

		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();



		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("SSN:"),c);
		field1 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		p.add(field1,c);

		c.gridx = 2;
		c.gridy = 0;
		p.add(new JLabel("Date:"),c);
		field2 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		p.add(field2,c);

		c.gridx = 0;
		c.gridy = 1;
		p.add(new JLabel("Amount:"),c);
		field3 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		p.add(field3,c);

		c.gridx = 2;
		c.gridy = 1;
		p.add(new JLabel("Description:"),c);
		field4 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 1;
		p.add(field4,c);

		c.gridx = 3;
		c.gridy = 4;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);

	}


	public void selection7(){	

		//Enter new organization and select team(s) to work with
		this.p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		this.p.setLayout(new GridBagLayout());
		this.c = new GridBagConstraints();

		this.c.gridx = 0;
		this.c.gridy = 0;
		this.p.add(new JLabel("Org Name:"),c);
		this.field1 =  new JTextField(10);
		this.c.fill = GridBagConstraints.HORIZONTAL;
		this.c.gridx = 1;
		this.c.gridy = 0;
		this.p.add(field1,c);


		this.c.gridx = 2;
		this.c.gridy = 0;
		this.p.add(new JLabel("Type:"),c);
		this.org_box = new JComboBox(ORGS);
		this.org_box.addActionListener(this);
		this.c.gridx = 3;
		this.c.gridy = 0;
		this.p.add(org_box,c);

		this.c.gridx = 0;
		this.c.gridy = 1;
		this.p.add(new JLabel("Street Number:"),c);
		this.field2 =  new JTextField(10);
		this.c.gridx = 1;
		this.c.gridy = 1;
		this.p.add(field2,c);

		this.c.gridx = 2;
		this.c.gridy = 1;
		this.p.add(new JLabel("Street:"),c);
		this.field3 =  new JTextField(10);
		this.c.gridx = 3;
		this.c.gridy = 1;
		this.p.add(field3,c);

		this.c.gridx = 0;
		this.c.gridy = 2;
		this.p.add(new JLabel("City:"),c);
		this.field4 =  new JTextField(10);
		this.c.gridx = 1;
		this.c.gridy = 2;
		this.p.add(field4,c);

		this.c.gridx = 2;
		this.c.gridy = 2;
		this.p.add(new JLabel("State:"),c);
		this.c.gridx = 3;
		this.c.gridy = 2;
		this.combo1 =  new JComboBox(STATES);
		this.p.add(combo1,c);

		this.c.gridx = 0;
		this.c.gridy = 3;
		this.p.add(new JLabel("Zip:"),c);
		this.field5 =  new JTextField(10);
		this.c.gridx = 1;
		this.c.gridy = 3;
		this.p.add(field5,c);

		this.c.gridx = 2;
		this.c.gridy = 3;
		this.p.add(new JLabel("Phone:"),c);
		this.field6 =  new JTextField(10);
		this.c.gridx = 3;
		this.c.gridy = 3;
		this.p.add(field6,c);

		this.c.gridx = 0;
		this.c.gridy = 4;
		this.p.add(new JLabel("Contact:"),c);
		this.field7 =  new JTextField(10);
		this.c.gridx = 1;
		this.c.gridy = 4;
		this.p.add(field7,c);


		//add the teams to the list
		String[] teams = mod.get_teams();
		this.c.gridx = 0;
		this.c.gridy = 9;
		this.p.add(new JLabel("Teams:"),c);
		this.list = new JList(teams);
		this.c.gridx = 1;
		this.c.gridy = 9;
		this.p.add(list,c);
		this.c.gridx = 3;
		this.c.gridy = 9;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);
	}

	public void selection8(){


		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();


		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("SSN:"),c);
		field1 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		p.add(field1,c);
		this.fields.add(field1);


		c.gridx = 2;
		c.gridy = 0;
		p.add(new JLabel("Name:"),c);
		field2 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 0;
		p.add(field2,c);
		this.fields.add(field2);

		c.gridx = 0;
		c.gridy = 1;
		p.add(new JLabel("Street Number:"),c);
		field3 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 1;
		p.add(field3,c);
		this.fields.add(field3);


		c.gridx = 2;
		c.gridy = 1;
		p.add(new JLabel("Street:"),c);
		field4 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 1;
		p.add(field4,c);
		this.fields.add(field4);

		c.gridx = 0;
		c.gridy = 2;
		p.add(new JLabel("City:"),c);
		field5 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 2;
		p.add(field5,c);
		this.fields.add(field5);

		c.gridx = 2;
		c.gridy = 2;
		p.add(new JLabel("State:"),c);
		c.gridx = 3;
		c.gridy = 2;
		field6 =  new JTextField(10);
		p.add(field6,c);
		this.fields.add(field6);


		c.gridx = 0;
		c.gridy = 3;
		p.add(new JLabel("Zip:"),c);
		field7 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 3;
		p.add(field7,c);
		this.fields.add(field7);

		c.gridx = 2;
		c.gridy = 3;
		p.add(new JLabel("DOB:"),c);
		field8 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 3;
		p.add(field8,c);
		this.fields.add(field8);

		c.gridx = 0;
		c.gridy = 4;
		p.add(new JLabel("Race:"),c);
		field9 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 4;
		p.add(field9,c);
		this.fields.add(field9);



		c.gridx = 2;
		c.gridy = 4;
		p.add(new JLabel("Email:"),c);
		field10 =  new JTextField(10);
		c.gridx = 3;
		c.gridy = 4;
		p.add(field10,c);
		this.fields.add(field10);


		c.gridx = 0;
		c.gridy = 5;
		p.add(new JLabel("Phone:"),c);
		field11 =  new JTextField(10);
		c.gridx = 1;
		c.gridy = 5;
		p.add(field11,c);
		this.fields.add(field11);


		c.gridx = 2;
		c.gridy = 5;
		p.add(new JLabel("Gender:"),c);
		combo1 = new JComboBox(GENDER);
		c.gridx = 3;
		c.gridy = 5;
		p.add(combo1,c);

		c.gridx = 0;
		c.gridy = 6;
		p.add(new JLabel("Mailing List:"),c);
		combo2 = new JComboBox(MAIL_LIST);
		c.gridx = 1;
		c.gridy = 6;
		p.add(combo2,c);

		c.gridx = 2;
		c.gridy = 6;
		p.add(new JLabel("Profession:"),c);
		field12 = new JTextField(10);
		c.gridx = 3;
		c.gridy = 6;
		p.add(field12,c);
		this.fields.add(field12);




		c.gridx = 0;
		c.gridy = 7;
		p.add(new JLabel("Donations:"),c);
		list = new JList(mod.get_donations());
		c.gridx = 1;
		c.gridy = 7;
		p.add(list,c);

		c.gridx = 2;
		c.gridy = 7;
		p.add(new JLabel("Anonymous:"),c);
		ckbox = new JCheckBox();
		c.gridx = 3;
		c.gridy = 7;
		p.add(ckbox,c);



		c.gridx = 3;
		c.gridy = 10;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);




	}

	public void selection9(){

		//Enter new organization and select team(s) to work with
		this.p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		this.p.setLayout(new GridBagLayout());
		this.c = new GridBagConstraints();

		this.c.gridx = 0;
		this.c.gridy = 0;
		this.p.add(new JLabel("Org Name:"),c);
		this.field1 =  new JTextField(10);
		this.c.fill = GridBagConstraints.HORIZONTAL;
		this.c.gridx = 1;
		this.c.gridy = 0;
		this.p.add(field1,c);


		this.c.gridx = 2;
		this.c.gridy = 0;
		this.p.add(new JLabel("Type:"),c);
		this.org_box = new JComboBox(ORGS);
		this.org_box.addActionListener(this);
		this.c.gridx = 3;
		this.c.gridy = 0;
		this.p.add(org_box,c);

		this.c.gridx = 0;
		this.c.gridy = 1;
		this.p.add(new JLabel("Street Number:"),c);
		this.field2 =  new JTextField(10);
		this.c.gridx = 1;
		this.c.gridy = 1;
		this.p.add(field2,c);

		this.c.gridx = 2;
		this.c.gridy = 1;
		this.p.add(new JLabel("Street:"),c);
		this.field3 =  new JTextField(10);
		this.c.gridx = 3;
		this.c.gridy = 1;
		this.p.add(field3,c);

		this.c.gridx = 0;
		this.c.gridy = 2;
		this.p.add(new JLabel("City:"),c);
		this.field4 =  new JTextField(10);
		this.c.gridx = 1;
		this.c.gridy = 2;
		this.p.add(field4,c);

		this.c.gridx = 2;
		this.c.gridy = 2;
		this.p.add(new JLabel("State:"),c);
		this.c.gridx = 3;
		this.c.gridy = 2;
		this.combo1 =  new JComboBox(STATES);
		this.p.add(combo1,c);

		this.c.gridx = 0;
		this.c.gridy = 3;
		this.p.add(new JLabel("Zip:"),c);
		this.field5 =  new JTextField(10);
		this.c.gridx = 1;
		this.c.gridy = 3;
		this.p.add(field5,c);

		this.c.gridx = 2;
		this.c.gridy = 3;
		this.p.add(new JLabel("Phone:"),c);
		this.field6 =  new JTextField(10);
		this.c.gridx = 3;
		this.c.gridy = 3;
		this.p.add(field6,c);

		this.c.gridx = 0;
		this.c.gridy = 4;
		this.p.add(new JLabel("Contact:"),c);
		this.field7 =  new JTextField(10);
		this.c.gridx = 1;
		this.c.gridy = 4;
		this.p.add(field7,c);



		c.gridx = 0;
		c.gridy = 7;
		p.add(new JLabel("Donations:"),c);
		list = new JList(mod.get_donations());
		c.gridx = 1;
		c.gridy = 7;
		p.add(list,c);

		c.gridx = 2;
		c.gridy = 7;
		p.add(new JLabel("Anonymous:"),c);
		ckbox = new JCheckBox();
		c.gridx = 3;
		c.gridy = 7;
		p.add(ckbox,c);



		c.gridx = 3;
		c.gridy = 10;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);


	}
	public void selection10()
	{
		// Retrieve name and phone of doc with particular client

		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();


		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("SSN:"),c);
		field1 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		p.add(field1,c);
		fields.add(field1);

		c.gridx = 3;
		c.gridy = 1;
		this.button = new JButton("Submit");
		this.button.addActionListener(this);
		p.add(this.button,c);





	}
	public void selection11(){
		//retrieve total amt of expenses charged by each employee for a particular period of time
		//sorted by total amt of expenses
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("From Date:"),c);
		this.field1 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		p.add(this.field1,c);
		c.gridx = 2;
		c.gridy = 0;
		p.add(new JLabel("To Date:"),c);
		this.field2 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		p.add(this.field2,c);
		c.gridx = 3;
		c.gridy = 1;
		this.button = new JButton("Submit");
		this.button.addActionListener(this);
		p.add(this.button,c);

	}
	public void selection12(){
		//retrieve list of volunteers thaht are members of teams that usupport a particular client
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("Client SSN:"),c);
		field1 =  new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		p.add(field1,c);

		c.gridx = 3;
		c.gridy = 1;
		this.button = new JButton("Submit");
		this.button.addActionListener(this);
		p.add(this.button,c);



	}
	public void selection13(){
		//retrieve names and contact info of clients that are supported by 
		//an org whose name starts between b and k
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("Press Submit to Execute Query"),c);

		c.gridx = 3;
		c.gridy = 1;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);

	}
	public void selection14(){
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("Please hit Submit to execute Query"),c);


		c.gridx = 3;
		c.gridy = 1;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);


	}
	public void selection15(){
		// for each team retrieve name and associated contact info of 
		//volunteers that has worked the most total hours between march and june
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("Please hit Submit to retrive volunteers"),c);


		c.gridx = 3;
		c.gridy = 1;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);

	}
	public void selection16(){
		//increase by 10% of all employees to whom more than one team must report
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("Hit submit to increase salary of employees who work with more than 1 team"),c);




		c.gridx = 3;
		c.gridy = 1;
		this.button = new JButton("Submit");
		this.button.addActionListener(this);
		p.add(this.button,c);
	}
	public void selection17(){
		//delete all clients who do not have health insurance and whose
		//value for transporatation is less than 5
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("Delete all clients who do not have health in surance adn value for trans is < 5"),c);


		c.gridx = 3;
		c.gridy = 1;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);


	}
	public void selection18(){
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("Enter File Name"),c);
		c.gridx = 1;
		c.gridy = 0;
		field1 = new JTextField(10);
		p.add(field1,c);
		c.gridx = 3;
		c.gridy = 1;
		this.button = new JButton("Submit");
		this.button.addActionListener(this);
		p.add(this.button,c);


	}
	public void selection19(){
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("Enter File Name"),c);
		c.gridx = 2;
		c.gridy = 2;
		field1 = new JTextField(10);
		p.add(field1,c);
		c.gridx = 3;
		c.gridy = 1;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);


	}
	public void selection20(){
		p = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(p,BorderLayout.NORTH);
		p.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p.add(new JLabel("Enter Query"),c);
		c.gridx = 2;
		c.gridy = 2;
		field1 = new JTextField(20);
		p.add(field1,c);
		c.gridx = 3;
		c.gridy = 1;
		button = new JButton("Submit");
		button.addActionListener(this);
		p.add(button,c);


	}


	public HashMap<String, String> data_for_input()
	{
		// Puts all of our text values nicely into a Hash Map so that I will not
		// Confuse myself when putting them into the model :P
		vals = new HashMap<String,String>();
		if (this.choice ==1)
		{
			vals.put("NAME", field1.getText());
			vals.put("Type", field2.getText());
			vals.put("DATE", field3.getText());	
		}
		else if (this.choice ==2)
		{
			vals.put("SSN", field1.getText());
			vals.put("NAME", field2.getText());
			vals.put("STR NUM", field3.getText());
			vals.put("STREET", field4.getText());
			vals.put("CITY", field5.getText());
			vals.put("STATE", (String) combo3.getSelectedItem());
			vals.put("ZIP", field7.getText());
			vals.put("DOB", field17.getText());
			vals.put("RACE", field8.getText());
			vals.put("EMAIL", field9.getText());
			vals.put("PHONE", field10.getText());
			vals.put("MAILING", (String) combo2.getSelectedItem());
			vals.put("PROFESSION", field11.getText());
			vals.put("GENDER", (String) combo1.getSelectedItem());
			vals.put("DATE ASSIGN", field16.getText());
			vals.put("DOC NAME", field12.getText());
			vals.put("DOC PHONE", field13.getText());
			vals.put("LAW NAME", field14.getText());
			vals.put("LAW PHONE", field15.getText());
			if (ckbox.isEnabled()){
				vals.put("ACTIVE", "T");

			}
			else
			{
				vals.put("ACTIVE", "F");
			}			
		}
		else if (this.choice == 3)
		{
			vals.put("SSN", field1.getText());
			vals.put("NAME", field2.getText());
			vals.put("STR NUM", field3.getText());
			vals.put("STREET", field4.getText());
			vals.put("CITY", field5.getText());
			vals.put("STATE", field6.getText());
			vals.put("ZIP", field7.getText());
			vals.put("DOB", field8.getText());
			vals.put("RACE", field9.getText());
			vals.put("EMAIL", field10.getText());
			vals.put("PHONE", field11.getText());
			vals.put("MAILING", (String) combo2.getSelectedItem());
			vals.put("PROFESSION", field12.getText());
			vals.put("GENDER", (String) combo1.getSelectedItem());
			vals.put("DATE JOINED", field13.getText());
			vals.put("TRAIN DATE", field14.getText());
			vals.put("TRAIN LOC", field15.getText());
		}
		else if (this.choice == 4)
		{
			vals.put("SSN",field1.getText());
			vals.put("HOURS WORKED", field2.getText() );
			vals.put("MONTH", String.format("%d",combo1.getSelectedIndex()+1));

		}
		else if (this.choice == 5)
		{
			vals.put("SSN", field1.getText());
			vals.put("NAME", field2.getText());
			vals.put("STR NUM", field3.getText());
			vals.put("STREET", field4.getText());
			vals.put("CITY", field5.getText());
			vals.put("STATE", field6.getText());
			vals.put("ZIP", field7.getText());
			vals.put("DOB", field8.getText());
			vals.put("RACE", field9.getText());
			vals.put("EMAIL", field10.getText());
			vals.put("PHONE", field11.getText());
			vals.put("MAILING", (String) combo2.getSelectedItem());
			vals.put("PROFESSION", field12.getText());
			vals.put("GENDER", (String) combo1.getSelectedItem());
			vals.put("MARITAL", field13.getText());
			vals.put("HIRE DATE", field14.getText());
			vals.put("SALARY", field15.getText());
		}
		else if (this.choice == 6)
		{
			vals.put("SSN", field1.getText());
			vals.put("DATE", field2.getText());
			vals.put("AMOUNT", field3.getText());
			vals.put("DESCRIPTION", field4.getText());

		}
		else if (this.choice == 7)
		{
			vals.put("NAME", field1.getText());
			vals.put("TYPE", (String) this.org_box.getSelectedItem());
			vals.put("STR NUM", field2.getText());
			vals.put("STREET", field3.getText());
			vals.put("CITY", field4.getText());
			vals.put("STATE", (String) combo1.getSelectedItem());
			vals.put("ZIP", field5.getText());
			vals.put("PHONE",field6.getText());
			vals.put("CONTACT",field7.getText());
			if (vals.get("TYPE") == "Business"){
				vals.put("SIZE", field10.getText());
				vals.put("BTYPE",field11.getText());
				vals.put("WEB", field12.getText());
			}
			else{
				vals.put("AFFIL", field10.getText());
			}

		}
		else if(this.choice == 8)
		{
			vals.put("SSN", field1.getText());
			vals.put("NAME", field2.getText());
			vals.put("STR NUM", field3.getText());
			vals.put("STREET", field4.getText());
			vals.put("CITY", field5.getText());
			vals.put("STATE", field6.getText());
			vals.put("ZIP", field7.getText());
			vals.put("DOB", field8.getText());
			vals.put("RACE", field9.getText());
			vals.put("EMAIL", field10.getText());
			vals.put("PHONE", field11.getText());
			vals.put("MAILING", (String) combo2.getSelectedItem());
			vals.put("PROFESSION", field12.getText());
			vals.put("GENDER", (String) combo1.getSelectedItem());
			if (ckbox.isEnabled()){
				vals.put("ANON", "T");

			}
			else
			{
				vals.put("ANON", "F");
			}			
		}
		else if (this.choice == 9)
		{
			vals.put("NAME", field1.getText());
			vals.put("TYPE", (String) this.org_box.getSelectedItem());
			vals.put("STR NUM", field2.getText());
			vals.put("STREET", field3.getText());
			vals.put("CITY", field4.getText());
			vals.put("STATE", (String) combo1.getSelectedItem());
			vals.put("ZIP", field5.getText());
			vals.put("PHONE",field6.getText());
			vals.put("CONTACT",field7.getText());
			if (vals.get("TYPE") == "Business"){
				vals.put("SIZE", field10.getText());
				vals.put("BTYPE",field11.getText());
				vals.put("WEB", field12.getText());
			}
			else if (vals.get("TYPE") =="Church"){
				vals.put("AFFIL", field10.getText());
			}
			if (ckbox.isEnabled()){
				vals.put("ANON", "T");

			}
			else
			{
				vals.put("ANON", "F");
			}			
		}
		else if (this.choice == 10)
		{
			vals.put("SSN", field1.getText());
		}
		else if (this.choice == 11)
		{
			vals.put("FROM", field1.getText());
			vals.put("TO", field2.getText());
		}
		else if (this.choice == 12)
		{
			vals.put("SSN",field1.getText());
		}
		else{
			return null;
		}

		return vals;
	}


	public ArrayList<String> get_teams()
	{
		// When we have a list of teams return them appropriately to model
		ArrayList<String> t_teams = (ArrayList<String>) this.list.getSelectedValuesList();

		return t_teams;
	}	

	public ArrayList<String> get_donations(){
		ArrayList<String> dons = (ArrayList<String>) this.list.getSelectedValuesList();

		return dons;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		//Performs all the actions ew need after the button is pressed
		if (evt.getSource() ==button){
			System.out.println(choice);
			switch(this.choice)
			{

			case 1:		mod.selection1(this.data_for_input());
			break;
			case 2:		mod.selection2(this.data_for_input(),this.get_teams());
			break;
			case 3:		mod.selection3(this.data_for_input(),this.get_teams());
			break;
			case 4:		mod.selection4(this.data_for_input(),this.get_teams());
			break;
			case 5:		mod.selection5(this.data_for_input(),this.get_teams());
			break;
			case 6:		mod.selection6(this.data_for_input());
			break;
			case 7:		mod.selection7(this.data_for_input(),this.get_teams());
			break;
			case 8:		mod.selection8(this.data_for_input(),this.get_donations());
			break;
			case 9:		mod.selection9(this.data_for_input(),this.get_donations());
			break;
			case 10:		mod.selection10(this.data_for_input());
			break;
			case 11:	
				mod.selection11(this.data_for_input());
				break;
			case 12:	    mod.selection12(this.data_for_input());
			break;
			case 13:     mod.selection13();
			break;
			case 14:     mod.selection14();
			break;
			case 15:     mod.selection15();
			break;

			case 16:	mod.selection16();
			break;
			case 17:     mod.selection17();
			break;
			case 20: mod.any_query(this.field1.getText());
			break;
			case 18: 	try {
				mod.writeCsv(this.field1.getText());
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			case 19: 	try {
				mod.readCsv(this.field1.getText());
			} catch (IOException e) {

				e.printStackTrace();
			}
			break;
			}
		}
		else if (evt.getSource() == org_box){
			System.out.println("Here");
			if(org_box.getSelectedItem()== "Business"){

				// Draw the stuff needed for a business dynamically add for either business or church
				this.c.gridx = 0;
				this.c.gridy = 5;
				this.p.add(new JLabel("Business Size:"),c);
				this.c.gridx = 1;
				this.c.gridy = 5;
				this.field10 = new JTextField(10);
				this.p.add(field10,c);
				this.c.gridx = 2;
				this.c.gridy = 5;
				this.p.add(new JLabel("Business Type:"),c);
				this.c.gridx = 3;
				this.c.gridy = 5;
				this.field11 = new JTextField(10);
				this.p.add(field11,c);
				this.c.gridx = 0;
				this.c.gridy = 6;
				this.p.add(new JLabel("Website:"),c);
				this.c.gridx = 1;
				this.c.gridy = 6;
				this.field12 = new JTextField(10);
				this.p.add(field12,c);
				this.validate();
				this.repaint();

			}
			else if (org_box.getSelectedItem() =="Church"){
				// Add required fields dynamically for church
				c.gridx = 0;
				c.gridy = 5;
				this.p.add(new JLabel("Relig Affil:"),c);
				c.gridx = 1;
				c.gridy = 5;
				field10 = new JTextField(10);
				this.p.add(field10,c);
				this.validate();
				this.repaint();
			}	
		}
	}
}