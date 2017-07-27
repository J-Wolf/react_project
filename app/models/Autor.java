package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by martinschipflinger on 29.05.17.
 */
@Entity
public class Autor extends Model {

    @Id
    @Column(name="autor_id")
    private Long id;

    private String vorname;
    private String nachname;
    private String geburtsDatum;


    public static Finder<Long, Autor> find = new Finder<Long, Autor>(Autor.class);

    @ManyToOne
    private Verlag verlag;

    @OneToMany(mappedBy = "autor")
    private List<Buch> bücher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(String geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }
}
