
public class Map {
	
	private int longueur;
	private int largeur;
	
	private int tailleDuTableau = 200;
	private coordonnees[] tableau = new coordonnees[tailleDuTableau];

	
	
	public Map()
	{
		this.longueur=15;
		this.largeur=15;
		
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
			this.tableau[nbElements] = new coordonnees(x,y,lettre);
		}
		else
		{
			this.tableau[nbElements + 1] = new coordonnees(x,y,lettre);
		}
		
		//System.out.println(tableau[0].x);
		System.out.println("nb" +nbElements);
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
					if(tableau[i].y == j)
					{				
						for(int a=0; a<tailleDuTableau;a++)
						{
							if(tableau[i].x == a)
							{
								System.out.print(tableau[i].lettre);
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
	
	public void remplacerSurLaMap(int x, int y, char lettre) //Un parametre en plus a mettre: l'instance du joueur
	{
		for(int i=0; i<tailleDuTableau;i++)
		{
			if(tableau[i] != null)
			{
				if(tableau[i].x==x && tableau[i].y==y )
				{
					tableau[i].lettre=lettre;
				}
			}
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
	

}
