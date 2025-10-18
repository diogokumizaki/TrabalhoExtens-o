package models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String titulo;

    @Column(name = "price", nullable = false)
    private Double preco;

    @Column(name = "category_id", nullable = false)
    private UUID categoriaId;

    @Column(name = "user_id", nullable = false)
    private UUID usuarioId;


    public Transacao() {}

    public Transacao(String titulo, Double preco, UUID categoriaId, UUID usuarioId) {
        this.titulo = titulo;
        this.preco = preco;
        this.categoriaId = categoriaId;
        this.usuarioId = usuarioId;
    }


    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public UUID getCategoriaId() { return categoriaId; }
    public void setCategoriaId(UUID categoriaId) { this.categoriaId = categoriaId; }

    public UUID getUsuarioId() { return usuarioId; }
    public void setUsuarioId(UUID usuarioId) { this.usuarioId = usuarioId; }
}
