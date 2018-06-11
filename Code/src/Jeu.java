import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {

	//C'est dans cette classe ou il y aurra le main et les fonction PRIVEE pour faire le calcul de degas ect.
	private Scanner input = new Scanner(System.in);
	
	private Map carte;
	
	private Deplacement deplacement;
	private Combat combat;
	
	private ArrayList<Personnage> participants;
	
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
	
	public boolean choix(Personnage p) {
		
		boolean leChoixEstFait = true;
		ArrayList<Coordonnees> autour = carte.scannerAutourCoordonnee(this.carte.chercherPersonnage(p).getX(), this.carte.chercherPersonnage(p).getY());
		
		boolean deplacer =  (autour.get(0).getLettre() == ' ' && autour.get(0).getPersonnage()==null) ||
			                (autour.get(1).getLettre() == ' ' && autour.get(1).getPersonnage()==null) ||
			                (autour.get(2).getLettre() == ' ' && autour.get(2).getPersonnage()==null) ||
			                (autour.get(3).getLettre() == ' ' && autour.get(3).getPersonnage()==null); 
		
		boolean attaquer =  autour.get(0).getPersonnage()!=null ||
							autour.get(1).getPersonnage()!=null ||
							autour.get(2).getPersonnage()!=null ||
							autour.get(3).getPersonnage()!=null;
		
		System.out.println("Au tour de " + p.getNom() +" !");
		
		System.out.println("vous pouvez:");
		if (deplacer) {System.out.println("d: deplacer");}
		if (attaquer) {System.out.println("a: attaquer");}
		
		System.out.println("u: utiliser un objet");
		System.out.println("r: rien");
		
		String choix = input.next();
		while (!(choix.equals("d") || choix.equals("a") || choix.equals("r") || choix.equals("u") )) {
			System.out.println("choisissez un choix valide");
			choix = input.next();
		}
		
		if (choix.equals("d")) {leChoixEstFait = this.deplacement.choixDeplacement(p, autour);}
		else if (choix.equals("a")) {leChoixEstFait = this.combat.choixAttaquer(p, autour);}
		else if (choix.equals("u")) {leChoixEstFait = p.choixObjet();}
		else {this.getCarte().dessinerMap();}
		
		return leChoixEstFait; //Le jouer a vraiment fait un choix
		
	}
	
	public void partie() {
		
		this.participants=this.carte.getPersonnages();
		System.out.println("liste" + participants);
		boolean enVie = true;
		boolean leChoixEstFait = false;
		
		while (enVie) {
			enVie=false;
			for (Personnage c:this.participants) {
				if (c.getHp()>0) {
					if (c.isJoueur()) {
						
						
						//pour tester les objets
						Objet potion1 = new Objet("potion");
						Objet potion2 = new Objet("potion");
						Objet potion3 = new Objet("potion");
						Objet potion4 = new Objet("potion");
						//System.out.println(potion.getNom());
						c.ajouterObjet(potion1);
						c.ajouterObjet(potion2);
						c.ajouterObjet(potion3);
						c.ajouterObjet(potion4);
					
						leChoixEstFait = false; //pour re-rentrer dans la boucle
						//la boucle pour que le jouer puisse refaire un choix
						while (leChoixEstFait == false) //Si c'est true, le joueur a fait un choix donc pas besoin de revenir
						{
						leChoixEstFait = this.choix(c);
						}
						enVie=true;
						
					}
					//this.carte.dessinerMap();
				}
				this.carte.dessinerMap();
			}
			//this.carte.dessinerMap();
			System.out.println("nouveau tour");
			
		}
		this.carte.getPersonnages();
	}
	
}
