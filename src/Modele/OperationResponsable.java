package Modele;


import java.sql.SQLException;
import java.util.ArrayList;

public class OperationResponsable {
	
	public boolean addActivite(Activite a) {
		ConnectionBD bd = new ConnectionBD("root","root","BelAirClub");
		bd.startConnection();
		int i = bd.addAct(a);
		try {
			bd.endConnectionWithOutResult();
		} catch (SQLException e) {
		}
		System.out.println("End");
		return i==1;
	}
	public boolean modActivite(Activite a,int code) {
		ConnectionBD bd = new ConnectionBD("root","root","BelAirClub");
		bd.startConnection();
		int i = bd.modAct(a,code);
		try {
			bd.endConnectionWithOutResult();
		} catch (SQLException e) {

		}
		
		return i==1;
	}
	public boolean delActivite(int code) {
		ConnectionBD bd = new ConnectionBD("root","root","BelAirClub");
		bd.startConnection();
		System.out.println("--- del activite-----");
		int i = bd.detAct(code);
		System.out.println("--- del activite-----"+i);
		try {
			bd.endConnectionWithOutResult();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i==1;
	}
	public int nombreAdhesion() {
		ConnectionBD bd = new ConnectionBD("root","root","BelAirClub");
		bd.startConnection();
		int i = bd.getNewMembre();
			try {
				bd.endConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return i;
	}
	public int nombreReservation() {
		ConnectionBD bd = new ConnectionBD("root","root","BelAirClub");
		bd.startConnection();
		int i = bd.getResravationNumber();
			try {
				bd.endConnection();
			} catch (SQLException e) {
				
			}
		return i;
	}
	public ArrayList<Membre> annulationUser(){
		ArrayList<Membre> a =new ArrayList<Membre>();
		ConnectionBD bd = new ConnectionBD("root","root","BelAirClub");
		bd.startConnection();
		a = bd.getBloked();
		try {
			bd.endConnection();
		} catch (SQLException e) {
		}
		return a;
	}
	public boolean block(String user) {
		ConnectionBD bd = new ConnectionBD("root","root","BelAirClub");
		bd.startConnection();
		boolean b = bd.bloquer(user);
		try {
			bd.endConnection();
		} catch (SQLException e) {
		}
		return b;
	}
	public ArrayList<Membre> listeToExecl(){
		ArrayList<Membre> a =new ArrayList<Membre>();
		ConnectionBD bd = new ConnectionBD("root","root","BelAirClub");
		bd.startConnection();
		a = bd.listeToExecl();
		try {
			bd.endConnection();
		} catch (SQLException e) {
		}
		return a;
	}

}
