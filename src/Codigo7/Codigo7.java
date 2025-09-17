package Codigo7;

import java.util.HashMap;
import java.util.Scanner;
import java.text.Normalizer;

/*
 * Programa: Capitales
 * Descripción: Este programa solicita al usuario que escriba el nombre de un país
 * y le devuelve la capital correspondiente. Si el país no existe en la lista,
 * pide al usuario que ingrese la capital y la guarda para futuras consultas.
 * El programa continúa hasta que el usuario escriba "salir". 
 * Ahora ignora mayúsculas y acentos para reconocer correctamente los países.
 */

public class Codigo7 {

    // Método para normalizar strings: elimina acentos y convierte a minúsculas
    private static String normalize(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD)
                         .replaceAll("\\p{M}", "") // quita acentos
                         .toLowerCase();            // convierte a minúsculas
    }

    public static void main(String[] args) {//se agrego metodo main 
        Scanner s = new Scanner(System.in); // Scanner para entrada de usuario

        // HashMap con los países y sus capitales
        HashMap<String, String> capitales = new HashMap<>();//se corrigieron los valores a ingresar y los parensesis extras

        // Se agregan las capitales iniciales (usando los nombres que proporcionaste)
        capitales.put("Canadá", "Ottawa"); // corregido de "Otawwa"
        capitales.put("Estados Unidos", "Washington DC");
        capitales.put("México", "México DF");
        capitales.put("Belice", "Belmopán");
        capitales.put("Costa rica", "San José");
        capitales.put("El Salvador", "San Salvador");//falataba el segundo valor 
        capitales.put("Guatemala", "Ciudad de Guatemala");
        capitales.put("Honduras", "Tegucigalpa");
        capitales.put("Nicaragua", "Managua");
        capitales.put("Panamá", "Panamá");

        String c = ""; // variable para almacenar el país ingresado // faltaba una letra 

        do {
            System.out.print("Escribe el nombre de un país y te diré su capital: ");
            c = s.nextLine();//nextLine era la forma correcta 

            if (!c.equalsIgnoreCase("salir")) {
                // Buscar el país ignorando mayúsculas y acentos
                String paisEncontrado = null;
                for (String pais : capitales.keySet()) {
                    if (normalize(pais).equals(normalize(c))) {
                        paisEncontrado = pais;
                        break;
                    }
                }

                if (paisEncontrado != null) {
                    // Mostrar capital si el país existe
                    System.out.println("La capital de " + c + " es " + capitales.get(paisEncontrado));
                } else {
                    // Pedir al usuario la capital si no existe
                    System.out.print("No conozco la respuesta ");
                    System.out.print("¿cuál es la capital de " + c + "?: ");
                    String ca = s.nextLine(); // mantiene el nombre de variable 'ca' que tú usaste
                    capitales.put(c, ca);
                    System.out.println("Gracias por enseñarme nuevas capitales");
                }
            }

        } while (!c.equalsIgnoreCase("salir")); // continuar hasta que escriba "salir"// faltaba la letra h en while

        s.close(); // cerrar el scanner
    }
}

