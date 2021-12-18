package com.pzdev.disignpatterns.demo1.controller;

import com.pzdev.disignpatterns.demo1.model.Model;
import com.pzdev.disignpatterns.demo1.view.View;

public class Controller {
	
	private View view;
	private Model model;

	public Controller(Model model, View view) {
		// TODO Auto-generated constructor stub

		this.model = model;
		this.view = view;

		
	}

}
