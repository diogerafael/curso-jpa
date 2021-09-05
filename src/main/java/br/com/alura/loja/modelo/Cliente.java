package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Embedded
    private DadosPessoais dadosPessoais;

    public Cliente() {
    }
    
    
    public String getNome(){
        return dadosPessoais.getNome();
    }
    
    public String getCpf(){
        return dadosPessoais.getCpf();
    }

    public Cliente(final DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public Cliente(final Long id, final DadosPessoais dadosPessoais) {
        this.id = id;
        this.dadosPessoais = dadosPessoais;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(final DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }
}
