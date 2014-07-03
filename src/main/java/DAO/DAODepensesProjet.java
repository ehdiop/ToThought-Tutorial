package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.MethodeCalcul;
import com.xyz.myproject.model.projet.DepenseST_RD;
import com.xyz.myproject.model.projet.DepenseST_Soutien;
import com.xyz.myproject.model.projet.DepensesProjet;
import com.xyz.myproject.model.projet.DepensesSousTraitance;
import com.xyz.myproject.model.projet.Equipement50;
import com.xyz.myproject.model.projet.Equipement90;
import com.xyz.myproject.model.projet.Location50;
import com.xyz.myproject.model.projet.Location90;
import com.xyz.myproject.model.projet.MaterielConsomme;
import com.xyz.myproject.model.projet.MaterielTransforme;
import com.xyz.myproject.model.projet.TSProjetCanada;
import com.xyz.myproject.model.projet.TSProjetEtr;

public class DAODepensesProjet extends DAO<DepensesProjet>{

	public DAODepensesProjet() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(DepensesProjet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DepensesProjet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DepensesProjet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DepensesProjet find() {
		// TODO Auto-generated method stub
return null;
	}

	public DepensesProjet find(int id_projet){
		System.out.println("---------------------------------------");
		System.out.println("recup depenses projet");
		DepensesProjet dp = new DepensesProjet(new Annee());
		try {
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select * "
					+ "from depenses,depenses_projet "
					+ "where depenses.id_depenses = depenses_projet.id_depenses "
					+ "and depenses_projet.id_projet="+id_projet+"");
			
			while(res.next()){
				int annee1 = res.getInt("annee");
				Calendar annee_date_debut = new GregorianCalendar(annee1, 0, 0);
				Calendar annee_date_fin = new GregorianCalendar(annee1+1, 0, 0);
				Annee annee = new Annee(annee_date_debut, annee_date_fin, MethodeCalcul.REMPLACEMENT);
				
				double eq50 = res.getDouble("eq50");
				Equipement50 eqt_50 = new Equipement50(eq50);
				
				double mat_cons = res.getDouble("mat_cons");
				MaterielConsomme mat_conso = new MaterielConsomme(mat_cons);
				
				double mat_transfo = res.getDouble("mat_trans");
				MaterielTransforme mat_transf = new MaterielTransforme(mat_transfo);
				
				double eq90 = res.getDouble("eq90");
				Equipement90 eqt_90 = new Equipement90(eq90);
				
				DAOTSProjetCanada daoTsCa = new DAOTSProjetCanada();
				TSProjetCanada tsCa = daoTsCa.find(id_projet);
				
				DAOTSProjetEtr daoTsEtr = new DAOTSProjetEtr();
				TSProjetEtr tsEtr = daoTsEtr.find(id_projet);
				
				DAODepensesST_RD daoDepSt_Rd = new DAODepensesST_RD();
				DepensesSousTraitance<DepenseST_RD> sout_rd = daoDepSt_Rd.find(id_projet);
				
				DAODepensesST_Soutien daoDepSt_sout = new DAODepensesST_Soutien();
				DepensesSousTraitance<DepenseST_Soutien> sout_soutien = daoDepSt_sout.find(id_projet);
				
				double loca50 = res.getDouble("loc50");
				Location50 loc50 = new Location50(loca50);
				
				double loca90 = res.getDouble("loc90");
				Location90 loc90 = new Location90(loca90);
				dp = new DepensesProjet(annee, eqt_50, mat_conso, mat_transf, eqt_90, tsCa, tsEtr, sout_rd, sout_soutien, loc50, loc90);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dp;
	}
	
}
