package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;
import java.time.LocalDate;

import co.edu.uniquindio.poo.model.EstadoLibro;
import co.edu.uniquindio.poo.model.Libro;

public class LibroTest {

    private static final  Logger LOG = Logger.getLogger(LibroTest.class.getName());


    /**
     * test para verificar el estado de un libro
     */
    @Test
    public void testCantidadUnidadesDisponibles() {
        LOG.info("iniciando test cantidad unidades disponibles");

        Libro libro = new Libro("la vaca", "1232", "asdf", "carlos", "norma", LocalDate.of(2012, 12, 3), 2, EstadoLibro.DISPONIBLE);  

        libro.cantidadUnidadesDisponibles();
        assertEquals(1, libro.getUnidadesDisponibles());
        assertEquals(EstadoLibro.DISPONIBLE, libro.getEstadoLibro());  

        libro.cantidadUnidadesDisponibles();  
        assertEquals(0, libro.getUnidadesDisponibles());
        assertEquals(EstadoLibro.OCUPADO, libro.getEstadoLibro());  

        libro.cantidadUnidadesDisponibles();  
        assertEquals(0, libro.getUnidadesDisponibles()); 
        assertEquals(EstadoLibro.OCUPADO, libro.getEstadoLibro());  

        LOG.info("finalizando test cantidad unidades disponibles");
    }

    /**
     * test para verificar que los datos de un libro no sean nulos
     */
    @Test
    public void datosNulosEmpleado(){
        LOG.info("iniciando test datos nulos");
        assertThrows(Throwable.class, ()-> new Libro(null, null, null, null, null, null, 0, null));
        LOG.info("finalizando test datos nulos");
    }
    
}
