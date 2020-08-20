package Modele;

public class Creneaux {
	private int jour;
	private int horaire;
	
	public Creneaux(int jour, int horaire) {
		this.jour = jour;
		this.horaire = horaire;
	}
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
	public int getHoraire() {
		return horaire;
	}
	public void setHoraire(int horaire) {
		this.horaire = horaire;
	}
	
}
