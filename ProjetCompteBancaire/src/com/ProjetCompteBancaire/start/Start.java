package com.ProjetCompteBancaire.start;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.ProjetCompteBancaire.banque.Banque;
import com.comptebancaire.fenetre.Fenetre;
import com.comptebancaire.ponction.Ponction;


public class Start {

	public static void main(String[] args) {
	

		//creation d'une hashmap de liste de compte bancaires
		Map<Integer, Integer> listeCompteBancaires = new HashMap<Integer,Integer>();
		
		Banque maBanque = new Banque(listeCompteBancaires);
		//creation de 10 comptes aleatoires et de qqs comtpes spécifiques
		maBanque.createComptes(10);
		maBanque.createComptes(99,150000);
		maBanque.createComptes(10,45000);
		maBanque.createComptes(11,40000);
		maBanque.createComptes(12,40000);
		maBanque.createComptes(13,40000);
		maBanque.createComptes(14,40000);
		
	      System.out.println("Parcours de l'objet compte bancaires et affichage : ");
	      Set<Entry<Integer, Integer>> setLCB = maBanque.getListeCompteBancaires().entrySet();
	      Iterator<Entry<Integer, Integer>> iterator = setLCB.iterator();
	      while(iterator.hasNext()){
	         Entry<Integer, Integer> e = iterator.next();
	         System.out.println("clé: "+ e.getKey() + "  valeur : " + e.getValue());
	      }

	      maBanque.credit(99,5000);
	      System.out.println("valeur à la clé 99 apres un virement de 5000: " + maBanque.getListeCompteBancaires().get(99));	      
	      maBanque.debit(99,20000);   
	      System.out.println("valeur à la clé 99 apres debit de 20 000: " + maBanque.getListeCompteBancaires().get(99));
	      
	      System.out.println("les clés des comptes à 40 000 sont : "+maBanque.rechercheSolde(40000));
	      
	      System.out.println("le total des soldes est égal à  : "+maBanque.totalBanque());
	      
	      //on fait des operations pour tester l'affichage de l'historique 
	      maBanque.credit(11,200);
	      maBanque.credit(12,10);
	      maBanque.credit(13,800);
	      maBanque.debit(14,800);    	   
	      maBanque.affichageHisto();
	      
	      
	      //tests sur les threads	
	      
	      Ponction maPonction = new Ponction(maBanque,5000,15000,99);
	      Thread t = new Thread(maPonction);
	      t.start();
	      
	     //test sur les fenetres
	     // Fenetre maFen = new Fenetre();
	      
	}   
	

}
