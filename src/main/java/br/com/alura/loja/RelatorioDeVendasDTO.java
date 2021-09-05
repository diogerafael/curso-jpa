package br.com.alura.loja;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RelatorioDeVendasDTO {
    private String  nomeProduto;
    private BigDecimal quantidadeVenda;
    private LocalDate dataUltimaVenda;

    public RelatorioDeVendasDTO(
            final String nomeProduto,
            final BigDecimal quantidadeVenda,
            final LocalDate dataUltimaVenda
    ) {
        this.nomeProduto = nomeProduto;
        this.quantidadeVenda = quantidadeVenda;
        this.dataUltimaVenda = dataUltimaVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(final String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(final BigDecimal quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    public LocalDate getDataUltimaVenda() {
        return dataUltimaVenda;
    }

    public void setDataUltimaVenda(final LocalDate dataUltimaVenda) {
        this.dataUltimaVenda = dataUltimaVenda;
    }
}
