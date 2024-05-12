

import Categoria.GenerationType.IDENTITY;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ItemPedido")
public class ItemPedido implements Serializable {

    private static final Object GenerationType = ;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Column(name = "precoUnitario", nullable = false, length = 0)
    private BigDecimal precoUnitario;

    @Column(name = "quantidade", nullable = false, length = 0)
    private int quantidade;

    @Column(name = "desconto", nullable = false, length = 0)
    private BigDecimal desconto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoDesconto", nullable = false, length = 0)
    private TipoDescontoProdutoEnum tipoDesconto = TipoDescontoProdutoEnum.NENHUM;

    public BigDecimal getTotal() {
        BigDecimal total = precoUnitario.multiply(new BigDecimal(quantidade));
        total = total.subtract(desconto);
        return total;
    }

    // getters e setters //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public TipoDescontoProdutoEnum getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(TipoDescontoProdutoEnum tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

}

public enum TipoDescontoProdutoEnum {
    QUANTIDADE,
    PROMOCAO,
    NENHUM
}
