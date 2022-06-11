package esameArnaldoAdventureTime;

import it.unibs.fp.mylib.EstrazioniCasuali;
import it.unibs.fp.mylib.MyMath;

public class Fight {
	
	private Being player;
	private Being nemico;
	
	/**Creazione della battaglia tra il personaggio giocante e tutti i tipi di nemici possibili
	 * @param player
	 * @param nemico
	 */
	public Fight(Being player, Being nemico) {
		super();
		this.player = player;
		this.nemico = nemico;
	}
	
	/**
	 * cuore del combattimento:<br>
	 * se il nemico muore viene ucciso, altrimenti gli viene tolta della vita
	 * @return
	 */
	public String combattimento() {
		
		int dannoGiocatoreAMostro=Fight.danno(player,nemico);
		if(nemico.getVita()<= dannoGiocatoreAMostro) {
			nemico.morto();
			return String.format("%s ha ucciso il mostro %s facendo %d danni", player.getNome(), nemico.getNome(), dannoGiocatoreAMostro);
		}
		else if(nemico.getVita()> dannoGiocatoreAMostro) {
			player.infliggiDanno(nemico, dannoGiocatoreAMostro);
			return String.format("%s ha ferito il mostro %s facendo %d danni", player.getNome(), nemico.getNome(), dannoGiocatoreAMostro);
		}
	}

	
	/**
	 * restituisce il danno fatto da p1 a p2
	 * @param p1
	 * @param p2
	 * @return
	 */
	private static int danno(Being p1, Being p2) {
		
		int potenzaP1=1, difesaP2=1;
		
		//impostazione critico;
		double modifier =1;
		double crit = EstrazioniCasuali.estraiIntero(0, 100);
		if(crit<=7.5) modifier = 1.5;
		else if(crit>7.5) modifier =1.0;
		
		
		for(int i=0;i<p1.getInventory().size(); i++) {
			if(p1.getInventory().get(i).getEffetto().equals(Effect.ATKUP)) 
				potenzaP1 =p1.getInventory().get(i).getValue();
		}
		
		for(int i=0;i<p2.getInventory().size(); i++) {
			if(p2.getInventory().get(i).getEffetto().equals(Effect.DEFUP)) 
				difesaP2 = p2.getInventory().get(i).getValue();
		}
		
		double damage = (((2*potenzaP1*p1.getBaseAtk()) / 25*difesaP2) +2) * modifier;
		
		return MyMath.aprossimazione(damage);
		
	}
	
	

}
