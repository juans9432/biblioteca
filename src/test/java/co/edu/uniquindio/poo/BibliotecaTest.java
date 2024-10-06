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

    @Test
public void testReemplazarLibro() {
    LOG.info("iniciando test reemplazar libro");

    // Configuración inicial: crear una lista de libros
    LinkedList<Libro> listaLibros = new LinkedList<>();
    Libro libro1 = new Libro("la vaca", "1232", "asdf", "carlos", "norma", LocalDate.of(2012, 12, 3), 2, EstadoLibro.DISPONIBLE);
    Libro libro2 = new Libro("cuentos", "1233", "asdd", "pablo", "norma", LocalDate.of(2012, 12, 6), 7, EstadoLibro.DISPONIBLE);
    listaLibros.add(libro1);
    listaLibros.add(libro2);

    // Clase que contiene el método reemplazarLibro (ej. Biblioteca)
    Biblioteca biblioteca = new Biblioteca("UQ");
    
    // Agregamos los libros a la biblioteca
    biblioteca.agregarLibros(listaLibros);

    // Crear un nuevo libro para reemplazar
    Libro nuevoLibro = new Libro("novela", "9999", "nqwe", "maria", "planet", LocalDate.of(2015, 5, 10), 10, EstadoLibro.DISPONIBLE);

    // Reemplazar el libro con título "la vaca" por el nuevo libro
    Libro libroReemplazado = biblioteca.reemplazarLibro("la vaca", nuevoLibro);

    // Verificar que el libro fue reemplazado correctamente
    assertEquals(nuevoLibro, libroReemplazado);

    // Verificar que la lista contiene el nuevo libro en lugar del antiguo
    assertEquals(nuevoLibro, listaLibros.get(0));

    // Verificar que el libro con el título "cuentos" sigue existiendo en la lista
    assertEquals(libro2, listaLibros.get(1));

    LOG.info("finalizando test reemplazar libro");
}
    
}
