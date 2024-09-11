package br.com.consultacep.controller;

import br.com.consultacep.domain.Cep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GravaCep {
    private final String url = "jdbc:postgresql://localhost:5432/cep";
    private final String user = "postgres";
    private final String password = "password";

    public void gravaCep(Cep cep){
        Cep gravaCep = cep;

        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String insertSQL = """
                    INSERT INTO cep (
                        cep,
                        logradouro,
                        complemento,
                        bairro,
                        localidade,
                        uf,
                        estado,
                        regiao,
                        ibge,
                        gia,
                        ddd,
                        siafi
                    )
                    VALUES (
                        ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
                    );
                    """;

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)){
                preparedStatement.setString(1, gravaCep.getCep());
                preparedStatement.setString(2, gravaCep.getLogradouro());
                preparedStatement.setString(3, gravaCep.getComplemento());
                preparedStatement.setString(4, gravaCep.getBairro());
                preparedStatement.setString(5, gravaCep.getLocalidade());
                preparedStatement.setString(6, gravaCep.getUf());
                preparedStatement.setString(7, gravaCep.getEstado());
                preparedStatement.setString(8, gravaCep.getRegiao());
                preparedStatement.setString(9, gravaCep.getIbge());
                preparedStatement.setString(10,gravaCep.getGia());
                preparedStatement.setString(11,gravaCep.getDdd());
                preparedStatement.setString(12,gravaCep.getSiafi());

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " linha(s) inseridas.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
