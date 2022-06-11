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

	//le grandezze altezza e larghezza stanza saranno prese tra MIN e MAX
	private static final int GRANDEZZA_STANZA_MAX = 40;
	private static final int GRANDEZZA_STANZA_MIN = 20;

	//numerodi stanze casualmente scelto tra il min e max
	private static final int NUMERO_MINIMO_STANZE = 1;
	private static final int NUMERO_MASSIMO_STANZE = 2;
	
	private List<String[][]> mappa;

	public List<String[][]> getMappa() {
		return mappa;
	}

	public void setMappa(List<String[][]> mappa) {
		this.mappa = mappa;
	}

	/**Creazione della mappa casuale
	 * @param mappa
	 */
	public Mappa() {
		super();
		this.mappa = creaMappa();
	}

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

	/**crea una stanza
	 * 
	 * @return
	 */
	private String[][] creaStanza() {
		String[][] stanza = new String[EstrazioniCasuali.estraiIntero(GRANDEZZA_STANZA_MIN,GRANDEZZA_STANZA_MAX)][EstrazioniCasuali.estraiIntero(GRANDEZZA_STANZA_MIN, GRANDEZZA_STANZA_MAX)];


		/////////////////////////////////////////////////inizio muri
		for(int i=0; i<stanza[0].length; i++) 
			stanza[0][i] = "#";
		for(int i=0; i<stanza[stanza.length-1].length; i++)
			stanza[stanza.length-1][i] = "#";
		for(int j=0; j<stanza.length; j++)
			stanza[j][0] = "#";
		for(int j=0; j<stanza.length; j++)
			stanza[0][stanza[j].length-1] = "#";
		
		stanza[0][stanza[0].length/2] = "^";  //passaggio all'altra stanza
		
		/////////////////////////////////////////////////fine muri
		/*
		for(int j=1; j< this.road.length-1; j++) {
			for(int k=0; k<this.road[j].length; k++) {
				this.road[j][k] = Valori.VUOTO.value;
			}
		}

		for(int j=2; j< this.road.length-1; j=j+2) {
			for(int k=0; k<this.road[j].length; k=k+2) {
				this.road[j][k] = Valori.LINE.value;
			}
		 */
		return stanza;
	}



	/**
	 * stampa tutto il piano
	 * @return
	 */
	public String stampaMappaCompleta() {

		String stampa = new String("");
		
		for(int k=0; k<mappa.size(); k++) {
			for(int i=0; i< mappa.get(k).length; i++) {
				for(int j=0; j<mappa.get(k)[i].length; j++) {
					stampa.concat(mappa.get(k)[i][j]);
				}
				stampa.concat("\n");
			}
			stampa.concat("\tV\n\tV\n\tV");
		}

		return stampa;
	}
}




