import java.util.Scanner;

public class amigoInvisible {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Pedimos número de amigos

        System.out.println("Cuantos amigos vais a jugar");
        int numero = in.nextInt();
        in.nextLine(); // limpiar salto de línea

        if(numero < 2) {
            System.out.println("Número de amigos incorrecto, debe ser mayor a 1");
            return;
        }

        // Array para guardar nombres

        String[] nombre = new String[numero];

        // Solicitamos nombres sin que se repitan

        for (int i = 0; i < numero; i++) {
            while(true) {
                System.out.println("Dime el nombre de tu amigo numero: " + (i + 1));
                String nombreAmigo = in.nextLine();

                // Comprobamos si el nombre ya existe

                boolean repetido = false;
                for (int j = 0; j < i; j++) { // solo revisamos los nombres anteriores
                    if(nombreAmigo.equals(nombre[j])) {
                        repetido = true;
                        break; // nombre es igual
                    }
                }

                if(!repetido) {//nombre es diferente de repetido,
                    nombre[i] = nombreAmigo;
                    break; // salimos de bucle
                } else {
                    System.out.println("Nombre repetido, introduce otro.");
                }
            }
        }
        // Array para asignaciones

        int[] regalo = new int[numero];
        for (int i = 0; i < numero; i++) {
            regalo[i] = i;
        }

        // Condicional para no repeticiones de regalo

        boolean coincidencia;
        do {
            for (int i = 0; i < numero; i++) {
                int aleatorio = (int)(Math.random() * numero);
                int sorteo = regalo[i];
                regalo[i] = regalo [aleatorio];
                regalo[aleatorio] = sorteo;
            }

            coincidencia = false;
            for (int i = 0; i < numero; i++) {
                if (regalo [i] == i) {
                    coincidencia = true;
                    break;
                }
            }
        } while (coincidencia);

        // Imprimimos resultados

        System.out.println("\nPAREJAS DEL AMIGO INVISIBLE:");
        for (int i = 0; i < numero; i++) {
            System.out.println(nombre[i] + " → " + nombre[regalo [i]]);
        }
    }

}
