package Modele;

import java.util.ArrayList;

public class Activite {
	private int code;
	private String desgnation;
	private double prix;
	private ArrayList<Creneaux> creneaux;
	public Activite(int code, String desgnation, double prix, ArrayList<Creneaux> creneaux) {
		this.code = code;
		this.desgnation = desgnation;
		this.prix = prix;
		this.creneaux = creneaux;
	}
	public Activite(int code, String desgnation, double prix) {
		this.code = code;
		this.desgnation = desgnation;
		this.prix = prix;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesgnation() {
		return desgnation;
	}
	public void setDesgnation(String desgnation) {
		this.desgnation = desgnation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public ArrayList<Creneaux> getCreneaux() {
		return creneaux;
	}
	public void setCreneaux(Creneaux c) {
		
	}
	
	

}
