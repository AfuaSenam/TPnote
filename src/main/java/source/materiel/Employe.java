package source.materiel;

public class Employe extends Emprunteur{
	private Agence agence;
	private Entreprise entreprise;
	
	public Employe()
	{
		
	}
	
	public Employe(Agence agence,Entreprise entreprise)
	{
		this.agence=agence;
		this.entreprise=entreprise;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	
}
