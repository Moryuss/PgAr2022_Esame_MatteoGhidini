package esameArnaldoAdventureTime;


/**
 * Movimento personaggio
 * @author Matteo Ghidini
 *
 */
public class Movement {

	public static String [][] movimento(String[][] mappa, int scelta){

		switch(scelta) {
		case 1: return movimentoSU(mappa);
		case 2: return movimentoGIU(mappa);
		case 3: return movimentoSX(mappa);
		case 4: return movimentoDX(mappa);
		}
		return mappa;
	}

	/**
	 * movimento su
	 * @param road
	 * @return
	 */
	private static String[][] movimentoSU(String[][] road) {

		return movimento(-1, 0,road);
	}


	/**
	 * movimento giu
	 * @param road
	 * @return
	 */
	private static String[][] movimentoGIU(String[][] road) {

		return movimento(1, 0, road);
	}

	/**
	 * movimeto destra
	 * @param road
	 * @return
	 */
	private static String[][] movimentoDX(String[][] road) {

		return movimento(0, 1, road);
	}

	/**
	 * moviment sinistra
	 * @param road
	 * @return
	 */
	private static String[][] movimentoSX(String[][] road) {

		return movimento(0,-1,road);
	}

 
	/**
	 * dati la direzione (jMod e kMod) si muove in quella direzione
	 * @param jMod
	 * @param kMod
	 * @param road
	 * @return
	 */
	private static String[][] movimento(int jMod, int kMod, String[][] road) {

		String[][] excRoad = road;
		for(int j=1; j< road.length-1; j++) {
			for(int k=0; k<road[j].length; k++) {

				try {
					if(road[j][k].equals(ValoriStanza.GIOCATORE.value)){
						
						//sono il luogo in cui si sposta
						jMod= jMod+j;
						kMod= kMod+k;
						
						if(road[jMod][kMod].equals(ValoriStanza.VUOTO.value)){
							road[j][k] = ValoriStanza.VUOTO.value;
							road[jMod][kMod] = ValoriStanza.GIOCATORE.value;
							return road;
						}
						else if(!(road[jMod][kMod].equals(ValoriStanza.VUOTO.value))){ ////////////temporaneo
							if(road[jMod][kMod].equals(ValoriStanza.BOSS.value)){
								return road;
							}
							if(road[jMod][kMod].equals(ValoriStanza.MOSTRO.value)){
								return road;

							}
							if(road[jMod][kMod].equals(ValoriStanza.CHEST.value)){
								return road;
							}
							if(road[jMod][kMod].equals(ValoriStanza.SCALE_SU.value)){
								return road;
							}
							if(road[jMod][kMod].equals(ValoriStanza.SCALE_GIU.value)){
								return road;
							}

						}
					}
				}catch(ArrayIndexOutOfBoundsException e) {return excRoad;};
			}
		}
		return road;
	}
}


/*	String[][] excRoad = road;
		for(int j=1; j< road.length-1; j++) {
			for(int k=0; k<road[j].length; k++) {

				try {
					if(road[j][k].equals(ValoriStanza.GIOCATORE.value)){

						if(road[j-1][k].equals(ValoriStanza.VUOTO.value)){
							road[j][k] = ValoriStanza.VUOTO.value;
							road[j-1][k] = ValoriStanza.GIOCATORE.value;
							return road;
						}
						else if(!(road[j-1][k].equals(ValoriStanza.VUOTO.value))){
							if(road[j-1][k].equals(ValoriStanza.BOSS.value){

							}
							if(road[j-1][k].equals(ValoriStanza.MOSTRO.value){

							}
							if(road[j-1][k].equals(ValoriStanza.CHEST.value){

							}
							if(road[j-1][k].equals(ValoriStanza.SCALE_SU.value){

							}
							if(road[j-1][k].equals(ValoriStanza.SCALE_GIU.value){

							}

						}
					}
				}catch(ArrayIndexOutOfBoundsException e) {return excRoad;};
			}
		}
*/
