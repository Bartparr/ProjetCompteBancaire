package com.ProjetCompteBancaire.banque;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

import com.comptebancaire.mouvement.Mouvement;

public class Banque   {
	
	/*Map contient les comptes bancaires
	 * Mouvement contient l'historique des transactions
	 * 
	 */
	Map<Integer, Integer> listeCompteBancaires;	
	ArrayList<Mouvement> mesMouvements = new ArrayList<Mouvement>();
	
	//constructeur
	public Banque(Map<Integer,Integer> listeCompteBancaires){
		this.listeCompteBancaires = listeCompteBancaires;
	}
	
	//getters and setters
	public Map<Integer, Integer> getListeCompteBancaires() {
		return listeCompteBancaires;
	}

	public void setListeCompteBancaires(Map<Integer, Integer> listeCompteBancaires) {
		this.listeCompteBancaires = listeCompteBancaires;
	}	
	
	public ArrayList<Mouvement> getMesMouvements() {
		return mesMouvements;
	}

	public void setMesMouvements(ArrayList<Mouvement> mesMouvements) {
		this.mesMouvements = mesMouvements;
	}

	//methodes creation de compte aléatoires
	public void createComptes(int nbComptes){
	      for (int i = 0;i<nbComptes;i++){
	    	  int randomNum = ThreadLocalRandom.current().nextInt(1, 999999 + 1);
	    	  int randomNum2 = ThreadLocalRandom.current().nextInt(1, 999999 + 1);
	    	  listeCompteBancaires.put(randomNum, randomNum2);
	      }
	}
	
	//pour creer un seul compte specifique
	public void createComptes(int cle, int valeur){	      
	    	  listeCompteBancaires.put(cle, valeur);
	      	}
	
	//methode credit: ajout d'argent
	public void credit(int cle, int montant){
				
		int r = this.listeCompteBancaires.get(cle);
		r = r + montant;
		this.listeCompteBancaires.put(cle, r);
		
		LocalDateTime localDate = LocalDateTime.now();		
		Mouvement monMouvement = new Mouvement(cle, montant, false,localDate,"credit");
		this.mesMouvements.add(monMouvement);
		
	}
	
	//methode debit
	public void debit(int cle, int montant){
		
		int r = this.listeCompteBancaires.get(cle);
		r = r - montant;
		this.listeCompteBancaires.put(cle, r);
			
		LocalDateTime localDate = LocalDateTime.now();		
		Mouvement monMouvement = new Mouvement(cle, montant, true,localDate,"debit");
		this.mesMouvements.add(monMouvement);
		
	}
	
	//methode recherche Solde, retourne une ArrrayList de clés qui correspondent à un compte avec la solde demandée
	
	public ArrayList<Integer> rechercheSolde(int solde){
		
		if(this.listeCompteBancaires.containsValue(solde)){
			ArrayList<Integer> tableauCle = new ArrayList<Integer>();
			
		    Set<Entry<Integer, Integer>> setLCB = this.getListeCompteBancaires().entrySet();
		    Iterator<Entry<Integer, Integer>> iterator = setLCB.iterator();
		    
		    while(iterator.hasNext()){
		    	Entry<Integer, Integer> e = iterator.next();
		    	if(e.getValue() == solde){
		    		tableauCle.add(e.getKey());
		    	}		    
		    }					
			return tableauCle;			
		}
		else{		
			return null;
		}
		
	}
	
	
	//methode total banque calcule la somme totale des soldes bancaires
	public int totalBanque(){
		int total = 0;
		 Set<Entry<Integer, Integer>> setLCB = this.getListeCompteBancaires().entrySet();
		    Iterator<Entry<Integer, Integer>> iterator = setLCB.iterator();
		    
		    while(iterator.hasNext()){
		    	Entry<Integer, Integer> e = iterator.next();
		    	total += e.getValue();
		    }		
		    
		return total;		
	}
	
	
	//methode affichage historique affiche l'historique de toutes les transactions bancaires	
	public void affichageHisto(){
		
		for(Mouvement monMouvement : this.mesMouvements){
			System.out.println("-----------------------");
			System.out.println("clé " + monMouvement.getNumeroCompte() );
			System.out.println("valeur " + monMouvement.getValeur() );
			if (monMouvement.getDebit()){
				System.out.println("nature de l'operation : debit");
			}else{
				System.out.println("nature de l'operation : credit");
			}			
			System.out.println("date " + monMouvement.getDate() );			
			System.out.println("description " + monMouvement.getDescription() );
			System.out.println("-----------------------");
		}
		
	}
}
