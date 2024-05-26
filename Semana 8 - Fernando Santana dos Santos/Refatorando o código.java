import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PedidosDAO {
    private Connection connection;

    public ListaClientesDAO(Connection connection) {
        this.connection = connection;
    }

    public void gerarRelatorio() {
        String sql = "SELECT c.nome AS cliente, COUNT(p.id) AS qntd_pedidos, SUM(p.preco) AS montante_gasto " +
                     "FROM cliente c " +
                     "JOIN pedido p ON c.id = p.cliente_id " +
                     "GROUP BY c.nome " +
                     "ORDER BY montante_gasto DESC " +
                     "LIMIT 3";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            List<Cliente> clientes = new ArrayList<>();

            while (rs.next()) {
                String cliente = rs.getString("cliente");
                int quantidadePedidos = rs.getInt("qntd_pedidos");
                double montanteGasto = rs.getDouble("montante_gasto");

                clientes.add(new Cliente(cliente, qntd_Pedidos, montanteGasto));
            }

            clientes.stream()
                    .sorted(Comparator.comparing(Cliente::getMontanteGasto).reversed())
                    .forEach(c -> {
                        System.out.println("Cliente: " + c.getNome());
                        System.out.println("Quantidade de Pedidos: " + c.getQntdPedidos());
                        System.out.println("Montante Gasto: " + c.getMontanteGasto());
                        System.out.println("-------------------------");
                    });

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

class Cliente {
    private String nome;
    private int quantidadePedidos;
    private double montanteGasto;

    }