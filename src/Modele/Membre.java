package Modele;

import java.util.Date;

public class Membre {
	private int Num_Membre;
	private String nom;
	private String prenom;
	private String user;
	private String email;
	private String pass;
	private Date date_de_naissance;
	private String Adresse;
	private int Num_anulation;
	private boolean blocked;
	public Membre(String nom, String prenom, String user, String email, String pass, Date date_de_naissance,
			String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
		this.email = email;
		this.pass = pass;
		this.date_de_naissance = date_de_naissance;
		Adresse = adresse;
	}
	
	public Membre(int num_Membre, String nom, String prenom) {
		Num_Membre = num_Membre;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Membre(int num_Membre, String nom, String prenom, String user, int num_anulation, boolean blocked) {
		Num_Membre = num_Membre;
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
		Num_anulation = num_anulation;
		this.blocked = blocked;
	}

	public int getNum_Membre() {
		return Num_Membre;
	}
	public void setNum_Membre(int num_Membre) {
		Num_Membre = num_Membre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getDate_de_naissance() {
		return date_de_naissance;
	}
	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public int getNum_anulation() {
		return Num_anulation;
	}
	public void setNum_anulation(int num_anulation) {
		Num_anulation = num_anulation;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	
}