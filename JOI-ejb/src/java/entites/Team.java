
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
    @NamedQuery(name = "entites.Team.AllTeam", query = "SELECT t FROM Team t"),
    @NamedQuery(name = "entites.Team.TeamByNom", query = "SELECT t FROM Team t WHERE t.nom = :paramNom"),
    @NamedQuery(name = "entites.Team.TeamById", query = "SELECT t FROM Team t WHERE t.id = :paramNom")
})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private boolean admin;
    
   
    @ManyToMany(mappedBy = "team")
    private Collection<Utilisateurs> utilisateurs;
    @ManyToMany(mappedBy = "team")
    private Collection<Projets> projets;
    
    
    //CONSTRUCTORS 

    public Team() {
        utilisateurs = new ArrayList();
        projets = new ArrayList();
    }

    public Team(String nom) {
        this.nom = nom;
    }
    public Team(String nom, boolean admin) {
        this.nom = nom;
        this.admin = admin;
    }

    //GETTERS AND SETTERS

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Collection<Utilisateurs> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Collection<Utilisateurs> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Collection<Projets> getProjets() {
        return projets;
    }

    public void setProjets(Collection<Projets> projets) {
        this.projets = projets;
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
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Team[ id=" + id + " ]";
    }
    
}
