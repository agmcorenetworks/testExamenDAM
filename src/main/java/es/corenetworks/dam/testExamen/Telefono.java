package es.corenetworks.dam.testExamen;

public class Telefono {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        try {
            agenda.añadirNumero(12345678);
            agenda.añadirNumero(23456789);
            agenda.añadirNumero(34567890);
            agenda.añadirNumero(45678901);
            agenda.añadirNumero(56789012);
            agenda.añadirNumero(67890123);
            agenda.añadirNumero(78901234);
            agenda.añadirNumero(89012345);
            agenda.añadirNumero(90123456);
            agenda.añadirNumero(12345234); // Este número no se añadirá porque tiene longitud distinta de 8

            int posicionNumero = agenda.buscarNumero(56789012);
            System.out.println("El número 56789012 está en la posición " + posicionNumero);

            agenda.eliminarNumero(56789012);

            System.out.println("El número 56789012 ha sido eliminado");

            int numeroEnPosicion = agenda.getNumeroEnPosicion(1);
            System.out.println("El número en la posición 1 es " + numeroEnPosicion);

            boolean estaVacia = agenda.estaVacia();
            System.out.println("La agenda está vacía: " + estaVacia);

            agenda.añadirNumero(65378518);
            numeroEnPosicion = agenda.getNumeroEnPosicion(4);
            System.out.println(numeroEnPosicion);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
