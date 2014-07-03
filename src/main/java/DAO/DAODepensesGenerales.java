package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.xyz.myproject.model.general.Annee;
import com.xyz.myproject.model.general.DepensesGenerales;
import com.xyz.myproject.model.general.MRVR;
import com.xyz.myproject.model.general.MapLigneMRVR;
import com.xyz.myproject.model.general.MethodeCalcul;
import com.xyz.myproject.model.general.SousTraitanceRD;
import com.xyz.myproject.model.general.SousTraitanceSoutien;
import com.xyz.myproject.model.general.TSGeneralCanada;
import com.xyz.myproject.model.general.TSGeneralEtr;
import com.xyz.myproject.model.projet.Equipement50;
import com.xyz.myproject.model.projet.Equipement90;
import com.xyz.myproject.model.projet.FraisGeneraux;
import com.xyz.myproject.model.projet.Location50;
import com.xyz.myproject.model.projet.Location90;
import com.xyz.myproject.model.projet.MaterielConsomme;
import com.xyz.myproject.model.projet.MaterielTransforme;

public class DAODepensesGenerales extends DAO<DepensesGenerales>{

	public DAODepensesGenerales() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(DepensesGenerales obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DepensesGenerales obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DepensesGenerales obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DepensesGenerales find() {
		// TODO Auto-generated method stub
		return null;
	}

	public DepensesGenerales find(int annee, String ne) {
		System.out.println("---------------------------------------");
		System.out.println("recup Depenses generales");
		// TODO Auto-generated method stub
		DepensesGenerales dg = new DepensesGenerales(new Annee());
			Calendar annee_date_debut = new GregorianCalendar(annee, 0, 0);
			Calendar annee_date_fin = new GregorianCalendar(annee+1, 0, 0);
			Annee annee1 = new Annee(annee_date_debut, annee_date_fin, MethodeCalcul.REMPLACEMENT);
			
			Statement st;
			try {
				st = connection.createStatement();
				ResultSet res = st.executeQuery("select eq50,eq90,mat_cons,mat_trans,loc50,loc90 "
						+ "from depenses_generales "
						+ "inner join depenses_gene_annee_client "
						+ "on depenses_generales.id_depenses=depenses_gene_annee_client.id_depenses "
						+ "and depenses_gene_annee_client.ne_client='"+ne+"' "
						+ "and depenses_gene_annee_client.annee="+annee+"");
				while(res.next()){
				double eqt50 = res.getDouble("eq50");
				Equipement50 eq50 = new Equipement50(eqt50);
				
				double mat_conso = res.getDouble("mat_cons");
				MaterielConsomme mat_cons = new MaterielConsomme(mat_conso);
				
				double mat_transfo = res.getDouble("mat_trans");
				MaterielTransforme mat_trans = new MaterielTransforme(mat_transfo);
				
				double eqt90 = res.getDouble("eq90");
				Equipement90 eq90 = new Equipement90(eqt90);
				
				double loca50 = res.getDouble("loc50");
				Location50 loc50 = new Location50(loca50);
				
				double loca90 = res.getDouble("loc90");
				Location90 loc90 = new Location90(loca90);
				
				DAOTSGeneralCanada daoTsGenCa = new DAOTSGeneralCanada();
				TSGeneralCanada tsGeneral_Canada = daoTsGenCa.find(annee,ne);
				
				DAOTSGeneralEtr daoTsGenEtr = new DAOTSGeneralEtr();
				TSGeneralEtr tsGeneral_Etr = daoTsGenEtr.find(annee,ne);
				
				DAOSousTraitanceRD daoSsT_RD = new DAOSousTraitanceRD();
				SousTraitanceRD sout_rd = daoSsT_RD.find(annee,ne);
				
				DAOSousTraitanceSoutien daoSsT_Sout = new DAOSousTraitanceSoutien();
				SousTraitanceSoutien sout_soutien = daoSsT_Sout.find(annee,ne);
				
				FraisGeneraux fg = new MRVR(annee1,tsGeneral_Canada,tsGeneral_Etr,new MapLigneMRVR(),new MapLigneMRVR());
				
				dg = new DepensesGenerales(eq50, mat_cons, mat_trans, eq90, fg, tsGeneral_Etr, tsGeneral_Canada, annee1, sout_rd, sout_soutien, loc50, loc90);
				
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return dg;
	}
}
