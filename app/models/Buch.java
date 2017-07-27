package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by martinschipflinger on 29.05.17.
 */
@Entity
public class Buch extends Model {

    @Id
    @Column(name="buch_id")
    private Long id;

    private String titel;
    private String untertitel;
    private String isbn;
    private int seitenAnzahl;

    @Transient
    private String tmpAutor;

    public String getTmpAutor() {
        return tmpAutor;
    }

    public void setTmpAutor(String tmpAutor) {
        this.tmpAutor = tmpAutor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public static Finder<Long, Buch> find = new Finder<Long, Buch>(Buch.class);

    @ManyToOne
    private Autor autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getUntertitel() {
        return untertitel;
    }

    public void setUntertitel(String untertitel) {
        this.untertitel = untertitel;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getSeitenAnzahl() {
        return seitenAnzahl;
    }

    public void setSeitenAnzahl(int seitenAnzahl) {
        this.seitenAnzahl = seitenAnzahl;
    }
}
