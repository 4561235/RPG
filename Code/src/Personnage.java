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
	
	public void ajouterObjet(Objet o)
	{
		this.listeObjet.add(o);
	}
	
	public void enleverObjet(Objet o)
	{
		for(int i = 0; i < this.listeObjet.size();i++)
		{
			if(o.getNom().equals(this.listeObjet.get(i)))
			{
				this.listeObjet.remove(i);
			}
		}
	}
	
	public void choixObjet()
	{
		for(int i = 0; i < this.listeObjet.size();i++)
		{
			System.out.println(i +": " +this.listeObjet.get(i).getNom() );
		}
		
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
			action = this.input.next();
			
			try
			{
				nombreChoix = Integer.parseInt(action);
			}
			catch(Exception e)
			{
				nombreChoix = -1;
			}
			
			
			System.out.println("Veuillez choisir une cible valide");
			
		} 
		
		if(nombreChoix >= 0 && nombreChoix <= this.listeObjet.size())
		{
			this.listeObjet.get(nombreChoix).activerObjet(this);
			this.enleverObjet(listeObjet.get(nombreChoix));
			
		}
		
		
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
	
	
	

}
