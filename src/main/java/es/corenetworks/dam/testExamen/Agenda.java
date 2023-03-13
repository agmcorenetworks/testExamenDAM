package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.*;
import es.corenetworks.dam.testExamen.utilidades.Constantes.*;

public class Agenda {
    private int[] agenda;
    private static int numeroContactos;

    public Agenda() {
        this(Constantes.TAMAÑO_AGENDA);
    }

    public Agenda(int tamaño) {
        agenda = new int[tamaño];
    }

    public int getTamanyoAgenda() {
        return numeroContactos;
    }

    public void añadirNumero(int numero) throws NumeroNoValidoException {
        if (Utilidades.getLongitudNumero(numero) != 8) {
            throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
        }

        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] == 0) {
                agenda[i] = numero;
                numeroContactos++;
                return;
            }
        }
    }

    public int buscarNumero(int numero) throws NumeroNotFoundException {
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] == numero) {
                return i;
            }
        }

        throw new NumeroNotFoundException(Constantes.NUMERO_NOT_FOUND_EXCEPTION);
    }

    public boolean eliminarNumero(int numero) throws NumeroNoValidoException {
        if (Utilidades.getLongitudNumero(numero) != 8) {
            throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
        }

        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] == numero) {
                agenda[i] = 0;
                numeroContactos--;
                return true;
            }
        }

        return false;
    }

    public int getNumeroEnPosicion(int posicion) throws PosicionNoValidaException, PosicionVaciaException {
        if (posicion < 0 || posicion >= agenda.length) {
            throw new PosicionNoValidaException(Constantes.POSICION_NO_VALIDA_EXCEPTION);
        }

        if (agenda[posicion] == 0) {
            throw new PosicionVaciaException(Constantes.POSICION_VACIA_EXCEPTION);
        }

        return agenda[posicion];
    }

    public boolean estaVacia() {
        return numeroContactos == 0;
    }
}
