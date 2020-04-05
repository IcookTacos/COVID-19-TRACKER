import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

@SuppressWarnings({ "serial", "unused" })
public class Window extends JFrame {
	
	// LABELS
	private JLabel source;
	private JLabel caseSweden;
	private JLabel caseSwedenINT;
	
	// TEXTAREA
	private JTextArea txtA;
	
	//BORDER
	//Border blackline = BorderFactory.createLineBorder(Color.BLACK,2);
	
	// WILL BE USING A ORANGE & BLUE COMPLEMENTARY COLOR SCHEME
	// COLORS
	Color blu = new Color(0,150,136);		// PRIMARY BACKGROUND COLOR
	Color org = new Color(255,87,34);		// PRIMARY FOREGROUND COLOR
	
	// FONTS
	Font f1 = new Font(Font.DIALOG,Font.BOLD,15);
	Font f2 = new Font(Font.DIALOG,Font.BOLD,12);

	public Window() {
		
		// WINDOW CONFIGURATIONS
		setSize(400,400);
		setLayout(null);
		setTitle("CASE TRACKER");
		setLocationRelativeTo(null);
		getContentPane().setBackground(blu);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// CASES LABEL (SWEDEN)
		caseSweden = new JLabel("CASES SWEDEN");
		caseSweden.setBounds(10,25,150,15);
		caseSweden.setFont(f1);
		caseSweden.setForeground(org);
		add(caseSweden);
		
		// LABEL SOURCE
		source = new JLabel("https://www.worldometers.info");
		source.setBounds(10,5,200,15);
		source.setFont(f2);
		source.setForeground(org);
		add(source);
		
		// CASES LABEL (INT)
		/*
		caseSwedenINT = new JLabel(GetCases.caseSwe);
		caseSwedenINT.setBounds(10,20,150,10);
		caseSwedenINT.setFont(f2);
		caseSwedenINT.setForeground(org);
		//add(caseSwedenINT);
		 */
		 
		// CASES AREA
		txtA = new JTextArea();
		txtA.setEditable(false);
		txtA.setBounds(10,45,200,250);
		txtA.setBackground(blu);
		txtA.setFont(f2);
		txtA.setForeground(org);
		txtA.append("Today: " + GetCases.caseSwe);
		add(txtA);
		
		
		
		
	}
}
