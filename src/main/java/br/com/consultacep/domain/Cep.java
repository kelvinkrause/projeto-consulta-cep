package br.com.consultacep.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cep {
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

    public Cep(CepRequest cepRequest) {
        this.cep = cepRequest.cep();
        this.logradouro = cepRequest.logradouro();
        this.complemento = cepRequest.complemento();
        this.bairro = cepRequest.bairro();
        this.localidade = cepRequest.localidade();
        this.uf = cepRequest.uf();
        this.estado = cepRequest.estado();
        this.regiao = cepRequest.regiao();
        this.ibge = cepRequest.ibge();
        this.gia = cepRequest.gia();
        this.ddd = cepRequest.ddd();
        this.siafi = cepRequest.siafi();
    }


}
