
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries({
    @NamedQuery(name = "entites.Projets.AllProjets", query = "SELECT p FROM Projets p"),
    @NamedQuery(name = "entites.Projets.ProjetsById", query = "SELECT p FROM Projets p WHERE p.id = :PramNom"),
    @NamedQuery(name = "entites.Projets.ProjetsByNom", query = "SELECT p FROM Projets p WHERE p.nom = :PramNom")
    
})
public class Projets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String cible;
    private String process;
    private String criteresDeval;
    private String reward;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    private boolean dispo;
    private String photo;
    private int nbMaxParticipants;
    
    //MAPP TO DO
    
    @ManyToOne
    private Postulation postulation;
    @ManyToMany
    private Collection<Categorie> categorie;
    @ManyToMany
    private Collection<Evenements> evenement;
    @ManyToMany
    private Collection<Team> team;
    @OneToMany(mappedBy = "projets")
    private Template template;
    
    // CONSTRUCTORS

    public Projets() {
        team = new ArrayList();
        categorie = new ArrayList();
        evenement = new ArrayList();
    }

    public Projets(String nom, String description, String cible, String process, String criteresDeval, String reward, boolean dispo, int nbMaxParticipants) {
        this();
        this.nom = nom;
        this.description = description;
        this.cible = cible;
        this.process = process;
        this.criteresDeval = criteresDeval;
        this.reward = reward;
        this.dispo = dispo;
        this.nbMaxParticipants = nbMaxParticipants;
    }

    public Projets(String nom, String description, Date dateDebut, Date dateFin, boolean dispo, int nbMaxParticipants) {
        this();
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dispo = dispo;
        this.nbMaxParticipants = nbMaxParticipants;
    }

    public Projets(String nom, String description, Date dateDebut, Date dateFin, boolean dispo, String photo, int nbMaxParticipants) {
        this();
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dispo = dispo;
        this.photo = photo;
        this.nbMaxParticipants = nbMaxParticipants;
    }

    public Projets(String nom, String description, boolean dispo, String photo, int nbMaxParticipants) {
        this();
        this.nom = nom;
        this.description = description;
        this.dispo = dispo;
        this.photo = photo;
        this.nbMaxParticipants = nbMaxParticipants;
    }
    
    
    // GETTERS AND SETTERS 

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
    
    public Collection<Team> getTeam() {
        return team;
    }

    public void setTeam(Collection<Team> team) {
        this.team = team;
    }
    public String getCible() {
        return cible;
    }

    public void setCible(String cible) {
        this.cible = cible;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getCriteresDeval() {
        return criteresDeval;
    }

    public void setCriteresDeval(String criteresDeval) {
        this.criteresDeval = criteresDeval;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public Postulation getPostulation() {
        return postulation;
    }

    public void setPostulation(Postulation postulation) {
        this.postulation = postulation;
    }

   

    public Collection<Categorie> getCategorie() {
        return categorie;
    }

    public void setCategorie(Collection<Categorie> categorie) {
        this.categorie = categorie;
    }

    public Collection<Evenements> getEvenement() {
        return evenement;
    }

    public void setEvenement(Collection<Evenements> evenement) {
        this.evenement = evenement;
    }

    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNbMaxParticipants() {
        return nbMaxParticipants;
    }

    public void setNbMaxParticipants(int nbMaxParticipants) {
        this.nbMaxParticipants = nbMaxParticipants;
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
        if (!(object instanceof Projets)) {
            return false;
        }
        Projets other = (Projets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Projets[ id=" + id + " ]";
    }
    
}
