package ec.sasf.prueba.Wilber.Alvarez.service.exception;


/**
 * Se lanza cuando se viola una regla de negocio del dominio, por ejemplo:
 * - Programar una funcion con una pelicula INACTIVA.
 * - Reservar mas entradas de las que hay disponibles en la funcion.
 */
public class BusinessRuleException extends RuntimeException {
 
    public BusinessRuleException(String message) {
        super(message);
    }
}