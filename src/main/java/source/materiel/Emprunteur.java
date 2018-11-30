package source.materiel;

import java.util.ArrayList;

public class Emprunteur {

	private ArrayList <Empruntable> stock=new ArrayList<Empruntable>();
	
	
	public Emprunteur()
	{
		
	}


	public ArrayList<Empruntable> getStock() {
		return stock;
	}


	public void setStock(ArrayList<Empruntable> stock) {
		this.stock = stock;
	}
	
	//Ajouter le stock
	
	public void ajouterAuStock(Empruntable matos)
	{
		this.stock.add(matos);
	}
	
	//Lister le matos
	
	public ArrayList<Empruntable> listerMateriel()
	{
		
		return getStock();
	}
	//perdre le matos et remove de la liste du stock
	public boolean perdreMateriel(Empruntable matos)
	{
		Empruntable mat=null;
		for(Empruntable emp:stock)
		{
			if(emp.equals(matos))
			{
				mat=emp;
				
			}
		}
		stock.remove(mat);
		return true;
	}
	
	//Rechercher le matos dans le stock
	public boolean rechercheMatos(Empruntable matos)
	{
		boolean recherche =false;
		for(Empruntable emp:stock)
		{
			if(emp.equals(matos))
			{
				recherche=true;
			}
		}
		return recherche;
	}
	
	//Retirer un matos du stock
	public void retirerMatos(Empruntable matos)
	{
		for(Empruntable emp:stock)
		{
			if(emp.equals(matos))
			{
				stock.remove(emp);
			}
		}
	}
}
