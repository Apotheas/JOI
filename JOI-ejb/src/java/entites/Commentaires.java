package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "entites.Commentaires.AllComments", query = "SELECT c FROM Commentaires c"),
    @NamedQuery(name = "entites.Commentaires.CommentsByUsers", query = "SELECT c FROM Commentaires c JOIN c.utilisateur u WHERE u.nom = :paramNom")
})
public class Commentaires implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentaire;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(mappedBy = "commentaires")
    private Collection<Utilisateurs> utilisateur;
    @ManyToMany(mappedBy = "commentaires")
    private Collection<Postulation> postulations;

    //CONSTRUCTORS 
    public Commentaires() {
        postulations = new ArrayList();
        utilisateur = new ArrayList();
    }

    public Commentaires(String commentaire) {
        this();
        this.commentaire = commentaire;
    }

    // GETTERS AND SETTERS 
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<Utilisateurs> getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Collection<Utilisateurs> utilisateur) {
        this.utilisateur = utilisateur;
    }

  

    public Collection<Postulation> getPostulations() {
        return postulations;
    }

    public void setPostulations(Collection<Postulation> postulations) {
        this.postulations = postulations;
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
        if (!(object instanceof Commentaires)) {
            return false;
        }
        Commentaires other = (Commentaires) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return commentaire;
    }

}
