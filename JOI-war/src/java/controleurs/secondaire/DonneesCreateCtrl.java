package controleurs.secondaire;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import traitement.JeuxDeTestLocal;

public class DonneesCreateCtrl implements Serializable, SousControleur {

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        JeuxDeTestLocal jeuxDeTest = lookupJeuxDeTestLocal();
        try {
            jeuxDeTest.creerDonnees();
            request.setAttribute("dClasse", "info");
            request.setAttribute("msg", "You did it !");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("dClasse", "erreur");
            request.setAttribute("msg", "ECHEEEEEEEEC ! Regarde dont tes logs !!");
        }
        return "/WEB-INF/home.jsp";
    }
    private JeuxDeTestLocal lookupJeuxDeTestLocal() {
        try {
            Context c = new InitialContext();
            return (JeuxDeTestLocal) c.lookup("java:global/JOI/JOI-ejb/JeuxDeTest!traitement.JeuxDeTestLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
