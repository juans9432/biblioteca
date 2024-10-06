package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.EstadoLibro;
import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Libro;
import co.edu.uniquindio.poo.model.Prestamo;

public class PrestamoTest {

    private static final  Logger LOG = Logger.getLogger(PrestamoTest.class.getName());

    /**
     * test para verificar que los datos de un prestamo no sean nulos
     */
    @Test
    public void datosNulosPersona(){
        LOG.info("iniciando test datos nulos");
        assertThrows(Throwable.class, ()-> new Prestamo(0, null, null, null, null, null, null));
        LOG.info("finalizando test datos nulos");
    }

    /**
     * test para verificar que los datos de un prestamo esten completos
     */
    @Test 
    public void datosCompletosPrestamo(){
        LOG.info("iniciando test datos completos");

        Empleado empleado = new Empleado("alex", "1112131432", "3106758456", "alex@gmail.com", 900000, 3);
        Estudiante estudiante = new Estudiante("miguel", "1113124567", "3109876543", "miguelito@gmail.com");
        Libro libro = new Libro("lady masacre", "0987", "jh54", "mario mendoza", "norma", LocalDate.of(2016, 10, 15), 15, EstadoLibro.DISPONIBLE);

        Prestamo prestamo = new Prestamo(5000, "3456", LocalDate.of(2023, 03, 16), LocalDate.of(2023, 03, 20), estudiante, empleado, libro);
        assertEquals(5000, prestamo.getCosto());
        assertEquals("3456", prestamo.getCodigo());
        assertEquals(LocalDate.of(2023, 03, 16), prestamo.getFechaEntrega());
        assertEquals(LocalDate.of(2023, 03, 20), prestamo.getFechaPrestamo());
        assertEquals(estudiante, prestamo.getEstudiante());
        assertEquals(empleado, prestamo.getEmpleado());
        assertEquals(libro, prestamo.getLibro());

        LOG.info("finalizando test datos completos");
    }
    
}
