package br.com.consultacep.controller;

import br.com.consultacep.domain.Endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GravaEndereco {
    private final String url = "jdbc:postgresql://localhost:5432/endereco";
    private final String user = "postgres";
    private final String password = "password";

    public void gravaCep(Endereco endereco){
        Endereco gravaEndereco = endereco;

        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String insertSQL = """
                    INSERT INTO endereco (
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
                preparedStatement.setString(1, gravaEndereco.getCep());
                preparedStatement.setString(2, gravaEndereco.getLogradouro());
                preparedStatement.setString(3, gravaEndereco.getComplemento());
                preparedStatement.setString(4, gravaEndereco.getBairro());
                preparedStatement.setString(5, gravaEndereco.getLocalidade());
                preparedStatement.setString(6, gravaEndereco.getUf());
                preparedStatement.setString(7, gravaEndereco.getEstado());
                preparedStatement.setString(8, gravaEndereco.getRegiao());
                preparedStatement.setString(9, gravaEndereco.getIbge());
                preparedStatement.setString(10, gravaEndereco.getGia());
                preparedStatement.setString(11, gravaEndereco.getDdd());
                preparedStatement.setString(12, gravaEndereco.getSiafi());

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " linha(s) inseridas.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
