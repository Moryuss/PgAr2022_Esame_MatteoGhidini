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
	private static final int NUMERO_MINIMO_STANZE = 2;
	private static final int NUMERO_MASSIMO_STANZE = 3;

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

		//impostazione a vuoto di tutto
		for(int j=0; j< stanza.length-1; j++) {
			for(int k=0; k<stanza[j].length; k++) {
				stanza[j][k] = ValoriStanza.VUOTO.value;
			}
		}
		/////////////////////////////////////////////////inizio muri
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
		/////////////////////////////////////////////////fine muri

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
	 * stampa tutto il piano
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




