package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class DepartamentoPK {
    private String nome;
    private String tipo;

    public DepartamentoPK(final String nome, final String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public DepartamentoPK() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }
}
