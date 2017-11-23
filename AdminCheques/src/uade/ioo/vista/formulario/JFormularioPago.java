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
import uade.ioo.vista.controlador.PagarChequeController;
import uade.ioo.vista.modeloVista.MiModeloChequesDisponibles;

public class JFormularioPago extends JFormularioBase implements IVistaPagoConCheque {

	private static final long serialVersionUID = 1L;

	private JTextField txtMontoPagar = new JTextField();
	private JButton btnPagar = new JButton("Determinar Cheques a Usar");
	private JTable tabla;

	public JFormularioPago(AdministradorPagos modelo) {
		super(modelo);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		this.getContentPane().add(new JLabel("Monto a Pagar:"));
		this.getContentPane().add(txtMontoPagar);
		this.getContentPane().add(btnPagar);
		btnPagar.setMaximumSize(getMaximumSize());
		btnPagar.addActionListener(new PagarChequeController(this.getModelo(), this));

		this.tabla = new JTable(new MiModeloChequesDisponibles(modelo, this.getMontoAPagar()));
		this.getContentPane().add(tabla);

		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!(e.getValueIsAdjusting() || tabla.getSelectedRow() < 0 ) ) {

					int result = JOptionPane.showConfirmDialog(null, "Quiere usar este cheque?", "Confirmacion",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						int idCheque = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
						Double monto = (Double) tabla.getValueAt(tabla.getSelectedRow(), 1);
						getModelo().actualizarEstadoCheque(idCheque, monto);
						actualizar();
					}
				}
			}
		});
	}

	@Override
	public void actualizar() {
		tabla.setModel(new MiModeloChequesDisponibles(getModelo(), this.getMontoAPagar()));
	}

	@Override
	public double getMontoAPagar() {
		if (!txtMontoPagar.getText().isEmpty()) {

			return Double.parseDouble((txtMontoPagar.getText()));
		}
		return 0;
	}

	@Override
	public JTable getTabla() {
		return this.tabla;
	}

}
