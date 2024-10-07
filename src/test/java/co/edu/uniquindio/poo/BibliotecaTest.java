package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

import co.edu.uniquindio.poo.model.Biblioteca;
import co.edu.uniquindio.poo.model.EstadoLibro;
import co.edu.uniquindio.poo.model.Libro;
import java.util.LinkedList;
import java.time.LocalDate;

public class BibliotecaTest {

    private static final  Logger LOG = Logger.getLogger(BibliotecaTest.class.getName());

    /**
     * test para verificar el metodo qeu consulta los datos de un libro
     */
    @Test
    public void testConsultarDatosLibro() {
        LOG.info("iniciando test consultar datos libro");

        LinkedList<Libro> listaLibros = new LinkedList<>();
        Libro libro1 = new Libro("la vaca", "1232", "asdf", "carlos", "norma", LocalDate.of(2012, 12, 3), 2, EstadoLibro.DISPONIBLE);
        Libro libro2 = new Libro("cuentos", "1233", "asdd", "pablo", "norma", LocalDate.of(2012, 12, 6), 7, EstadoLibro.DISPONIBLE);
        listaLibros.add(libro1);
        listaLibros.add(libro2);

        Biblioteca biblioteca = new Biblioteca("UQ");
        biblioteca.agregarLibros(listaLibros);

        String resultadoEsperado = "Código: 1232, Título: la vaca, Autor: carlos, isbn: asdf, Editorial: norma, unidades disponibles: 2";
        String resultadoObtenido = biblioteca.consultarDatosLibro("1232");
        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoObtenido = biblioteca.consultarDatosLibro("00000");
        assertEquals("libro no encontrado", resultadoObtenido);

        LOG.info("finalizando test consultar datos libro");
    }

    /**
     * test para verificar el metodo que reemplaza un libro 
     */
    @Test
    public void testReemplazarLibro() {
        LOG.info("iniciando test reemplazar libro");

        LinkedList<Libro> listaLibros = new LinkedList<>();
        Libro libro1 = new Libro("la vaca", "1232", "asdf", "carlos", "norma", LocalDate.of(2012, 12, 3), 2, EstadoLibro.DISPONIBLE);
        Libro libro2 = new Libro("cuentos", "1233", "asdd", "pablo", "norma", LocalDate.of(2012, 12, 6), 7, EstadoLibro.DISPONIBLE);
        listaLibros.add(libro1);
        listaLibros.add(libro2);

        Biblioteca biblioteca = new Biblioteca("UQ");
    
        biblioteca.agregarLibros(listaLibros);

        Libro nuevoLibro = new Libro("novela", "9999", "nqwe", "maria", "planet", LocalDate.of(2015, 5, 10), 10, EstadoLibro.DISPONIBLE);

        Libro libroReemplazado = biblioteca.reemplazarLibro("la vaca", nuevoLibro);

        assertEquals(nuevoLibro, libroReemplazado);

        assertEquals(nuevoLibro, listaLibros.get(0));

        assertEquals(libro2, listaLibros.get(1));

        LOG.info("finalizando test reemplazar libro");
    }
    
}
