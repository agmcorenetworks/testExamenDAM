package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.*;

public class Telefono {
    public static void main(String[] args) {
        Agenda agenda = new Agenda(10);
        
        try {
            agenda.añadirNumero(12345678);
            agenda.añadirNumero(66666666);
            agenda.añadirNumero(87654321);
            agenda.añadirNumero(23983266);
            agenda.añadirNumero(76978954);
            
            System.out.println("Tamanyo agenda: " + agenda.getTamanyoAgenda());
            
            int posicion = agenda.buscarNumero(66666666);
            System.out.println("El numero de telefono 66666666 esta en la posicion: " + posicion);
            
            boolean estaEliminado = agenda.eliminarNumero(87654321);
            if(estaEliminado) {
                System.out.println("El telefono 87654321 fue eliminado de la agenda");
            } else {
                System.out.println("El telefono 87654321 no se encontró en la agenda");
            }
            
            agenda.getNumeroEnPosicion(1);
            
            if(agenda.estaVacia()) {
                System.out.println("La agenda esta vacia");
            } else {
                System.out.println("La agenda contiene numeros de telefono");
            }
        } catch (NumeroNoValidoException e) {
            System.out.println(e.getMessage());
        } catch (NumeroNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (PosicionNoValidaException e) {
            System.out.println(e.getMessage());
        } catch (PosicionVaciaException e) {
            System.out.println(e.getMessage());
        }
    }
}
