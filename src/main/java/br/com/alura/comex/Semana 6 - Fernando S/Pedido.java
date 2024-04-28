import java.math.BigDecimal;

public class Pedido {
    private int id;
    private Cliente cliente;
    private double preco;
    private int quantidade;

    public Pedido(int id, Cliente cliente, double preco, int quantidade) {
        this.id = id;
        this.cliente = cliente;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // calcular valor total do pedido //
    public BigDecimal getValorTotal() {
        return BigDecimal.valueOf(preco * quantidade);
    }

    // mais barato que //
    public boolean isMaisBaratoQue(Pedido outroPedido) {
        return preco < outroPedido.getPreco();
    }

    // mais caro que //
    public boolean isMaisCaroQue(Pedido outroPedido) {
        return preco > outroPedido.getPreco();
    }

    

    // Exibição //
    public static void main(String[] args) {
        
        System.out.println(pedido1);
        System.out.println("Pedido 1 é mais barato que Pedido 2? " + pedido1.isMaisBaratoQue(pedido2));
        System.out.println("Pedido 1 é mais caro que Pedido 2? " + pedido1.isMaisCaroQue(pedido2));
    }
}