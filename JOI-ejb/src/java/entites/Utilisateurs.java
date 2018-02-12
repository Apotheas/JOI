
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
    @NamedQuery(name = "entites.Utilisateurs.AllUsers", query = "SELECT u FROM Utilisateurs u"),
    @NamedQuery(name = "entites.Utilisateurs.UsersByDroits", query = "SELECT u FROM Utilisateurs u JOIN u.droit d WHERE d.nom = :paramNom"),
    @NamedQuery(name = "entites.Utilisateurs.UsersByRoles", query = "SELECT u FROM Utilisateurs u JOIN u.roles r WHERE r.nom = :paramNom"),
})
public class Utilisateurs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String photo;
    private String societe;
    private String website;
    private String birthdate;
    private String location;
    
    //MAPP BY TO DO 
    
    @ManyToOne
    private Droits droit;     
    @ManyToMany
    private Collection<Roles> roles;
    @ManyToMany
    private Collection<Team> team;
    @ManyToOne
    private Commentaires commentaires;
    @ManyToOne
    private Postulation postulation;
    
    
    // CONSTRUCTORS

    public Utilisateurs() {
        roles = new ArrayList();
        team = new ArrayList();
    }
    
    public Utilisateurs(String nom, String prenom, String email, String password) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public Utilisateurs(String nom, String prenom, String email, String password, String photo, String societe, String website, String birthdate, String location) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.societe = societe;
        this.website = website;
        this.birthdate = birthdate;
        this.location = location;
    }

    
    
    // GETTERS AND SETTERS
    
    public Droits getDroit() {
        return droit;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    public Collection<Team> getTeam() {
        return team;
    }

    public void setTeam(Collection<Team> team) {
        this.team = team;
    }

    public Commentaires getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Commentaires commentaires) {
        this.commentaires = commentaires;
    }

    public Postulation getPostulation() {
        return postulation;
    }

    public void setPostulation(Postulation postulation) {
        this.postulation = postulation;
    }

   
    public void setDroit(Droits droit) {
        this.droit = droit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        if (!(object instanceof Utilisateurs)) {
            return false;
        }
        Utilisateurs other = (Utilisateurs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom + " / " + prenom;
    }
    
}
