package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by martinschipflinger on 29.05.17.
 */
@Entity
public class Leser extends Model {

    @Id
    @Column(name="autor_id")
    private Long id;

    private String vorname;
    private String nachname;
    private String geburtsDatum;

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
