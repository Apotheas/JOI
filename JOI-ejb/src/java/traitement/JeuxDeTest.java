
package traitement;

import entites.Categorie;
import entites.Champs;
import entites.Commentaires;
import entites.Droits;
import entites.Postulation;
import entites.Projets;
import entites.Team;
import entites.Template;
import entites.Utilisateurs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Apotheas
 */
@Stateless
public class JeuxDeTest implements JeuxDeTestLocal {

    @PersistenceContext(unitName = "JOI-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
   @Override
   public void creerDonnees(){
       
       Utilisateurs user01 = new Utilisateurs("Zerbib", "Jonathan", "zerbib.jonathan@laposte.net", "root");
       Utilisateurs user02 = new Utilisateurs("Chouraqui", "Brigitte", "Brigitte.chouraqui@gmail.com", "user01");
       Utilisateurs user03 = new Utilisateurs("Zerbib", "Alain", "zerbib.alain@laposte.net", "user02");
       Utilisateurs user04 = new Utilisateurs("Berlancourt", "Anne", "Berlancourt.anne@gmail.com", "user03");
       Utilisateurs user05 = new Utilisateurs("Zaffaroni", "Vincent", "Zaffaroni.vincent@gmail.com", "user04");
       Utilisateurs user06 = new Utilisateurs("Boulon", "Christophe", "boulon.christophe@gmail.com", "user05");
       Utilisateurs user07 = new Utilisateurs("Washiton", "George", "Washinton.george@gmail.com", "user06");
       Utilisateurs user08 = new Utilisateurs("Cuaz", "Miltord", "Miltiord.cuaz@gmail.com", "user07");
       Utilisateurs user09 = new Utilisateurs("Ponto", "Guillaume", "Ponto.guillaume@gmail.com", "user08");
       em.persist(user01);
       em.persist(user02);
       em.persist(user03);
       em.persist(user04);
       em.persist(user05);
       em.persist(user06);
       em.persist(user07);
       em.persist(user09);
       em.persist(user08);
       
       Droits root = new Droits("root");
       Droits sousAdmin = new Droits("sousAdmin");
       Droits manager = new Droits("Manager");
       Droits moderateur = new Droits("Moderateur");
       Droits simple = new Droits("Simple");
       em.persist(root);
       em.persist(sousAdmin);
       em.persist(manager);
       em.persist(moderateur);
       em.persist(simple);
       
       user01.setDroit(root);
       user02.setDroit(sousAdmin);
       user03.setDroit(manager);
       user04.setDroit(moderateur);
       user05.setDroit(simple);
       user06.setDroit(simple);
       user07.setDroit(simple);
       user08.setDroit(simple);
       user09.setDroit(simple);
       
       Commentaires comment01 = new Commentaires("Superbe projet, même si de mon point de vue un chat ne devrait pas etre utiliser comme transistor...");
       Commentaires comment02 = new Commentaires("je ne pense pas que concetuellement ce projet soit réalisable, il faudrait une trop grosse infrastructure et bien entendu, cela prendrai beaucoup trop de temps  à mettre en place ");
       Commentaires comment03 = new Commentaires("il faudrait trouver une solution concernant le monitoring, imaginons que je n'ai pas internet, comment pourrais-je me tenir informer en temps réel !? mais sinon superbe idées !! Bravo !!  ");
       Commentaires comment04 = new Commentaires("cool comme projet ! tenez-nous informez de l'avancement, et si vs avez besoin de moyens techniques n'hesitez pas à nous contacter. on adorerait travailler avec vous ! ");
       Commentaires comment05 = new Commentaires("je ne pense pas que vortre idée puisse fonctionner dans le contexte actuelle à cause de l'ambition");
       Commentaires comment06 = new Commentaires("pas terrrible !!!! je dirais même à chier !!! vive airPaca !!!");
       em.persist(comment01);
       em.persist(comment02);
       em.persist(comment03);
       em.persist(comment04);
       em.persist(comment05);
       em.persist(comment06);
       
       Team team01 = new Team("poneyTeam");
       Team team02 = new Team("horseTeam");
       Team team03 = new Team("hippoTeam");
       Team team04 = new Team("dadaTeam");
       em.persist(team01);
       em.persist(team02);
       em.persist(team03);
       em.persist(team04);
       
       Categorie cat01 = new Categorie("Environement");
       Categorie cat02 = new Categorie("Air");
       Categorie cat03 = new Categorie("Test");
       Categorie cat04 = new Categorie("Autre");
       em.persist(cat01);
       em.persist(cat02);
       em.persist(cat03);
       em.persist(cat04);
       
       Template temp01 = new Template("sujet Ecologique", "Template specifique aux sujets ecolo europeens");
       Template temp02 = new Template("sujet Economique", "economies des pays sous-develloppé");
       em.persist(temp01);
       em.persist(temp02);
       
       Champs champ01 = new Champs("Target", "WHO WE’RE DESIGNING FOR");
       Champs champ02 = new Champs("Process","THE AIRPACA CHALLENGE PROCESS");
       Champs champ03 = new Champs("Goals", "GOALS FOR THE CHALLENGE");
       Champs champ04 = new Champs("Criteres","EVALUATION CRITERIA");
       Champs champ05 = new Champs("Conseils","ADVISORS");
       em.persist(champ01);
       em.persist(champ02);
       em.persist(champ03);
       em.persist(champ04);
       em.persist(champ05);
       
       user01.getTeam().add(team01);
       user01.getTeam().add(team02);
       user02.getTeam().add(team01);
       user02.getTeam().add(team03);
       user03.getTeam().add(team01);
       user03.getTeam().add(team04);
       user04.getTeam().add(team01);
       user04.getTeam().add(team04);
       user05.getTeam().add(team02);
       user05.getTeam().add(team03);
       user06.getTeam().add(team03);
       user06.getTeam().add(team02);
       user07.getTeam().add(team02);
       user07.getTeam().add(team04);
       user08.getTeam().add(team04);
       user08.getTeam().add(team01);
       user09.getTeam().add(team02);
       user09.getTeam().add(team03);
       
       em.flush();
       
      
       
       
       
       
       
       
       
  
       
       
       
       
      
       
       
       
       
       
       
       
       
       
       
       
       
       
       
   }
    
    
}
