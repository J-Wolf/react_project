package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by martinschipflinger on 29.05.17.
 */
@Entity
public class Verlag extends Model{

    @Id
    @Column(name="verlag_id")
    private Long id;

    private String bezeichnung;
    private String strasse;
    private String plz;
    private String ort;

    public static Finder<Long, Verlag> find = new Finder<Long, Verlag>(Verlag.class);


    @ManyToOne
    private Verlag verlag;

    @OneToMany(mappedBy = "verlag")
    private List<Autor> autoren;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
