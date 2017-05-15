package com.comptebancaire.ponction;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import com.ProjetCompteBancaire.banque.Banque;

public class Ponction implements Runnable{
	
	Banque maBanque;
	int cooldown;
	int montant;
	int cle;
	
	public Ponction(Banque banque, int cooldown, int montant){
		this.maBanque = banque;
		this.cooldown = cooldown;		
		this.montant = montant;
	}

	public Ponction(Banque banque, int cooldown, int montant, int cle){
		this.maBanque = banque;
		this.cooldown = cooldown;		
		this.montant = montant;
		this.cle = cle;
	}
	//retire 20 000 euros à un compte aleatoire toutes les cooldown secondes et a compte 99
	public void run() { 
		
		for(int i=0;i<100;i++){
			this.ponctionne();
			this.ponctionne(this.cle);
				      
			try {
				Thread.sleep(this.cooldown);
			} catch (InterruptedException e1) {				
				e1.printStackTrace();
			}	      
		}
	}
	
	//ponctionne un compte aléatoire
	public void ponctionne(){		
		Set<Entry<Integer, Integer>> setLCB = maBanque.getListeCompteBancaires().entrySet();
		Iterator<Entry<Integer, Integer>> iterator = setLCB.iterator();
     
		Entry<Integer, Integer> e = iterator.next();
		maBanque.debit( e.getKey(),this.montant);
		System.out.println("le compte  "+ e.getKey() + "  a été débité de " + this.montant + " euros et il reste : " + e.getValue() +" sur le compte");
		
	}
	
	//ponctionne un compte particulier
	public void ponctionne(int cle){		
		  Set<Entry<Integer, Integer>> setLCB = maBanque.getListeCompteBancaires().entrySet();
		    Iterator<Entry<Integer, Integer>> iterator = setLCB.iterator();
		    
		    while(iterator.hasNext()){
		    	Entry<Integer, Integer> e = iterator.next();
		    	if(e.getKey() == cle){
		    		maBanque.debit( e.getKey(),this.montant);
		    		System.out.println("le compte  "+ e.getKey() + "  a été débité de " + this.montant + " euros et il reste : " + e.getValue() +" sur le compte");
		    	}		    
		    }	
		
		
	}
	

}
