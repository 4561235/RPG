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
		System.out.println("pv apr�s" + defenseur.getHp());
		this.mort(defenseur);
	}
	
	//Mort: si les Pv d'un personnage sont inf�rieur ou �gal � 0, il est supprim� de la carte
	
	public void mort(Personnage p){
		if (p.getHp()<=0) {this.carte.remplacerSurLaMap(this.carte.chercherPersonnage(p).getX(), this.carte.chercherPersonnage(p).getY(), ' ', null);}
	}
	
	//M�thode donnant au joueur le choix de la direction dans la quelle attaquer
	
	public void choixAttaquer(Personnage p, ArrayList<Coordonnees> autour) {
		
		//V�rification de sdirections disponible
		
		boolean haut   = (autour.get(0).getPersonnage()!=null);
		boolean gauche = (autour.get(1).getPersonnage()!=null);
		boolean droite    = (autour.get(2).getPersonnage()!=null);
		boolean bas = (autour.get(3).getPersonnage()!=null);
		
		System.out.println("Vous pouvvez attaquer:");
		if (haut) {System.out.println("haut: " + autour.get(0).getPersonnage().getNom());}
		if (gauche) {System.out.println("gauche: " + autour.get(1).getPersonnage().getNom());}
		if (droite) {System.out.println("droite: " + autour.get(2).getPersonnage().getNom());}
		if (bas) {System.out.println("bas: " + autour.get(3).getPersonnage().getNom());}
		
		//tant que la cible n'est pas valide
		
		String action = this.carte.getInput().next();
		while  ((action.equals("haut") && !(haut)) ||
				(action.equals("bas") && !(bas)) ||
				(action.equals("gauche") && !(gauche)) ||
				(action.equals("droite") && !(droite)) ||
				!(action.equals("haut") || action.equals("bas") || action.equals("gauche") || action.equals("droite"))) {
			
			System.out.println("Veuillez choisir une cible valide");
			action = this.carte.getInput().next();
		}
		
			 if (action.equals("haut"))   {this.attaquer(p, autour.get(0).getPersonnage());}
		else if (action.equals("gauche")) {this.attaquer(p, autour.get(1).getPersonnage());}
		else if (action.equals("droite")) {this.attaquer(p, autour.get(2).getPersonnage());}
		else if (action.equals("bas"))    {this.attaquer(p, autour.get(3).getPersonnage());}
		
	}
}
