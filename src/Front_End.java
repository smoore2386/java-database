/*
 * Shane Moore 
 * 
 * Front end describes the gui that we made for this part of the
 * project, nothing too fancy here just some frames action listeners
 * doing what they need to do
 * 
 * 
 * 
 */


// standard library Imports for this
import javax.swing.*; 
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Front_End extends JFrame implements ActionListener {
 
	private static final long serialVersionUID = 1L;

	// Define Selections and Descriptions
	private static final String[] SELECTIONS = {"1","2","3","4","5","6","7","8", "9",
												"10","11","12","13","14","15","16","17","20"};	
	
	private static final String[] DESCRIPTIONS = {
			"Enter a new team into the database",
			"Enter a new client into the database and associate him or her with one or more teams",
			"Enter a new volunteer into the database and associate him or her with one or more teams",
			"Enter the number of hours a volunteer worked this month for a particular team",
			"Enter a new employee into the database and associate him or her with one or more teams",
			"Enter an expense charged by an employee",
			"Enter a new organization and associate it to one or more PAN teams",
			"Enter a new donor and associate him or her with several donations",
			"Enter a new organization and associate it with several donations",
			"Retrieve the name and phone number of the doctor of a particular client ",
			"Retrieve the total amount of expenses charged by each employee for a particular period of time",
			"Retrieve the list of volunteers that are members of teams that support a particular client",
			"Retrieve the names and contact information of the clients that are supported by teams sponsored by",
			"Retrieve the name and total amount donated by donors that are also employees.  The list should be",
			"For each team, retrieve the name and associated contact information of the volunteer that has worked",
			"Increase the salary by 10% of all employees to whom more than one team must report.",
			"Delete all clients who do not have health insurance and whose value of importance for transportation",
			"Execute Any Query you want"
			};

	// Initial Front screen creation
	private JComboBox combo_box; 
	private JButton button;
	private JLabel lbl;
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem imp;
	private JMenuItem exp;
	private JMenuItem quit;
	private JPanel p;
	private JPanel p2;
	private GridBagConstraints c;
	
	
	public Front_End() {
		
		p = new JPanel();
		p2 = new JPanel();
		this.setLayout(new BorderLayout());
		p.setLayout(new GridBagLayout());
		p2.setLayout(new GridBagLayout());
		
		c = new GridBagConstraints();

		//##################################################
		//########       Menu bar creation   ###############
		//##################################################
		this.menubar = new JMenuBar();
		this.menu = new JMenu("File");
		this.imp = new JMenuItem("Import");
		this.imp.addActionListener(this);
		this.exp = new JMenuItem("Export");
		this.exp.addActionListener(this);
		this.quit = new JMenuItem("Quit");
		this.quit.setAccelerator(KeyStroke.getKeyStroke("control + q"));
		this.quit.addActionListener(this);
		this.menu.add(imp);
		this.menu.add(exp);
		this.menu.add(quit);
		this.menubar.add(menu); 
		this.setJMenuBar(menubar);
		
		
		this.button = new JButton("Select");
		this.combo_box = new JComboBox(SELECTIONS);
		this.combo_box.addActionListener(this);
		c.gridx = 0;
		c.gridy = 0;
		p.add(combo_box,c);
		c.gridx = 1;
		c.gridy = 0;
		p.add(button,c);
		
		// Dynamic Lable creation
		this.lbl = new JLabel(DESCRIPTIONS[0]);
		c.gridx = 1;
		c.gridy = 4;
		p2.add(lbl,c);
		this.add(p,BorderLayout.NORTH);
		this.add(p2,BorderLayout.CENTER);
		this.button.addActionListener(this);
		this.quit.setAccelerator(KeyStroke.getKeyStroke("control + q"));	
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if (evt.getSource() == button){
				// Have a Selection perform accordingly
				Option opt = new Option(this,Integer.parseInt((String) this.combo_box.getSelectedItem()));
			    try {
			        UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
			    } catch (Exception e) { }
				opt.setTitle(String.format("Option %s", this.combo_box.getSelectedItem()));
				opt.setSize(500,500);
				opt.setLocationRelativeTo(null);
				opt.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				opt.setVisible(true);
		}
		else if(evt.getSource() == combo_box){	
			//  Update JLabel for whatever selection person is choosing
			switch(Integer.parseInt((String) combo_box.getSelectedItem())){
			
				case 1:		lbl.setText(DESCRIPTIONS[0]);
							break;
				case 2:		lbl.setText(DESCRIPTIONS[1]);
							break;
				case 3:		lbl.setText(DESCRIPTIONS[2]);
							break;
				case 4:		lbl.setText(DESCRIPTIONS[3]);
							break;
				case 5:		lbl.setText(DESCRIPTIONS[4]);
							break;
				case 6:		lbl.setText(DESCRIPTIONS[5]);
							break;
				case 7:		lbl.setText(DESCRIPTIONS[6]);
							break;
				case 8:		lbl.setText(DESCRIPTIONS[7]);
							break;
				case 9:		lbl.setText(DESCRIPTIONS[8]);
							break;
				case 10:	lbl.setText(DESCRIPTIONS[9]);
							break;
				case 11:	lbl.setText(DESCRIPTIONS[10]);
							break;			
				case 12:	lbl.setText(DESCRIPTIONS[11]);
							break;
				case 13:	lbl.setText(DESCRIPTIONS[12]);
							break;
				case 14:	lbl.setText(DESCRIPTIONS[13]);
							break;
				case 15:	lbl.setText(DESCRIPTIONS[14]);
							break;
				case 16:	lbl.setText(DESCRIPTIONS[15]);
							break;
				case 17:	lbl.setText(DESCRIPTIONS[16]);
							break;							
				case 20: lbl.setText(DESCRIPTIONS[17]);
					break;
			}
		}
		else if (evt.getSource()== this.imp)
		{
			Option opt = new Option(this,19);
		    try {
		        UIManager.setLookAndFeel(
		            UIManager.getSystemLookAndFeelClassName());
		    } catch (Exception e) { }
			opt.setTitle(String.format("Option %d", 18));
			opt.setSize(500,500);
			opt.setLocationRelativeTo(null);
			opt.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			opt.setVisible(true);
			
		}
		else if (evt.getSource() == this.exp)
		{
			Option opt = new Option(this,18);
		    try {
		        UIManager.setLookAndFeel(
		            UIManager.getSystemLookAndFeelClassName());
		    } catch (Exception e) { }
			opt.setTitle(String.format("Option %d", 19));
			opt.setSize(500,500);
			opt.setLocationRelativeTo(null);
			opt.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			opt.setVisible(true);
			
		}
		else if (evt.getSource()==this.quit){
			System.exit(0);
		}
	}
}