

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pedido {

    @Entity
    @Table(name = "Pedido")
    public class pedido implements Serializable {

        private static final Object TemporalType = ;
        @Id
        @GeneratedValue(strategy = Categoria.categoria.GenerationType.IDENTITY)
        private Long id;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "data", nullable = false, length = 0)
        private Date data;

        @ManyToOne
        @JoinColumn(name = "cliente_id", nullable = false)
        private Cliente cliente;

        @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<ItemDePedido> itens;

        @Column(name = "desconto", nullable = false, length = 0)
        private Double desconto;

        @Enumerated(EnumType.STRING)
        @Column(name = "tipoDesconto", nullable = false, length = 0)
        private TipoDesconto tipoDesconto = TipoDesconto.NENHUM;

        public enum TipoDesconto {
            FIDELIDADE,
            NENHUM
        }

        
        // getters e setters //

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
            this.data = data;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public List<ItemDePedido> getItens() {
            return itens;
        }

        public void setItens(List<ItemDePedido> itens) {
            this.itens = itens;
        }

        public Double getDesconto() {
            return desconto;
        }

        public void setDesconto(Double desconto) {
            this.desconto = desconto;
        }

        public TipoDesconto getTipoDesconto() {
            return tipoDesconto;
        }

        public void setTipoDesconto(TipoDesconto tipoDesconto) {
            this.tipoDesconto = tipoDesconto;
        }

    }
}
