import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class Testes {
    public static void main(String[] args) {
        
        Categoria celulares = new Categoria("Celulares");
        
        Produto celular = new Produto("Xiaomi Redmi", "Legal", new BigDecimal(800), celulares);
        
        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        em.getTransaction().begin();
        categoriaDAO.cadastrar(celulares);
        produtoDAO.cadastrar(celular);
        em.getTransaction().commit();
        
        produtoDAO.buscarTodos().forEach(p -> System.out.println(p.getDescricao()));
        produtoDAO.buscarPorNome("Xiaomi Redmi").forEach(p -> System.out.println(p.getDescricao()));
        produtoDAO.buscarPorNomeCategoria("Celulares").forEach(p -> System.out.println(p.getDescricao()));

        em.close();
    }
}
