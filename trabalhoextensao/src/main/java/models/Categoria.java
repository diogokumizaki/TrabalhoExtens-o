package models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "category")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String titulo;

    @Column(name = "color_hex")
    private String corHex;

    @Column(name = "user_id", nullable = false)
    private UUID usuarioId;


    public Categoria() {}

    public Categoria(String titulo, String corHex, UUID usuarioId) {
        this.titulo = titulo;
        this.corHex = corHex;
        this.usuarioId = usuarioId;
    }


    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getCorHex() { return corHex; }
    public void setCorHex(String corHex) { this.corHex = corHex; }

    public UUID getUsuarioId() { return usuarioId; }
    public void setUsuarioId(UUID usuarioId) { this.usuarioId = usuarioId; }
}