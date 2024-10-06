package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.DetallePrestamo;

public class DetallePrestamoTest {

    private static final  Logger LOG = Logger.getLogger(DetallePrestamo.class.getName());

    /**
     * test para verificar que los datos de un detallePrestamo no sean nulos
     */
    @Test
    public void datosNulosDetallePrestamo(){
        LOG.info("iniciando test datos nulos");
        assertThrows(Throwable.class, ()-> new DetallePrestamo(0.0, 0));
        LOG.info("finalizando test datos nulos");
    }

    /**
     * test para verificar que los datos de un detallePrestamo esten completos
     */
    @Test 
    public void datosCompletosDetallePrestamo(){
        LOG.info("iniciando test datos completos");
        DetallePrestamo detallePrestamo= new DetallePrestamo(13.45, 5);
        assertEquals(13.45, detallePrestamo.getSubtotal());
        assertEquals(5, detallePrestamo.getCantidad());
        LOG.info("finalizando test datos completos");
    }
    
}
