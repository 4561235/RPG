import java.util.ArrayList;

public class TestJeu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Jeu jeu = new Jeu(10, 10); //creation d'un objet Jeu avec une carte de 10 par 10
		
		System.out.println("longueur de la map:" + jeu.getCarte().getLongueur());
		System.out.println("largeur de la map:" + jeu.getCarte().getLargeur());
		
		//Creation des murs
		
		for(int x=0;x<10;x++)
		{
			jeu.getCarte().mettreSurLaMap(x, 0, '#');
		}
		
		
		for(int y=1;y<9;y++)
		{
			jeu.getCarte().mettreSurLaMap(0, y, '#');
			for(int x=1;x<9;x++)
			{
				jeu.getCarte().mettreSurLaMap(x, y, ' ');
			}
			jeu.getCarte().mettreSurLaMap(9, y, '#');
		}
		
		for(int x=0;x<10;x++)
		{
			jeu.getCarte().mettreSurLaMap(x, 9, '#');
		}

		//cratuin des personnages et affichage des diff�rents objets
		
		Personnage a = new Personnage("Testorius", 10, 10, true);
		Personnage v = new Personnage("Viktimus", 10, 10, false);
		
		jeu.getCarte().remplacerSurLaMap(3, 2, 'P',a);
		jeu.getCarte().remplacerSurLaMap(2, 2, 'C',null);
		jeu.getCarte().remplacerSurLaMap(1, 2, 'A',null);
		jeu.getCarte().remplacerSurLaMap(3, 3, 'V', v);
		jeu.getCarte().remplacerSurLaMap(5, 8, 'S',null);
	
		jeu.getCarte().dessinerMap();
		
		ArrayList<Coordonnees> liste = jeu.getCarte().scannerAutourCoordonnee(5,8);
		
		System.out.println(liste.get(0).toString());
		System.out.println(liste.get(1).toString());
		System.out.println(liste.get(2).toString());
		System.out.println(liste.get(3).toString());
		System.out.println();
		System.out.println("Je cherche le personnage donner en parametre");
		System.out.println("resultat de ma recherche: " +jeu.getCarte().chercherPersonnage(a).toString());
		
		//test du syst�me de choix
		
		for (int i = 0; i<100; i++) {
			jeu.choix(a);
			jeu.getCarte().dessinerMap();
		}
	}

}
