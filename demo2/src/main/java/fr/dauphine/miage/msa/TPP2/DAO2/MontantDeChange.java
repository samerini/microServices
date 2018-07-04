package fr.dauphine.miage.msa.TPP2.DAO2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;






@Entity
public class MontantDeChange  implements Serializable {


    @Id
    @GeneratedValue
    private Long id;
    private String source;
    private String dest;
    private double taux;
    private double montant;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date date;

    public Long getIdTransaction() {
        return id;
    }

    public void setIdTransaction(Long idTransaction) {
        this.id = idTransaction;
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

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public double getMontant() {
        return montant;
    }

    public Date getDate() {
        return date;
    }



}