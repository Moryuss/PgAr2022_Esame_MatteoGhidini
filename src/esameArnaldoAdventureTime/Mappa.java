package esameArnaldoAdventureTime;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.unibs.fp.mylib.EstrazioniCasuali;

/**
 * Classe per rappresentare un piano con più stanze
 * @author Matteo Ghidini
 *
 */
public class Mappa {

	//SIGNIFICA 1/POSSIBILITA_SPAWN_CHEST che spawni!
	private static final int POSSIBILITA_SPAWN_CHEST = 200;

	//SIGNIFICA 1/POSSIBILITA_SPAWN_MOSTRO che spawni!
	private static final int POSSIBILITA_SPAWN_MOSTRO = 50;

	//SIGNIFICA 1/POSSIBILITA_SPAWN_BOSS che spawni! NB spawnerà sempre 1 e 1 solo
	private static final int POSSIBILITA_SPAWN_BOSS = 100;

	//le grandezze altezza e larghezza stanza saranno prese tra MIN e MAX
	private static final int GRANDEZZA_STANZA_MAX = 40;
	private static final int GRANDEZZA_STANZA_MIN = 20;

	//numerodi stanze casualmente scelto tra il min e max
	private static final int NUMERO_MINIMO_STANZE = 2;
	private static final int NUMERO_MASSIMO_STANZE = 3;





	private List<String[][]> mappa;
	private Personaggio player;
	
	

	public Personaggio getPlayer() {
		return player;
	}

	public void setPlayer(Personaggio player) {
		this.player = player;
	}

	public List<String[][]> getMappa() {
		return mappa;
	}

	public void setMappa(List<String[][]> mappa) {
		this.mappa = mappa;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////COSTRUTTORE
	/**Creazione della mappa casuale
	 * @param mappa
	 */
	public Mappa(Personaggio _player) {
		super();
		this.player=_player;
		this.mappa = creaMappa();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////FINE COSTRUTTORE


	/**
	 * crea una list di stanze
	 * @return
	 */
	private List<String[][]> creaMappa() {

		List<String[][]> map = new LinkedList<String[][]>();

		int numeroStanze = EstrazioniCasuali.estraiIntero(NUMERO_MINIMO_STANZE, NUMERO_MASSIMO_STANZE);

		for(int i=0; i< numeroStanze; i++) {
			map.add(creaStanza());
		}

		return map;
	}

	/**crea una stanza: <br>
	 * crea: prima vuota<br>
	 * aggiuge i bordi <br>
	 * aggiungeentrata e uscita <br>
	 * aggiunge il personaggio <br>
	 * aggiunge chest <br>
	 * aggiunge mostri <br>
	 * aggiunge boss <br>
	 * aggiunge scale <br>
	 * aggiunge finalBoss in caso.
	 * 
	 * @return
	 */
	private String[][] creaStanza() {
		String[][] stanza = new String[EstrazioniCasuali.estraiIntero(GRANDEZZA_STANZA_MIN,GRANDEZZA_STANZA_MAX)][EstrazioniCasuali.estraiIntero(GRANDEZZA_STANZA_MIN, GRANDEZZA_STANZA_MAX)];

		//impostazione a vuoto di tutto
		for(int i=0; i< stanza.length-1; i++) {
			for(int j=0; j<stanza[i].length; j++) {
				stanza[i][j] = ValoriStanza.VUOTO.value;
			}
		}
		/////////////////////////////////////////////////////////////////////inizio muri
		for(int i=0; i<stanza[0].length; i++) 
			stanza[0][i] = ValoriStanza.MURO.value;
		for(int i=0; i<stanza[stanza.length-1].length; i++)
			stanza[stanza.length-1][i] = ValoriStanza.MURO.value;
		for(int j=0; j<stanza.length; j++)
			stanza[j][0] = ValoriStanza.MURO.value;
		for(int j=0; j<stanza.length; j++)
			stanza[j][stanza[j].length-1] = ValoriStanza.MURO.value;

		stanza[0][stanza[0].length/2] = "^";  //passaggio all'altra stanza
		stanza[stanza.length-1][stanza[0].length/2] = "_"; //entrata
		/////////////////////////////////////////////////////////////////////fine muri

		
		/////////////////////////////////////////////////personaggio
		stanza[stanza.length-2][stanza[0].length/2] = ValoriStanza.GIOCATORE.value;
		
		
		/////////////////////////////////////////////////chest
		for(int i=0; i< stanza.length-1; i++) {
			for(int j=0; j<stanza[i].length; j++) {
				if(stanza[i][j].equals(ValoriStanza.VUOTO.value)) 
					if(EstrazioniCasuali.estraiIntero(1, POSSIBILITA_SPAWN_CHEST) == 1 )  stanza[i][j] = ValoriStanza.CHEST.value;
			}
		}

		
		
		////////////////////////////////////////////////mostri
		for(int i=0; i< stanza.length-1; i++) {
			for(int j=0; j<stanza[i].length; j++) {
				if(stanza[i][j].equals(ValoriStanza.VUOTO.value)) 
					if(EstrazioniCasuali.estraiIntero(1, POSSIBILITA_SPAWN_MOSTRO) == 1 )  stanza[i][j] = ValoriStanza.MOSTRO.value;
			}
		}

		
		
		////////////////////////////////////////////////boss
		boolean bossSpawned = false;

		for(int i=0; i< stanza.length-1; i++) {
			for(int j=0; j<stanza[i].length; j++) {
				if(stanza[i][j].equals(ValoriStanza.VUOTO.value)) 
					if(EstrazioniCasuali.estraiIntero(1, POSSIBILITA_SPAWN_BOSS) == 1 ) {
						stanza[i][j] = ValoriStanza.BOSS.value;
						bossSpawned =true;
						break;
					}
			}
			if(bossSpawned) break;
		}

		return stanza;
	}



	/**
	 * stampa la n.esima stanza
	 * @param numeroStanza
	 * @return
	 */
	public StringBuffer stampaStanza(int numeroStanza) {

		StringBuffer stampa = new StringBuffer("");

		for(int i=0; i< mappa.get(numeroStanza).length; i++) {
			for(int j=0; j<mappa.get(numeroStanza)[i].length; j++) {
				stampa.append(mappa.get(numeroStanza)[i][j]);
			}
			stampa.append("\n");
		}
		return stampa;
	}

	/**
	 * stampa tutto il piano NB DEVI GIRARE IL CICLO FOR
	 * @return
	 */
	public StringBuffer stampaMappaCompleta() {

		StringBuffer stampa = new StringBuffer("");

		for(int k=0; k<mappa.size(); k++) {
			stampa.append(stampaStanza(k));
			if(k<mappa.size()-1)stampa.append("\tV\n\tV\n\tV\n");
		}

		return stampa;
	}
}




