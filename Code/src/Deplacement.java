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
		
		if (s.equals("haut"))
		{
			this.carte.remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			this.carte.remplacerSurLaMap(c.getX(), c.getY()-1, lettre, personnage);
		}
		
		else if (s.equals("droite"))
		{
			this.carte.remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			this.carte.remplacerSurLaMap(c.getX()+1, c.getY(), lettre, personnage);
		}
		
		else if (s.equals("bas"))
		{
			this.carte.remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			this.carte.remplacerSurLaMap(c.getX(), c.getY()+1, lettre, personnage);
		}
		
		else if (s.equals("gauche"))
		{
			this.carte.remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			this.carte.remplacerSurLaMap(c.getX()-1, c.getY(), lettre, personnage);
		}
		
	}
	
	//choix de la direction du d�placement
	public void choixDeplacement(Personnage p, ArrayList<Coordonnees> autour) {
		
		//Verification des directions disponibles
		
		boolean haut   = (autour.get(0).getLettre() == ' ' && autour.get(0).getPersonnage()==null);
		boolean gauche = (autour.get(1).getLettre() == ' ' && autour.get(1).getPersonnage()==null);
		boolean droite    = (autour.get(2).getLettre() == ' ' && autour.get(2).getPersonnage()==null);
		boolean bas = (autour.get(3).getLettre() == ' ' && autour.get(3).getPersonnage()==null);
		
		System.out.println("Vous pouvez aller:");
		if (haut) System.out.println("haut");
		if (droite) System.out.println("droite");
		if (bas) System.out.println("bas");
		if (gauche) System.out.println("gauche");
		
		@SuppressWarnings("resource")
		String action = this.carte.getInput().next();
		
		//tant que le choix entrer ne'est une direction valide ou un mot valide
		
		while((action.equals("haut") && !(haut)) || (action.equals("bas") && !(bas)) || (action.equals("gauche") && !(gauche)) || (action.equals("droite") && !(droite))
			|| !(action.equals("haut") || action.equals("bas") || action.equals("gauche") || action.equals("droite")))
		{
			System.out.println("veuillez choisir une direction valide");
			action = this.carte.getInput().nextLine();
		}
		
		this.deplacerPersonnage(p, action);
	}
}
