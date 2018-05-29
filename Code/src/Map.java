import java.util.*;

public class Map {
	
	private int longueur;
	private int largeur;
	
	private int tailleDuTableau = 500;
	private Coordonnees[] tableau = new Coordonnees[tailleDuTableau];

	
	
	public Map()
	{
		this.longueur=10;
		this.largeur=10;
		
	}
	
	public Map(int longueur, int largeur)
	{
		this.longueur=longueur;
		this.largeur=largeur;
		
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
		
		if(nbElements==0)
		{
			this.tableau[nbElements] = new Coordonnees(x,y,lettre,null);
		}
		else
		{
			this.tableau[nbElements + 1] = new Coordonnees(x,y,lettre,null);
		}
		
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
	
	public void deplacerPersonnage(Personnage personnage, String s)
	{
		Coordonnees c = chercherPersonnage(personnage);
		char lettre = c.getLettre();
		
		if (s.equals("haut"))
		{
			remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			remplacerSurLaMap(c.getX(), c.getY()-1, lettre, personnage);
		}
		
		else if (s.equals("droite"))
		{
			remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			remplacerSurLaMap(c.getX()+1, c.getY(), lettre, personnage);
		}
		
		else if (s.equals("bas"))
		{
			remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			remplacerSurLaMap(c.getX(), c.getY()+1, lettre, personnage);
		}
		
		else if (s.equals("gauche"))
		{
			remplacerSurLaMap(c.getX(), c.getY(),' ', null);
			remplacerSurLaMap(c.getX()-1, c.getY(), lettre, personnage);
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
	
	public String input() {
		Scanner input = new Scanner(System.in);
		String action = input.next();
		input.close();
		return action;
	}
	
	public void choixDeplacement(Personnage p) {
		
		int x = this.chercherPersonnage(p).getX();
		int y = this.chercherPersonnage(p).getY();
		ArrayList<Coordonnees> autour = scannerAutourCoordonnee(x, y);
		
		
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
		Scanner input = new Scanner(System.in);
		String action = input.next();
		System.out.println(action);
		
		while((action.equals("haut") && !(haut)) || (action.equals("bas") && !(bas)) || (action.equals("gauche") && !(gauche)) || (action.equals("droite") && !(droite))
			|| !(action.equals("haut") || action.equals("bas") || action.equals("gauche") || action.equals("droite")))
		{
			System.out.println("veuillez choisir une direction valide");
			action = input.nextLine();
		}
		
		this.deplacerPersonnage(p, action);
	}
	
	
	

}
