package com.comptebancaire.fenetre;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	//constructeur
	public Fenetre(){
		this.setTitle("barth");
		this.setSize(800,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(new Panneau());
		this.setVisible(true);
		
		
	}

}
