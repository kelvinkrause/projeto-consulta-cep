package br.com.consultacep;

import br.com.consultacep.controller.ConsultaCep;
import br.com.consultacep.controller.GravaCep;
import br.com.consultacep.domain.Cep;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe um CEP:");
        String cep = scan.nextLine();

        Cep classeCep = new Cep(new ConsultaCep().buscaEndereco(cep));

        new GravaCep().gravaCep(classeCep);

    }
}