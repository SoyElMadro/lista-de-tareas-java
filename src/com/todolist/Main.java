package com.todolist;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tareas = new ArrayList<>();

        System.out.println("Bienvenido a este To-Do List");

        System.out.println("-----------------------------------------------------------");

        System.out.println("Primero debes crear una tarea.\nIngresa una tarea:");
        String corchetes = "[ ] ";
        String tarea = scanner.nextLine();
        String Tarea = corchetes.concat(tarea);
        tareas.add(Tarea);
        System.out.println("Tarea añadida");

        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Elige una opción:");
            System.out.println("1: Crear tarea");
            System.out.println("2: Mostrar lista de tareas");
            System.out.println("3: Marcar tarea como completada");
            System.out.println("4: Eliminar una tarea");
            System.out.println("5: Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Funciones.crearTarea(tareas, scanner, corchetes);
                    break;
                case 2:
                    Funciones.mostrarTareas(tareas);
                    break;
                case 3:
                    Funciones.marcarCompletada(tareas, scanner);
                    break;
                case 4:
                    Funciones.eliminarTarea(tareas, scanner);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("No has elegido ninguna de las opciones proporcionadas.");
                    System.out.println("Se te volvera a pedir una opción");
                    break;
            }
        }
    }
}