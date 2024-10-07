package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Persona;

import java.util.logging.Logger;

public class PersonaTest {

    private static final  Logger LOG = Logger.getLogger(PersonaTest.class.getName());

    /**
     * test para verificar que los datos de una persona no sean nulos
     */
    @Test
    public void datosNulosPersona(){
        LOG.info("iniciando test datos nulos");
        assertThrows(Throwable.class, ()-> new Persona(null, null, null, null));
        LOG.info("finalizando test datos nulos");
    }

    /**
     * test para  verificar que los datos de una persona no esten vacios
     */
    @Test
    public void datosVaciosPersona(){
        LOG.info("iniciando test datos vacios");
        assertThrows(Throwable.class, ()-> new Persona("", "", "", ""));
        LOG.info("finalizando test datos vacios");

    }

    
    
}
