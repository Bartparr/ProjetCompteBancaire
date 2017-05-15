package com.comptebancaire.mouvement;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mouvement {
	
	int numeroCompte;
	int valeur;
	Boolean debit;
	LocalDateTime date;
	String description;
	
	
	//contructeur
	
	public Mouvement(int numeroCompte, int valeur, Boolean debit, LocalDateTime date, String description){
		this.numeroCompte=numeroCompte;
		this.valeur = valeur;
		this.debit = debit;
		this.date = date;
		this.description = description;
	}
	
	
	public int getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	public Boolean getDebit() {
		return debit;
	}
	public void setDebit(Boolean debit) {
		this.debit = debit;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
