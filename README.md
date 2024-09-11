CREATE TABLE endereco (cep TEXT PRIMARY KEY UNIQUE NOT NULL,
                       logradouro TEXT NOT NULL,
                       complemento TEXT NOT NULL,
                       bairro TEXT NOT NULL,
                       localidade TEXT NOT NULL,
                       uf TEXT NOT NULL,
                       estado TEXT NOT NULL,
                       regiao TEXT NOT NULL,
                       ibge TEXT NOT NULL,
                       gia TEXT NOT NULL,
                       ddd TEXT NOT NULL,
                       siafi TEXT NOT NULL
);
