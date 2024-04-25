package API;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class API {
    private static final String API_KEY = "3e6ea59506daf11c1eed26b9";

    public static double convertirMoneda(String moneda, double valor) {
        String direccion = "https://v6.exchangerate-api.com/v6/" +
                API_KEY +
                "/latest/" +
                moneda;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String json = response.body();
                Gson gson = new Gson();
                ExchangeRates exchangeRates = gson.fromJson(json, ExchangeRates.class);

                double tasaDeConversion = exchangeRates.getConversionRate(moneda.toUpperCase());

                if (tasaDeConversion != -1) {
                    return valor * tasaDeConversion;
                } else {
                    return -1;
                }
            } else {
                System.out.println("Error al obtener la respuesta de la API. Código de estado: " + response.statusCode());
                return -1;
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static class ExchangeRates {
        private String result;
        private Map<String, Double> conversionRates;

        public double getConversionRate(String currencyCode) {
            if (conversionRates != null && conversionRates.containsKey(currencyCode)) {
                return conversionRates.get(currencyCode);
            } else {
                return -1;
            }
        }

        public Map<String, Double> getConversionRates() {
            return conversionRates;
        }

        public void setConversionRates(Map<String, Double> conversionRates) {
            this.conversionRates = conversionRates;
        }
    }
}
