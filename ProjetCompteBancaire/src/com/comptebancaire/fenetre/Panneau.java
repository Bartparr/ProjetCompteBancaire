package com.comptebancaire.fenetre;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel{
	public void paintComponent (Graphics g){
		
		g.drawString("tiens ! je suis barth !", 10, 20);
	}

}
