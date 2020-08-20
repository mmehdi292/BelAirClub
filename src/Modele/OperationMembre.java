package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class OperationMembre {
	public boolean Adherer(Membre M) {
		try {
			ConnectionBD bd = new ConnectionBD("root", "root", "BelAirClub");
			bd.startConnection();
			if (bd.ilExiste(M)) {
				return false;
			}
			if (bd.checkUser(M)) {
				return false;
			}
			int i = bd.addMembre(M);
			bd.endConnection();
			return i == 1;
		} catch (SQLException e) {
			System.out.println("SQLException");
		}
		return false;
	}

	public ArrayList<Activite> consulter() {
		ArrayList<Activite> a = new ArrayList<Activite>();

		try {
			ConnectionBD bd = new ConnectionBD("root", "root", "BelAirClub");
			bd.startConnection();
			a = bd.consulter();
			bd.endConnection();
		} catch (SQLException e) {
			System.out.println("SQL ");
		}

		return a;
	}

	public ArrayList<Activite> consulterSansCreneaux() {
		ArrayList<Activite> a = new ArrayList<Activite>();

		try {
			ConnectionBD bd = new ConnectionBD("root", "root", "BelAirClub");
			bd.startConnection();
			
			a = bd.consulterSansCreneaux();
			
			bd.endConnection();
		} catch (SQLException e) {
			System.out.println("SQL ");
		}

		return a;
	}

	public boolean login(String user, String pass) {
		ConnectionBD bd = new ConnectionBD("root", "root", "BelAirClub");
		bd.startConnection();
		boolean t = false;
		try {
			t = bd.authentification(user, pass);
			bd.endConnection();
		} catch (SQLException e) {
			System.out.println("error");
		}
		return t;
	}

	public int[] heureReserveCreneaux(int code, int jour) {
		int[] a = { 0, 0, 0, 0, 0, 0, 0, 0 };
		ConnectionBD bd = new ConnectionBD("root", "root", "BelAirClub");
		bd.startConnection();
		try {
			ArrayList<Integer> b = bd.heureReserveCreneaux(code, jour);
			int i = 0;

			while (i < b.size()) {
				int c = b.get(i);
				a[c - 1] = 1;
				i++;
			}

			bd.consulter();
		} catch (SQLException e) {

		}
		return a;
	}

	public ArrayList<Object> ConsulterListeReservation(String user) {
		ArrayList<Object> a = new ArrayList<Object>();

		try {
			ConnectionBD bd = new ConnectionBD("root", "root", "BelAirClub");
			bd.startConnection();
			a = bd.consulterListeReservation(user);
			bd.endConnection();
		} catch (SQLException e) {
			System.out.println("SQL ");
		}

		return a;

	}
	public boolean addCreneaux(int code,int jour,int heure,String user,int codereservation) {
		boolean i=false;
		try {
			ConnectionBD bd = new ConnectionBD("root", "root", "BelAirClub");
			bd.startConnection();
			
			i = bd.addCreneaux(code,jour,heure,user,codereservation);
			
			bd.endConnectionWithOutResult();
		} catch (SQLException e) {
			System.out.println("SQL ");
		}
		return i;
	}
	public boolean annulerCreneaux(int code,int jour,int heure,String user) {
		int i=0;
		try {
			ConnectionBD bd = new ConnectionBD("root", "root", "BelAirClub");
			bd.startConnection();
			
			i = bd.annulerCreneaux(code,jour,heure,user);
			
			bd.endConnectionWithOutResult();
		} catch (SQLException e) {
			System.out.println("SQL ");
		}
		return i==1;
	}
	public String getEmail(String user) {
		String s="";
		try {
			ConnectionBD bd = new ConnectionBD("root", "root", "BelAirClub");
			bd.startConnection();
			
			s = bd.getEmail(user);
			
			bd.endConnection();
		} catch (SQLException e) {
			System.out.println("SQL ");
		}
		return s;
	}
	public ArrayList<String> getEmails(int code,int jour,int heure) {
		ArrayList<String> emails = new ArrayList<String>();
		ConnectionBD bd = new ConnectionBD("root", "root", "BelAirClub");
		bd.startConnection();
		ArrayList<String> users = bd.getUsers(code, jour, heure);
			for(String a:users) {
				String s = getEmail(a);
				if(s!=null)
					emails.add(getEmail(a));
			}
			try {
				bd.endConnectionWithOutResult();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return emails;
	}
	public int getCodeConfiramation(int code,int jour,int heure,String user) {
		
		ConnectionBD bd = new ConnectionBD("root", "root", "BelAirClub");
		bd.startConnection();
		int i = bd.getCodeConfirmation(code, jour, heure, user);
			try {
				bd.endConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return i;
	}
}
