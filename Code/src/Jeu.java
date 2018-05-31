import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {

	//C'est dans cette classe ou il y aurra le main et les fonction PRIVEE pour faire le calcul de degas ect.
	private Scanner input = new Scanner(System.in);
	
	private Map carte;
	
	private Deplacement deplacement;
	private Combat combat;
	
	//constructeurs
	
	public Jeu() {
		this.carte=new Map();
		this.combat=new Combat(carte);
		this.deplacement=new Deplacement(carte);
		
	}
	
	public Jeu (int hauteur, int largeur) {
		this.carte=new Map (hauteur, largeur);
		this.combat=new Combat(carte);
		this.deplacement=new Deplacement(carte);
	}

	
	
	public Map getCarte() {
		return this.carte;
	}
	
	public void setCarte(Map m) {
		this.carte=m;
	}

	//La m�thode principale donnant � l'utilisateur le choix de l'action � effectuer selon ce qui est disponible 
	
	public void choix(Personnage p) {
		ArrayList<Coordonnees> autour = carte.scannerAutourCoordonnee(this.carte.chercherPersonnage(p).getX(), this.carte.chercherPersonnage(p).getY());
		
		boolean deplacer =  (autour.get(0).getLettre() == ' ' && autour.get(0).getPersonnage()==null) ||
			                (autour.get(1).getLettre() == ' ' && autour.get(1).getPersonnage()==null) ||
			                (autour.get(2).getLettre() == ' ' && autour.get(1).getPersonnage()==null) ||
			                (autour.get(3).getLettre() == ' ' && autour.get(1).getPersonnage()==null); 
		
		boolean attaquer =  autour.get(0).getPersonnage()!=null ||
							autour.get(1).getPersonnage()!=null ||
							autour.get(2).getPersonnage()!=null ||
							autour.get(3).getPersonnage()!=null;
		
		System.out.println("vous pouvez:");
		if (deplacer) {System.out.println("deplacer");}
		if (attaquer) {System.out.println("attaquer");}
		
		String choix = input.next();
		while (!(choix.equals("deplacer") || choix.equals("attaquer"))) {
			System.out.println("choisissez un choix valide");
			choix = input.next();
		}
		
		if (choix.equals("deplacer")) {this.deplacement.choixDeplacement(p, autour);}
		else if (choix.equals("attaquer")) {this.combat.choixAttaquer(p, autour);}
		
	}
	
	
}
