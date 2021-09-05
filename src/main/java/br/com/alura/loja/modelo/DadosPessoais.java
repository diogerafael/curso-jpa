package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
    private String nome;
    private String cpf;

    public DadosPessoais() {
    }

    public DadosPessoais(final String cpf) {
        this.cpf = cpf;
    }

    public DadosPessoais(final String nome, final String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }
}
