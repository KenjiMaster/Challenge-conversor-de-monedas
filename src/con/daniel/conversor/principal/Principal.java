package con.daniel.conversor.principal;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import con.daniel.conversor.modules.Conversor;
import con.daniel.conversor.modules.Moneda;
import con.daniel.conversor.net.Conectionapi;

import java.util.AbstractMap;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String enlace = "https://v6.exchangerate-api.com/v6/bc63c4755283ba7c9cf45766/latest/USD";
        Gson gson = new Gson();

        Conectionapi servicio = new Conectionapi();
        String respuesta = servicio.peticion(enlace);

        //Mapa de monedas
        Moneda monedas = gson.fromJson(respuesta, Moneda.class);

        //Converison
        Conversor conversor = new Conversor(monedas.conversion_rates());

        //Entrada de datos
        Scanner teclado = new Scanner(System.in);

        Boolean salir = false;
        while (!salir){
            conversor.exibirMenu();
            int res = teclado.nextInt();
            AbstractMap.SimpleEntry<String,String> cambio = null;

            switch (res){
                case 1:
                    cambio = new AbstractMap.SimpleEntry<>("USD","ARS");
                    break;
                case 2:
                    cambio = new AbstractMap.SimpleEntry<>("ARS","USD");
                    break;
                case 3:
                    cambio = new AbstractMap.SimpleEntry<>("USD","BRL");
                    break;
                case 4:
                    cambio = new AbstractMap.SimpleEntry<>("BRL","USD");
                    break;
                case 5:
                    cambio = new AbstractMap.SimpleEntry<>("USD","COP");
                    break;
                case 6:
                    cambio = new AbstractMap.SimpleEntry<>("COP","USD");
                    break;
                case 7:
                    System.out.println("Saliendo..");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    continue;
            }
            if (!salir) {
                System.out.print("Ingrese el monto: ");
                double monto = teclado.nextFloat();
                String resultado = conversor.converitir(cambio.getKey(), cambio.getValue(), monto);
                System.out.println("\nEl valor " + monto + " [" + cambio.getKey() + "] corresponde al valor final de -=> " + resultado + " [" + cambio.getValue() + "]\n");
            }
        }
        teclado.close();

    }
}
