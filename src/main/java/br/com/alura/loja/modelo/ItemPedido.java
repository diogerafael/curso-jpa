package br.com.alura.loja.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    
    private BigDecimal quantidade;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(final Long id, final BigDecimal quantidade, final Pedido pedido, final Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produto = produto;
        this.precoUnitario = produto.getPreco();
    }

    public ItemPedido(final BigDecimal quantidade, final Pedido pedido, final Produto produto) {
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produto = produto;
        this.precoUnitario = produto.getPreco();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setPrecoUnitario(final BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setQuantidade(final BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void setPedido(final Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(final Produto produto) {
        this.produto = produto;
    }
    
    public BigDecimal getValor() {
        return precoUnitario.multiply(quantidade);
    }
}
