package it.unibs.fp.mylib;

import java.util.*;

public class NumeriCasuali {
	
	private static Random estrattore = new Random();
	
	public static int estraiIntero(int min, int max)
	{
		 int range = max + 1 - min;
		 int casual = estrattore.nextInt(range);
		 return casual + min;
	}
	
	public static double estraiDouble(double min, double max)
	{
	 double range = max - min;
	 double casual = estrattore.nextDouble();
	 
	 double posEstratto = range*casual;
	 
	 return posEstratto + min;
	}

	public static void shuffle (Object[] ar) {
        Random r = new Random();
        int a=0,b=0,size=ar.length;
        Object temp;
        for (int i=0; i<ar.length;i++) {
            a = r.nextInt(size);
            b=r.nextInt(size);
            b= (b==a) ? (a==ar.length-1) ? b-- : b++ : b;
            temp = ar[b];
            ar[b] = ar[a];
            ar[a] = temp;
        }
    }
}
