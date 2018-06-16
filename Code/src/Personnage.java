import java.util.ArrayList;
import java.util.Scanner;

public class Personnage {
	
	private String nom;
	private int hp;
	private int hpmax;
	private int pa;
	private int pamax;
	private boolean joueur;
	private String metier;
	
	private ArrayList<Objet> listeObjet = new ArrayList<Objet>();
	private Scanner input = new Scanner(System.in);
	
	private Objet arme;
	private Objet armure;
	
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
	
	public Personnage(String nom, boolean joueur, String metier) {
		super();
		this.nom = nom;
		this.joueur=joueur;
		this.metier = metier;
		this.appliquerLeMetier();
	}
	
	public void appliquerLeMetier()
	{
		if(this.metier.equals("guerrier"))
		{
			this.hp = 20;
			this.hpmax = 20;
			this.pa = 3;
			this.pamax = 3;
			
			this.arme = new Objet("epee");
			this.armure = new Objet("armure simple");
			
			Objet pot1 = new Objet ("potion");
			Objet booster1 = new Objet ("boosterPA");
			this.listeObjet.add(pot1);
			this.listeObjet.add(booster1);
		}
		else if (this.metier.equals("voleur"))
		{
			this.hp = 15;
			this.hpmax = 15;
			this.pa = 3;
			this.pamax = 4;
			
			this.arme = new Objet("dague");
			this.armure = new Objet("armure legere");
			
			Objet booster1 = new Objet ("boosterPA");
			Objet booster2 = new Objet ("boosterPA");
			this.listeObjet.add(booster1);
			this.listeObjet.add(booster2);
		}
		else if(this.metier.equals("magicien"))
		{
			this.hp = 10;
			this.hpmax = 10;
			this.pa = 3;
			this.pamax = 3;
			
			this.arme = new Objet("baton magique");
			this.armure = new Objet("robe");
			
			Objet pot1 = new Objet ("potion");
			Objet pot2 = new Objet ("potion");
			this.listeObjet.add(pot1);
			this.listeObjet.add(pot2);
		}
	}
	
	public Personnage(Personnage p) {
		this.nom=p.nom;
		this.hp=p.hp;
		this.hpmax=p.hpmax;
		this.pa=p.pa;
		this.pamax=p.pamax;
		this.joueur=p.joueur;
		this.listeObjet=new ArrayList<Objet>(p.listeObjet);
		this.metier = p.metier;
	}
	
	
	public ArrayList<Objet> getListeObjet() {
		return listeObjet;
	}



	public void setListeObjet(ArrayList<Objet> listeObjet) {
		this.listeObjet = listeObjet;
	}



	public void ajouterObjet(Objet o)
	{
		this.listeObjet.add(o);
	}
	
	public void enleverObjet(int index)
	{	
		this.listeObjet.remove(index);	
	}
	
	public boolean lacherObjet(Map m)
	{
		boolean leChoixEstFait = true;
		
		System.out.println("Choisir un objet a lacher");
		
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
		
		//effet de lacher
		if(nombreChoix >= 0 && nombreChoix <= this.listeObjet.size()-1)
		{
			Coordonnees c = m.chercherPersonnage(this);
			c.ajouterObjet(this.listeObjet.get(nombreChoix));
			this.enleverObjet(nombreChoix);
			
		}
		
		if(action.equals("a"))
		{
			return false;
		}
		
		return leChoixEstFait;
		
	}
	
	
	
	public boolean choixObjet()
	{
		boolean leChoixEstFait = true;
		
		System.out.println("Choisir un objet a utiliser");
		
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
			boolean objetUtilise = this.listeObjet.get(nombreChoix).activerObjet(this);
			
			if(objetUtilise)
			{
				this.enleverObjet(nombreChoix);
			}
			
		}
		
		if(action.equals("a"))
		{
			return false;
		}
		
		return leChoixEstFait;
		
	}
	
	public boolean ramasserObjet(Coordonnees c)
	{
		boolean leChoixEstFait = true;
		
		System.out.println("Choisir un objet a rammasser");
		
		for(int i = 0; i < c.getListeObjet().size();i++)
		{
			System.out.println(i +": " +c.getListeObjet().get(i).getNom() );
		}
		
		//System.out.println("t: tous rammasser");
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
		
		while(!(nombreChoix >= 0 && nombreChoix <= c.getListeObjet().size()-1)) 
		{
			
			try
			{
				nombreChoix = Integer.parseInt(action);
				if( nombreChoix <= c.getListeObjet().size()-1)
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
			
			/*else if(action.equals("t"))
			{
				for(int i = 0; i<c.getListeObjet().size(); i++)
				{
					this.listeObjet.add(c.getListeObjet().get(i));
					c.getListeObjet().remove(i);
				}
				return leChoixEstFait;
			}*/
			
			System.out.println("Veuillez choisir un objet valide");
			action = this.input.next();
			
		}
		
		
		//L'effet du rammassage
		if(nombreChoix >= 0 && nombreChoix <= c.getListeObjet().size()-1)
		{
			this.listeObjet.add(c.getListeObjet().get(nombreChoix));
			c.getListeObjet().remove(nombreChoix);
			
		}
		
		if(action.equals("a"))
		{
			return false;
		}
		
		return leChoixEstFait;
		
	}
	
	public boolean desequiperObjet()
	{
		boolean leChoixEstFait = true;
		System.out.println("Choisir un objet a desequiper");
		
		
		if(this.arme != null)
		{
			System.out.println("w: "  +this.arme.getNom() +" INFO: degas =|--> " +this.arme.getDegas() +" defence [] " +this.arme.getDefence() );
		}
		if(this.armure != null)
		{
			System.out.println("o: "  +this.armure.getNom() +" INFO: degas =|--> " +this.armure.getDegas() +" defence [] " +this.armure.getDefence() );
		}
		
		System.out.println("a: annuler");
		String action = this.input.next(); 
		
		while (!(action.equals("w") || action.equals("o") || action.equals("a") ))
			{
				if(action.equals("a"))
				{
					return false;
				}
				
				System.out.println("choisissez un choix valide");
				action = input.next();
			}
		
		if(action.equals("w") && this.arme != null)
		{
			this.listeObjet.add(this.arme);
			this.arme = null;
		}
		else if(action.equals("o") && this.armure != null)
		{
			this.listeObjet.add(this.armure);
			this.armure = null;
		}
		
		return leChoixEstFait;
	}
	
	public boolean equiperObjet()
	{
		boolean leChoixEstFait = true;
		
		System.out.println("Choisir un objet a equiper");
		
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
			
			if(this.arme == null && this.listeObjet.get(nombreChoix).isArme() == true )
			{
				this.arme = this.listeObjet.get(nombreChoix);
				this.listeObjet.remove(nombreChoix);
			}
			else if(this.armure == null && this.listeObjet.get(nombreChoix).isArmure() == true )
			{
				this.armure = this.listeObjet.get(nombreChoix);
				this.listeObjet.remove(nombreChoix);
			}
			else
			{
				System.out.println("Impossible a equiper cet objet");
			}
			
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
	
	public Objet getArme() {
		return arme;
	}

	public void setArme(Objet arme) {
		this.arme = arme;
	}

	public Objet getArmure() {
		return armure;
	}

	public void setArmure(Objet armure) {
		this.armure = armure;
	}

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
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
