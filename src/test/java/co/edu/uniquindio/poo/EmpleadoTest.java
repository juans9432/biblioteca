package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Empleado;

import java.util.logging.Logger;

public class EmpleadoTest {

    private static final  Logger LOG = Logger.getLogger(EmpleadoTest.class.getName());

    /**
     * test para verificar que los datos de un empleado no sean nulos
     */
    @Test
    public void datosNulosEmpleado(){
        LOG.info("iniciando test datos nulos");
        assertThrows(Throwable.class, ()-> new Empleado(null, null, null, null, 0, 0));
        LOG.info("finalizando test datos nulos");
    }

    /**
     * test para  verificar que los datos de un empleado no esten vacios
     */
    @Test
    public void datosCompletosEmpleado(){
        LOG.info("iniciando test datos vacios");
        Empleado empleado = new Empleado("juan", "1115183021", "3217774651", "juanrew@gmail.com", 1000000, 5);
        assertEquals("juan", empleado.getNombre());
        assertEquals("1115183021", empleado.getCedula());
        assertEquals("3217774651", empleado.getTelefono());
        assertEquals("juanrew@gmail.com", empleado.getCorreo());
        assertEquals(1000000, empleado.getSalario());
        assertEquals(5, empleado.getAntiguedad());
        LOG.info("iniciando test datos vacios");
    }

    
}
