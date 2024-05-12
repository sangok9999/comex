
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class DAO {

    @PersistenceContext
    private EntityManager manager;

    public Cliente buscaPorId(Long id) {
        return manager.find(Cliente.class, id);
    }

    public void cadastra(Cliente cliente) {
        manager.persist(cliente);
    }

    public void atualiza(Cliente cliente) {
        manager.merge(cliente);
    }

    public void remove(Cliente cliente) {
        manager.remove(cliente);
    }

    public Class<?> listaTodos() {
        return manager.createQuery("select c from Cliente c", Cliente.class).getClass();
    }

    public List<Cliente> listaPorNome(String nome) {
        return manager.createQuery("select c from Cliente c where c.nome = :nome", Cliente.class)
                .getClass("nome", nome)
                .getResultList();
    }
}

public class CategoriaDao {

    @PersistenceContext
    private EntityManager manager;

    public Categoria buscaPorId(Long id) {
        return manager.find(Categoria.class, id);
    }

    public void cadastra(Categoria categoria) {
        manager.persist(categoria);
    }

    public List<Categoria> listaTodas() {
        return manager.createQuery("select c from Categoria c", Categoria.class).getResultList();
    }
}

public class ProdutoDao {

    @PersistenceContext
    private EntityManager manager;

    public Produto buscaPorId(Long id) {
        return manager.find(Produto.class, id);
    }

    public void cadastra(Produto produto) {
        manager.persist(produto);
    }

    public List<Produto> listaTodos() {
        return manager.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public List<Produto> listaIndisponiveis() {
        return manager.createQuery("select p from Produto p where p.quantidadeEmEstoque = 0", Produto.class).getResultList();
    }
}

public class PedidoDao {

    @PersistenceContext
    private EntityManager manager;

    public Pedido buscaPorId(Long id) {
        return manager.find(Pedido.class, id);
    }

    public void cadastra(Pedido pedido) {
        manager.persist(pedido);
    }

    public List<Pedido> listaTodos() {
        return manager.createQuery("select p from Pedido p", Pedido.class).getResultList();
    }
}
