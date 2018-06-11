import java.util.ArrayList;


public class Coordonnees {

	private int x;
	private int y;
	private char lettre;
	private Personnage personnage;
	private ArrayList<Objet> listeObjet = new ArrayList<Objet>();
	

	public Coordonnees(int x, int y, char lettre, Personnage personnage )
	{
		this.x=x;
		this.y=y;
		this.lettre=lettre;
		this.personnage=personnage;
	}
	
	public Coordonnees(Coordonnees c) {
		this.x=c.x;
		this.y=c.y;
		this.lettre=c.lettre;
		this.personnage=new Personnage(c.personnage);
	}
	
	public void ajouterObjet(Objet o)
	{
		this.listeObjet.add(o);
	}
	
	public void enleverObjet(Objet o)
	{
		this.listeObjet.remove(o);
	}

	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public char getLettre()
	{
		return this.lettre;
	}
	
	public Personnage getPersonnage()
	{
		return this.personnage;
	}
	
	public void setX(int x)
	{
		this.x=x;
	}
	
	public void setY(int y)
	{
		this.y=y;
	}
	
	public void setPersonnage(Personnage personnage)
	{
		this.personnage=personnage;
	}
	
	public void setLettre(char lettre)
	{
		this.lettre=lettre;
	}
	
	public String toString()
	{
		String objets = "";
		
		for(int i = 0; i<listeObjet.size(); i++)
		{
			objets = listeObjet.get(i).getNom()+"," +objets;
			//System.out.println("test objet" +listeObjet.get(i).getNom());
		}
		
		if(this.personnage != null) //On regarde si le personnage est null car on ne peut pas utiliser getNom() sur NULL
		{
			return "la coordonnees X: " +this.x +" la coordonnees Y: " +this.y +" la lettre: " +this.lettre +" le personnage: " +this.personnage.getNom() +" les objets: "+objets;
		}
		else
		{
			return "la coordonnees X: " +this.x +" la coordonnees Y: " +this.y +" la lettre: " +this.lettre +" le personnage: " +this.personnage +" les objets: " +objets;
		}
	}
	
	public ArrayList<Objet> getListeObjet() {
		return listeObjet;
	}

	public void setListeObjet(ArrayList<Objet> listeObjet) {
		this.listeObjet = listeObjet;
	}
}
