package uade.ioo.vista.modeloVista;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;

public class MiModeloChequesDisponibles extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Cheque> cheques;
	private Double montoAPagar;

	public MiModeloChequesDisponibles(AdministradorPagos admin, Double montoAPagar) {
		cheques = admin.getListaDeCheques();
		this.montoAPagar = montoAPagar;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}

	public int getColumnCount() {

		return 3;
	}

	public int getRowCount() {
		return this.cheques.size() + 1;
	}

	public Object getValueAt(int fila, int col) {
		if (fila == 0) {
			if (col == 0) {
				return "Numero De Cheque";
			}
			if (col == 1) {
				return "Monto";
			}
			if (col == 2) {
				return "Fecha de Vencimiento (YYYY-MM-DD)";
			}
		}
		//if (cheques.get(fila - 1).isActive() && cheques.get(fila - 1).getMonto() >= this.montoAPagar) {
		if (cheques.get(fila - 1).isActive()) {
			if (col == 0 && fila != 0) {
				return (Integer) cheques.get(fila - 1).getNumero();
			}
			if (col == 1 && fila != 0) {
				return cheques.get(fila - 1).getMonto();
			}
			if (col == 2 && fila != 0) {
				return cheques.get(fila - 1).getDate();
			}
		}
		return "N/A";
	}

}
