import javax.swing.JFrame;
import javax.swing.UIManager;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		// main entry point for program
		
	    try {
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception e) { }
		Front_End fe = new Front_End();
		fe.setTitle("PAN Database System");
		fe.setSize(700,400);
		fe.setLocationRelativeTo(null);
		fe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fe.setVisible(true);
	}

}
