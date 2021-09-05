import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.DadosPessoais;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDePedido {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        Produto produto = produtoDAO.buscarPorId(1l);
        ClienteDAO clienteDAO = new ClienteDAO(em);
        Cliente cliente = clienteDAO.buscarPorId(1l);

        em.getTransaction().begin();
        
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItemPedido(new ItemPedido(BigDecimal.TEN, pedido, produto));
        
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        pedidoDAO.cadastrar(pedido);
        em.getTransaction().commit();
        
        BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
        System.out.println("Valor  total:"+totalVendido);
        
        pedidoDAO.relatorioDeVendas().forEach(item -> System.out.println("Nome do Produto: "+item.getNomeProduto()));
        
        //buscando pedido forcando o fetch de cliente
        Pedido pedido1 = pedidoDAO.buscarPedidoComCliente(1l);
        System.out.println("Pedido fetch: "+ pedido1.getCliente().getCpf());
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("Celulares");

        Produto celular = new Produto("Xiaomi Redmi", "Legal", new BigDecimal("800"), celulares);
        
        Cliente cliente = new Cliente( new DadosPessoais("Diogenes","21212"));
        
        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();
        
        categoriaDAO.cadastrar(celulares);
        produtoDAO.cadastrar(celular);
        clienteDAO.cadastrar(cliente);
        
        em.getTransaction().commit();
        
        
    }
}
