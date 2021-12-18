package com.pzdev.disignpatterns.demo1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.pzdev.disignpatterns.demo1.model.Model;

public class View extends JFrame implements ActionListener{
	
	private Model model;
	private GridBagConstraints gc = new GridBagConstraints();

	private JButton helloButton;
	private JButton byeButton;
	
	
	
	public View(Model model) throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("MVC Demo");
		this.model = model;
		
		showWindow();

	}

	
	
	private void showWindow() {
		
		setLayout(new GridBagLayout());
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
				
		helloButton = createButton("Hello");
		byeButton = createButton("GoodBye");
		
		addButtonToGrid(helloButton,1);
		addButtonToGrid(byeButton ,2);
		
		
		// Here we add one more listener for the byeButton - but this time we 
		// instantiate a new anonymous class implementing directly 
		// the ActionListener Interface
		byeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sorry to see you go.");
			}
			
		});
		
	}

	
	
	private JButton createButton(String buttonText) {
		JButton button = new JButton(buttonText);
		return button;
	}
	
	
	private void addButtonToGrid(JButton button, int verticalPosition) {
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx=1;
		gc.gridy=verticalPosition;
		gc.weightx=1;
		gc.weighty=1;
		gc.fill=GridBagConstraints.NONE;
		
		add(button, gc);
		addActionListenerToButton(button);
	}
	
	private void addActionListenerToButton(JButton button) {
		button.addActionListener(this);
	}


	// This is the abstract method of the ActionListener Interface that should be implemented
	// https://docs.oracle.com/javase/8/docs/api/java/awt/event/ActionListener.html
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton sourceButton = (JButton)e.getSource();
		
		if(sourceButton == helloButton) {
			System.out.println("Hello there!");
		}
		else {
			System.out.println("Some other button.");
		}
		
	}

}
