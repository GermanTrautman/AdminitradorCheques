package uade.ioo.principal;

import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.formulario.JFormularioPrincipal;

public class Programa {

	public static void main(String[] args) {
		AdministradorPagos modelo = new AdministradorPagos();
		JFrame f = new JFormularioPrincipal(modelo);
		f.setVisible(true);
	}

}
