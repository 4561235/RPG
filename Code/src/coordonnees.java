
public class coordonnees {
	
	private int x;
	private int y;
	private char lettre;
	//ICI les instances des joueurs et des ennemies
	
	public coordonnees(int x, int y, char lettre)
	{
		this.x=x;
		this.y=y;
		this.lettre=lettre;
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
	
	public void setX(int x)
	{
		this.x=x;
	}
	
	public void setY(int y)
	{
		this.y=y;
	}
	
	public void setLettre(char lettre)
	{
		this.lettre=lettre;
	}
}
