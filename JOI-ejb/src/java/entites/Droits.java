package entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "entites.Droits.AllDroits", query = "SELECT d FROM Droits d"),
    @NamedQuery(name = "entites.Droits.DroitsByNom", query = "SELECT d FROM Droits d WHERE d.nom = :PramNom")
})
public class Droits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "droit")
    private Collection<Utilisateurs> utillisateurs;

    //CONSTRUCTORS
    public Droits() {
    }

    public Droits(String nom) {
        this.nom = nom;
    }

    //GETTERS AND SETTERS 

    public Collection<Utilisateurs> getUtillisateurs() {
        return utillisateurs;
    }

    public void setUtillisateurs(Collection<Utilisateurs> utillisateurs) {
        this.utillisateurs = utillisateurs;
    }
   
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Droits)) {
            return false;
        }
        Droits other = (Droits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }

}
