package source.materiel;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class AdministrateurTest {

	Entreprise e;
    Agence a1, a2;
    Empruntable e1, e2, e3, e4, e5, e6;
    Employe admin, emp1, emp2, emp3, emp4;

    @Before
    public void setUp() throws Exception {

        e = new Entreprise("Super Entreprise de l'ENSIM");
        a1 = new Agence("Agence du Sud");
        a2 = new Agence("Agence du Nord");

        e.getAgences().add(a1);
        e.getAgences().add(a2);

        e1 = new UC(true);
        e2 = new Ecran();
        e3 = new Souris();
        e4 = new Clavier();
        e5 = new Clavier();
        e6 = new Ecran();

        /*
        e.ajouterAuStock(e1);
        e.ajouterAuStock(e2);
        e.ajouterAuStock(e3);
        e.ajouterAuStock(e4);
        e.ajouterAuStock(e5);
        e.ajouterAuStock(e6);
        */


        admin = new Administrateur(a1, e);
        emp1 = new Employe(a1, e);
        emp2 = new Employe(a1, e);
        emp3 = new Employe(a2, e);
        emp4 = new Employe(a2, e);

        a1.getEmploye().add(admin);
        a1.getEmploye().add(emp1);
        a1.getEmploye().add(emp2);

        a2.getEmploye().add(emp3);
        a2.getEmploye().add(emp4);
        /*
        e5.declarerDefectueux();
        e6.declarerDefectueux();
        */
    }

    @Test
    public void attribuerMateriel() {

        int stockActuel = admin.listerMateriel().size();
        ((Administrateur) admin).attribuerMateriel(new Ecran(), admin);

        Assert.assertEquals("attribuerMateriel: fail", stockActuel+1, admin.listerMateriel().size());
    }


    @Test
    public void recupererMateriel() {

        int stockActuel = admin.listerMateriel().size();
        emp1.listerMateriel().add(e1);
        ((Administrateur) admin).recupererMateriel(e1, emp1);

        Assert.assertEquals("recupererMateriel: fail", stockActuel+1, admin.listerMateriel().size());
    }

    @Test
    public void stockEntreprise() {
        e.listerMateriel().add(e1);
        int stockEntreprise = ((Administrateur) admin).stockEntreprise().size();
        Assert.assertEquals("stock entreprise: fail", 1, stockEntreprise);
    }

    @Test
    public void stockAgence() {
        a1.listerMateriel().add(e1);
        int stockAgence = ((Administrateur) admin).stockAgence().size();
        Assert.assertEquals("stock agence de l'admin: fail", 1, stockAgence);
    }

    @Test
    public void transfererMateriel_envoyeurNaPasObjetTransfere() {
        int stockEmp2 = emp2.listerMateriel().size();
        ((Administrateur) admin).transfererMateriel(emp1, e2, emp2);
        Assert.assertEquals("transfererMateriel (envoyeur n'a pas l'objet transféré): fail", stockEmp2, emp2.listerMateriel().size());
    }

    @Test
    public void transfererMateriel_envoyeurAObjectMaisReserveAgence() {
        int stockEmp2 = emp2.listerMateriel().size();
        a1.listerMateriel().add(e1);
        ((Administrateur) admin).transfererMateriel(a1, e1, emp2);
        Assert.assertEquals("transfererMateriel (envoyeur a l'objet mais transfert réservé agences): fail", stockEmp2, emp2.listerMateriel().size());
    }

    @Test
    public void transfererMateriel_OK() {
        int stockEmp2 = emp2.listerMateriel().size();
        emp1.listerMateriel().add(e2);
        ((Administrateur) admin).transfererMateriel(emp1, e2, emp2);
        Assert.assertEquals("transfererMateriel (transfert OK): fail", stockEmp2+1, emp2.listerMateriel().size());
    }


    @Test
    public void supprimerMaterielDefectueuxEntreprise_sansMaterielDefectueux() {
        e.listerMateriel().add(e4);
        e.listerMateriel().add(e5);

        int stockE = e.listerMateriel().size();
        ((Administrateur) admin).supprimerMaterielDefEntreprise(e);
        Assert.assertEquals("supprimerMaterielDefectueuxEntreprise_sansMaterielDefectueux: fail", stockE, e.listerMateriel().size());
    }

    @Test
    public void supprimerMaterielDefectueuxEntreprise_avecMaterielDefectueux() {
        e.listerMateriel().add(e4);
        e.listerMateriel().add(e5);
        e5.declarerDefectueux();

        int stockE = e.listerMateriel().size();
        ((Administrateur) admin).supprimerMaterielDefEntreprise(e);
        Assert.assertEquals("supprimerMaterielDefectueuxEntreprise_avecMaterielDefectueux: fail", stockE-1, e.listerMateriel().size());
        for (Empruntable e : e.listerMateriel()) {
            Assert.assertEquals("supprimerMaterielDefectueuxEntreprise_avecMaterielDefectueux: fail car il reste un Empruntable defectueux", false, e.isDefectueux());
        }
    }

    @Test
    public void supprimerMaterielDefectueuxAgence_sansMaterielDefectueux() {
        a1.listerMateriel().add(e4);
        a1.listerMateriel().add(e5);

        int stockA1 = a1.listerMateriel().size();
        ((Administrateur) admin).supprimerMaterielDefectueuxAgence();
        Assert.assertEquals("supprimerMaterielDefectueuxAgence_sansMaterielDefectueux: fail", stockA1, a1.listerMateriel().size());
    }

    @Test
    public void supprimerMaterielDefectueuxAgence_avecMaterielDefectueux() {
        a1.listerMateriel().add(e4);
        a1.listerMateriel().add(e5);
        e5.declarerDefectueux();

        int stockA1 = a1.listerMateriel().size();
        ((Administrateur) admin).supprimerMaterielDefectueuxAgence();
        Assert.assertEquals("supprimerMaterielDefectueuxAgence_avecMaterielDefectueux: fail", stockA1-1, a1.listerMateriel().size());
        for (Empruntable e : a1.listerMateriel()) {
            Assert.assertEquals("supprimerMaterielDefectueuxAgence_avecMaterielDefectueux: fail car il reste un Empruntable defectueux", false, e.isDefectueux());
        }
    }
}
