package br.com.consultacep.controller;

import br.com.consultacep.domain.EnderecoRequest;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    public EnderecoRequest buscaEndereco(String cep) throws IOException, InterruptedException {

        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();

        try {

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //Gson, converte o response.body() em uma EnderecoRequest.class
            return new Gson().fromJson(response.body(), EnderecoRequest.class);

        } catch (IOException | InterruptedException e){
            throw new RuntimeException("Não foi possível obter o endereço desse cep: " + cep + ".");
        }
    }
}