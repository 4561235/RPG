import java.util.ArrayList;

public class testMap {

	public static void main(String[] args) {
		
		Map maMap = new Map(10,15);
		System.out.println("longueur de la map:" +maMap.getLongueur());
		System.out.println("largeur de la map:" +maMap.getLargeur());
		
		for(int x=0;x<10;x++)
		{
			maMap.mettreSurLaMap(x, 10, '#');
		}
		
		for(int x=0;x<10;x++)
		{
			maMap.mettreSurLaMap(x, 0, '#');
		}
		
		for(int y=1;y<9;y++)
		{
			maMap.mettreSurLaMap(0, y, '#');
			for(int x=1;x<9;x++)
			{
				maMap.mettreSurLaMap(x, y, ' ');
			}
			maMap.mettreSurLaMap(10, y, '#');
		}
		
		Personnage a = new Personnage();
		
		maMap.remplacerSurLaMap(3, 2, 'P',a);
		maMap.remplacerSurLaMap(2, 2, 'C',null);
		maMap.remplacerSurLaMap(6, 6, 'A',null);
		
		maMap.dessinerMap();
		
		ArrayList<coordonnees> liste = maMap.scannerAutourCoordonnee(2,2);
		System.out.println(liste.get(0).toString());
		System.out.println(liste.get(1).toString());
		System.out.println(liste.get(2).toString());
		System.out.println(liste.get(3).toString());
		System.out.println();
		System.out.println("Je cherche le personnage donner en parametre");
		System.out.println("resultat de ma recherche: " +maMap.chercherPersonnage(a).toString());
		
	
	}

}
