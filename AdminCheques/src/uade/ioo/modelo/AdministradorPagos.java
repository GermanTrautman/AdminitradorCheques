package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.List;

import uade.ioo.observer.Observado;

public class AdministradorPagos extends Observado {

	private List<Cheque> cheques = new ArrayList<Cheque>();

	public void registrarChequeTerceros(ChequeDeTerceros cheque) {
		this.cheques.add(cheque);
		this.notificarObservadores();
	}

	// Por cada cálculo que me solicitan en el enunciado
	// voy a agregar un métido del administrador que lo realice.
	public double getMontoTotalCheques() {
		double result = 0;
		for (Cheque c : this.cheques) {
			result += c.getMonto();
		}
		return result;
	}

	public List<Cheque> getListaDeCheques() {
		return this.cheques;

	}
	
	public List<Cheque> getListaChequeParaPagarMonto(Double monto){
		List<Cheque> chequesTemp = new ArrayList<Cheque>();
		for (int i = 0; i < cheques.size(); i++) {
			if (cheques.get(i).getMonto() > monto) {
				chequesTemp.add(cheques.get(i));
			}
		}
		return chequesTemp;
	}

	public void actualizarEstadoCheque(int idCheque, Double monto) {

		for (int i = 0; i < cheques.size(); i++) {
			if (cheques.get(i).getNumero() == idCheque && (cheques.get(i).getMonto() - monto) == 0) {
				cheques.get(i).setActive(false);
			}
		}
	}

}
