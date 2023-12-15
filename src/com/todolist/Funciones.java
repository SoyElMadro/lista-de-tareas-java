package com.todolist;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Funciones {
    static void crearTarea(
        ArrayList<String> tareas,
        Scanner scanner,
        String corchetes
    ) {
        System.out.println("Ingresa la tarea:");
        String tarea = scanner.nextLine();
        String Tarea = corchetes.concat(tarea);
        tareas.add(Tarea);
        System.out.println("Tarea añadida");
    }
    static void mostrarTareas(ArrayList<String> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("La lista de tareas está vacia.");
        } else {
            System.out.println("Mostrando lista...");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i));
            }
        }
    }

    static void marcarCompletada(ArrayList<String> tareas, Scanner scanner) {
        mostrarTareas(tareas);
        System.out.println("Cual tarea quieres marcar como completa?");
        int tareaCompletada = scanner.nextInt() - 1;
        scanner.nextLine();

        if (tareaCompletada < 0 || tareaCompletada >= tareas.size()) {
            System.out.println("No has elegido una opción correcta");
            System.out.println("En caso de que quieras salir, escribe 'SALIR'");
            System.out.println("(si no quieres salir, solo aprieta ENTER.)");
            String salir = scanner.nextLine();
            if (Objects.equals(salir, "SALIR") || Objects.equals(salir, "salir")) return;
            else marcarCompletada(tareas, scanner);
        } else {
            String tarea = tareas.get(tareaCompletada);
            tarea = tarea.replace("[ ]", "[X]");
            tareas.set(tareaCompletada, tarea);
            System.out.println("Tarea en la posicion " + (tareaCompletada + 1) + " ha sido completada");
        }
    }

    static void eliminarTarea(ArrayList<String> tareas, Scanner scanner) {
        mostrarTareas(tareas);
        System.out.println("Cuál tarea deseas eliminar de la lista? (ingresa el número)");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index < 0 || index >= tareas.size()) {
            System.out.println("No has elegido una opción correcta");
            System.out.println("En caso de que quieras salir, escribe 'SALIR'");
            System.out.println("(si no quieres salir, solo aprieta ENTER.)");
            String salir = scanner.nextLine();
            if (Objects.equals(salir, "SALIR") || Objects.equals(salir, "salir")) return;
        }
        tareas.remove(index);
        System.out.println("Tarea eliminada!");
        mostrarTareas(tareas);
    }
}
