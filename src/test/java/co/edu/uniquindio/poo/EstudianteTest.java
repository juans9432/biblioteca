package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Estudiante;

public class EstudianteTest {

    private static final  Logger LOG = Logger.getLogger(EstudianteTest.class.getName());

    /**
     * test para verificar que los datos de un estudiante no sean nulos
     */
    @Test
    public void datosNulosEstudiante(){
        LOG.info("iniciando test datos nulos");
        assertThrows(Throwable.class, ()-> new Estudiante(null, null, null, null));
        LOG.info("finalizando test datos nulos");
    }

    /**
     * test para  verificar que los datos de un estudiante no esten vacios
     */
    @Test
    public void datosCompletosEstudiante(){
        LOG.info("iniciando test datos vacios");
        Estudiante estudiante = new Estudiante("miguel", "1115183022", "3176927081", "miguelito@gmail.com");
        assertEquals("miguel", estudiante.getNombre());
        assertEquals("1115183022", estudiante.getCedula());
        assertEquals("3176927081", estudiante.getTelefono());
        assertEquals("miguelito@gmail.com", estudiante.getCorreo());
        LOG.info("iniciando test datos vacios");
    }
    
}
