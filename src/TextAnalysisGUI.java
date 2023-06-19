import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/** TextAnalysisGUI is a GUI that accepts user text input and analyzes the text to determine the number of words and number of sentences
 * 
 * @author Nick Nikolov
 *
 */
public class TextAnalysisGUI implements ActionListener{

		
	private JTextArea inputArea;
	private JTextArea display;
	private JButton clear, analyze;
	private TextAnalyzer textAnalyzer;
	private String text;

	/**
	 * constructor for the TextAnalysis GUI
	 * Initializes buttons, and default text
	 * 
	 * @param title (String) - Title of the program displayed to the user on the GUI
	 */
	public TextAnalysisGUI(String title) { 
		
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(800, 800);  
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.inputArea = new JTextArea(10,60); 
		this.inputArea.setText("Enter or copy Text...");
		jfrm.add(inputArea);
		
		this.display = new JTextArea (3 ,60);
		jfrm.add(display);
		
		analyze = new JButton("ANALYZE");
		analyze.addActionListener(this);
		jfrm.add(analyze);

		clear = new JButton("CLEAR");
		clear.addActionListener(this);
		jfrm.add(clear);
		
		jfrm.setVisible(true);	
	}

	/**Either analyzes the text given or clears the GUI based on which button is clicked by the user
	 * 
	 * 
	 * @param e (ActionEvent) - When analyze or clear buttons are clicked by user
	 */
	public void actionPerformed(ActionEvent e) {

		//Displays the statistic results of all the user inputs
		//else

		if(e.getSource() == analyze) {
			text = (inputArea.getText()); //add the current user input to a string variable
			this.textAnalyzer = new TextAnalyzer(text);
			this.display.append(textAnalyzer.toString());
		}
		
		
		// Resets the GUI window, removes all current text and creates new stats object. All inputs are reset.
		else if(e.getSource() == clear) { //used else if so both buttons aren't pressed at the same time.
			this.display.setText("");
			this.inputArea.setText("Enter or copy Text...");
		}

	}

	public static void main(String[] args) {
		//Starting the GUI application
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TextAnalysisGUI("Text Statistics");
			}
		});
	}

	
	}
