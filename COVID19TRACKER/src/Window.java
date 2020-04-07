import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

@SuppressWarnings({ "serial", "unused" })
public class Window extends JFrame {

	// FILEPATH
	static String path = new String("C:\\COVID19CASES\\case2.txt");
	
	// STRING
	String date = new String("April 4: ");
	
	// CASES
	int cases = GetCases.x;

	// LABELS
	private JLabel source;
	private JLabel caseSweden;
	private JLabel caseSwedenINT;
	private static JLabel error1;

	// TEXTAREA
	private JTextArea txtA;
	
	// ARRAY LIST
	ArrayList<String> storedCases = new ArrayList<>();

	// BUTTONS
	private JButton get, save, refresh;

	// COLORS
	Color bgrnd = new Color(95, 125, 140); 		// PRIMARY BACKGROUND COLOR
	Color fgrnd = new Color(255, 248, 225); 	// PRIMARY FOREGROUND COLOR

	// FONTS
	Font f1 = new Font(Font.MONOSPACED, Font.BOLD, 15);
	Font f2 = new Font(Font.MONOSPACED, Font.BOLD, 12);

	// BORDER
	Border blackline = BorderFactory.createLineBorder(fgrnd, 2);

	// DRAWINGCOMPONENT
	static DrawingComponent dC = new DrawingComponent();

	public Window() {

		// WINDOW CONFIGURATIONS
		setSize(400, 400);
		setLayout(null);
		setTitle("CASE TRACKER");
		setLocationRelativeTo(null);
		getContentPane().setBackground(bgrnd);
		// getContentPane().add(dC); //TODO: FIX THIS
		// dC.repaint(); //TODO: FIX THIS
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// CASES LABEL (SWEDEN)
		caseSweden = new JLabel("CASES SWEDEN");
		caseSweden.setBounds(10, 25, 150, 15);
		caseSweden.setFont(f1);
		caseSweden.setForeground(fgrnd);
		add(caseSweden);

		// LABEL SOURCE
		source = new JLabel("https://www.worldometers.info");
		source.setBounds(10, 5, 210, 15);
		source.setFont(f2);
		source.setForeground(fgrnd);
		add(source);
		
		// LABEL ERROR
		error1 = new JLabel("Invalid filepath");
		error1.setBounds(255, 42, 150, 25);
		error1.setFont(f2);
		error1.setForeground(Color.red);
		add(error1);
		error1.setVisible(false);

		// BUTTONS
		save = new JButton("SAVE");
		save.setBounds(180, 45, 70, 25);
		save.setFont(f2);
		save.setBorder(blackline);
		save.setForeground(fgrnd);
		save.setBackground(bgrnd);
		save.setOpaque(false);
		add(save);
		
		refresh = new JButton("REFRESH");
		refresh.setBounds(180, 75, 70, 25);
		refresh.setFont(f2);
		refresh.setBorder(blackline);
		refresh.setForeground(fgrnd);
		refresh.setBackground(bgrnd);
		refresh.setOpaque(false);
		add(refresh);

		// CASES LABEL (INT)
		/*
		 * caseSwedenINT = new JLabel(GetCases.caseSwe);
		 * caseSwedenINT.setBounds(10,20,150,10); caseSwedenINT.setFont(f2);
		 * caseSwedenINT.setForeground(org); //add(caseSwedenINT);
		 */

		// CASES AREA
		txtA = new JTextArea();
		txtA.setEditable(false);
		txtA.setBounds(10, 45, 160, 250);
		txtA.setBorder(blackline);
		txtA.setBackground(bgrnd);
		txtA.setForeground(fgrnd);
		txtA.setFont(f2);
		txtA.append("Current: " + GetCases.caseSwe);
		add(txtA);

		// ACTIONLISTENERS
		save.addActionListener((e) -> storeCurrentCases(date, cases));	// TODO: SOLVE DATE AND CASES
		refresh.addActionListener((e) -> refreshCaseList(storedCases));	// TODO: WHAT ARE THEY, HOW DO YOU WANT THIS TO WORK?

	}

	private void refreshCaseList(ArrayList<String> storedCases) {
		 
		try (FileReader f = new FileReader(path)) {
		    StringBuffer sb = new StringBuffer();
		    while (f.ready()) {
		        char c = (char) f.read();
		        if (c == '\n') {
		        	storedCases.add(sb.toString());
		            sb = new StringBuffer();
		        } else {
		            sb.append(c);
		        }
		    }
		    if (sb.length() > 0) {
		    	storedCases.add(sb.toString());
		    }
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}       
		String date = storedCases.get(0);		// TODO: SOLVE THIS
		txtA.append("\n");		
		txtA.append(date);
		
	}
	
	public static void storeCurrentCases(String date,int cases) {
		{
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
				writer.newLine();
				writer.write(date + cases);
				writer.close();
				error1.setVisible(false);
			} catch (IOException e) {
				error1.setVisible(true);
				e.printStackTrace();
			} 
			
		}
	}
}
