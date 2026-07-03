package ec.sasf.prueba.Wilber.Alvarez.service.exception;

 
/**
 * Se lanza cuando se busca una entidad (Pelicula, Sala, Funcion, Reserva)
 * por id y no existe en la base de datos.
 */
public class ResourceNotFoundException extends RuntimeException {
 
    public ResourceNotFoundException(String message) {
        super(message);
    }
 
    public static ResourceNotFoundException of(String entidad, Long id) {
        return new ResourceNotFoundException(entidad + " con id " + id + " no fue encontrado(a)");
    }
}