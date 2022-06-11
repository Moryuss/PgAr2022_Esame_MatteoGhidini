package esameArnaldoAdventureTime;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMath;
import it.unibs.fp.mylib.MyMenu;

public class Main {

	//primo ciclo do-while
	private static final String TITOLO = "ADVENTURE TIME";
	private static final String[] SCELTE_PRINCIPALI = {"START"};


	public static void main(String[] args) {

		MyMenu menuPrincipale = new MyMenu(TITOLO, SCELTE_PRINCIPALI);
		int sceltaPrincipale=0;
		boolean b =true;/////////////////////////////////////////////////////////////////////////////////per far giocare infinitamente
		do {
			sceltaPrincipale= menuPrincipale.scegli(); //prima scelta

			if (sceltaPrincipale==1) {//START THE GAME
				Mappa m1 = new Mappa();

				do {
					System.out.println(m1.stampaStanza(0));
					Movement.movimento(m1.getMappa().get(0), conversioneSceltaInInt());
				}while(b);////////////condizione di uscita (morte o disfatta o resa)


			}
		}while(sceltaPrincipale!=0); //ENDGAME



	}

	/**converte w,a,s,d, in numeri 
	 * su =1 <br>
	 * giu= 2<br>
	 * sinistra = 3 <br>
	 * destra = 4 <br>
	 * @return
	 */
	public static int conversioneSceltaInInt() {

		String s = "";

		while(!s.equals("w") && !s.equals("a") && !s.equals("s") && !s.equals("d")) {
			s=InputDati.leggiStringaNonVuota("direzione spostamento (w/a/s/d) :");
		}
		switch(s) {
		case("w"): return 1;
		case("s"):return 2;
		case("a"): return 3;
		case("d"): return 4;
		default :  return -1;
		}
	}




}
