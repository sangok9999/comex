import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestaPedidoOrdenado {
    public static void main(String[] args) {
        List<Pedido> pedidos = new ArrayList<>();

        // 5 pedidos e variações de valores e produtos //
        pedidos.add(new Pedido("Produto1", 10, 100.0));
        pedidos.add(new Pedido("Produto2", 5, 200.0));
        pedidos.add(new Pedido("Produto3", 20, 50.0));
        pedidos.add(new Pedido("Produto4", 15, 150.0));
        pedidos.add(new Pedido("Produto5", 30, 30.0));

        // Ordenar a lista de pedidos //
        List<Pedido> pedidosOrdenadosMaiorValor = pedidos.stream()
                .sorted(Comparator.comparing(Pedido::getValorTotal).reversed())
                .collect(Collectors.toList());

        System.out.println("Ordenados pelo maior valor total:");
        pedidosOrdenadosMaiorValor.forEach(System.out::println);

        // Ordena a lista de pedidos pelo valor total em ordem crescente
        List<Pedido> pedidosOrdenadosMenorValor = pedidos.stream()
                .sorted(Comparator.comparing(Pedido::getValorTotal))
                .collect(Collectors.toList());

        System.out.println("\nOrdenados pelo menor valor total:");
        pedidosOrdenadosMenorValor.forEach(System.out::println);
    }
}

class Pedido {
    private String produto;
    private int quantidade;
    private double precoUnitario;

    public Pedido(String produto, int quantidade, double precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double getValorTotal() {
        return quantidade * precoUnitario;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", valorTotal=" + getValorTotal() +
                '}';
    }
}