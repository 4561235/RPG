import java.util.ArrayList;

public class Combat{
	
	private Map carte;//l'attirbut Carte est le m�me que celui de Jeu et Deplacement
	
	//Constructeurs
	
	public Combat() {
		super();
	}
	
	public Combat(Map m) {
		this.carte =(m);
	}
	
	//attaquer inflige des degats entre 3 et 5 de mani�re al�atoire
	
	public void attaquer(Personnage attaquant, Personnage defenseur) {
		int dmg =(int) (Math.random()*3+3);
		System.out.println(dmg+"\npv avant: "+defenseur.getHp());
		defenseur.setHp(defenseur.getHp()-dmg);
		System.out.println("pv apres" + defenseur.getHp());
		this.mort(defenseur);
	}
	
	//Mort: si les Pv d'un personnage sont inf�rieur ou �gal � 0, il est supprim� de la carte
	
	public void mort(Personnage p){
		if (p.getHp()<=0) {this.carte.remplacerSurLaMap(this.carte.chercherPersonnage(p).getX(), this.carte.chercherPersonnage(p).getY(), ' ', null);}
	}
	
	//M�thode donnant au joueur le choix de la direction dans la quelle attaquer
	
	public boolean choixAttaquer(Personnage p, ArrayList<Coordonnees> autour) {
		
		//V�rification de sdirections disponible
		
		boolean haut   = (autour.get(0).getPersonnage()!=null);
		boolean gauche = (autour.get(1).getPersonnage()!=null);
		boolean droite    = (autour.get(2).getPersonnage()!=null);
		boolean bas = (autour.get(3).getPersonnage()!=null);
		
		System.out.println("Vous pouvvez attaquer:");
		if (haut) {System.out.println("h: haut --> " + autour.get(0).getPersonnage().getNom());}
		if (gauche) {System.out.println("g: gauche --> " + autour.get(1).getPersonnage().getNom());}
		if (droite) {System.out.println("d: droite --> " + autour.get(2).getPersonnage().getNom());}
		if (bas) {System.out.println("b: bas --> " + autour.get(3).getPersonnage().getNom());}
		System.out.println("a: annuler");
		//tant que la cible n'est pas valide
		
		String action = this.carte.getInput().next();
		
		while  ((action.equals("h") && !(haut)) ||
				(action.equals("b") && !(bas)) ||
				(action.equals("g") && !(gauche)) ||
				(action.equals("d") && !(droite)) ||
				!(action.equals("h") || action.equals("b") || action.equals("g") || action.equals("d") || action.equals("a")))  {
			
			System.out.println("Veuillez choisir une cible valide");
			action = this.carte.getInput().next();
		}
		
			 if (action.equals("h"))   {this.attaquer(p, autour.get(0).getPersonnage());}
		else if (action.equals("g")) {this.attaquer(p, autour.get(1).getPersonnage());}
		else if (action.equals("d")) {this.attaquer(p, autour.get(2).getPersonnage());}
		else if (action.equals("b"))    {this.attaquer(p, autour.get(3).getPersonnage());}
		else if (action.equals("a"))    {return false;}
			 
		return true; //On return true pour dire que l'utilisateur a vraiment attaquer
			
		
	}
}
