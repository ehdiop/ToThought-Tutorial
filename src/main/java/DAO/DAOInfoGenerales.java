package DAO;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.DepensesGenerales;
import com.xyz.myproject.model.general.InfoGenerales;
import com.xyz.myproject.model.general.MRVR;
import com.xyz.myproject.model.general.MRVR.LigneTableau;
import com.xyz.myproject.model.general.MethodeCalcul;
import com.xyz.myproject.model.projet.Employee;

public class DAOInfoGenerales extends DAO<InfoGenerales>{

	public DAOInfoGenerales() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(InfoGenerales obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(InfoGenerales obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(InfoGenerales obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InfoGenerales find() {
		// TODO Auto-generated method stub
		return null;
	}

	public InfoGenerales find(int annee,String ne){
		System.out.println("---------------------------------------");
		System.out.println("recup Infos generales");
		DAOListeEmploye daoListeEmp;
		InfoGenerales infos = new InfoGenerales();
		try {
			daoListeEmp = new DAOListeEmploye();
			List<Employee> listeEmp = daoListeEmp.find(annee,ne);
			
			DAODepensesGenerales daoDepGen = new DAODepensesGenerales();
			DepensesGenerales depGen = daoDepGen.find(annee,ne);
//			DepensesGenerales depGen = new DepensesGenerales(new Annee());
			
			
			Calendar annee_date_debut = new GregorianCalendar(annee, 0, 0);
			Calendar annee_date_fin = new GregorianCalendar(annee+1, 0, 0);
			Annee annee1 = new Annee(annee_date_debut, annee_date_fin, MethodeCalcul.REMPLACEMENT);
			
			//------------------------------------------------------------------------------
			//faire une clebou for pour faire ainsi pour tous les employes
			//Cela permet de les afficher dans l'onglet general\main d'oeuvre\TS
			for (int i = 0 ; i<listeEmp.size();i++){
			MRVR.LigneTableau ligne = new LigneTableau(listeEmp.get(i), 252, 500, 12, annee1);
			Employee e = listeEmp.get(i);
			depGen.addDepenseSalaireIndivCa(e, ligne);
			depGen.addDepenseSalaireIndivEtr(e, ligne);
			}
			//------------------------------------------------------------------------------
			
			infos = new InfoGenerales(listeEmp, depGen, annee1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infos;
	}
}
