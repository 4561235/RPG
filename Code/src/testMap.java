
public class testMap {

	public static void main(String[] args) {
		
		Map maMap = new Map(10,10);
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
		
		maMap.remplacerSurLaMap(5, 3, 'P');
		maMap.remplacerSurLaMap(2, 2, 'C');
		maMap.remplacerSurLaMap(6, 6, 'A');
		
		maMap.dessinerMap();
	
	}

}
