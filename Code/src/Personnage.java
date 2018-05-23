
public class Personnage {
	
	private String nom;
	private int hp;
	private int hpmax;
	private int pa;
	private int pamax;
	
	public Personnage()
	{
		this.nom="Perso1";
		this.hp=100;
		this.hpmax=100;
		this.pa=10;
		this.pamax=10;
	}
	
	public String getNom()
	{
		return this.nom;
	}

}
