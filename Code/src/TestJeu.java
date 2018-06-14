

public class TestJeu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Jeu jeu = new Jeu(10, 10); //creation d'un objet Jeu avec une carte de 10 par 10
		
		
		
		System.out.println("longueur de la map:" + jeu.getCarte().getLongueur());
		System.out.println("largeur de la map:" + jeu.getCarte().getLargeur());
		System.out.println("--- Creation de la carte ---");
		
		//Creation des de la carte
		
		jeu.getCarte().genererCarte();
		
		

		//cration des personnages et affichage des diff�rents objets
		
		Personnage a = new Personnage("Testorius", 10, 3, true);
		Personnage v = new Personnage("Viktimus", 10, 3, false);
		Personnage e = new Personnage("Ennemius", 10, 3, true);
		Personnage c = new Personnage("Ciblus", 10, 3, false);
		
		jeu.getCarte().remplacerSurLaMap(3, 2, 'T',a);
		jeu.getCarte().remplacerSurLaMap(3, 3, 'V', v);
		jeu.getCarte().remplacerSurLaMap(5, 8, 'S', c);
		jeu.getCarte().remplacerSurLaMap(3, 4, 'E', e);
		
		Objet pot1 = new Objet("potion");
		Objet pot2 = new Objet("potion");
		Objet pot3 = new Objet("potion");
		Objet pot4 = new Objet("potion");
		
		jeu.getCarte().ajouterObjetSurLaMap(4,2,pot1);
		jeu.getCarte().ajouterObjetSurLaMap(4,2,pot2);
		jeu.getCarte().ajouterObjetSurLaMap(1,2,pot3);
		jeu.getCarte().ajouterObjetSurLaMap(1,2,pot4);
		
	
		jeu.getCarte().dessinerMap();
		
		/*ArrayList<Coordonnees> liste = jeu.getCarte().scannerAutourCoordonnee(5,8);
		System.out.println(liste.get(0).toString());
		System.out.println(liste.get(1).toString());
		System.out.println(liste.get(2).toString());
		System.out.println(liste.get(3).toString());
		System.out.println();
		System.out.println("Je cherche le personnage donner en parametre");
		System.out.println("resultat de ma recherche: " +jeu.getCarte().chercherPersonnage(a).toString());
		*/
		//test du systeme de choix
		
		System.out.println(jeu.getCarte().scannerPoint(2,2));
		
		
		jeu.partie();
		
	}

}
