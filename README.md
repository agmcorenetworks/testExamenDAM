# simulacro examen DAM

Crear el paquete es.corenetworks.dam.testExamen
Crear el paquete es.corenetworks.dam.testExamen.utilidades

dentro del paquete es.corenetworks.dam.testExamen.utilidades crear:

una clase Constantes con las siquientees constantes estaticas

	POSICION_VACIA_EXCEPTION = "No hay numero en esa posicion";
	POSICION_NO_VALIDA_EXCEPTION = "La posicion no es valida";
	NUMERO_NO_VALIDO_EXCEPTION = "Numero no valido";
	TAMAÑO_AGENDA=100;
	NUMERO_NOT_FOUND_EXCEPTION="No se ha encontrado el numero";

Crear las siguientes excepciones
NumeroNotFoundException, NumeroNoValidoException, PosicionNoValidaException, PosicionVaciaException

Crea la clase Utilidades con los siguientes metodos estaticos:

- getLongitudNumero que recibe un entero y devuelve un entero con el numero de digitos del numero que se le pasa como parametro


Dentro del paquete Crear el paquete es.corenetworks.dam.testExamen crear:

Clase Agenda, esta clase contiene: 
- un atributo privado agenda que será un array de enteros 
- un atributo estatico para contar los elementos de la agenda
- un constructor sin parametros, que dara como tañaño al array dela agenda el dado por la constante TAMAÑO_AGENDA
- un constructor con un parametro que será el tamaño de la agenda
- un metodo getTamanyoAgenda que devuelve el tamaño de la agenda como el numero de contactos actuales(numeros de telefono guardados)
- un metodo añadirNumero que recibe como parametro un numero de telefono y lo guarda en la primera posicion libre de la agenda, una posicion esta libre si contiene un cero, si la longitud del numero es disinto de 8 lanzará la excepcion NUMERO_NO_VALIDO_EXCEPTION, en otro caso guardará el numero
- un metodo buscarNumero que busca un numero en el array de la agenda y devuelve la posicion del array en la que está el numero, si no encuentra el numero lanzará la excepcion NUMERO_NOT_FOUND_EXCEPTION
- un metodo eliminarNumero que recibe un numero de telfono y lo elimina de la agenda (volviendo a poner un cero en su posicion) si el numero recibido no es valido (no tiene 8 digitos) lanzará la excepcion NUMERO_NO_VALIDO_EXCEPTION la funcion devuelve true si ha borrado el numero o false si no existe el numero
-  un metodo getNumeroEnPosicion que recibe un entero que representa la posicoin en el array y devuelve el numero en esa posicion del array, si la posicion recibida no es una posicion valida del array lanzará una excepcion POSICION_NO_VALIDA_EXCEPTION, si la posicion está vacia lanzará un POSICION_VACIA_EXCEPTION
- un metodo estaVacia sin parametros que devuelve true si no hay numeros guardados en la agenda y false en otro caso

Clase Telefono, que crea una agenda y utiliza los metodos para guardar distintos numeros de telefono en un metodo main
