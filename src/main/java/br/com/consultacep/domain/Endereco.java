package br.com.consultacep.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public Endereco(EnderecoRequest enderecoRequest) {
        this.cep = enderecoRequest.cep();
        this.logradouro = enderecoRequest.logradouro();
        this.complemento = enderecoRequest.complemento();
        this.bairro = enderecoRequest.bairro();
        this.localidade = enderecoRequest.localidade();
        this.uf = enderecoRequest.uf();
        this.estado = enderecoRequest.estado();
        this.regiao = enderecoRequest.regiao();
        this.ibge = enderecoRequest.ibge();
        this.gia = enderecoRequest.gia();
        this.ddd = enderecoRequest.ddd();
        this.siafi = enderecoRequest.siafi();
    }


}
