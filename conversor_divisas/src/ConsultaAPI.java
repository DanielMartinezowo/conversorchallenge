

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {


    double conversion;

    public Rate ConexionAPI(String base_code, String target_code, double monto){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ecb08dcd4b9c9f0009fda125/pair/"
                + base_code + "/" + target_code + "/" + monto);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Rate.class);
        }catch (IOException | InterruptedException e){
            throw new RuntimeException();
        }

    }
    public void resultado(String base_code, String target_code, double monto){
        ConsultaAPI busqueda =  new ConsultaAPI();
        conversion = busqueda.ConexionAPI(base_code,target_code,monto).conversion_result();
        System.out.println("El valor es: "+monto+"["+base_code+"]"+"y el monto final es: "+conversion+"["+target_code+"]");
    }

}
