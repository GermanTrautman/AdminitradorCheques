package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Chequera {

	private List<ChequePropio> chequesPropios;

	public Chequera(List<ChequePropio> chequesPropios) {
		super();
		this.chequesPropios = chequesPropios;
	}
	
	public Chequera() {
		chequesPropios = new ArrayList<ChequePropio>();
	}

	public List<ChequePropio> getCheques() {
		return chequesPropios;
	}

	public void setChequesPropios(List<ChequePropio> chequesPropios) {
		this.chequesPropios = chequesPropios;
	}

	

}
