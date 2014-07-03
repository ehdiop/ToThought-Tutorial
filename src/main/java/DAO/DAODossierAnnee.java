package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.EmployesImpliques;
import com.xyz.myproject.model.general.InfoGenerales;
import com.xyz.myproject.model.general.ListeEmployee;
import com.xyz.myproject.model.general.MethodeCalcul;
import com.xyz.myproject.model.projet.DepensesProjet;
import com.xyz.myproject.model.projet.DossierAnnee;
import com.xyz.myproject.model.projet.InfoGeneralesProjet;
import com.xyz.myproject.model.projet.ListeProjet;
import com.xyz.myproject.model.projet.Projet;

public class DAODossierAnnee extends DAO<DossierAnnee>{

	public DAODossierAnnee() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(DossierAnnee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DossierAnnee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DossierAnnee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DossierAnnee find() {
		// TODO Auto-generated method stub
		return null;
	}

	public DossierAnnee find(int annee,String ne){
		System.out.println("---------------------------------------");
		System.out.println("recup dossierAnnee");
		Annee annee1 = new Annee();
		ListeProjet listeProj = new ListeProjet();
		InfoGenerales infos = new InfoGenerales();
		DAOInfoGenerales daoInfos;
		try {
			daoInfos = new DAOInfoGenerales();
		
			infos = daoInfos.find(annee,ne);
		
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select projet.id_projet,projet.nom,projet.respo,projet.date_debut,projet.date_fin "
					+ "from projet,projet_client "
					+ "where projet.annee="+annee+" "
					+ "and projet.id_projet=projet_client.id_projet "
					+ "and projet_client.ne_client='"+ne+"'");
			while(res.next()){
				int id_projet = res.getInt("id_projet");

//				DAOInfoGeneralesProjet daoInfosProjet = new DAOInfoGeneralesProjet();
//				InfoGeneralesProjet informationsGenerales = daoInfosProjet.find(id_projet);
				InfoGeneralesProjet informationsGenerales = new InfoGeneralesProjet();
				
				DAOEmployeImplique daoEmployesImp = new DAOEmployeImplique();
				EmployesImpliques employesImp = daoEmployesImp.find(id_projet);

				DAOListeEmployee daoEmpProj = new DAOListeEmployee();
				ListeEmployee employesProjet = daoEmpProj.find(id_projet);

				String nomProjet = res.getString("nom");

				String responsable = res.getString("respo");

				Date deb = res.getDate("date_debut");
				GregorianCalendar debut = new GregorianCalendar(deb.getYear(), deb.getMonth(), deb.getDay());

				Date fin1 = res.getDate("date_fin");
				GregorianCalendar fin = new GregorianCalendar(fin1.getYear(), fin1.getMonth(), fin1.getDay());

				DAODepensesProjet daoDepProj = new DAODepensesProjet();
				DepensesProjet depenses = daoDepProj.find(id_projet);

				Calendar annee_date_debut = new GregorianCalendar(annee, 0, 0);
				Calendar annee_date_fin = new GregorianCalendar(annee+1, 0, 0);
				annee1 = new Annee(annee_date_debut, annee_date_fin, MethodeCalcul.REMPLACEMENT);

				int numero = id_projet;

				Projet proj = new Projet(informationsGenerales, employesImp, employesProjet, nomProjet, responsable, debut, fin, depenses, annee1, numero);
				listeProj.add(proj);
			}
			

		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DossierAnnee dossierAnnee = new DossierAnnee(annee1, listeProj, infos);
//		System.out.println(dossierAnnee.toString());
		return dossierAnnee;
	}
}
