package co.edu.uniquindio.poo.application;

import java.util.Scanner;

import co.edu.uniquindio.poo.model.Biblioteca;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        
        Biblioteca biblioteca = new Biblioteca("uniquindio");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al menu interactivo");
        System.out.println("1. crear bibliotecario");
        System.out.println("2. crear estudiante");
        System.out.println("3. crear libro");
        System.out.println("4. consultar los datos de un libro por su codigo");
        System.out.println("5. reemplazar libro");
        System.out.println("6. crear prestamo");
        System.out.println("7. adicionar libro al prestamo");
        System.out.println("8. consultar datos de un prestamo");
        System.out.println("9. total dinero recaudado por la empresa");

        System.out.println("por favor digite una opcion");

        int opcion=scanner.nextInt();


        

    }
}
