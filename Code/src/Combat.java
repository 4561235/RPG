import java.util.ArrayList;

public class Combat{
	
	private Map carte;//l'attirbut Carte est le mï¿½me que celui de Jeu et Deplacement
	
	//Constructeurs
	
	public Combat() {
		super();
	}
	
	public Combat(Map m) {
		this.carte =(m);
	}
	
	//attaquer inflige des degats entre 3 et 5 de maniï¿½re alï¿½atoire
	
	public void attaquer(Personnage attaquant, Personnage defenseur) {
		
		int dmg = 0;
		
		if (attaquant.getArme()!=null) {
			dmg += attaquant.getArme().getDegas();
		}
		
		if (defenseur.getArmure() != null) {
			dmg -= defenseur.getArmure().getDefence();
		}
		
		dmg += (int) (Math.random()*3+1);
		
		if (dmg>0) {
			System.out.println("dmg = " + dmg + "\npv avant: "+defenseur.getHp());
			defenseur.setHp(defenseur.getHp()-dmg);
			System.out.println("pv apres: " + defenseur.getHp());
			this.mort(defenseur);
		}
		
		else {
			System.out.println("Ce n'est pas très efficace...");
		}
		attaquant.setPa(attaquant.getPa()-1);
	}
	
	//Mort: si les Pv d'un personnage sont inferieur ou egal a 0, il est supprime de la carte
	
	public void mort(Personnage p){
		
		//Lacher les objets apres la mort
		Coordonnees c = carte.chercherPersonnage(p);
		
		for(int i = 0; i < p.getListeObjet().size(); i++)
		{
			this.carte.ajouterObjetSurLaMap(c.getX(), c.getY(), p.getListeObjet().get(i) );
			p.getListeObjet().remove(i);
		}
		if(p.getArme() != null)
		{
			this.carte.ajouterObjetSurLaMap(c.getX(), c.getY(), p.getArme() );
			p.setArme(null);
		}
		if(p.getArmure() != null)
		{
			this.carte.ajouterObjetSurLaMap(c.getX(), c.getY(), p.getArmure() );
			p.setArmure(null);
		}
		
				
		//Tuer le personnage
		if (p.getHp()<=0) {
		this.carte.remplacerSurLaMap(this.carte.chercherPersonnage(p).getX(), this.carte.chercherPersonnage(p).getY(), ' ', null);}
		
	
	}
	
	//Mï¿½thode donnant au joueur le choix de la direction dans la quelle attaquer
	
	public boolean choixAttaquer(Personnage p, ArrayList<Coordonnees> autour) {
		
		//Vï¿½rification de sdirections disponible
		
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
		
			 if (action.equals("h")) {this.attaquer(p, autour.get(0).getPersonnage());}
		else if (action.equals("g")) {this.attaquer(p, autour.get(1).getPersonnage());}
		else if (action.equals("d")) {this.attaquer(p, autour.get(2).getPersonnage());}
		else if (action.equals("a"))    {return false;}
		else if (action.equals("b"))    {this.attaquer(p, autour.get(3).getPersonnage());}
		return true; //On return true pour dire que l'utilisateur a vraiment attaquer
		
	}
}
