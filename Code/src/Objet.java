
public class Objet {
	
	//tableau des objets disponible
	private String[] objets = {"potion"};
	
	private String nom;
	
	
	public Objet(String s)
	{
		if(objetValide(s))
		{
			this.nom=s;
		}
		else
		{
			System.out.println("L'OBJET N'EXISTE PAS!");
		}
	}
	
	//On regarde si l'objet mis en parametre est dans le tableau d'objet valide
	public boolean objetValide(String s)
	{
		for(int i = 0; i < this.objets.length; i++)
		{
			if(!(s.equals(objets[i])))
			{
				return false;
			}
		}
		
		return true;
	}
	
	//C'est ici que on va mettre les effet des objets
	public void activerObjet(Personnage p)
	{
		//Effet de la potion
		if(this.nom.equals("potion"))
		{
			p.setHp(p.getHp() + 20);
			
			if(p.getHpmax()<=p.getHp());
			{
				p.setHp(p.getHpmax());
			}
		}
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	
}