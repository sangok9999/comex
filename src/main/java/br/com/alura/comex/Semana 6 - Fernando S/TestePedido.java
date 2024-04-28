import listaPedidos;

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Pedido {
    private int id;
    private Cliente cliente;
    private List<Produto> produtos;
    private LocalDate data;

    public Pedido(int id, Cliente cliente, List<Produto> produtos, LocalDate data) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.data = data;
    }

    public BigDecimal getValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Produto produto : produtos) {
            total = total.add(BigDecimal.valueOf(produto.getPreco()));
        }
        return total;
    }

    
}

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Paula");
        Produto produto1 = new Produto("Tênis", 99.99);
        Produto produto2 = new Produto("Short", 59.99);
        Produto produto3 = new Produto("Camisa", 79.99);

        List<Produto> produtosPedido1 = List.of(produto1, produto2);
        List<Produto> produtosPedido2 = List.of(produto2, produto3, produto1);

        Pedido pedido1 = new Pedido(1, cliente, produtosPedido1, LocalDate.now());
        Pedido pedido2 = new Pedido(2, cliente, produtosPedido2, LocalDate.now());

        List<Pedido> listaPedidos = new ArrayList<>();
        listaPedidos.add(pedido1);
        listaPedidos.add(pedido2);

        listaPedidos.sort(Comparator.comparing(Pedido::getValorTotal));

        System.out.println("Ordem por valor total:");
        for (Pedido pedido : listaPedidos) {
            System.out.println(pedido);
        }
    }
}