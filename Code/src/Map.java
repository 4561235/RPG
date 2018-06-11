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
		
		
		
		//System.out.println(tableau[0].x);
		//System.out.println("nb" +nbElements);
		
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
			if(tableau[i] != null && x<=this.largeur && y<=this.longueur)
			{
				if(tableau[i].getX()== x && tableau[i].getY() == y )
				{
					this.tableau[i].ajouterObjet(o);
				}
			}
			
		}
	}
	
	public void enleverObjetDeLaMap(int x, int y, Objet o)
	{
		for(int i=0; i<tailleDuTableau;i++)
		{
			if(tableau[i] != null && x<=this.largeur && y<=this.longueur)
			{
				if(tableau[i].getX()== x && tableau[i].getY() == y )
				{
					this.tableau[i].enleverObjet(o);
				}
			}
		}
	}
	
	
	

}
