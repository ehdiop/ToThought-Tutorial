package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.ListeEmployee;
import com.xyz.myproject.model.general.MethodeCalcul;
import com.xyz.myproject.model.projet.DossierAnnee;
import com.xyz.myproject.model.projet.DossierClient;

public class DAODossierClient extends DAO<DossierClient>{


	public DAODossierClient() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(DossierClient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DossierClient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DossierClient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DossierClient find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public DossierClient find(String ne){
		System.out.println("---------------------------------------");
		System.out.println("recup Dossier Client");
//		DossierClient dossierClient = new DossierClient();
		try {
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from projet_client where projet_client.ne_client='"+ne+"'");
			while (res.next()){
				int id_annee = res.getInt("annee");
				Calendar annee_date_debut = new GregorianCalendar(id_annee, 0, 0);
				Calendar annee_date_fin = new GregorianCalendar(id_annee+1, 0, 0);
				Annee annee = new Annee(annee_date_debut, annee_date_fin, MethodeCalcul.REMPLACEMENT);
				
				
				// recuperation du dossier annee par le dao pour le dossier annee
				DAODossierAnnee daoDossierAnnee = new DAODossierAnnee();
				DossierAnnee dossierAnnee = daoDossierAnnee.find(id_annee,ne);
				
				//------------------------------------------------
				//recupreration des employes 
				DAOListeEmployee daoListeEmp = new DAOListeEmployee();
				ListeEmployee employes = daoListeEmp.find(id_annee,ne);
				//------------------------------------------------
				
				// creation du dossier client relatif a une annee
				HashMap<Annee, DossierAnnee> futurDossier = new HashMap<Annee, DossierAnnee>();
				futurDossier.put(annee, dossierAnnee);
//				dossierClient.addDossierAnnee(dossierAnnee);
				DossierClient dossierClient = new DossierClient(futurDossier);
				dossierClient.setEmployes(employes); //ajout posterieur
				return dossierClient;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		return dossierClient;
	}

}
