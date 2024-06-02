import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaClientesDAO extends JpaRepository<Cliente, Long> {

    @Query("SELECT new ListaClientesDTO(c.nome, COUNT(p.id), SUM(p.preco)) " +
           "FROM Cliente c JOIN Pedido p ON c.id = p.cliente.id " +
           "GROUP BY c.nome " +
           "ORDER BY SUM(p.preco) DESC")
    List<ListaClientesDTO> gerarRelatorio();
}
