package esameArnaldoAdventureTime;

public enum ValoriStanza {
	VUOTO("."), MURO("#"), 
	MOSTRO("M"), GIOCATORE("O"), CHEST("C"), PRINCESS("K"), DIJKSTRA("D"), SCALE_SU("T"), SCALE_GIU("t"), BOSS("B"),
	M_BATTLE("m"), D_BATTLE("d"), B_BATTLE("b"), P_FOUND("k"), C_FOUND("c");
	
	public final String value;
	
	ValoriStanza(String _value) {
		this.value = _value;
	}

}
