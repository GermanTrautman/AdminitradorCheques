package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.ChequeDeTerceros;
import uade.ioo.vista.comportamiento.IVistaAgregarChequeTercero;

public class AgregarChequeTerceroController implements ActionListener {

	private AdministradorPagos modelo;
	private IVistaAgregarChequeTercero vista;
	
	public AgregarChequeTerceroController(AdministradorPagos modelo, IVistaAgregarChequeTercero vista){
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void actionPerformed(ActionEvent arg0) {		
		ChequeDeTerceros cheque = new ChequeDeTerceros(vista.getNumero(), 
				vista.getMonto());
		this.modelo.registrarChequeTerceros(cheque);
		JOptionPane.showMessageDialog(null, "Cheque agregado correctamente");
		vista.reset();
	}

}
