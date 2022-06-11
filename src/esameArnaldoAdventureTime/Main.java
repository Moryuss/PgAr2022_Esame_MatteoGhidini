package esameArnaldoAdventureTime;

import java.util.ArrayList;
import java.util.HashMap;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMath;
import it.unibs.fp.mylib.MyMenu;

public class Main {

	//primo ciclo do-while
	private static final String TITOLO = "ADVENTURE TIME";
	private static final String[] SCELTE_PRINCIPALI = {"START"};
	private static final String TITOLO_CHEST = "CHEST";
	private static final String[] OPZIONI_CHEST_PIENA = {"butta oggetto", "usa oggetto"};



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
				ArrayList<Mappa> dungeon = new ArrayList<>();
				dungeon.add(m1);
				dungeon.add(m2);
				dungeon.add(m3);
				DROP_LIST.setDropListaDrop();
				

				do {

					int numeroStanzaDelPiano=0;
					int piano=0;

					System.out.println(dungeon.get(piano).stampaStanza(numeroStanzaDelPiano));
					Movement.movimento(dungeon.get(piano).getMappa().get(numeroStanzaDelPiano), conversioneSceltaInInt(), m1.getPlayer());

					for(int i=0; i< dungeon.get(piano).getMappa().get(numeroStanzaDelPiano).length; i++) {
						for(int j=0; j<dungeon.get(piano).getMappa().get(numeroStanzaDelPiano)[i].length; j++) {
							if(dungeon.get(piano).getMappa().get(numeroStanzaDelPiano)[i][j].equals(ValoriStanza.B_BATTLE.value)) {
								Fight battle = new Fight(dungeon.get(piano).getPlayer(), new Mostro());

								System.out.println(battle.combattimento());
							}
							if(dungeon.get(piano).getMappa().get(numeroStanzaDelPiano)[i][j].equals(ValoriStanza.D_BATTLE.value)) {
								Fight battle = new Fight(dungeon.get(piano).getPlayer(), Boss.DIJKSTRA);

								System.out.println(battle.combattimento());
							}
							if(dungeon.get(piano).getMappa().get(numeroStanzaDelPiano)[i][j].equals(ValoriStanza.M_BATTLE.value)) {
								Fight battle = new Fight(dungeon.get(piano).getPlayer(), new Mostro());

								System.out.println(battle.combattimento());

							}
							if(dungeon.get(piano).getMappa().get(numeroStanzaDelPiano)[i][j].equals(ValoriStanza.C_FOUND.value)) {
								if(dungeon.get(piano).getPlayer().getInventory().size()<6) {
									Chest ch = new Chest();
									dungeon.get(piano).getPlayer().getInventory().put(dungeon.get(piano).getPlayer().getInventory().size(), (ch.getContenuto()));
								}
								else {
									MyMenu menuChest = new MyMenu(TITOLO_CHEST, OPZIONI_CHEST_PIENA);
									int scelta =0;
									do {
										scelta = menuChest.scegli();
										String[] listaOggettInv = creaScelte(dungeon.get(piano).getPlayer().getInventory());
										switch(scelta) {
										//buttare oggetto
										case 1 : {
											MyMenu scegliDaButtare = new MyMenu("Quale oggetto vuoi buttare?", listaOggettInv);
											int sceltaOggetto=0;
											do {
												sceltaOggetto = scegliDaButtare.scegli();
												dungeon.get(piano).getPlayer().getInventory().remove(sceltaOggetto-1);
											}while(sceltaOggetto==0);



												break;
											}
										}
										}while(scelta!=0);
									}
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



		/**
		 * trasforma gli oggetti nell'inventario come string[]
		 * @param inv
		 * @return
		 */
		private static String[] creaScelte(HashMap<Integer, Drop> inv) {
			ArrayList<Drop> scelte = new ArrayList<>();

			for(int i=0; i< inv.size(); i++) {
				scelte.add(inv.get(i));
			}

			String[] scelteArray =  scelte.toArray(new String[scelte.size()]);
			return scelteArray;
		}
	}




