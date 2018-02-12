package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "entites.Champs.AllChamps", query = "SELECT c FROM Champs c"),
    @NamedQuery(name = "entites.Champs.DroitsById", query = "SELECT c FROM Champs c WHERE c.id = :PramNom")
})
public class Champs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    @ManyToMany(mappedBy = "champs")
    private Collection<Template> templates;

    //CONSTRUCTORS
    public Champs() {
        templates = new ArrayList();
    }

    public Champs(String nom) {
        this();
        this.nom = nom;
    }

    public Champs(String nom, String description) {
        this();
        this.nom = nom;
        this.description = description;
    }

    //GETTERS AND SETTERS 
    public String getNom() {
        return nom;
    }

    public Collection<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(Collection<Template> templates) {
        this.templates = templates;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Champs)) {
            return false;
        }
        Champs other = (Champs) object;
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
