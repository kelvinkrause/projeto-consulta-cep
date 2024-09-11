package br.com.consultacep.controller;

import br.com.consultacep.domain.CepRequest;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    public CepRequest buscaEndereco(String cep) throws IOException, InterruptedException {

        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), CepRequest.class);
    }
}