import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaClientesDAO {
    private Connection connection;

    public ListaClientesDAO(Connection connection) {
        this.connection = connection;
    }

    public void gerarRelatorio() {
        String sql = "SELECT c.nome AS cliente, COUNT(p.id) AS quantidade_pedidos, SUM(p.preco) AS montante_gasto " +
                     "FROM cliente c " +
                     "JOIN pedido p ON c.id = p.cliente_id " +
                     "GROUP BY c.nome " +
                     "ORDER BY montante_gasto DESC " +
                     "LIMIT 3";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String cliente = rs.getString("cliente");
                int quantidadePedidos = rs.getInt("quantidade_pedidos");
                double montanteGasto = rs.getDouble("montante_gasto");

                System.out.println("Cliente: " + cliente);
                System.out.println("Quantidade de Pedidos: " + quantidadePedidos);
                System.out.println("Montante Gasto: " + montanteGasto);
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}