/* Version 27/02/2020*/

/*Package*/
package PokerTest;

/*Import*/
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Collections;

/*Main()*/
public class Main {
	public static void main(String[] args) {
		/*Create all different cards*/
		List<String>Paquet = new ArrayList<String>();
		List<String>Color = new ArrayList<String>();
		List<String> Value = new ArrayList<String>();
		Color.add("pique");
		Color.add("coeur");
		Color.add("carreau");
		Color.add("trefle");
		Value.add("7");
		Value.add("8");
		Value.add("9");
		Value.add("X");
		Value.add("V");
		Value.add("D");
		Value.add("R");
		Value.add("A");
		
		/*Create paquet*/
		for (int ite_Color = 0; ite_Color < Color.size(); ite_Color++) {
			for (int ite_Value = 0; ite_Value < Value.size(); ite_Value++) {
				Paquet.add(Value.get(ite_Value)+"_"+Color.get(ite_Color));
			}
		}
	    Collections.shuffle(Paquet);
	    
	    /*Give Hand Card*/
	    List<String>Hand_Player_One = new ArrayList<String>();
	    List<String>Hand_Player_Two = new ArrayList<String>();
	    for (int ite_Hand_P1 = 0; ite_Hand_P1 < 5; ite_Hand_P1++) {
	    	Hand_Player_One.add(Paquet.get(ite_Hand_P1));
	    	Paquet.remove(ite_Hand_P1);
	    }
	    for (int ite_Hand_P2 = 0; ite_Hand_P2 < 5; ite_Hand_P2++) {
	    	Hand_Player_Two.add(Paquet.get(ite_Hand_P2));
	    	Paquet.remove(ite_Hand_P2);
	    }
	    /*P1 tour for change own cards*/
	    System.out.println("Hand P1: " + Hand_Player_One);
	    for (int ite_Mixe_Hand_P1 = 0; ite_Mixe_Hand_P1 < 5; ite_Mixe_Hand_P1++) {
	    	Scanner myObj1 = new Scanner(System.in);
		    System.out.println("Want u to remove the card : " + Hand_Player_One.get(ite_Mixe_Hand_P1));
		    System.out.println("yes/no");
		    String response = myObj1.nextLine(); 
		    if (response.equals("yes")){
		    	Paquet.add(Hand_Player_One.get(ite_Mixe_Hand_P1));
		    	Hand_Player_One.remove(Hand_Player_One.get(ite_Mixe_Hand_P1));
		    	Collections.shuffle(Paquet);
		    	Hand_Player_One.add(Paquet.get(0));
		    	Paquet.remove(0);
		    }
	    } 
	    System.out.println("New Hand P1: " + Hand_Player_One);
	    
	    /*P2 tour for change own cards*/
	    System.out.println("Hand P2: " + Hand_Player_Two);
	    for (int ite_Mixe_Hand_P2 = 0; ite_Mixe_Hand_P2 < 5; ite_Mixe_Hand_P2++) {
	    	Scanner myObj2 = new Scanner(System.in);
		    System.out.println("Want u to remove the card : " + Hand_Player_Two.get(ite_Mixe_Hand_P2));
		    System.out.println("yes/no");
		    String response = myObj2.nextLine(); 
		    if (response.equals("yes")){
		    	Paquet.add(Hand_Player_Two.get(ite_Mixe_Hand_P2));
		    	Hand_Player_Two.remove(Hand_Player_Two.get(ite_Mixe_Hand_P2));
		    	Collections.shuffle(Paquet);
		    	Hand_Player_Two.add(Paquet.get(0));
		    	Paquet.remove(0);
		    }
	    } 
	    System.out.println("New Hand P2: " + Hand_Player_Two);
	    
	    /*Calculate the total point of hands*/
	    int compteurPar = 0;
	    int compteurTot = 0;
	    
	    for (int ite_Phase_Player = 0; ite_Phase_Player < 2; ite_Phase_Player++) { 
	    	List<String>Serie1 = new ArrayList<String>();
		    List<String>Serie2 = new ArrayList<String>();
	    	if  (ite_Phase_Player == 0) {
	    		for (int ite_Split_Hand_P1 = 0; ite_Split_Hand_P1 < 5; ite_Split_Hand_P1++) {
	    	    	String[] SerieValue = Hand_Player_One.get(ite_Split_Hand_P1).split("_");
	    	    	Serie1.add(SerieValue[0]);
	    	    	String[] SerieColor = Hand_Player_One.get(ite_Split_Hand_P1).split("_");
	    	    	Serie2.add(SerieColor[1]);
	    		}
	    	}
	    	if  (ite_Phase_Player == 1) {
	    		for (int ite_Split_Hand_P2 = 0; ite_Split_Hand_P2 < 5; ite_Split_Hand_P2++) {
	    	    	String[] SerieValue = Hand_Player_Two.get(ite_Split_Hand_P2).split("_");
	    	    	Serie1.add(SerieValue[0]);
	    	    	String[] SerieColor = Hand_Player_Two.get(ite_Split_Hand_P2).split("_");
	    	    	Serie2.add(SerieColor[1]);
	    		}
	    	}
	    	compteurTot = 0;
	    	for (int ite_Card = 0;  ite_Card < 5;  ite_Card++) {
	    		compteurPar = 0;
	    		for (int ite_Other_Card = 0; ite_Other_Card < 5; ite_Other_Card++ ) {
	    			if (Serie1.get( ite_Card).equals(Serie1.get(ite_Other_Card))) {
	    				compteurPar++;
	    			}
	    		}
	    		if (compteurPar == 2) {
	    			compteurTot++;
	    		}
	    		if (compteurPar == 3) {
	    			compteurTot = compteurTot + 3;
	    		}
	    		if (compteurPar == 4) {
	    			compteurTot = compteurTot + 4;
	    		}
	    		
	    	}
	    	if  (ite_Phase_Player == 0) {
	    		System.out.println("\nPlayer1 have: ");
	    	}
	    	if  (ite_Phase_Player == 1) {
	    		System.out.println("\nPlayer2 have: ");
	    	}
	    	int TotalPoint = compteurTot/2;
	    	if (TotalPoint == 0) {
	    		System.out.println("None");
	    	}
	    	if (TotalPoint == 1) {
	    		System.out.println("Pair");
	    	}
	    	if (TotalPoint == 2) {
	    		System.out.println("Double pairs");
	    	}
	    	if (TotalPoint == 3) {
	    		System.out.println("Triple");
	    	}
	    	if (TotalPoint == 6.5) {
	    		System.out.println("Flush");
	    	}
	    	if (TotalPoint == 8) {
	    		System.out.println("Carré");
	    	}
	    	
	    
	    	if (Serie2.get(0).equals(Serie2.get(1)) & Serie2.get(1).equals(Serie2.get(2)) & Serie2.get(2).equals(Serie2.get(3)) & Serie2.get(3).equals(Serie2.get(4))){
	    		System.out.println("With Color");
	    	}else {
	    		System.out.println("Not With Color");
	    	}
	    }
	    /* Winner*/
	}
	
}
