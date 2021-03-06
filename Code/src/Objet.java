
public class Objet {
	
	//tableau des objets disponible
	private String[] objets = {"potion","boosterPA","epee","armure simple","dague","armure legere","baton magique","robe"};
	private String nom;
	
	private int degas = 0;
	private int defence = 0;
	
	
	private boolean isArme = false;
	private boolean isArmure = false; //est ce que on peux equiper l'objet


	public Objet(String s)
	{
		if(objetValide(s))
		{
			this.nom=s;
			
			if(this.nom.equals("epee"))
			{
				isArme = true;
				degas = 1;
			}
			else if(this.nom.equals("armure simple"))
			{
				isArmure = true;
				defence = 3;
			}
			else if(this.nom.equals("dague"))
			{
				isArme = true;
				degas = 2;
			}
			else if(this.nom.equals("armure legere"))
			{
				isArmure = true;
				defence = 2;
			}
			else if(this.nom.equals("baton magique"))
			{
				isArme = true;
				degas = 3;
			}
			else if(this.nom.equals("robe"))
			{
				isArmure = true;
				defence = 1;
			}
			
			
		}
		else
		{
			System.out.println("L'OBJET N'EXISTE PAS!");
		}
	}
	
	//On regarde si l'objet mis en parametre est dans le tableau d'objet valide
	public boolean objetValide(String s)
	{
		for(int i = 0; i < this.objets.length; i++)
		{
			if(s.equals(objets[i]))
			{
				return true;
			}
		}
		
		return false;
	}
	
	//C'est ici que on va mettre les effet des objets
	public boolean activerObjet(Personnage p)
	{
		//Effet de la potion
		if(this.nom.equals("potion"))
		{
			activerPotion(p);
			return true;
		}
		else if (this.nom.equals("boosterPA"))
		{
			activerBoosterPA(p);
			return true;
		}
		else
		{
			System.out.println("Impossible d'utiliser cet objet");
			return false;
		}
	}
	
	public void activerBoosterPA(Personnage p)
	{
		System.out.println("PA avant: " +p.getPa());
		p.setPa(p.getPa() + 1);
		System.out.println("BoosterPA utilise! + 1 PA");
		
		if( p.getPamax() < p.getPa() )
		{
			p.setPa(p.getPamax());
			System.out.println("Tes PA ne peuvent pas depasser la valeur max");
			System.out.println("PA apres: " +p.getPa());
		}
		else
		{
			System.out.println("PA apres: " +p.getPa());
		}
	}
	
	
	public void activerPotion(Personnage p)
	{
		System.out.println("HP avant: " +p.getHp());
		p.setHp(p.getHp() + 4);
		System.out.println("Potion utilise! + 4 HP");
		
		int hpmax = p.getHpmax();
		int hp =  p.getHp();
		
		if(hpmax < hp)
		{
			p.setHp(p.getHpmax());
			System.out.println("Tes HP ne peuvent pas depasser la valeur max");
			System.out.println("HP apres: " +p.getHp());
		}
		else
		{
			System.out.println("HP apres: " +p.getHp());
		}
	}

	
	
	public boolean isArme() {
		return isArme;
	}

	public void setArme(boolean isArme) {
		this.isArme = isArme;
	}

	public boolean isArmure() {
		return isArmure;
	}

	public void setArmure(boolean isArmure) {
		this.isArmure = isArmure;
	}

	public int getDegas() {
		return degas;
	}

	public void setDegas(int degas) {
		this.degas = degas;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public String getNom()
	{
		return this.nom;
	}
	
	
}
