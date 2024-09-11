package br.com.consultacep;

import br.com.consultacep.controller.ConsultaCep;
import br.com.consultacep.controller.GravaEndereco;
import br.com.consultacep.domain.Endereco;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe um CEP:");
        String cep = scan.nextLine();

        try {
            Endereco classeEndereco = new Endereco(new ConsultaCep().buscaEndereco(cep));
            new GravaEndereco().gravaCep(classeEndereco);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação.");
        }


    }
}