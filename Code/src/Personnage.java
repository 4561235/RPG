
public class Personnage {
	
	private String nom;
	private int hp;
	private int hpmax;
	private int pa;
	private int pamax;
	private boolean joueur;
	
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
