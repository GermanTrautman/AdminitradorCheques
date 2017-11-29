package uade.ioo.vista.modeloVista;

import java.util.Calendar;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.ChequeDeTerceros;
import uade.ioo.modelo.EstadoChequeEnum;

public class MiModeloChequesDisponiblesPorVencer extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Cheque> cheques;

	public MiModeloChequesDisponiblesPorVencer(AdministradorPagos admin) {
		cheques = admin.getListaDeCheques();
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
				return "Fecha de Vencimiento (DD-MM-YYYY)";
			}
		} else {
			// se muestran los cheques a vencer en 48hs
			long diff = cheques.get(fila - 1).getCalendar().getTime().getTime()
					- Calendar.getInstance().getTime().getTime();
			long horas = diff / (1000 * 60 * 60 * 24);
			if (cheques.get(fila - 1).isActive() && horas >= 0 && horas <= 48
					&& ((ChequeDeTerceros) cheques.get(fila - 1)).getEstadoCheque() != EstadoChequeEnum.DEPOSITADO) {
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
		}

		return "N/A";
	}

}
