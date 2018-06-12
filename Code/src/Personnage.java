import java.util.ArrayList;
import java.util.Scanner;

public class Personnage {
	
	private String nom;
	private int hp;
	private int hpmax;
	private int pa;
	private int pamax;
	private boolean joueur;
	
	private ArrayList<Objet> listeObjet = new ArrayList<Objet>();
	private Scanner input = new Scanner(System.in);
	
	public Personnage()
	{
		this.nom="Perso1";
		this.hp=100;
		this.hpmax=100;
		this.pa=10;
		this.pamax=10;
		this.joueur=false;
	}
	
	

	public Personnage(String nom, int hp, int hpmax, int pa, int pamax, boolean joueur) {
		super();
		this.nom = nom;
		this.hp = hp;
		this.hpmax = hpmax;
		this.pa = pa;
		this.pamax = pamax;
		this.joueur=joueur;
	}

	public Personnage(String nom, int hpmax, int pamax, boolean joueur) {
		super();
		this.nom = nom;
		this.hp = hpmax;
		this.hpmax = hpmax;
		this.pa = pamax;
		this.pamax = pamax;
		this.joueur=joueur;
	}
	
	public Personnage(Personnage p) {
		this.nom=p.nom;
		this.hp=p.hp;
		this.hpmax=p.hpmax;
		this.pa=p.pa;
		this.pamax=p.pamax;
		this.joueur=p.joueur;
		this.listeObjet=new ArrayList<Objet>(p.listeObjet);
	}
	
	
	public void ajouterObjet(Objet o)
	{
		this.listeObjet.add(o);
	}
	
	public void enleverObjet(Objet o)
	{
		for(int i = 0; i < this.listeObjet.size();i++)
		{
			if(o.getNom().equals(this.listeObjet.get(i).getNom()))
			{
				this.listeObjet.remove(i);
			}
		}
	}
	
	public boolean choixObjet()
	{
		boolean leChoixEstFait = true;
		
		for(int i = 0; i < this.listeObjet.size();i++)
		{
			System.out.println(i +": " +this.listeObjet.get(i).getNom() );
		}
		System.out.println("a: annuler");
		
		String action = this.input.next(); 
		int nombreChoix;
		
		try
		{
			nombreChoix = Integer.parseInt(action);
		}
		catch(Exception e)
		{
			nombreChoix = -1;
		}
		
		while(!(nombreChoix >= 0 && nombreChoix <= this.listeObjet.size()-1)) 
		{
			
			try
			{
				nombreChoix = Integer.parseInt(action);
				if( nombreChoix <= this.listeObjet.size()-1)
				{
					break;
				}
			}
			catch(Exception e)
			{
				nombreChoix = -1;
			}
			
			if(action.equals("a"))
			{
				return false;
			}
			
			System.out.println("Veuillez choisir un objet valide");
			action = this.input.next();
			
		} 
		
		if(nombreChoix >= 0 && nombreChoix <= this.listeObjet.size()-1)
		{
			this.listeObjet.get(nombreChoix).activerObjet(this);
			this.enleverObjet(listeObjet.get(nombreChoix));
			
		}
		
		if(action.equals("a"))
		{
			return false;
		}
		
		return leChoixEstFait;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHpmax() {
		return hpmax;
	}

	public void setHpmax(int hpmax) {
		this.hpmax = hpmax;
	}

	public int getPa() {
		return pa;
	}

	public void setPa(int pa) {
		this.pa = pa;
	}

	public int getPamax() {
		return pamax;
	}

	public void setPamax(int pamax) {
		this.pamax = pamax;
	}

	public boolean isJoueur() {
		return joueur;
	}

	public void setJoueur(boolean joueur) {
		this.joueur = joueur;
	}
	
	public String toString() {
		return (
			"Personnage [\n"+
			"nom:" + this.nom +
			"\npv:" + this.hp +"/"+this.hpmax+
			"\npa:" + this.pa +"/"+this.pamax+
			"\nest un joueur:" + this.joueur+ "]\n"
		);
	}
	

}
