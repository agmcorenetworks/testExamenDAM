package es.corenetworks.dam.testExamen.utilidades;

public class Utilidades {
    public static int getLongitudNumero(int numero) {
        if (numero == 0) {
            return 1; 
        }
        
        int longitud = 0;
        while (numero != 0) {
            longitud++;
            numero /= 10; 
        }
        return longitud;
    }
}

