package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ConnectionBD {
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user;
	public String pass;
	public String nameDatabase;
	
	public ConnectionBD(String user, String pass, String nameDatabase) {
		this.user = user;
		this.pass = pass;
		this.nameDatabase = nameDatabase;
	}
	//Tester la présence du prenom et nom de membre dans notre base de données
	public Boolean ilExiste(Membre M) throws SQLException {
		result = state.executeQuery(
				"select nom,prenom from membre where nom = '" + M.getNom() + "' and prenom ='" + M.getPrenom() + "';");
		return result.next() == true;
	}
	//Tester la présence du username de membre dans notre base de données
	public Boolean checkUser(Membre M) throws SQLException {
		result = state.executeQuery("select user from membre where user=\"" + M.getUser() + "\";");
		return result.next() == true;
	}
	//Ajouter un membre dans notre base de données
	public int addMembre(Membre M) throws SQLException {

		SimpleDateFormat d = new SimpleDateFormat("yyyy-mm-dd");

		String sql = "insert into membre(user,pass,nom,prenom,date,adr,email,insc) values(\"" + M.getUser() + "\",MD5('"
				+ M.getPass() + "'),\"" + M.getNom() + "\",\"" + M.getPrenom() + "\",\""
				+ d.format(M.getDate_de_naissance()) + "\",\"" + M.getAdresse() + "\",\"" + M.getEmail()
				+ "\",CURDATE());";
		return state.executeUpdate(sql);
	}
	//consulter les activites (avec les creneaux) existant dans notre base de données
	public ArrayList<Activite> consulter() throws SQLException {
		ArrayList<Activite> a = new ArrayList<Activite>();
		result = state.executeQuery("select * from activite a , creneaux c where a.code=c.code;");
		if (result.next() == false) {
			return a;
		} else {
			boolean r = true;
			do {
				int code = result.getInt(1);
				String desgnation = result.getString(2);
				double prix = result.getDouble(3);
				ArrayList<Creneaux> c = new ArrayList<Creneaux>();
				while (r != false && code == result.getInt(1)) {
					int jour = result.getInt(5);
					int heure = result.getInt(6);
					c.add(new Creneaux(jour, heure));
					r = result.next();
				}
				a.add(new Activite(code, desgnation, prix, c));
			} while (r);
			return a;
		}
	}
	//consulter les activites (Sans les creneaux) existant dans notre base de données
	public ArrayList<Activite> consulterSansCreneaux() throws SQLException {
		ArrayList<Activite> a = new ArrayList<Activite>();
		result = state.executeQuery("select * from activite;");
		if (result.next() == false) {
			return a;
		} else {
			do {
				int code = result.getInt(1);
				String desgnation = result.getString(2);
				double prix = result.getDouble(3);
				a.add(new Activite(code, desgnation, prix));
			} while (result.next());
			return a;
		}
	}
	//initialisation de la connection BD
	public void startConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/" + nameDatabase;
			cn = DriverManager.getConnection(url, user, pass);
			state = cn.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (SQLException e) {
			System.out.println("SQLException");
		}
	}
	//fermer la connection
	public void endConnection() throws SQLException {
		result.close();
		state.close();
		cn.close();

	}
	//fermer la connection (utiliser avec executeUpdate() cause d'absence de ResultSet)
	public void endConnectionWithOutResult() throws SQLException {
		state.close();
		cn.close();

	}
	//Tester ace que user et pass dans notre bd
	public boolean authentification(String user, String pass) throws SQLException {
		result = state.executeQuery(
				"SELECT user,pass FROM membre WHERE user=\"" + user + "\" AND pass=MD5('" + pass + "') AND block=0; ");
		return result.next() == true;
	}
	//Le nombre de membres inscrits dans le mois en cours
	public int getNewMembre() {
		int i = 0;
		try {
			result = state.executeQuery(
					"SELECT count(num) FROM membre WHERE MONTH(insc)=MONTH(CURDATE()) and YEAR(insc)=YEAR(CURDATE());");
			result.next();
			i = result.getInt(1);
		} catch (SQLException e) {
			System.out.println("getNewMembre");
		}
		return i;
	}
	//Le nombre de Resarvation dans le mois en cours
	public int getResravationNumber() {
		int i = 0;
		try {
			result = state.executeQuery(
					"SELECT count(code) FROM creneaux WHERE MONTH(insc)=MONTH(CURDATE()) and YEAR(insc)=YEAR(CURDATE());");
			result.next();
			i = result.getInt(1);
		} catch (SQLException e) {
			System.out.println("getResravationNumber");
		}
		return i;
	}
	//les membres bloque
	public ArrayList<Membre> getBloked() {
		ArrayList<Membre> a = new ArrayList<Membre>();
		try {
			result = state.executeQuery("SELECT num,user,nom,prenom,num_annul,block FROM membre WHERE num_annul>3;");
			if (result.next() == false) {
				return a;
			} else {
				do {
					int num = result.getInt(1);
					String user = result.getString(2);
					String nom = result.getString(3);
					String prenom = result.getString(4);
					int num_b = result.getInt(5);
					boolean b = result.getBoolean(6);
					a.add(new Membre(num, nom, prenom, user, num_b, b));
				} while (result.next());

			}
		} catch (SQLException e) {
			System.out.println("getBloked");
		}
		return a;
	}
	//bloque un membre
	public boolean bloquer(String user) {
		int i=0;
		try {
			result = state.executeQuery("SELECT block FROM membre WHERE user='"+user+"';");
			result.next();
			boolean b = result.getBoolean(1);
			
			if(b) {
				i = state.executeUpdate("UPDATE membre SET block='0' WHERE user='"+user+"';");
			}
			else {
				i = state.executeUpdate("UPDATE membre SET block='1' WHERE user='"+user+"';");
					
			}
		} catch (SQLException e) {
			
		}
		return i==1;
	}
	//Tester ace que cette activite est existe ou no
	public Boolean checkActiviteCode(Activite a) throws SQLException {
		result = state.executeQuery("select code from activite where code=\"" + a.getCode() + "\";");
		return result.next() == true;
	}
	//Ajouter une activite
	public int addAct(Activite a) {
		
		int i = 0;
		try {
			
			System.out.println(a.getDesgnation() + "|" + a.getPrix());
			i = state.executeUpdate(
					"insert into activite(desgnation,prix) values('" + a.getDesgnation() + "'," + a.getPrix() + ");");
			
		} catch (SQLException e) {

		}
		
		return i;
	}
	//modifier une activite
	public int modAct(Activite a, int code) {
		int i = 0;
		try {
			i = state.executeUpdate("UPDATE activite SET desgnation =\"" + a.getDesgnation() + "\",prix=\""
					+ a.getPrix() + "\"  WHERE code =" + code + " ;");

		} catch (SQLException e) {

		}
		return i;
	}
	//Supprimer une activite
	public int detAct(int code) {
		int i = 0;
		try {
			i = state.executeUpdate("DELETE FROM creneaux WHERE code=" + code + ";");
			i = state.executeUpdate("DELETE FROM activite WHERE code=" + code + ";");
		} catch (SQLException e) {

		}
		return i;
	}
	// la liste des membre ayant plus de trois annulation
	public ArrayList<Membre> listeToExecl() {
		ArrayList<Membre> a = new ArrayList<Membre>();
		try {
			result = state.executeQuery("SELECT num,nom,prenom FROM membre WHERE num_annul>3;");
			System.out.println("aa");
			if (result.next() == false) {
				return a;
			} else {
				do {
					int num = result.getInt(1);
					String nom = result.getString(2);
					String prenom = result.getString(3);
					a.add(new Membre(num, nom, prenom));
				} while (result.next());

			}
		} catch (SQLException e) {
			System.out.println("getBloked");
		}
		return a;
	}
	//touts les heure resrver dans un Activite
	public ArrayList<Integer> heureReserveCreneaux(int code,int jour){
		ArrayList<Integer> a =new ArrayList<Integer>();
		
		try {
			result = state.executeQuery("SELECT heure FROM creneaux WHERE code="+code+" AND jour="+jour+" GROUP BY heure;");
			
			while(result.next()) {
				int c = result.getInt(1);
				a.add(c);
			}
			
			
			
		} catch (SQLException e) {
		}
		
		return a;
	}
	//consulter la Liste de Reservation d'un membre
	public ArrayList<Object> consulterListeReservation(String user) throws SQLException {
		ArrayList<Object> a =new ArrayList<Object>();
		System.out.println("Top");
		result = state.executeQuery("SELECT * FROM creneaux WHERE user='"+user+"';");
		System.out.println("Valid requte");
		if (result.next() == false) {
			return a;
		} else {
			do {
				int code = result.getInt(1);
				int jour = result.getInt(2);
				int heure = result.getInt(3);
				int tab[] = {code,jour,heure};
				a.add(tab);
			} while (result.next());
			return a;
		}
	}
	//Reserver un creneaux
	public boolean addCreneaux(int code,int jour,int heure,String user,int codereservation) {
		int i=0;
		try {
			i = state.executeUpdate("INSERT INTO creneaux VALUES("+code+","+jour+","+heure+",'"+user+"',CURDATE(),"+codereservation+");");
		} catch (SQLException e) {
			System.out.println("Error");
		}
		return i==1;
	}
	//Annuler un creneaux
	public int annulerCreneaux(int code,int jour,int heure,String user) {
		int i = 0;
		try {
			i = state.executeUpdate("UPDATE membre SET num_annul =num_annul+1 WHERE user='"+user+"';");
			i = state.executeUpdate("DELETE FROM creneaux WHERE code=" + code + " AND  jour ="+jour+" AND heure ="+heure+" AND user = '"+user+"' ;");
		} catch (SQLException e) {

		}
		return i;
	}
	// get Email d'un membre
	public String getEmail(String user) {
		try {
			result = state.executeQuery("SELECT email FROM membre WHERE user='"+user+"';");
			if(result.next()) {
				return result.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// get touts les membres reserver un creneaux
	public ArrayList<String> getUsers(int code,int jour,int heure) {
		ArrayList<String> users = new ArrayList<String>();
		try {
			result = state.executeQuery("SELECT user FROM creneaux WHERE code="+code+" AND jour="+jour+" AND heure="+heure+";");
			while(result.next()) {
				users.add(result.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	//get le code de confiramation pour fair la supprition
	public int getCodeConfirmation(int code,int jour, int heure,String user) {
		try {
			result = state.executeQuery("SELECT codereservation FROM creneaux WHERE code= "+code+" and jour = "+jour+" and heure = "+heure+" and user='"+user+"';");
			if(result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}