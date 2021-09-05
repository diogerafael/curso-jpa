package br.com.alura.loja.dao;

import br.com.alura.loja.RelatorioDeVendasDTO;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(final EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarPorNome(final String nome) {
        return em.createQuery("SELECT p FROM Produto p where  p.nome = :nome ", Produto.class)
                 .setParameter("nome", nome)
                 .getResultList();
    }

    public List<Produto> buscarPorNomeCategoria(final String nome) {
        return em.createQuery("SELECT p FROM Produto p where  p.categoria.nome = :nome ", Produto.class)
                 .setParameter("nome", nome)
                 .getResultList();
    }

    public List<Produto> buscarTodos() {
        return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }
    
    //usandro criteria sql
    public List<Produto> buscarPorParametrosComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);

        Root<Produto> from = query.from(Produto.class);

        Predicate filtros = builder.and();
        
        if (nome != null && !nome.trim().isEmpty()){
            filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
        }

        if (nome != null && !nome.trim().isEmpty()){
            filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
        }

        if (nome != null && !nome.trim().isEmpty()){
            filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
        }
        
        query.where(filtros);
        
        return em.createQuery(query).getResultList();

    }
}
