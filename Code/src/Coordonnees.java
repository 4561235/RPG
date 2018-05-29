
public class Coordonnees {

	private int x;
	private int y;
	private char lettre;
	private Personnage personnage;
	
	public Coordonnees(int x, int y, char lettre, Personnage personnage )
	{
		this.x=x;
		this.y=y;
		this.lettre=lettre;
		this.personnage=personnage;
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
		if(this.personnage != null) //On regarde si le personnage est null car on ne peut pas utiliser getNom() sur NULL
		{
			return "la coordonnees X: " +this.x +" la coordonnees Y: " +this.y +" la lettre: " +this.lettre +" le personnage: " +this.personnage.getNom();
		}
		else
		{
			return "la coordonnees X: " +this.x +" la coordonnees Y: " +this.y +" la lettre: " +this.lettre +" le personnage: " +this.personnage;
		}
	}
}
