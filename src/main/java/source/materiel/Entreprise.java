package source.materiel;

import java.util.ArrayList;

public class Entreprise extends Emprunteur{
	private ArrayList <Agence> agences=new ArrayList<Agence>();
	private ArrayList <Employe> employe=new ArrayList<Employe>();
	public ArrayList<Agence> getAgences() {
		return agences;
	}

	public void setAgences(ArrayList<Agence> agences) {
		this.agences = agences;
	}

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
	
	public Entreprise()
	{
		super();
	}
	public Entreprise(String phrase)
	{
		this.nom=phrase;
	}
}
