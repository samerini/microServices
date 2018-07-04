package fr.dauphine.miage.msa.TP;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class TauxChange implements Serializable{


    @Id
    @GeneratedValue
    private Long id;
    private String source;
    private String dest;
    private double taux;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date date;

    public void setId(Long id) {
        this.id = id;
    }

    public TauxChange() {
    super();
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {

        return id;
    }

    public String getSource() {
        return source;
    }

    public String getDest() {
        return dest;
    }

    public double getTaux() {
        return taux;
    }

    public Date getDate() {
        return date;
    }


}



