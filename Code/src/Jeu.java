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
	
	public void choix(Personnage p) {
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
		
		System.out.println("r: rien");
		
		String choix = input.next();
		while (!(choix.equals("d") || choix.equals("a") || choix.equals("r") )) {
			System.out.println("choisissez un choix valide");
			choix = input.next();
		}
		
		if (choix.equals("d")) {this.deplacement.choixDeplacement(p, autour);}
		else if (choix.equals("a")) {this.combat.choixAttaquer(p, autour);}
		else {this.getCarte().dessinerMap();}
		
	}
	
	public void partie() {
		this.participants=this.carte.getPersonnages();
		System.out.println("liste" + participants);
		boolean enVie = false;///////////////////////////////////////////////A REMETTRE A TRUE
		while (enVie) {
			enVie=false;
			for (Personnage c:this.participants) {
				if (c.getHp()>0) {
					if (c.isJoueur()) {
						
						//pour tester les objets
						/*Objet potion1 = new Objet("potion");
						Objet potion2 = new Objet("potion");
						Objet potion3 = new Objet("potion");
						Objet potion4 = new Objet("potion");
						//System.out.println(potion.getNom());
						c.ajouterObjet(potion1);
						c.ajouterObjet(potion2);
						c.ajouterObjet(potion3);
						c.ajouterObjet(potion4);
						c.choixObjet();*/
						
						this.choix(c);
						enVie=true;
					}
					this.carte.dessinerMap();
				}
			}
			System.out.println("nouveau tour");
			
		}
		this.participants=this.carte.getPersonnages();
		
		
		
		
		
		
		
		
		this.pathfindig(this.participants.get(0));
		
		
		
		
		
		
		
		
	}
	
	private Coordonnees[] pathfindig(Personnage p) {
		
		//le tableau de l'algorithme de Dijkstra
		int[]metrique= new int[this.carte.getLongueur()*this.carte.getLargeur()];
		
		// pour se rendre a l'emplacementi*10+j, il faut passer par la coordonnee stocker
		Coordonnees[] chemin=new Coordonnees[this.carte.getLongueur()*this.carte.getLargeur()];	
		
		//tableau de bool permet de savoir si une case � d�ja �t� v�rifier ou non. Si non, on applique l'algorithme
		boolean[] verifier=new boolean[this.carte.getLongueur()*this.carte.getLargeur()];
		
		//on rempli le tableau de valeurs maximales
		for (int i=0; i<this.carte.getLongueur(); i++) {
			for (int j=0; j<this.carte.getLargeur(); j++) {
				
				System.out.println("i  = " + i + " et j = " + j);
				System.out.println(this.carte.getTableau().length);
				System.out.println(this.carte.getTableau());
				System.out.println(this.carte.getTableau() [i*this.carte.getLongueur()+j] );
				
				metrique[i*this.carte.getLargeur()+j]=99;
				chemin[i*this.carte.getLargeur()+j]=new Coordonnees(i, j, ' ',null);
				if (this.carte.getTableau() [i*this.carte.getLargeur()+j] != null && this.carte.getTableau() [i*this.carte.getLargeur()+j] .getLettre() =='#') {
					verifier[i*this.carte.getLargeur()+j]=true;
				}
			}
		}
		
		//emplacement dans la carte du personnage actuel
		
		int iActuel=(this.carte.chercherPersonnage(p).getX()*10+this.carte.chercherPersonnage(p).getY());
		metrique[iActuel]=0;
		verifier[iActuel]=true;
		
		boolean fini = false;
		
		
		//r�cup�ration des 4 cases autour de la case courante
		ArrayList<Coordonnees> autour = this.carte.scannerAutourCoordonnee(this.carte.chercherPersonnage(p).getX(), this.carte.chercherPersonnage(p).getY());
		
		
		
		while(!(fini)) {
			//pour les 4 cases autour, on calcul la metrique
			for (Coordonnees c: autour) {
				//Si la metrique de la case actuelle +1 est inferieur a la metrique de la case � cot�, on la remplace
				if (c!=null) {
					if (metrique [iActuel]+1 < metrique [(c.getX()*10+c.getY())]) {
						if(c.getPersonnage().equals(null)) {
							if (c.getLettre()==' ' && verifier[iActuel]==false ) {
								metrique [(c.getX()*10+c.getY())]=metrique [iActuel]+1;
								chemin[(c.getX()*10+c.getY())].setX(chemin[iActuel].getX());
								chemin[(c.getX()*10+c.getY())].setY(chemin[iActuel].getY());
						}
					}
				}

				}
			}
			
			//on determine la prochaine case � analyser
			
			int metriqueMax=99;
			int iMetriqueMax=999;
			int x = 100;
			int y = 100;
			
			for (int i=0; i<this.carte.getLongueur(); i++) {
				for (int j=0; j<this.carte.getLargeur(); j++) {
					if (verifier[i*this.carte.getLargeur()+j] && metrique[i*this.carte.getLargeur()+j]<metriqueMax) {
						iMetriqueMax=i*this.carte.getLargeur()+j;
						metriqueMax=metrique[iMetriqueMax];
						y=i;
						x=j;
					}
				}
			}
			//la prochaine case est la premi�re case non-verifier avec la metrique la plus faible 
			autour = this.carte.scannerAutourCoordonnee(x, y);
			
			fini = true;
			
			for (int i=0; i<this.carte.getLongueur() && fini; i++) {
				for (int j=0; j<this.carte.getLargeur() && fini; j++) {
					if (verifier[i*this.carte.getLargeur()+j]==false) {
						fini=false;
					}
				}
			}
		}
		
		return chemin;
		
	}
	
}
