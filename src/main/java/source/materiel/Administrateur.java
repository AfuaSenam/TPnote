package source.materiel;

import java.util.ArrayList;

public class Administrateur extends Employe {

	public Administrateur()
	{
		
	}
	
	public Administrateur(Agence agence,Entreprise entreprise)
	{
		super(agence,entreprise);
	}
	
	//Attribuer le materiel
	public boolean attribuerMateriel(Empruntable matos,Emprunteur emprunteur)
	{
		boolean marche=false;
		if(matos.isLimitationPretAgence())
		{
			emprunteur.ajouterAuStock(matos);
			marche=true;
		}
		
		return marche;
	}
	
	//retirer le matos
	/*
	 * Si matos est toujours dans le stock alors on retourne true
	 */
	public boolean recupererMateriel(Empruntable matos,Emprunteur emprunteur)
	{
		boolean marche=false;
		Empruntable matosArestituer;
		for(Empruntable matoss:emprunteur.getStock())
		{
			if(matos.equals(matoss))
			{
				matosArestituer=matos;
				emprunteur.getStock().remove(matos);
				marche=true;
			}
		}
		return marche;
	}
	
	//Lister le materiel d'une entreprise
	public ArrayList<Empruntable> stockEntreprise()
	{
		return this.getEntreprise().listerMateriel();
		
	}
	
	//Lister le materiel d'une agence
	public ArrayList<Empruntable> stockAgence()
	{
		return this.getAgence().listerMateriel();
			
	}
	
	//transferer le materiel
	public void transfererMateriel(Emprunteur emprunteur1,Empruntable matos,Emprunteur emprunteur2)
	{
		emprunteur1.ajouterAuStock(matos);
		emprunteur2.retirerMatos(matos);
	}
	
	//Suprrimer le materiel de l'admin
	public void supprimerMateriel(Empruntable matos)
	{
		if(this.rechercheMatos(matos))
		{
			this.retirerMatos(matos);
			//log 
		}
		//log
	}
	
	
	//supprime les matos defectueux de l'agence
	public void supprimerMaterielDefAgence(Agence agence)
	{
		for(Empruntable matos:agence.listerMateriel())
		{
			if(matos.isDefectueux())
			{
				agence.retirerMatos(matos);
			}
		}
	}
	
	
	//supprime les matos defectueux de l'entreprise
	public void supprimerMaterielDefEntreprise(Entreprise entreprise)
	{
		for(Empruntable matos:entreprise.listerMateriel())
		{
			if(matos.isDefectueux())
			{
				entreprise.retirerMatos(matos);
			}
		}
	}
		
	//supprime les matos defectueux de l'entreprise
	private void supprimerMaterielDefEmprunteur(Emprunteur emprunteur)
	{
		for(Empruntable matos:emprunteur.listerMateriel())
		{
			if(matos.isDefectueux())
			{
				emprunteur.retirerMatos(matos);
			}
		}
	}

	public void supprimerMaterielDefectueuxAgence() {
		for(Empruntable matos:this.getAgence().listerMateriel())
		{
			if(matos.isDefectueux())
			{
				this.getAgence().retirerMatos(matos);
			}
		}
	}

	
	
		
}
