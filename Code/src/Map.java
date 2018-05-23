import java.util.ArrayList;

public class Map {
	
	private int longueur;
	private int largeur;
	
	private int tailleDuTableau = 500;
	private coordonnees[] tableau = new coordonnees[tailleDuTableau];

	
	
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
			this.tableau[nbElements] = new coordonnees(x,y,lettre,null);
		}
		else
		{
			this.tableau[nbElements + 1] = new coordonnees(x,y,lettre,null);
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
	
	public ArrayList<coordonnees> scannerAutourCoordonnee(int x, int y)
	{
		ArrayList<coordonnees> liste = new ArrayList<coordonnees>();
		for(int i=0; i<tailleDuTableau;i++)
		{
			if(tableau[i] != null)
			{
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
	
	public coordonnees chercherPersonnage(Personnage personnage) //On va regarder sur la map pour trouver les coordonnees du personnage
	{
		for(int i=0; i<tailleDuTableau;i++)
		{
			if(tableau[i] != null && tableau[i].getPersonnage() == personnage )
			{
				return tableau[i];
			}
		}
		
		return new coordonnees(0,0,' ',null);
	}
	
	public int getLongueur()
	{
		return longueur;
	}
	
	public int getLargeur()
	{
		return largeur;
	}
	

}
