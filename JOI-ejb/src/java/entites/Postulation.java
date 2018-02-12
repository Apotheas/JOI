
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
    @NamedQuery(name = "entites.Postulation.AllPostulation", query = "SELECT p FROM Postulation p"),
    @NamedQuery(name = "entites.Projets.PostulationByProject", query = "SELECT p FROM Postulation p JOIN p.projet i WHERE i.id = :PramNom")   
})
public class Postulation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String oneLineDescription;
    private String image;
    private String video;
    private String explication;
    private String beneficiare;
    private String impact;
    private String innovation;
    private String plus;
    
    @ManyToMany
    private Collection<Commentaires> commentaires;
    @ManyToMany
    private Collection<Champs> champs;
    @OneToMany(mappedBy = "postulation")
    private Collection<Utilisateurs> utilisateur;
    @OneToMany(mappedBy = "postulation")
    private Collection<Projets> projet;
    @OneToMany(mappedBy = "postulations")
    private Template template;
    
    //CONSTRUCTORS 

    public Postulation() {
        commentaires = new ArrayList();
        champs = new ArrayList();
        utilisateur = new ArrayList();
        projet = new ArrayList();
    }

    public Postulation(String titre, String oneLineDescription, String explication, String beneficiare, String impact, String innovation) {
        this();
        this.titre = titre;
        this.oneLineDescription = oneLineDescription;
        this.explication = explication;
        this.beneficiare = beneficiare;
        this.impact = impact;
        this.innovation = innovation;
    }

    public Postulation(String titre, String oneLineDescription, String explication, String beneficiare, String impact, String innovation, String plus) {
        this();
        this.titre = titre;
        this.oneLineDescription = oneLineDescription;
        this.explication = explication;
        this.beneficiare = beneficiare;
        this.impact = impact;
        this.innovation = innovation;
        this.plus = plus;
    }
    

    public Postulation(String titre, String oneLineDescription, String image, String video, String explication, String beneficiare, String impact, String innovation, String plus) {
        this();
        this.titre = titre;
        this.oneLineDescription = oneLineDescription;
        this.image = image;
        this.video = video;
        this.explication = explication;
        this.beneficiare = beneficiare;
        this.impact = impact;
        this.innovation = innovation;
        this.plus = plus;
    }

    public Postulation(String titre, Date date, String oneLineDescription, String image, String video, String explication, String beneficiare, String impact, String innovation, String plus, Utilisateurs utilisateur, Projets projet) {
        this();
        this.titre = titre;
        this.date = date;
        this.oneLineDescription = oneLineDescription;
        this.image = image;
        this.video = video;
        this.explication = explication;
        this.beneficiare = beneficiare;
        this.impact = impact;
        this.innovation = innovation;
        this.plus = plus;
        
    }
    
    
    
    // GETTERS AND SETTERS

    public Date getDate() {
        return date;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<Champs> getChamps() {
        return champs;
    }

    public void setChamps(Collection<Champs> champs) {
        this.champs = champs;
    }

    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getOneLineDescription() {
        return oneLineDescription;
    }

    public void setOneLineDescription(String oneLineDescription) {
        this.oneLineDescription = oneLineDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getExplication() {
        return explication;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public String getBeneficiare() {
        return beneficiare;
    }

    public void setBeneficiare(String beneficiare) {
        this.beneficiare = beneficiare;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getInnovation() {
        return innovation;
    }

    public void setInnovation(String innovation) {
        this.innovation = innovation;
    }

    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Utilisateurs> getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Collection<Utilisateurs> utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Collection<Projets> getProjet() {
        return projet;
    }

    public void setProjet(Collection<Projets> projet) {
        this.projet = projet;
    }

    

    public Collection<Commentaires> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Collection<Commentaires> commentaires) {
        this.commentaires = commentaires;
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
        if (!(object instanceof Postulation)) {
            return false;
        }
        Postulation other = (Postulation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Postulation[ id=" + id + " ]";
    }
    
}
