package uade.ioo.vista.formulario;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.modeloVista.MiModeloChequesDisponibles;

public class JFormularioChequesPorVencer extends JFormularioBase {

	JTextField fechaVencimiento = new JTextField("Fecha de vencimiento");
	JButton btnDepositar = new JButton("Depositar");
	JTable tabla;

	public JFormularioChequesPorVencer(AdministradorPagos modelo) {
		super(modelo);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		this.getContentPane().add(new JLabel("Monto a Pagar:"));
		this.getContentPane().add(fechaVencimiento);
		this.getContentPane().add(btnDepositar);
		btnDepositar.setSize(200, 100);
//		this.tabla = new JTable(new MiModeloChequesDisponibles(modelo));
		tabla.setSize(200, 100);
		this.getContentPane().add(tabla);

	}

	private static final long serialVersionUID = 1L;

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

}
