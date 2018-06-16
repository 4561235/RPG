import java.util.*;

public class Map {
	
	private int longueur;
	private int largeur;
	
	private int tailleDuTableau = 500;
	private Coordonnees[] tableau = new Coordonnees[tailleDuTableau];

	private Scanner input = new Scanner(System.in);
	

	
	public Map(){}
	
	public Map(int longueur, int largeur)
	{
		this.longueur=longueur;
		this.largeur=largeur;
		
	}
	
	public Map(Map m) {
		this.longueur=m.longueur;
		this.largeur=m.largeur;
		this.tableau=new Coordonnees[m.tailleDuTableau];
		for (int i = 0; i<m.longueur*m.largeur; i++) {
			this.tableau[i]= new Coordonnees (m.tableau[i]);
		}
	}
	
	public int getLongueur()
	{
		return longueur;
	}
	
	public int getLargeur()
	{
		return largeur;
	}
	
	public Scanner getInput() {
		return input;
	}

	public Coordonnees getCoordonnees(int i) {
		return this.tableau[i];
	}
	
	public Coordonnees[] getTableau() {
		return tableau;
	}

	public void setTableau(Coordonnees[] tableau) {
		this.tableau = tableau;
	}

	public ArrayList<Personnage> getPersonnages(){
		ArrayList<Personnage> liste = new ArrayList<Personnage>();
		for (int i =0; i<this.tailleDuTableau; i++) {
			if (this.tableau[i] != null && this.tableau[i].getPersonnage()!=null) {
				liste.add(tableau[i].getPersonnage());
			}
		}
		return liste;
	}

	public void mettreSurLaMap(int x, int y, char lettre)
	{
		int nbElements = 0;
		
		for(int i=0;i<tailleDuTableau;i++)
		{
			if(tableau[i] != null)
			{
				nbElements = nbElements + 1;
			}
		}
		
		this.tableau[nbElements] = new Coordonnees(x,y,lettre,null);
		
	}
	
	public void dessinerMap()
	{
		for(int j=0; j<tailleDuTableau;j++)
		{
			int nb = 0;
			for(int i=0; i<tailleDuTableau;i++)
			{
				if(tableau[i] != null)
				{
					if(tableau[i].getY() == j)
					{				
						for(int a=0; a<tailleDuTableau;a++)
						{
							if(tableau[i].getX() == a)
							{
								//Indication des emplacement des objets
								if(tableau[i].getListeObjet().size() != 0 && tableau[i].getLettre() == ' ' )
								{
									remplacerSurLaMap(tableau[i].getX(), tableau[i].getY(), 'o', tableau[i].getPersonnage());
								}
								//
								System.out.print(tableau[i].getLettre());
								nb = nb + 1;
								
								if(nb == longueur)
								{
									System.out.println();
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void remplacerSurLaMap(int x, int y, char lettre, Personnage personnage) 
	{
		for(int i=0; i<tailleDuTableau;i++)
		{
			if(tableau[i] != null)
			{
				if(tableau[i].getX()==x && tableau[i].getY()==y )
				{
					tableau[i].setLettre(lettre);
					tableau[i].setPersonnage(personnage);
				}
			}
		}
	}
	
	public ArrayList<Coordonnees> scannerAutourCoordonnee(int x, int y)
	{
		ArrayList<Coordonnees> liste = new ArrayList<Coordonnees>();
		for(int i=0; i<tailleDuTableau;i++)
		{
			if(tableau[i] != null && x<=this.largeur && y<=this.longueur)
			{
				
				//System.out.println("C'est ca: " +tableau[i]);
				//System.out.println("Iteration: " +i);
				
				if(tableau[i].getX()==x && tableau[i].getY() - 1 ==y ) //On scanne la case au dessus
				{
					liste.add(tableau[i]); //On rajoute l'instance dans la liste
				}
				
				if(tableau[i].getX() + 1==x && tableau[i].getY()==y ) //On scanne la case a droite
				{
					liste.add(tableau[i]); 
				}
				
				if(tableau[i].getX()==x && tableau[i].getY() + 1==y ) //On scanne la case en bas
				{
					liste.add(tableau[i]); 
				}
				
				if(tableau[i].getX() - 1==x && tableau[i].getY()==y ) //On scanne la case a gauche
				{
					
					liste.add(tableau[i]); 
				}
			}
		}
		
		return liste;
	}
	
	public Coordonnees scannerPoint(int x, int y)
	{
		for(int i=0; i<tailleDuTableau;i++)
		{
			if(tableau[i] != null && x<=this.largeur && y<=this.longueur)
			{
				if(tableau[i].getX()== x && tableau[i].getY() == y )
				{
					return this.tableau[i];
				}
			}
		}
		
		return new Coordonnees(0,0,'!',null);
	}
	
	public Coordonnees chercherPersonnage(Personnage personnage) //On va regarder sur la map pour trouver les coordonnees du personnage
	{
		for(int i=0; i<tailleDuTableau;i++)
		{
			if(tableau[i] != null && tableau[i].getPersonnage() == personnage )
			{
				return tableau[i];
			}
		}
		
		return new Coordonnees(0,0,'!',null);
	}
	
	public void ajouterObjetSurLaMap(int x, int y, Objet o)
	{
		for(int i=0; i<tailleDuTableau;i++)
		{
			if(tableau[i] != null)
			{
				if(tableau[i].getX()== x && tableau[i].getY() == y )
				{
					tableau[i].ajouterObjet(o);
				}
			}
			
		}
	}
	
	public void enleverObjetDeLaMap(int x, int y, Objet o)
	{
		for(int i=0; i<tailleDuTableau;i++)
		{
			if(tableau[i] != null)
			{
				if(tableau[i].getX()== x && tableau[i].getY() == y )
				{
					tableau[i].enleverObjet(o);
				}
			}
			
		}
	}
	
	public int getICoordonnees(int x, int y){
		for(int i=0; i<this.longueur*this.largeur+1;i++)
		{
			if(tableau[i] != null && x<=this.largeur && y<=this.longueur)
			{
				if(tableau[i].getX()== x && tableau[i].getY() == y )
				{
					return i;
				}
			}
		}
		return -1;
	}
	
	public int getICoordonnees(Coordonnees c) {
		
		for(int i=0; i<this.longueur*this.largeur+1;i++)
		{
			if(tableau[i] != null && tableau[i].equals(c))
			{
					return i;
			}
		}
		
		return -1;
	}

	public int[] dijkstra(Personnage p) {
		
		//le tableau de l'algorithme de Dijkstra
		int[]metrique= new int[this.getLongueur()*this.getLargeur()];
		
		// pour se rendre a l'emplacementi*10+j, il faut passer par la coordonnee stocker
		
		//tableau de bool permet de savoir si une case a ddeja ete verifier ou non. Si non, on applique l'algorithme
		boolean[] verifier=new boolean[this.getLongueur()*this.getLargeur()];
		
		//on rempli le tableau de valeurs maximales
		for (int i=0; i<this.getLongueur(); i++) {
			for (int j=0; j<this.getLargeur(); j++) {
				metrique[this.getICoordonnees(i, j)]=99;
				if (this.getTableau() [this.getICoordonnees(i, j)] != null && this.getTableau() [this.getICoordonnees(i, j)] .getLettre() =='#') {
					verifier[this.getICoordonnees(i, j)]=true;
				}
			}
		}
		
		
		//emplacement dans la carte du personnage actuel
		
		
		int iActuel=this.getICoordonnees(this.chercherPersonnage(p).getX(), this.chercherPersonnage(p).getY());
		metrique[iActuel]=0;
		verifier[iActuel]=true;
		
		boolean fini = false;
		
		
		//recuperation des 4 cases autour de la case courante
		ArrayList<Coordonnees> autour = this.scannerAutourCoordonnee(this.chercherPersonnage(p).getX(), this.chercherPersonnage(p).getY());
		
		
		
		while(!(fini)) {
			//pour les 4 cases autour, on calcul la metrique
			for (Coordonnees c: autour) {
				//Si la metrique de la case actuelle +1 est inferieur a la metrique de la case a cote, on la remplace
				if (c!=null){
					if ( c.getLettre()!='#' && c.getLettre()!='X') {
						if (verifier[this.getICoordonnees(c.getX(), c.getY())]==false){
							if(metrique [iActuel]+1 < metrique [this.getICoordonnees(c.getX(), c.getY())]) {
								metrique[this.getICoordonnees(c.getX(), c.getY())]=metrique[iActuel]+1;
									
								
							}		
						}			
					}				
				}
			}
			
			//on determine la prochaine case a analyser
			
			int metriqueMax=99999999;
			int iMetriqueMax=999;
			int x = 100;
			int y = 100;
			
			for (int i=0; i<this.getLongueur(); i++) {
				for (int j=0; j<this.getLargeur(); j++) {
					if (verifier[this.getICoordonnees(i, j)]==false){
						if (metrique[this.getICoordonnees(i, j)]<metriqueMax) {
							iMetriqueMax=this.getICoordonnees(i, j);
							metriqueMax=metrique[iMetriqueMax];
							
							y=j;
							x=i;
						}
					}
				}
			}
			
			//la prochaine case est la premi�re case non-verifier avec la metrique la plus faible
			autour = this.scannerAutourCoordonnee(x, y);
			verifier[this.getICoordonnees(x, y)]=true;
			iActuel=this.getICoordonnees(x, y);
			fini = true;
			
			for (int i=0; i<this.getLongueur() && fini; i++) {
				for (int j=0; j<this.getLargeur() && fini; j++) {
					if (verifier[this.getICoordonnees(i, j)]==false) {
						fini=false;
					}
				}
			}
			
		}
		/*
		System.out.println("fin");
		
	
		
		System.out.println("metrique:");
		for (int i = 0; i<10; i++){
			String s = "";
			for (int j = 0; j<10; j++){
				if (metrique[i*10+j]==99){ s+="## ";}
				else{
					s+=(metrique[i*10+j]) + " ";
					if (metrique[i*10+j]<10)
						s+= " ";
				}	
			}
			System.out.println(s);
		}
		*/
		
		return metrique;
	}

	public Coordonnees[] dijkstra(Personnage p, Personnage cible) {
		
		//le tableau de l'algorithme de Dijkstra
		int[]metrique= new int[this.getLongueur()*this.getLargeur()];
		
		// pour se rendre a l'emplacementi*10+j, il faut passer par la coordonnee stocker
		Coordonnees[] chemin=new Coordonnees[this.getLongueur()*this.getLargeur()];	
		
		//tableau de bool permet de savoir si une case a ddeja ete verifier ou non. Si non, on applique l'algorithme
		boolean[] verifier=new boolean[this.getLongueur()*this.getLargeur()];
		
		//on rempli le tableau de valeurs maximales
		for (int i=0; i<this.getLongueur(); i++) {
			for (int j=0; j<this.getLargeur(); j++) {
				metrique[this.getICoordonnees(i, j)]=99;
				chemin[this.getICoordonnees(i, j)]=new Coordonnees(i, j, ' ',null);
				if (this.getTableau() [this.getICoordonnees(i, j)] != null && this.getTableau() [this.getICoordonnees(i, j)] .getLettre() =='#') {
					verifier[this.getICoordonnees(i, j)]=true;
				}
			}
		}
		
		
		//emplacement dans la carte du personnage actuel
		
		
		int iActuel=this.getICoordonnees(this.chercherPersonnage(p).getX(), this.chercherPersonnage(p).getY());
		metrique[iActuel]=0;
		verifier[iActuel]=true;
		
		boolean fini = false;
		
		
		//recuperation des 4 cases autour de la case courante
		ArrayList<Coordonnees> autour = this.scannerAutourCoordonnee(this.chercherPersonnage(p).getX(), this.chercherPersonnage(p).getY());
		
		
		
		while(!(fini)) {
			//pour les 4 cases autour, on calcul la metrique
			for (Coordonnees c: autour) {
				//Si la metrique de la case actuelle +1 est inferieur a la metrique de la case a cote, on la remplace
				if (c!=null){
					if ( c.getPersonnage() == null || c.getPersonnage().equals(cible)) {
						if ( c.getLettre()==' ' || c.getLettre()=='o' || c.getLettre() == this.chercherPersonnage(cible).getLettre()) {
							if (verifier[this.getICoordonnees(c.getX(), c.getY())]==false){
								if(metrique [iActuel]+1 < metrique [this.getICoordonnees(c.getX(), c.getY())]) {
									metrique[this.getICoordonnees(c.getX(), c.getY())]=metrique[iActuel]+1;
									chemin[this.getICoordonnees(c.getX(), c.getY())].setX(iActuel%10);
									chemin[this.getICoordonnees(c.getX(), c.getY())].setY(iActuel/10);
									
								}
							}		
						}			
					}				
				}
			}
			
			//on determine la prochaine case a analyser
			
			int metriqueMax=99999999;
			int iMetriqueMax=999;
			int x = 100;
			int y = 100;
			
			for (int i=0; i<this.getLongueur(); i++) {
				for (int j=0; j<this.getLargeur(); j++) {
					if (verifier[this.getICoordonnees(i, j)]==false){
						if (metrique[this.getICoordonnees(i, j)]<metriqueMax) {
							iMetriqueMax=this.getICoordonnees(i, j);
							metriqueMax=metrique[iMetriqueMax];
							
							y=j;
							x=i;
						}
					}
				}
			}
			
			//la prochaine case est la premi�re case non-verifier avec la metrique la plus faible
			autour = this.scannerAutourCoordonnee(x, y);
			verifier[this.getICoordonnees(x, y)]=true;
			iActuel=this.getICoordonnees(x, y);
			fini = true;
			
			for (int i=0; i<this.getLongueur() && fini; i++) {
				for (int j=0; j<this.getLargeur() && fini; j++) {
					if (verifier[this.getICoordonnees(i, j)]==false) {
						fini=false;
					}
				}
			}
		}
		/*
		System.out.println("fin");
		
	
		
		System.out.println("metrique:");
		for (int i = 0; i<10; i++){
			String s = "";
			for (int j = 0; j<10; j++){
				if (metrique[i*10+j]==99){ s+="## ";}
				else{
					s+=(metrique[i*10+j]) + " ";
					if (metrique[i*10+j]<10)
						s+= " ";
				}	
			}
			System.out.println(s);
		}
		*/
		
		return chemin;
	}
	
	public void genererCarte() {
		
		
		//creation des murs
		for(int x=0;x<10;x++)
		{
			this.mettreSurLaMap(x, 0, '#');
		}
		
		
		for(int y=1;y<9;y++)
		{
			this.mettreSurLaMap(0, y, '#');
			for(int x=1;x<9;x++)
			{
				this.mettreSurLaMap(x, y, ' ');
			}
			this.mettreSurLaMap(9, y, '#');
		}
		
		for(int x=0;x<10;x++)
		{
			this.mettreSurLaMap(x, 9, '#');
		}
		
		
		//creation des obstacle de la map
		for (int i = 0; i< this.longueur; i++) {
			for (int j = 0; j<this.largeur; j++) {
				if (this.getCoordonnees(this.getICoordonnees(i, j)).getLettre()==' '){   	//si la case n'est pas deja occuper
					ArrayList<Coordonnees> autour = this.scannerAutourCoordonnee(i, j);
					boolean obstacle = false;
					for (Coordonnees c:autour) {
						obstacle = obstacle || c.getLettre()=='X';
					}
					
					int rand= (int) (Math.random()*14);
					
					if ((obstacle && (int) (rand) < 4) || rand == 0) { 						//on place aleatoirement des obstacle sur la map, la chance est plus elever si il y a u obstacle a cote
						this.remplacerSurLaMap(i, j, 'X', null);
					}
					
					
				}
			}
		}
		
		this.dessinerMap();
		
		//verification d'une carte valide
		
		boolean erreur=false;
		
		Personnage p = new Personnage();
		
		for (int i = 0; i< this.longueur && !(erreur); i++) {
			for (int j = 0; j<this.largeur && !(erreur); j++) {
				if (this.getCoordonnees(this.getICoordonnees(i, j)).getLettre()!='#' && this.getCoordonnees(this.getICoordonnees(i, j)).getLettre()!='X') {
					
					this.remplacerSurLaMap(i, j, 't', p);
					int[] metrique = this.dijkstra(p);
					
					for (int a = 0; a<this.longueur && !(erreur); a++) {
						for (int b = 0; b<this.largeur && !(erreur); b++) {
							if (metrique[this.getICoordonnees(a, b)] == 99 && this.getCoordonnees(this.getICoordonnees(a, b)).getLettre()==' ') {
								erreur=true;
							}
						}
					}
					this.remplacerSurLaMap(i, j, ' ', null);
				}
			}
		}
		
		System.out.println(erreur);
		
		if (erreur) {
			this.viderCarte();
			this.genererCarte();
		}
		
		//remplacerSurLaMap(0,0,'#',null);
		
	}
	
	public void viderCarte() {
		for (int i = 0; i<500; i++) {
			this.tableau[i]=null;
		}
	}

}
