package uade.ioo.vista.formulario;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaPagoConCheque;
import uade.ioo.vista.modeloVista.MiModeloChequesDisponibles;
import uade.ioo.vista.modeloVista.MiModeloChequesDisponiblesPorVencer;

public class JFormularioChequesPorVencer extends JFormularioBase implements IVistaPagoConCheque {

	private static final long serialVersionUID = 1L;

	JTextField fechaVencimiento = new JTextField("Fecha de vencimiento");
	JTable tabla;

	public JFormularioChequesPorVencer(AdministradorPagos modelo) {
		super(modelo);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		this.getContentPane().add(new JLabel("Cheques de terceros por vencer (48hs):"));
		this.getContentPane().add(fechaVencimiento);
		this.tabla = new JTable(new MiModeloChequesDisponiblesPorVencer(modelo, this.getMontoAPagar()));
		tabla.setSize(200, 100);
		this.getContentPane().add(tabla);
		
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!(e.getValueIsAdjusting() || tabla.getSelectedRow() <= 0)) {

					int idCheque = (int) (tabla.getValueAt(tabla.getSelectedRow(), 0) != "N/A"
							? tabla.getValueAt(tabla.getSelectedRow(), 0)
							: -1);
					if (idCheque > 0 && getMontoAPagar() > 0) {
						int result = JOptionPane.showConfirmDialog(null, "Quiere depositar este cheque?", "Confirmacion",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							getModelo().depositarCheque(idCheque);
							actualizar();
						}
					}
				}
			}
		});

	}

	@Override
	public void actualizar() {
		tabla.setModel(new MiModeloChequesDisponiblesPorVencer(getModelo(), this.getMontoAPagar()));
	}

	@Override
	public double getMontoAPagar() {
		return 0;
	}

	@Override
	public JTable getTabla() {
		return tabla;
	}

}
