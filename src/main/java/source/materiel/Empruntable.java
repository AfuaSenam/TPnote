package source.materiel;

public class Empruntable {
	private boolean limitationPretAgence;
	private boolean defectueux;
	
	public Empruntable()
	{
		
	}

	public boolean isLimitationPretAgence() {
		return limitationPretAgence;
	}

	public void setLimitationPretAgence(boolean limitationPretAgence) {
		this.limitationPretAgence = limitationPretAgence;
	}

	public boolean isDefectueux() {
		return defectueux;
	}

	public void setDefectueux(boolean defectueux) {
		this.defectueux = defectueux;
	}
	
	//Fonction declarer defectueux
	public void declarerDefectueux()
	{
		this.setDefectueux(true);
	}
	
	
}
