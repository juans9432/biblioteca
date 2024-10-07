package co.edu.uniquindio.poo.application;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.model.Biblioteca;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.EstadoLibro;
import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Libro;
import co.edu.uniquindio.poo.model.Prestamo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        
        Biblioteca biblioteca = new Biblioteca("uniquindio");
    
        int opcion = 0;

        do{
            String input = JOptionPane.showInputDialog(
                null,
                "Bienvenido al menú interactivo\n"
                + "1. Crear bibliotecario\n"
                + "2. Crear estudiante\n"
                + "3. Crear libro\n"
                + "4. Consultar los datos de un libro por su código\n"
                + "5. Reemplazar libro\n"
                + "6. Crear préstamo\n"
                + "7. Consultar datos de un préstamo\n"
                + "8. Total dinero recaudado por la empresa\n"
                + "9. Mostrar estudiante con más préstamos\n"
                + "10. total a pagar a los empleados\n"
                + "11. Salir\n\n"
                + "Por favor, digite una opción:"
            );

            
            opcion=Integer.parseInt(input);

            switch(opcion){
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
                    String cedula = JOptionPane.showInputDialog("Ingrese el número de identificación:");
                    String telefono = JOptionPane.showInputDialog("Ingrese el número de teléfono:");
                    String correo = JOptionPane.showInputDialog("Ingrese el correo electrónico:");
                
                    String salarioInput = JOptionPane.showInputDialog("Ingrese el salario del empleado:");
                    Integer salario = Integer.parseInt(salarioInput);
                
                    String antiguedadExpInput = JOptionPane.showInputDialog("Ingrese los años de experiencia:");
                    Integer antiguedad = Integer.parseInt(antiguedadExpInput);
                
                    Empleado nuevoEmpleado = new Empleado(nombre, cedula, telefono, correo, salario, antiguedad);
            
                    biblioteca.agregarEmpleado(nuevoEmpleado);
                    JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente.");
                    break;
                case 2:
                    String nombreEst = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
                    String cedulaEst = JOptionPane.showInputDialog("Ingrese el número de identificación:");
                    String telefonoEst = JOptionPane.showInputDialog("Ingrese el número de teléfono:");
                    String correoEst = JOptionPane.showInputDialog("Ingrese el correo electrónico:");

                    Estudiante nuevoEstudiante = new Estudiante(nombreEst, cedulaEst, telefonoEst, correoEst);

                    biblioteca.agregarEstudiante(nuevoEstudiante);
                    JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente.");
                    break;
                case 3:
                    String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro:");
                    String codigo = JOptionPane.showInputDialog("Ingrese el codigo del libro:");
                    String isbn = JOptionPane.showInputDialog("Ingrese el isbn del libro:");
                    String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
                    String editorial = JOptionPane.showInputDialog("Ingrese la editorial:");
                    LocalDate fecha = solicitarFecha("ingrese la fecha de publicacion");
                    String unidadesDisponiblesExInput = JOptionPane.showInputDialog("ingrese las unidades disponibles");
                    Integer unidadesDisponibles= Integer.parseInt(unidadesDisponiblesExInput);
                    EstadoLibro estadoSeleccionado = escogerEstadoLibro();
                    JOptionPane.showMessageDialog(null, "Estado seleccionado: " + estadoSeleccionado);

                    Libro nuevoLibro = new Libro(titulo, codigo, isbn, autor, editorial, fecha, unidadesDisponibles, estadoSeleccionado);

                    biblioteca.agregarLibro(nuevoLibro);
                    break;
                case 4:
                    String codigo1 = JOptionPane.showInputDialog("Ingrese el código del libro:");
                    
                    String libroEncontrado = biblioteca.consultarDatosLibro(codigo1);
                
                    if (libroEncontrado != null) {
                        JOptionPane.showMessageDialog(null, libroEncontrado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
                    }
                    break;
                case 5:

                    String tituloReemplazo = JOptionPane.showInputDialog("Ingrese el título del libro a reemplazar:");

                    String nuevoTitulo = JOptionPane.showInputDialog("Ingrese el nuevo título del libro:");
                    String nuevoAutor = JOptionPane.showInputDialog("Ingrese el nuevo autor del libro:");
                    String nuevaEditorial = JOptionPane.showInputDialog("Ingrese la nueva editorial del libro:");
                    LocalDate nuevaFechaPublicacion = LocalDate.of(2023, 10, 1); 

                    Libro nuevoLibro1 = new Libro(nuevoTitulo, "codigo123", "ISBN123", nuevoAutor, nuevaEditorial, nuevaFechaPublicacion, (byte)20, EstadoLibro.DISPONIBLE);

                    Libro libroActualizado = biblioteca.reemplazarLibro(tituloReemplazo, nuevoLibro1);

                    if (libroActualizado != null) {
                        JOptionPane.showMessageDialog(null, "El libro ha sido reemplazado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un libro con el título proporcionado.");
                    }
                    break;
                case 6:
                    String costoInput = JOptionPane.showInputDialog("Ingrese el costo del prestamo:");
                    Integer costo = Integer.parseInt(costoInput);
                    String codigoPrestamo = JOptionPane.showInputDialog("Ingrese el codigo del prestamo:");
                    LocalDate fechaPrestamo = solicitarFecha("fecha del prestamo");
                    LocalDate fechaEntrega = solicitarFecha("fecha de entrega");

                    Estudiante estudiantePrestamo = new Estudiante("juan", "1115183021", "3102345678", "juans@gmail");

                    Empleado empleadoPrestamo = new Empleado("diego", "66543876", "3124567654", "diegobib@gmail", 1000000, 10);

                    Libro libroPrestamo =new Libro("akelarre", "2345", "jh56", "mario mendoza", "norma", LocalDate.of(2019, 3, 16), 23, EstadoLibro.DISPONIBLE);

                    Prestamo nuevoPrestamo = new Prestamo(costo, codigoPrestamo, fechaEntrega, fechaPrestamo, estudiantePrestamo, empleadoPrestamo, libroPrestamo);
                
                    biblioteca.agergarPrestamo(nuevoPrestamo);
                    JOptionPane.showMessageDialog(null, "prestamo agregado exitosamente.");
                    break;
                case 7:
                    String codigoBuscarPrestamo = JOptionPane.showInputDialog("Ingrese el código del prestamo:");
                    
                    String prestamoEncontrado = biblioteca.consultarDatosPrestamo(codigoBuscarPrestamo);
            
                    if (prestamoEncontrado != null) {
                    JOptionPane.showMessageDialog(null, prestamoEncontrado);
                    } else {
                        JOptionPane.showMessageDialog(null, "prestamo no encontrado.");
                    }
                    break;
                case 8:
                    double totalRecaudado = biblioteca.calcularTotalRecaudado();
                    JOptionPane.showMessageDialog(null, "El total recaudado por préstamos es: $" + totalRecaudado);
                    break;
                case 9:
                    Estudiante estudiante = biblioteca.estudianteConMasPrestamos();
                    if (estudiante != null) {
                        JOptionPane.showMessageDialog(null, "El estudiante con más préstamos es: " + estudiante.getNombre());
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay préstamos registrados.");
                    }
                    break;
                case 10:
                    double totalAPagar = biblioteca.calcularTotalAPagarABibliotecarios();
                    JOptionPane.showMessageDialog(null, "El total a pagar a los bibliotecarios es: $" + totalAPagar);
                    break;
                case 11: 
                    JOptionPane.showMessageDialog(null, "saliendo del sistema");
                }
        }while (opcion != 10);
    }

    private static LocalDate solicitarFecha(String mensaje) {
        int dia, mes, anio;

        String diaInput = JOptionPane.showInputDialog(mensaje+ " Ingrese el día:");
        dia = Integer.parseInt(diaInput);

        String mesInput = JOptionPane.showInputDialog(" Ingrese el mes (1-12):");
        mes = Integer.parseInt(mesInput);

        String anioInput = JOptionPane.showInputDialog(" Ingrese el año:");
        anio = Integer.parseInt(anioInput);

        LocalDate fecha = LocalDate.of(anio, mes, dia);

        return fecha;
    }

    private static EstadoLibro escogerEstadoLibro() {
        
        EstadoLibro[] opciones = EstadoLibro.values();
        String[] nombresOpciones = new String[opciones.length];

        for (int i = 0; i < opciones.length; i++) {
            nombresOpciones[i] = opciones[i].name();
        }

        
        String estadoSeleccionado = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione el estado del libro:",
            "Seleccionar Estado",
            JOptionPane.QUESTION_MESSAGE,
            null,
            nombresOpciones,
            nombresOpciones[0]  
        );

        return EstadoLibro.valueOf(estadoSeleccionado);
    }

}
