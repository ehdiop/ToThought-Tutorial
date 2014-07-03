package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.xyz.myproject.model.exceptions.ClientException;
import com.xyz.myproject.model.exceptions.NEException;
import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.Client;
import com.xyz.myproject.model.general.CodePostal;
import com.xyz.myproject.model.general.ListClient;
import com.xyz.myproject.model.general.MethodeCalcul;
import com.xyz.myproject.model.general.NumeroEntreprise;
import com.xyz.myproject.model.general.NumeroIdProv;
import com.xyz.myproject.model.projet.DossierClient;

public class DAOListeClients extends DAO<ListClient> {

	public DAOListeClients() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(ListClient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ListClient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ListClient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	// alors la ... il faut creer les donnees relatives aux clients dans la base de donnees -_-
	// ie tous les param presents dans la classe Client
	// ensuite faire un bon vieux select 
	// ajouter les clients selectionnes a la liste
	// la renvoyer !
	// Utiliser un DAOListeClients dans la classe mainFrame et voir ce que ca donne 
	@Override
	public ListClient find() {
		System.out.println("---------------------------------------");
		System.out.println("recup Liste Clients");
		// TODO Auto-generated method stub
		Statement st;
		ListClient listeClients = new ListClient();
		try {
			st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from Client");
			while (res.next()){
				String nom_entreprise = res.getString("nom");
				String adresse = res.getString("adresse");
				String ville = res.getString("ville");
//				Province province = new Province(res.getString("province"));
				CodePostal cp = new CodePostal(res.getString("cp"));
				try {
					String ne = res.getString("ne");
					NumeroEntreprise NE = new NumeroEntreprise(ne);
					NumeroIdProv numProv = new NumeroIdProv(res.getString("num_id_prov"));
					DAODossierClient daoDossierClient = new DAODossierClient();
					DossierClient dossierClient = daoDossierClient.find(ne);
					try {
						
						listeClients.add(new Client(nom_entreprise, adresse, ville, null, cp, NE, numProv, dossierClient));
						Annee pipo = listeClients.get(0).getDossierClient().getAnnees().get(0);
					} catch (ClientException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (NEException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeClients;
	}



}
