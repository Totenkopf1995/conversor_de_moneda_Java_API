package principal;

import API.API;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        boolean continuar = true;
        while (continuar) {
            System.out.println("¿Cuál es el valor que desea convertir en pesos colombianos?: ");
            var valor = lectura.nextLine();
            System.out.println("¿A qué moneda desea convertirlo?: ");
            var moneda = lectura.nextLine();

            if (validarMoneda(moneda)) {
                double valorConvertido = API.convertirMoneda(moneda, Double.parseDouble(valor));
                if (valorConvertido != -1) {
                    System.out.println("El valor convertido a " + moneda + " es: " + valorConvertido);
                } else {
                    System.out.println("La tasa de conversión para la moneda especificada no se encontró.");
                }
            } else {
                System.out.println("La moneda especificada no es válida.");
            }

            System.out.println("¿Desea realizar otra conversión? (S/N): ");
            String respuesta = lectura.nextLine().toUpperCase();
            if (!respuesta.equals("S")) {
                continuar = false;
            }
        }
    }

    private static boolean validarMoneda(String moneda) {
        List<String> monedasAdmitidas = new ArrayList<>(Arrays.asList("USD", "EUR", "GBP", "JPY", "CAD", "ZAR"));
        return monedasAdmitidas.contains(moneda.toUpperCase());
    }
}
