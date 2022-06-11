package esameArnaldoAdventureTime;

import java.util.ArrayList;

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

				//creazione personaggio (nome) e mappa totale
				Mappa m1 = new Mappa(new Personaggio(InputDati.leggiStringaNonVuota("Lascia che il tuo nome venga scritto sugli annali akashici: ")));
				Mappa m2 = new Mappa(m1.getPlayer());
				Mappa m3 = new Mappa(m1.getPlayer());
				ArrayList<Mappa> Dungeon = new ArrayList<>();
				Dungeon.add(m1);
				Dungeon.add(m2);
				Dungeon.add(m3);


				do {

					int numeroStanzaDelPiano=0;
					int piano=0;

					System.out.println(Dungeon.get(piano).stampaStanza(numeroStanzaDelPiano));
					Movement.movimento(Dungeon.get(piano).getMappa().get(numeroStanzaDelPiano), conversioneSceltaInInt(), m1.getPlayer());

					for(int i=0; i< Dungeon.get(piano).getMappa().get(numeroStanzaDelPiano).length; i++) {
						for(int j=0; j<Dungeon.get(piano).getMappa().get(numeroStanzaDelPiano)[i].length; j++) {
							if(Dungeon.get(piano).getMappa().get(numeroStanzaDelPiano)[i][j].equals(ValoriStanza.B_BATTLE.value)) {
								Fight battle = new Fight(Dungeon.get(piano).getPlayer(), new Mostro());
							}
							if(Dungeon.get(piano).getMappa().get(numeroStanzaDelPiano)[i][j].equals(ValoriStanza.D_BATTLE.value)) {

							}
							if(Dungeon.get(piano).getMappa().get(numeroStanzaDelPiano)[i][j].equals(ValoriStanza.M_BATTLE.value)) {

							}
							if(Dungeon.get(piano).getMappa().get(numeroStanzaDelPiano)[i][j].equals(ValoriStanza.C_FOUND.value)) {

							}
						}
					}

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
