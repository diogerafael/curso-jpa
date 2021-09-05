package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ClienteDAO {
    private EntityManager em;

    public ClienteDAO(final EntityManager em) {
        this.em = em;
    }

    public Cliente buscarPorId(Long id){
        return em.find(Cliente.class, id);
    }
    
    public void cadastrar(Cliente Cliente) {
        this.em.persist(Cliente);
    }
}
