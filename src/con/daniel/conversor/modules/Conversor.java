package con.daniel.conversor.modules;

import java.text.DecimalFormat;
import java.util.Map;

public class Conversor {
    Map monedas;
    public Conversor(Map monedas){
        this.monedas = monedas;
    }
    public String converitir(String moneda1, String moneda2 ,double monto){
        double valorDolar = monto/(double) monedas.get(moneda1) ;
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(valorDolar*(double) monedas.get(moneda2));
    }

    public void exibirMenu(){
        System.out.println("""
                *****************************************************
                Sea bienvenid@ al Conversor de Monedas :)
                
                1) Dolar -> Peso argentino
                2) Peso argentino -> Dolar
                3) Dolar -> Real brasileno
                4) Real brasileno -> Dolar
                5) Dolar -> Peso colombiano
                6) Peso colombiano -> Dolar
                7) Salir
                
                Elija una opcion valida:
                """);
    }
}
