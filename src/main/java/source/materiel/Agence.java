package source.materiel;

import java.util.ArrayList;

public class Agence extends Emprunteur{
	private ArrayList <Employe> employe=new ArrayList<Employe>();
	

	public ArrayList<Employe> getEmploye() {
		return employe;
	}

	public void setEmploye(ArrayList<Employe> employe) {
		this.employe = employe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	private String nom;
	
	public Agence()
	{
		
	}
	
}
