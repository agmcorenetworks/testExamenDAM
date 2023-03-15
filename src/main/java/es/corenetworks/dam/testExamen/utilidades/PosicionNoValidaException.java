package es.corenetworks.dam.testExamen.utilidades;

public class PosicionNoValidaException extends Exception {

	String msj;
	
	public PosicionNoValidaException (String msj) {
		
		super(msj);
		
	}
}
