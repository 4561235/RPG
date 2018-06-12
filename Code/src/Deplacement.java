import java.util.ArrayList;

public class Deplacement{
	
	
	private Map carte; //l'attirbut Carte est le m�me que celui de Jeu et Combat
	
	//Contructeurs
	
	public Deplacement() {
		super();
	}
	
	public Deplacement (Map m) {
		this.carte = (m);
	}
	
	//d�placement d'un personnage d'une case vers une des cases adjacente
	public void deplacerPersonnage(Personnage personnage, String s)
	{
		Coordonnees c = this.carte.chercherPersonnage(personnage);
		char lettre = c.getLettre();
		personnage.setPa(personnage.getPa()-1);
		
		if (s.equals("h"))
		{
			this.carte.remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			this.carte.remplacerSurLaMap(c.getX(), c.getY()-1, lettre, personnage);
		}
		
		else if (s.equals("d"))
		{
			this.carte.remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			this.carte.remplacerSurLaMap(c.getX()+1, c.getY(), lettre, personnage);
		}
		
		else if (s.equals("b"))
		{
			this.carte.remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			this.carte.remplacerSurLaMap(c.getX(), c.getY()+1, lettre, personnage);
		}
		
		else if (s.equals("g"))
		{
			this.carte.remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			this.carte.remplacerSurLaMap(c.getX()-1, c.getY(), lettre, personnage);
		}
		
		
	}
	
	//choix de la direction du d�placement
	public boolean choixDeplacement(Personnage p, ArrayList<Coordonnees> autour) {
		
		//Verification des directions disponibles
		
		boolean haut   = (autour.get(0).getLettre() == ' ' && autour.get(0).getPersonnage()==null);
		boolean gauche = (autour.get(1).getLettre() == ' ' && autour.get(1).getPersonnage()==null);
		boolean droite    = (autour.get(2).getLettre() == ' ' && autour.get(2).getPersonnage()==null);
		boolean bas = (autour.get(3).getLettre() == ' ' && autour.get(3).getPersonnage()==null);
		
		
		System.out.println("Vous pouvez aller:");
		if (haut) System.out.println("h: haut");
		if (droite) System.out.println("d: droite");
		if (bas) System.out.println("b: bas");
		if (gauche) System.out.println("g: gauche");
		System.out.println("a: annuler");
		
		@SuppressWarnings("resource")
		String action = this.carte.getInput().next();
		
		//tant que le choix entrer ne'est une direction valide ou un mot valide
		
		while((action.equals("h") && !(haut)) || (action.equals("b") && !(bas)) || (action.equals("g") && !(gauche)) || (action.equals("d") && !(droite))
			|| !(action.equals("h") || action.equals("b") || action.equals("g") || action.equals("d") || action.equals("a")) )
		{
			System.out.println("veuillez choisir une direction valide");
			action = this.carte.getInput().nextLine();
		}
		
		if(action.equals("a"))
		{
			return false;
		}
		else
		{
			this.deplacerPersonnage(p, action);
		}
		
		return true;
	}
}
