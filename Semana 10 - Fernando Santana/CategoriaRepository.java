import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.io.Serializable;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByStatus(Categoria.Status status);

    @Query("SELECT c FROM Categoria c WHERE c.nome = ?1")
    List<Categoria> findByNome(String nome);
}

@Entity
@Table(name = "Categoria")
class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.ATIVA;

    public enum Status {
        ATIVA,
        INATIVA
    }
}
