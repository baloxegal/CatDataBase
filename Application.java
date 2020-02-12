package main;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import data.Cat;
import data.FelineInterface;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("all")

public class Application {
	
	public static List<String> catsNameList = new ArrayList();
	public static List<FelineInterface> ArrHasFelineInterface  = new ArrayList();
	
	public static void main(String[] args) {
		// GUI -> Graphical User Interface
		// CLI -> Command Line Interface
		
		//JavaFX (OPEN SOURCE!) - Framework
		
		//Java Swing
			//DOM -> document object model
				// DESIGN - Layout
				// *Composition
				// *Observer (events ----> actions)
				
				// *dynamic class / anonymous class
		
		initGUI();
	}
	
	public static void initGUI(){
		
		JFrame window = new JFrame("Cat Database App");
		
		JButton saveBtn = new JButton("SAVE");
		JTextField idInput = new JTextField();
		JTextField nameInput = new JTextField();
		JTextField raceInput = new JTextField();
		JTextField yearInput = new JTextField();
		
		window.getContentPane().add(idInput);
		window.getContentPane().add(nameInput);
		window.getContentPane().add(raceInput);
		window.getContentPane().add(yearInput);
		window.getContentPane().add(saveBtn);
		
		window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.PAGE_AXIS));
		window.setBounds(100, 100, 600, 400);
		window.show();
		
		JRootPane rootPane = SwingUtilities.getRootPane(saveBtn); 
		rootPane.setDefaultButton(saveBtn);
		
		//OBSERVER - pas button -> action  --------> ANONIMOUS CLASS
		// IoC - Inversion of control
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("OK!");
				//System.out.println(nameInput.getText());
				//nameInput.setText("");
				
				//accumulate
				//catsNameList.add(nameInput.getText());
				
				ArrHasFelineInterface.add(new Cat(Integer.parseInt(idInput.getText()), nameInput.getText(), raceInput.getText(), Integer.parseInt(yearInput.getText())));
			    
				//System.out.println(catsNameList.get(catsNameList.size() - 1));
				//System.out.println("Cats in the collection - " + catsNameList.size());
				printLIst();
				idInput.setText("");
				nameInput.setText("");
				raceInput.setText("");
				yearInput.setText("");
			}
		});
	}
	
	public static void printLIst(){
//		System.out.print("[" + catsNameList.size() + "]: ");
//		System.out.println(catsNameList.get(catsNameList.size() - 1));
//		System.out.println(String.join(",", catsNameList));
		
		System.out.print("[" + ArrHasFelineInterface.size() + "]: ");
		ArrHasFelineInterface.forEach(c -> {if(ArrHasFelineInterface.indexOf(c) != 0) System.out.print("     "); System.out.println(c.toString());});
		
	}
}