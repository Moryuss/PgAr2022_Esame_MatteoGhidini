package it.unibs.fp.mylib;

import java.util.ArrayList;

public class MyMath {
	
	public static final double EPSYLON = 0.0001;
	public static final double META = 0.5;
	
	public static double percNumeroDouble(double num, double perc) {
		
		return (num/100.0)*perc;
	}


	public static int percNumeroInt(double num, double perc) {
	
		return ((int) ((num/100)*perc));
	
	}
	/**
	 * Metodo che aumenta num di percentuale di num <br>
	 * Questo accade n volte
	 * @param num: double da aumentare
	 * @param perc: double che indica la percentuale
	 * @param n: numero di volte che si vuole far eseguire il ciclo
	 * @return double
	 */
	public static double percAumentoCiclico (double num, double perc, int n) {
		
		int i;
		
		for(i=0; i<n; i++) {
			num = num + MyMath.percNumeroDouble(num, perc);
		}
		
		return num;
	}
	
	
	public static int aprossimazione(double num) {
		
		if((num - (int) num)<= META ) return (int)num;
		else return ((int)num +1);
			
		
	}
	
	public static int media(int []num) {
		
		int somma=0, count=0;
		
		for(int i=0; i< num.length; i++) {
			somma += num[i];
			count++;
		}
		
		return somma/count;
	}
	
	public static double media(double []num) {
		
		double somma=0.0;
		int count=0;
		
		for(int i=0; i< num.length; i++) {
			somma += num[i];
			count++;
		}
		
		return somma/count;
	}
	
	
	public static int media(ArrayList<Integer> num) {
		
		int somma=0, count=0;
		
		for(int i=0; i< num.size(); i++) {
			somma += num.get(i);
			count++;
		}
		
		return somma/count;
	}
	
}