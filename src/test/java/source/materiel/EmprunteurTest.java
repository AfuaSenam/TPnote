package source.materiel;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmprunteurTest {

	Emprunteur e1;

    @Before
    public void setUp() {
        e1 = new Emprunteur();
    }

    @Test
    public void ajouterAuStock() {
        int stock = e1.listerMateriel().size();
        e1.ajouterAuStock(new UC());

        Assert.assertEquals("ajouterAuStock: fail", stock+1, e1.listerMateriel().size());
    }

    @Test
    public void listerMateriel() {
        e1.setStock(new ArrayList<Empruntable>()) ;
        int stock = e1.getStock().size();
        e1.getStock().add(new UC());

        int newStock = e1.listerMateriel().size();

        Assert.assertEquals("listeMateriel: fail", stock+1, newStock);
    }

    @Test
    public void perdreMateriel() {
        Empruntable emprunt1 = new UC();
        e1.listerMateriel().add(emprunt1);

        boolean result = e1.perdreMateriel(emprunt1);

        Assert.assertEquals("perdreMateriel: méthode fail", true, result);
        Assert.assertEquals("perdreMateriel: taille fail", 0, e1.listerMateriel().size());
    }

}
