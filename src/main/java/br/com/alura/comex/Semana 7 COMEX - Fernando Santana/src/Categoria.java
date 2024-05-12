

import java.io.Serializable;

public class Categoria {


    public static final Object GenerationType = ;

    @Entity
    @Table(name = "Categoria")
    public class categoria implements Serializable {

        static final Object GenerationType =;
        private static final Object EnumType = ;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome", nullable = false)
        private String nome;

        @Enumerated(EnumType.string)
        @Column(name = "status", nullable = false)
        private Status status = Status.ATIVA;

        // getters e setters //

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public enum Status {
            ATIVA,
            INATIVA


        }
    }

}