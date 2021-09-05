package br.com.alura.loja.dao;

import br.com.alura.loja.RelatorioDeVendasDTO;
import br.com.alura.loja.modelo.Pedido;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO {
    private EntityManager em;

    public PedidoDAO(final EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido Pedido) {
        this.em.persist(Pedido);
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public List<RelatorioDeVendasDTO> relatorioDeVendas() {
        String jpql = "SELECT new br.com.alura.loja.RelatorioDeVendasDTO( " +
                " produto.nome," +
                " SUM(item.quantidade)," +
                " MAX(pedido.data)) " +
                " FROM Pedido pedido JOIN pedido.itens item JOIN item.produto produto " +
                " GROUP BY produto.nome " +
                " ORDER BY item.quantidade DESC";
        return em.createQuery(jpql, RelatorioDeVendasDTO.class).getResultList();
    }

    public Pedido buscarPedidoComCliente(Long id) {
        return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
                 .setParameter("id", id)
                 .getSingleResult();
    }
}
