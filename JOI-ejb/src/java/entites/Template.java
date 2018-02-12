package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "entites.Templates.AllTemplates", query = "SELECT t FROM Template t"),
    @NamedQuery(name = "entites.Templates.TemplatesByNom", query = "SELECT t FROM Template t WHERE t.nom = :paramNom")
})
public class Template implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    @ManyToMany
    private Collection<Champs> champs;
    @ManyToOne
    private Collection<Projets> projets;
    @ManyToOne
    private Collection<Postulation> postulations;

    //CONSTRUCTORS
    public Template() {
        champs = new ArrayList();
    }

    public Template(String nom) {
        this();
        this.nom = nom;
    }

    public Template(String nom, String description) {
        this();
        this.nom = nom;
        this.description = description;
    }

    //GETTERS AND SETTERS 
    public String getNom() {
        return nom;
    }

    public Collection<Champs> getChamps() {
        return champs;
    }

    public void setChamps(Collection<Champs> champs) {
        this.champs = champs;
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

    public Collection<Projets> getProjets() {
        return projets;
    }

    public void setProjets(Collection<Projets> projets) {
        this.projets = projets;
    }

    public Collection<Postulation> getPostulations() {
        return postulations;
    }

    public void setPostulations(Collection<Postulation> postulations) {
        this.postulations = postulations;
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
        if (!(object instanceof Template)) {
            return false;
        }
        Template other = (Template) object;
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
