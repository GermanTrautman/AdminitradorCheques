package uade.ioo.modelo;

import java.util.Calendar;

public class ChequeDeTerceros extends Cheque {
	
	private EstadoChequeEnum estadoCheque;

	public ChequeDeTerceros(int numero, double monto, Calendar fecha) {
		super(numero, monto, fecha);
		estadoCheque = EstadoChequeEnum.RECIBIDO;
	}
	
	public EstadoChequeEnum getEstadoCheque() {
		return estadoCheque;
	}

	public void setEstadoCheque(EstadoChequeEnum estadoCheque) {
		this.estadoCheque = estadoCheque;
	}

}
