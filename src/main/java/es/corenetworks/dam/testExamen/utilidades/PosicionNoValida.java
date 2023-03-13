package es.corenetworks.dam.testExamen.utilidades;

public class PosicionNoValida extends Exception {

	String msj;
	
	public PosicionNoValida (String msj) {
		
		super(msj);
		
	}
}
