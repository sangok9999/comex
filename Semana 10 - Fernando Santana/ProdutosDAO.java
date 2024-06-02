import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosDAO extends JpaRepository<Produto, Long> {

    @Query("SELECT new ListaProdutosDTO(c.nome, COUNT(p.id), SUM(p.preco)) " +
           "FROM Pedido c JOIN Produto p ON c.id = p.produto.id " +
           "JOIN Venda v ON p.id = v.produto.id " +
           "GROUP BY c.nome")
    List<ListaProdutosDTO> gerarRelatorio();
}
