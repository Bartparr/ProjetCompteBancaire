package com.comptebancaire.thread;

public class TestThread extends Thread{
	
	//constructeur
	public TestThread(String name){
		super(name);
	}
	  
	  //redefinition de run
	public void run(){
		for(int i = 0; i < 10; i++)
			System.out.println(this.getName());
	}   

}
