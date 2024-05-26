public class PedidosDAO {
}
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutosDAO {
    private Connection connection;

    public ProdutosDAO(Connection connection) {
        this.connection = connection;
    }

    public void gerarRelatorio() {
        String sql = "SELECT c.nome AS pedido, COUNT(p.id) AS qntd_vendida, SUM(p.preco) AS montante_vendido " +
                "FROM pedido c " + "JOIN produto p ON c.id = p.produto_id " + "JOIN venda v ON p.id = v.produto_id " +
                "GROUP BY c.nome";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String categoria = rs.getString("categoria");
                int quantidadeVendida = rs.getInt("qntd_vendida");
                double montanteVendido = rs.getDouble("montante_vendido");

                System.out.println("Pedido: " + categoria);
                System.out.println("Qntd. Vendida: " + quantidadeVendida);
                System.out.println("Montante Vendido: " + montanteVendido);
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}